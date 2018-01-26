package e2im.tic5.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.sun.net.httpserver.Authenticator.Success;






public class UserService {

	
	/*************************************************/
	private Long id;
	private String nom,prenom,email,login,pwd;
/*************************************************/

	public String getNom() {
		return nom;
	}

	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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
/*************************************************/
	public UserService(String nom, String prenom, String email, String login, String pwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
	}
	public UserService() {
		super();
		
	}
/*************************************************/

/*************************************************/
	public UserService(Long id, String nom, String prenom, String email, String login, String pwd) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.pwd = pwd;
	}

	
	public boolean addUser(){
		boolean res=false;
		
		Connection conn=Singleton.getConnection();
		//preparaion de la req
		String req="insert into user values(null,?,?,?,?,?)";
		
		try{
			PreparedStatement ps =(PreparedStatement)conn.prepareStatement(req);
			ps.setString(1, this.nom);
			ps.setString(2, this.prenom);
			ps.setString(3, this.email);
			ps.setString(4, this.login);
			ps.setString(5, this.pwd);

			ps.executeUpdate();
			res=true;
			System.out.println("User ajouté avec succes");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("prob d'ajout du User");
		}
		return res;
	}
	
	public static ArrayList<UserService> getAllUser(){
		ArrayList<UserService> listUser =new ArrayList<UserService>();
		try {
			Connection conn=Singleton.getConnection();
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement("SELECT * FROM user");
			ResultSet rs=pr.executeQuery();
			while(rs.next()){
				UserService user= new UserService();
				user.setId(rs.getLong("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setLogin(rs.getString("login"));
				user.setPwd(rs.getString("pwd"));
				listUser.add(user);
				System.out.println(listUser);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return listUser;
	}
	public boolean SuppUser(Long id) {
		boolean res=false;
		try {
			Connection cnx=Singleton.getConnection();
		  PreparedStatement st=(PreparedStatement) cnx.prepareStatement("delete from user where id=?");
		  st.setLong(1, id);
		  st.executeUpdate();
		  res=true;
		  st.close();
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;				
	}
	
	
	public ResultSet getUser(Long id) throws SQLException{
		UserService u=new UserService();
		Connection conn = Singleton.getConnection();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from user where id=" +id );
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public boolean UpdateUser(Long id,String nom,String prenom,String email,String login,String pwd){
		boolean resultat = false; 
		Connection conn = Singleton.getConnection();
		String req = "update user SET nom = ? ,prenom=?, email = ?,login=? ,pwd=? where id = ?";		
		
		
		
		try{
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(req);
			ps.setString(1,nom);
			ps.setString(2,prenom);
			ps.setString(3,email);
			ps.setString(4,login);
			ps.setString(5,pwd);
			ps.setLong(6,id);
			ps.executeUpdate();
			resultat = true;
			System.out.println("Modification avec succe");
			return resultat;
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println(" prob de modification du user");
			resultat = false;
			return resultat;
		}
		
		
	}
	
	
	}

