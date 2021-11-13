package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World new Verison V1";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		// throw new RuntimeException("Some Error has Happened! Contact Support at
		// ***-***");
		return new HelloWorldBean("Hello World Bean V1");
	}

	/// hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World v1, %s", name));
	}
	
	//10 secs = 10000, 10 mins = 600,000 and 20 mins = 1,200,000
	@GetMapping(path = "/hello-world-timeout")
	public String helloWorldTimeout() {
		
		new Timer().schedule(
			    new TimerTask() {
			        @Override
			        public void run() {
			        	System.out.println("Timer pause complete");
			        }
			    }, 
			    600000
			);
		
		return "Hello World Test Timeout";
	}

}
