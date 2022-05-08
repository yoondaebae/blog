package com.toto.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/http/")
public class HttpControllerTest {

	@GetMapping("get")
	public String getTest(Member m) {
		return "get 요청 : "+ m.getId() +":"+m.getUsername()+":"+m.getPassword()+":"+m.getEmail();
	}
	
	@PostMapping("post")
	public String postTest() {
		return "post 요청";
	}
	
	@PutMapping("put")
	public String putTest() {
		return "put 요청";
	}
	
	@DeleteMapping("delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
