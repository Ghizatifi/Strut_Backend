package e2im.tic5.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;


import com.mysql.jdbc.PreparedStatement;
public class LoginService {
private int id;
private String nom,prenom,email,login,pwd;
	
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public static LoginService getAuth(String login,String pwd){
		LoginService log = new LoginService();
		String res=null;
		
		 try {
			    Connection cn=Singleton.getConnection();
				PreparedStatement pr = (PreparedStatement) cn.prepareStatement("select * from user where login=? and pwd=?");
				pr.setString(1,login);
				pr.setString(2,pwd);
				ResultSet rs=pr.executeQuery();
				 if(rs.next()){
					 log.setId(rs.getInt("id"));
					 log.setNom(rs.getString("nom"));
					 log.setPrenom(rs.getString("prenom"));
					 log.setEmail(rs.getString("email"));
					 log.setLogin(rs.getString("login"));
					 log.setPwd(rs.getString("pwd"));
				 }
				 res=log.getNom();
				 System.out.println(res);
		 } catch (Exception e1) {
				
				e1.printStackTrace();
			}
		 
		return log;
		}
}
