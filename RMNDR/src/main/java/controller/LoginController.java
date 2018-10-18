package controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import auth.AuthService;
import entities.Ruser;

/**
 * @author Nana Febriana
 */

@Controller
//@RequestMapping(value = "account")
public class LoginController {

	/* 
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:account/login.html";
	} */
	
	/* Example Form */
	@RequestMapping("/exampleform")
	public ModelAndView userListView() {
		ModelAndView model = new ModelAndView("formdetail");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelmap, HttpSession session, HttpServletRequest request) {
		Ruser ruser = checkCookie(request);
		if (ruser == null) {
			modelmap.put("ruser", new Ruser());
		} else {
			AuthService auth = new AuthService();
			Boolean check = auth.findUser(ruser.getUsername(),ruser.getPassword());
			if (check == true) {
				return "menu";
			} else {
				return "index";
			}
		}
		modelmap.put("ruser", new Ruser());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "ruser") Ruser ruser,
			ModelMap modelmap, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		AuthService auth = new AuthService();
		Boolean check = auth.findUser(ruser.getUsername(), ruser.getPassword());

		if (check == true) {
			session.setAttribute("username", ruser.getUsername());

			if (request.getParameter("remember") != null) {
				Cookie ckUsername = new Cookie("username", ruser.getUsername());
				ckUsername.setMaxAge(3600);
				response.addCookie(ckUsername);
				Cookie ckPassword = new Cookie("password", ruser.getPassword());
				ckPassword.setMaxAge(3600);
				response.addCookie(ckPassword);
			}
			return "menu";
		} else {
			modelmap.put("error", "Account is invalid");
			return "index";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		// Remove Session
		session.removeAttribute("username");

		// Remove Cookie
		for (Cookie ck : request.getCookies()) {
			if (ck.getName().equalsIgnoreCase("username")) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
			if (ck.getName().equalsIgnoreCase("password")) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
		}
		return "redirect:login.html";
	}

	public Ruser checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Ruser ruser = null;
		String username = "", password = "";

		for (Cookie ck : cookies) {
			if (ck.getName().equalsIgnoreCase("username"))
				username = ck.getValue();
			if (ck.getName().equalsIgnoreCase("password"))
				password = ck.getValue();
		}
		if (!username.isEmpty() && !password.isEmpty())
//			ruser = new Ruser(username, password);
			ruser = new Ruser(null, null);

		return ruser;
	}
}
