package com.nagi.springdemo.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagi.springdemo.customexception.BusinessException;
import com.nagi.springdemo.customexception.ControllerException;
import com.nagi.springdemo.dao.TicketDao;
import com.nagi.springdemo.model.DemoComparable;
import com.nagi.springdemo.model.Ticket;
import com.nagi.springdemo.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
//	@Autowired
//	private PrototypeExample prototypeExample;

	@Autowired
	private TicketDao dao;

	@Autowired
	private TicketService ticketService;

	@PostMapping("/bookTickets")
	public Ticket bookTicket(@RequestBody Ticket tickets) {
		try {
			System.out.println("controller class");
			Ticket ticketSaved = ticketService.addTicket(tickets);
			return ticketSaved;
			// return new ResponseEntity<Ticket>(ticketSaved,HttpStatus.CREATED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			// return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("611", "something went wrong in controller class");
			// return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		return tickets;

	}

	@GetMapping("/hi")
	public String home() {
		
		DemoComparable dc=new DemoComparable();
		dc.setId(1);
		dc.setName("Nagi");
		
		DemoComparable dc1=new DemoComparable();
		dc1.setId(1);
		dc1.setName("Nagi");
		
		System.out.println("Shallow comparision   : "+(dc == dc1));
		System.out.println("deep comparision   : "+(dc.equals(dc1)));
		
		Integer i= new Integer(10);
		Integer i1=new Integer(10);
		System.out.println(i.hashCode());
		System.out.println(i1.hashCode());
		System.out.println(i.equals(i1));
		
		System.out.println(i==i1);
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(i, "one");
		map.put(i1, "one");
		System.out.println(map.size());

		return "<h2>  Welcome...!!! </h2>";
	}

	@GetMapping("/user")
	public String user() {

		return "<h1> Hi..... User!!! </h1>";
	}
	@GetMapping("/")
	public String getString() {
		
		System.out.println(showPrototypeObject());
		
		String s1="java";
		s1.concat("TCS");
		System.out.println(s1);

		return "Nagireddy";
	}
	
	@Lookup
	public PrototypeExample showPrototypeObject() {
		return null;
	}
	

	@GetMapping("/admin")
	public String admin() {

		// Predicate tesing

		Predicate<String> checkLength = str -> str.length() >= 5;
		System.out.println("Length of given String is greater than 5 :" + checkLength.test("Nag"));

		Predicate<String> checkLength1 = str -> str.length() >= 6;
		System.out.println("Length of given String is greater than 6 :" + checkLength1.test("NagireddyAnakala"));

		System.out.println(checkLength.negate().test("demo"));

		return "Rajesh";

	}

	@GetMapping("/getTickets/{id}")
	public List<Ticket> getTickets(@PathVariable("id") Long idl) {

// To get unique data based on age & age in sorted order
		// Map<Object, Set<Ticket>> data=dao.findAll().stream()
		// .collect(Collectors.groupingBy(x->x.getCatagory(),TreeMap ::
		// new,Collectors.toSet()));

// To get max age
//		List<Integer> Age=dao.findAll().stream().map(x->x.getAge()).collect(Collectors.toList());
//		long maxAge=Age.stream().mapToInt(x->x).summaryStatistics().getMax();

//To get duplicate names & their count
//		List<String> names=dao.findAll().stream().map(x->x.getCatagory()).collect(Collectors.toList());
//		Set<String> s= new HashSet<>();
//		Set<String> duplicateNames=names.stream().filter(y->!s.add(y)).collect(Collectors.toSet());

//To get duplicate data based groupingby & their frequency
//		List<String> data=dao.findAll().stream().map(x->x.getCatagory()).collect(Collectors.toList());	
//		Set<String> duplicateNames=	data.stream().filter(name->Collections.frequency(data, name) >1).collect(Collectors.toSet());
//		Map<String, Long> str =data.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//	Set<String> s= new HashSet<>();
//	Set<String> duplicateNames=data.stream().filter(y->!s.add(y)).collect(Collectors.toSet());

// To use optional class
//	Optional<Ticket> t=dao.findById(id);
//	 Optional<String> name = Optional.ofNullable(t.get().getCatagory());
//		 name.ifPresent(n->System.out.println("name is present"+ n.toUpperCase()));		
//	String names = Optional.ofNullable(t.get().getCatagory()).orElseGet(()->callMe());
//		String excep = Optional.ofNullable(t.get().getCatagory()).orElseThrow(()-> new IllegalArgumentException("The Id you passed is incorrect, pls pass correct id"));

// To get salaries in desc order
//		List<Ticket> data=dao.findAll().stream().sorted((o1,o2) -> (int)(o2.getAmount()-o1.getAmount())).skip(2).limit(10).collect(Collectors.toList());

//To get first element that contains given string like "movie"	 
//		Ticket t = dao.findAll().stream().filter(x -> x.getCatagory().contains("hi")).findAny().get();
//		Boolean b = dao.findAll().stream().anyMatch(e -> e.getCatagory().contains("hello"));

		// How to use map
//	 Ticket
//		 names=dao.findAll().stream().filter(x->x.getCatagory().contains("hello")).findFirst().get();
//		 List<String>
//		 str=dao.findAll().stream().map(x->x.getCatagory()).sorted().collect(Collectors.toList());
//		 Map<Object, Set<Ticket>>
//		 data=dao.findAll().stream().collect(Collectors.groupingBy(x->x.getCatagory(),Collectors.toSet()));

//		List<String> sortedList = names.stream().sorted().collect(Collectors.toList());     
		// sortedList.forEach(System.out::println);
		// List<String> names = Arrays.asList("Tanu", "Kamal", "Suman", "Lucky",
		// "Bunty", "Amit");
		// names.sort(Comparator.naturalOrder());
		// Collections.sort(names);

		// Sorting names & get data greater than age 18
		 List<Ticket>
		 names=ticketService.getAllTicket().stream().filter(x->x.getAge()>18).collect(Collectors.toList());
		 names.sort(Comparator.comparing(Ticket::getAmount));

//		try {
//			List<Ticket> getTicket=dao.findAll();
//			if(getTicket.isEmpty())
//				throw new BusinessException("612","Hey list is empty");
//		}
//		catch(BusinessException e) {
//			ControllerException ce= new ControllerException(e.getErrorCode(),e.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//		}catch(Exception e) {
//			ControllerException ce= new ControllerException("611","something went wrong in controller class");
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//		}

		return names;
	}

	public String callMe() {
		System.out.println("Call me method called");
		return "Anonymus";
	}

}
