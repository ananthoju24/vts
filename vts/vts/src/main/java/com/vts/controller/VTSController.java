package com.vts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vts.beans.Owner;
import com.vts.beans.TaxData;
import com.vts.beans.TaxDetails;
import com.vts.service.VtsService;

@Controller
// @RequestMapping(value = "/vts")
@SessionAttributes("userName")
@CrossOrigin
public class VTSController {

	private static final Logger logger = LogManager.getLogger(VTSController.class);

	@Autowired
	private VtsService vtsService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String mainPage() {
		return "login";
	}

	@RequestMapping(value = "/loginrequest", method = RequestMethod.POST)
	public String processLogin(ModelMap model, @RequestParam String username, @RequestParam String password,
			HttpServletRequest request) {
		boolean isValidUser = vtsService.validateUser(username, password);
		logger.info("processLogin :: username " + username);
		if (isValidUser) {
			HttpSession session = request.getSession(false);
			if (null != session) {
				session.invalidate();
			}
			session = request.getSession();
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(30 * 60); // 30 mins
			model.put("userName", username);
			return "redirect:/home";
		}
		model.put("errorMsg", "Invalid username/password");
		return "login";
	}

	@GetMapping("/home")
	public String vtsHomePage() {
		return "home";
	}

	@GetMapping("/taxDetails")
	public String taxDetails() {
		return "taxDetails";
	}

	@RequestMapping(value = "/fetchTax", method = RequestMethod.POST)
	public String fetchTaxData(ModelMap model, @RequestParam String houseno) {
		logger.info("fetchTaxData :: Request recevied for fetch tax data for houseno : " + houseno);
		TaxDetails taxDetails = vtsService.geTaxDetails(houseno);
		TaxDetails addTaxData = new TaxDetails();
		TaxData taxData = new TaxData();
		addTaxData.setCurrentTaxData(taxData);
		if (null != taxDetails) {
			logger.info("fetchTaxData :: tax datafound ");
			model.put("taxDetails", taxDetails);
			model.put("addTaxData", addTaxData);
			return "searchresult";
		} else {
			logger.info("fetchTaxData :: invalid house no");
			model.put("searchErrMsg", "Invalid House No.");
			return "taxDetails";
		}

	}

	@PostMapping("/addtaxdetails")
	public String addTaxDetails(ModelMap model, @ModelAttribute TaxDetails addTaxData) {
		logger.info("addTaxData " + addTaxData);
		return "searchresult";
	}

	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest httpServletRequest) {
		logger.info("logoutUser :: processing logout ");
		HttpSession httpSession = httpServletRequest.getSession(false);
		if (null != httpSession) {
			logger.info("logoutUser :: invalidating the session " + httpSession.getAttribute("username"));
			httpSession.invalidate();
		}
		return "login";
	}

	@GetMapping("/enroll")
	public String enrollNewHouse() {
		return "enroll";
	}
	 
	@PostMapping("/createEnroll")
	public String createEnroll(Owner owner){
		vtsService.create(owner);
		return "Sucess";
		
	}

	/*
	 * @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	 * public String loginError(ModelMap model) {
	 * logger.info("Invalid credentials "); model.put("errorMsg",
	 * "Invalid username/password"); return "login"; }
	 * 
	 * if we use spring security == private String getName() { String userName =
	 * null; Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
	 * (principal instanceof UserDetails) { userName = ((UserDetails)
	 * principal).getUsername(); } else { userName = principal.toString(); }
	 * return userName; }
	 */
}
