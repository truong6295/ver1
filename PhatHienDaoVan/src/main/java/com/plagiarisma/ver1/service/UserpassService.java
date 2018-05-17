package com.plagiarisma.ver1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plagiarisma.ver1.dao.UserpassRepository;
import com.plagiarisma.ver1.model.Userpass;

@Service
public class UserpassService {
	@Autowired
	private UserpassRepository userpassRepository;
	
	//add
	public Userpass addUserpass(Userpass obj){
		List<Userpass> list=userpassRepository.findAll();
		for(int i=0;i<list.size();i++){
			if(!list.get(i).getUser().equals(obj.getUser())){
				userpassRepository.save(obj);
				return obj;
			}	
		}
		return null;
	}
	//delete
	public boolean deleteUserpass(int id){
		if(userpassRepository.existsById(id)){
			userpassRepository.deleteById(id);
			return true;
		}
		return false;
	}
	//update
	public boolean updateUserpass(Userpass obj){
		int id=obj.getIdUser();
		userpassRepository.saveAndFlush(obj);
		if(userpassRepository.getOne(id).equals(obj))
			return true;
		return false;
	}
	//get id 
	public Userpass getUserpassById(int id){
		if(userpassRepository.existsById(id)){
			return userpassRepository.getOne(id);
		}
		return null;
	}
	//get User
	public Userpass getUserpassByUser(String user){
		if(userpassRepository.findByUser(user)!=null)
			return userpassRepository.findByUser(user);
		return null;
	}
	//get all 
	public List<Userpass> getAllUserpass(){
		List<Userpass> lists=userpassRepository.findAll();
		if(lists.isEmpty())
			return null;
		return lists;
	}
}
