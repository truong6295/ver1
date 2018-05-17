package com.plagiarisma.ver1.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plagiarisma.ver1.model.Userpass;
@Repository
public interface  UserpassRepository extends JpaRepository<Userpass, Integer>{
	Userpass findByUser(String user);
}
