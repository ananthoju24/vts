package com.vts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vts.beans.TaxData;
import com.vts.beans.TaxDetails;
import com.vts.service.VtsService;

@Controller
@RequestMapping(value = "/vts")
@SessionAttributes("userName")
public class VTSController {

	@Autowired
	private VtsService vtsService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String redirectToLogin() {
		return "login";
	}

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String mainPage() {
		return "login";
	}

	@RequestMapping(value = "/loginrequest", method = RequestMethod.POST)
	public String loginRequest(ModelMap model, @RequestParam String username, @RequestParam String password) {
		boolean isValidUser = vtsService.validateUser(username, password);
		if (isValidUser){
			model.put("userName",username);
			return "home";
		}
		model.put("errorMsg", "Invalid username/password");
		return "login";
	}

	@RequestMapping(value = "/searchRequest", method = RequestMethod.POST)
	public String searchRequest(ModelMap model, @RequestParam String houseno) {
		TaxDetails taxDetails = vtsService.geTaxDetails(houseno);
		TaxDetails addTaxData = new TaxDetails();
		TaxData taxData = new TaxData();
		addTaxData.setCurrentTaxData(taxData);
		if (null != taxDetails) {
			model.put("taxDetails", taxDetails);
			model.put("addTaxData", addTaxData);
			return "searchresult";
		} else {
			model.put("searchErrMsg", "Invalid House No.");
			return "home";
		}

	}

	@PostMapping("/addtaxdetails")
	public String addTaxDetails(ModelMap model,@ModelAttribute TaxDetails addTaxData){
		System.out.println("addTaxData "+addTaxData);
		return "searchresult";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		return "user";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
}
