package e2im.tic5.backend.action;

import com.opensymphony.xwork2.Action;

import e2im.tic5.backend.service.LoginService;

public class LoginAction implements Action{
private String login,pwd,resultat;

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
public String getResultat() {
	return resultat;
}

public void setResultat(String resultat) {
	this.resultat = resultat;
}

	public String execute(){
		String login =this.getLogin();
		String pwd =this.getPwd();
	    System.out.println(login);
	    LoginService log =new LoginService();
	    LoginAction logAct=new LoginAction();
	    log=LoginService.getAuth(login, pwd);
	   String res=log.getNom();
	    if(log.getId()==0){
	    	return ERROR;
	    }
	    else{
	    	this.setLogin(login);
			this.setPwd(pwd);
			this.setResultat(res);
			
			return SUCCESS;
	    }
		
		
	}


	
	
}

