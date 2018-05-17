package com.plagiarisma.ver1.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userpass database table.
 * 
 */
@Entity
@NamedQuery(name="Userpass.findAll", query="SELECT u FROM Userpass u")
public class Userpass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String pass;

	private String user;

	public Userpass() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}