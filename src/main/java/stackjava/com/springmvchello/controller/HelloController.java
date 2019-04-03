package stackjava.com.springmvchello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import stackjava.com.springmvc.model.User;
import stackjava.com.springmvchello.entities.Employee;

@Controller
public class HelloController {

	@RequestMapping("/json")
	@ResponseBody
	public User testJson() {
		User user = new User(1, "nam", "example@gmail.com");
		return user;
	}

	@RequestMapping("/list-json")
	@ResponseBody
	public List<User> listJson() {
		List<User> listUser = new ArrayList<User>();
		listUser.add(new User(1, "stack", "stack@gmail.com"));
		listUser.add(new User(2, "jack", "jack@gmail.com"));
		listUser.add(new User(3, "son", "son@gmail.com"));
		return listUser;
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/test1")
	@ResponseBody
	public String test1() {
		return "test1";
	}

	@RequestMapping("/test/{id}")
	public String test(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		return "test1";
	}

	@RequestMapping("/test2/{id}/{name}")
	public String test2(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "test2";
	}

	@RequestMapping("/test3")
	public String test3(@RequestParam("name") String name, @RequestParam("id") int id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "test3";
	}

	@RequestMapping(value = { "/employee" }, method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "add-employee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String doAddEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		employee.setName(employee.getName().toUpperCase());
		model.addAttribute("employee", employee);
		return "view-employee";
	}
	
	@RequestMapping(value= "/addEmployee-get", method = RequestMethod.GET)
	  public String addEmployeeGet(Model model) {
	    model.addAttribute("employee", new Employee());
	    List<String> listFavorite = new ArrayList<String>();
	    listFavorite.add("Swimming");
	    listFavorite.add("Listening music");
	    listFavorite.add("Walking");
	    listFavorite.add("Watching movie");
	    listFavorite.add("Reading comic");
	    model.addAttribute("listFavorite", listFavorite);
	    List<String> listPosition = new ArrayList<String>();
	    listPosition.add("Developer");
	    listPosition.add("Designer");
	    listPosition.add("Tester");
	    listPosition.add("QA");
	    model.addAttribute("listFavorite", listFavorite);
	    model.addAttribute("listPosition", listPosition);
	    return "add-employee-get";
	  }
	
	  @RequestMapping(value = "/addEmployee-post", method = RequestMethod.POST)
	  public String doAddEmployeePost(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
	    modelMap.addAttribute("employee", employee);
	    return "view-employee-post";
	  }
}