package e2im.tic5.backend.action;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import e2im.tic5.backend.service.UserService;


public class UserAction implements Action  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom,prenom,email,login,pwd;
	private ArrayList<UserService> list;
	private String msg = "";
	int res=0;
	ResultSet rs = null;
	UserService user=new UserService();
	String Action;

	public UserService getUser() {
		return user;
	}


	public void setUser(UserService user) {
		this.user = user;
	}


	public ArrayList<UserService> getList() {
		return list;
	}


	public void setList(ArrayList<UserService> list) {
		this.list = list;
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


	//UserService user= new UserService();
	public String AddUser(){
		
		String name=this.getNom();
		String pren=this.getPrenom();
		String em=this.getEmail();
		String log=this.getLogin();
		String pd=this.getPwd();
		
		UserService user=new UserService(name, pren, em, log, pd);
		
		Boolean res=user.addUser();
		if(res){
			return SUCCESS;
		}else
			return ERROR;
		
	}

	public String getAllUser(){
		list=UserService.getAllUser();
		this.setList(list);
			System.out.println(list);		
			return SUCCESS;
		
	}
	
	public String deleteUser(){
		Long id=this.getId();
		UserService us=new UserService();
		boolean res=us.SuppUser(id);
		if(res){
			getAllUser();
			return SUCCESS;
		}else
			return ERROR;
		
	}


	@Override
	public String execute() throws Exception {			
		try {
			if (Action.equals("updateUser")) {
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
//			} else {
//				
//				boolean var=user.UpdateUser(id,nom,prenom,email,login,pwd);
//				if(var==true){
//				msg="Update avec succee";
//				
//				}
			}
				 
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "UPDATE";
	}
	
	public String UpdateUser(){
		Long id=this.getId();
		String name=this.getNom();
		String pren=this.getPrenom();
		String em=this.getEmail();
		String log=this.getLogin();
		String pd=this.getPwd();
		
		boolean var=user.UpdateUser(id, name, pren, em, log, pd);
		if(var==true){
		msg="Update avec succee";
		
		}
			return SUCCESS;
		
	}
	
/*************************************************************/
//	public void validate(){
//		if(StringUtils.isNullOrEmpty(getNom())){
//			addFieldError("nom", "Le champ est obligatoire");
//		}
//		if(StringUtils.isNullOrEmpty(getPrenom())){
//			addFieldError("prenom", "Le champ est obligatoire");
//		}
//		if(StringUtils.isNullOrEmpty(getEmail())){
//			addFieldError("email", "Le champ est obligatoire");
//		}
//		if(StringUtils.isNullOrEmpty(getLogin())){
//			addFieldError("login", "Le champ est obligatoire");
//		}
//		if(StringUtils.isNullOrEmpty(getPwd())){
//			addFieldError("pwd", "Le champ est obligatoire");
//		}
//	}
	
	
//	public String Test(){
//		if(this.getNom().equals("izza") && this.getAge().equals("20")){
//			return SUCCESS;
//		}
//		return LOGIN;
//	}
	/*************************************************************/

	public String getAction() {
		return Action;
	}




	public void setAction(String Action) {
		this.Action = Action;
	}
}
