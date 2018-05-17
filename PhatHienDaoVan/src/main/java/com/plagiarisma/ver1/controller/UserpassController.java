package com.plagiarisma.ver1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plagiarisma.ver1.model.Userpass;
import com.plagiarisma.ver1.service.UserpassService;



@RestController
@RequestMapping("/app")
public class UserpassController {
	@Autowired
	private UserpassService userpassService;
	//get all
	
	@RequestMapping(value = "/getAllUserpass", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUserpass() {
		List<Userpass> lists=userpassService.getAllUserpass();
		return new ResponseEntity<List<Userpass>>(lists,HttpStatus.OK);
	}
	//save 
	@RequestMapping(value = "/saveUserpass", method = RequestMethod.POST)
	public ResponseEntity<?> saveUserpass(@RequestBody Userpass obj) {
		if(userpassService.addUserpass(obj)!=null)
			return new ResponseEntity<Userpass>(obj,HttpStatus.OK);
		return new ResponseEntity<>("not save",HttpStatus.NOT_FOUND);
	}
	//update book
	@RequestMapping(value="/updateUserpass/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUserpass(@PathVariable("id") int id,@RequestBody Userpass obj){
		obj.setIdUser(id);
		if(userpassService.updateUserpass(obj))
			return new ResponseEntity<Userpass>(obj,HttpStatus.OK);
		return new ResponseEntity<>("not update",HttpStatus.NOT_FOUND);
	}
	//delete book
	@RequestMapping(value = "/deleteUserpass/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteUserpass(@PathVariable("id") int id) {
		if(userpassService.deleteUserpass(id)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}
	//get catergory
	@RequestMapping(value = "/getUserpassByUser", method = RequestMethod.GET)
	public ResponseEntity<?> getUserpassByUser(@RequestParam String user) {
			Userpass curr=userpassService.getUserpassByUser(user);
			return new ResponseEntity<Userpass>(curr, HttpStatus.OK); 
	}
	//get id 
	@RequestMapping(value = "/getUserpassById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserpassById(@PathVariable("id") int id) {
			Userpass obj=userpassService.getUserpassById(id);
			return new ResponseEntity<Userpass>(obj, HttpStatus.OK); 
	}
}
