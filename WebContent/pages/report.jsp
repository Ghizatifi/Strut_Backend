<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div id="wrapper">
<%@ include file="../includes/header.jsp"%>

      
        <!-- Page Content -->
        <div id="page-wrapper">
        
            <div class="container-fluid">
            
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Liste User</h1>
                      <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>Sr.No.</th>
						<th>Name</th>
						<th>Prenom</th>
						<th>Email</th>
						<th>Login</th>
						<th>Password</th>	
						<th>Supprimer</th>
						<th>Modifier</th>
					</tr>
				</thead>
				<s:iterator value="list">
					<tr>
						 <td><s:property value="id" /></td>
						 <td><s:property value="nom" /></td>
					 <td><s:property value="prenom" /></td>
						 <td><s:property value="email" /></td>
						 <td><s:property value="login" /></td>
						 <td><s:property value="pwd" /></td>
						<td> 
			 <a href="DeleteUser?id=<s:property value="id"/>"><span class="glyphicon glyphicon-remove"></span></a>
		</td>
		<td> 	
			 <a href="ChargerUser.action?Action=updateUser&id=<s:property value="id"/>"><span class="glyphicon glyphicon-pencil"></span></a>
		</td>
					</tr>
				</s:iterator>
			</table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
