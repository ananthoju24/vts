package com.gov.vill.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gov.vill.bean.TaxData;
import com.gov.vill.bean.TaxDetails;
import com.gov.vill.service.VillageTaxServiceImpl;

/**
 * Servlet implementation class SearchCotroller
 */
@WebServlet("/admin/vtscontroller")
public class TaxactionCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static VillageTaxServiceImpl service = new VillageTaxServiceImpl();

	public TaxactionCotroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if ("search".equals(action)) {
			String hno = request.getParameter("houseno");
			if (null == hno || "".equals(hno)) {

				System.out.println("hno " + hno);
				request.getSession(false).setAttribute("errorMsg", "No data found. Please enter valid house no.");
				request.getRequestDispatcher("/admin/home").forward(request, response);
			} else {
				TaxDetails taxDetails = service.geTaxData(hno);
				if (null != taxDetails) {
					System.out.println(" Tax Details ::" + taxDetails);
					request.setAttribute("taxDetails", taxDetails);
					request.getRequestDispatcher("/admin/searchresult").forward(request, response);
				} else {
					request.getSession(false).setAttribute("errorMsg", "No data found. Please enter valid house no.");
					request.getRequestDispatcher("/admin/home").forward(request, response);
				}

			}
		} else if ("add".equals(action)) {
			String respDesc = null;
			System.out.println(" Request Received to add tax data ");
			List<TaxData> ll = new ArrayList<TaxData>();
			TaxDetails taxDetails = new TaxDetails();
			taxDetails.setHno(request.getParameter("hno"));
			taxDetails.setOwnerName(request.getParameter("ownerName"));
			taxDetails.setTaxDataList(ll);
			TaxData taxData = new TaxData();

			taxData.setEp(getIntVal(request.getParameter("houseTax")));
			taxData.setGp(getIntVal(request.getParameter("villageTax")));
			taxData.setNp(getIntVal(request.getParameter("waterTax")));
			taxData.setLp(getIntVal(request.getParameter("lightingTax")));
			taxData.setPp(getIntVal(request.getParameter("cleanlinessTax")));
			taxData.setTaxYear(request.getParameter("taxYear"));
			taxData.setPaymentStatus("Pending");
			setTaxTotal(taxData);
			ll.add(taxData);
			System.out.println(" taxDataList :: " + taxDetails);
			int respCode = service.addTaxData(taxDetails);
			System.out.println(" Request Data :: " + taxData + "\n " + respCode);
			if (respCode == 0) {
				respDesc = "Successfully Added";
			} else {
				respDesc = "Failed to add please try again";
			}
			System.out.println("respDesc " + respDesc);
			// response.getWriter().write(respDesc);
			request.getSession(false).setAttribute("responseMsg", respDesc);
			request.getRequestDispatcher("/admin/searchresult").forward(request, response);

			// request.getRequestDispatcher("/admin/home").forward(request,
			// response);
		}

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	int getIntVal(String s) {
		return Integer.parseInt(s);
	}

	void setTaxTotal(TaxData taxData) {
		int totalTax = taxData.getEp() + taxData.getGp() + taxData.getLp() + taxData.getNp() + taxData.getPp();
		taxData.setTotalTaxAmount(totalTax);
	}
}
