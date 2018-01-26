package e2im.tic5.backend.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import e2im.tic5.backend.service.UserService;

public class UpUserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom= "",prenom= "",email= "",login= "",pwd= "";
	UserService user=new UserService();
	ResultSet rs = null;
	String submitType;
	String msg ="";
	
	
	@Override
	public String execute() throws Exception {			
		try {
			if (submitType.equals("updatedata")) {
				rs = user.getUser(id);
				if (rs != null) {
					while (rs.next()) {
						id=rs.getLong("id");
						nom = rs.getString("nom");
						prenom = rs.getString("prenom");
						email = rs.getString("email");
						login = rs.getString("login");
						pwd = rs.getString("pwd");
					}
				}	
			} else {
				
				boolean var=user.UpdateUser(id,nom,prenom,email,login,pwd);
				if(var==true){
				msg="Update avec succee";
				}
			}
				 
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "UPDATE";
	}
	
	

	
	public String getMsg() {
		return msg;
	}




	public void setMsg(String msg) {
		this.msg = msg;
	}




	public String getSubmitType() {
		return submitType;
	}




	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
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




	public UserService getUser() {
		return user;
	}




	public void setUser(UserService user) {
		this.user = user;
	}




	
}
