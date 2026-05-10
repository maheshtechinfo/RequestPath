package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.model.Student;
import com.nt.service.IWishMessageService;

@Controller
@RequestMapping("/wish")
public class WishMessageOperationsController {
	@Autowired
	private IWishMessageService wishMessageService;

	// @RequestMapping("/")
	@RequestMapping
	public String showHomepage() {
		System.out.println("WishMessageOperationsController.showHomepage()");
		// return LVN
		return "welcome";
	}

	@RequestMapping("/season")
	public String showWishMessage(Map<String, Object> map) {
		// use service
		String msg = wishMessageService.wishMessage();

		// add model attributes(simple values)
		map.put("name", "mahesh");
		map.put("age", 23);

		// add model attributes (arrays, collections)
		map.put("nickNames", new String[] { "Satya", "Sarat", "Sanjay", "Gautam", "Abhishek" });
		map.put("friends", List.of("Mahaesh", "Suresh", "Sachin", "Rakesh"));
		map.put("phones", Set.of(99999999L, 88888888L, 77777777L));
		map.put("idDetails", Map.of("Aadhar", 665456786565L, "Voterid", 125656565L, "PanNo", 4665656));

		// adding model class obj as the model attribute
		Student stud = new Student(1001, "rajesh", "hyd", 89.99f);
		map.put("studData", stud);

		// adding List of Model class objs as the model attributes
		Student stud1 = new Student(1001, "rajesh", "hyd", 99.99f);
		Student stud2 = new Student(1002, "ramesh", "vizag", 81.99f);
		Student stud3 = new Student(1003, "suresh", "hyd", 56.99f);
		map.put("studList", List.of(stud1, stud2, stud3));

		// keep the result in shared memory as model attributes
		map.put("resultMsg", msg);
		// return LVN
		return "display";
	}

	/*	@RequestMapping("/report1")
		public String showReport1() {
			System.out.println("WishMessageOperationsController.showReport1()");
			return "show_report1";
		}*/

	/*	@RequestMapping("/REPORT1")
		public String showReport2() {
			System.out.println("WishMessageOperationsController.showReport2()");
	 		return "show_report2";
		}*/

	/*@RequestMapping({"/report1","/report2","/report3"})
	public String showReport1() {
		System.out.println("WishMessageOperationsController.showReport1()");
		return "show_report1";
	}
	*/

	//@RequestMapping(value = "/report1", method = RequestMethod.GET)
	/*@GetMapping("/report1")
	public String showReport1() {
		System.out.println("WishMessageOperationsController.showReport1()");
		return "show_report1";
	}*/

	//@RequestMapping(value = "/report1", method = RequestMethod.POST)
	/*@PostMapping("/report1")
	public String showReport2() {
		System.out.println("WishMessageOperationsController.showReport2()");
		return "show_report2";
	}*/

	/*@GetMapping("/report1")
	@PostMapping("/report1")
	public String showReport1() {
		System.out.println("WishMessageOperationsController.showReport1()");
		return "show_report1";
	}*/
	
	/*	@GetMapping("/report1")
	 	public String showReport1() {
			System.out.println("WishMessageOperationsController.showReport1()");
			return "show_report1";
		}*/
	
	/*	@GetMapping("/report1")
	 	public String showReport1() {
			System.out.println("WishMessageOperationsController.showReport1()");
			return "forward:/test/report1";
		}*/
	@GetMapping("/report1")
 	public String showReport1() {
		System.out.println("WishMessageOperationsController.showReport1()");
		return "redirect:/test/report1";
	}
	
	
}
