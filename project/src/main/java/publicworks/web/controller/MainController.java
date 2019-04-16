package publicworks.web.controller;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import database.workers.CustomersWorker;
import database.workers.DataBaseWorker;
import database.workers.ServiceWorkersWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
public class MainController {

	@Autowired private ApplicationContext context = new ClassPathXmlApplicationContext("DatabaseBeans.xml");
	DataBaseWorker dbw = (DataBaseWorker)context.getBean("dataBaseWorker");
	ServiceWorkersWorker sww = (ServiceWorkersWorker)context.getBean("serviceWorkersWorker");
	CustomersWorker cw = (CustomersWorker)context.getBean("customersWorker");

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/admin/getWorkers", method = RequestMethod.GET)
	public ModelAndView getWorkers() {

		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("data", dbw.getAllWorkersFromDatabaseGson());

		return mav;

	}

	@RequestMapping(value = "/admin/getRequestsList", method = RequestMethod.GET)
	public ModelAndView getRequests() {



		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("data", cw.getAllUnverifiedCustomersFromDatabaseGson());

		return mav;

	}

	@RequestMapping(value = "/admin/deleteWorker/{id}", method = RequestMethod.GET)
	public ModelAndView deleteWorker(@PathVariable String id) {


		sww.deleteServiceWorker(Integer.parseInt(id));

		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("data", "success");

		return mav;

	}

	@RequestMapping(value = "/admin/registration-accept/{id}", method = RequestMethod.GET)
	public ModelAndView accept(@PathVariable String id) {

		cw.acceptUnverifiedCustomer(Integer.parseInt(id));

		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("data", "success");

		return mav;

	}

	@RequestMapping(value = "/admin/registration-decline/{id}", method = RequestMethod.GET)
	public ModelAndView decline(@PathVariable String id) {

		cw.rejectUnverifiedCustomer(Integer.parseInt(id));

		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("data", "success");

		return mav;

	}

	@RequestMapping(value = "/admin/addWorker", method = RequestMethod.POST)
	public ModelAndView addWorker(@RequestBody String jsonString) {

		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
		sww.addNewWorkerToDatabase(jo);

		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("data", "success");

		return mav;

	}

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			System.out.println("User has authorities: " );
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			
			System.out.println(userDetail);
		
			model.addObject("login", userDetail.getUsername());
			
		}

		model.setViewName("403");

		return model;

	}

}