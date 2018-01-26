<%@ taglib prefix="s" uri="/struts-tags" %>
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
                        <h1 class="page-header">Blank</h1>
                         <s:form action="AddUser" method="post"  enctype="multipart/form-data">
                                
		<div class="form-group">
                                    <label>nom</label>
                                    <input class="form-control" type="text" name="nom" id="nom">
                                </div>
		<div class="form-group">
                                    <label>prenom</label>
                                    <input class="form-control" type="text" name="prenom" id="prenom">
                                </div>
              <div class="form-group">
                                    <label>email</label>
                                    <input class="form-control" type="text" name="email" id="email">
                                </div>
                                 <div class="form-group">
                                    <label>login</label>
                                    <input class="form-control" type="text" name="login" id="login">
                                </div>
                                   <label>password</label>
                                    <input class="form-control" type="password" name="pwd" id="pwd">
                                </div>
                               <div class="panel-footer">
                              <a href="getAllUser"><button type="submit" class="btn btn-primary">Add</button></a>
                            	
                                </div>
                               
                    </s:form>
                     <div class="panel-footer">
                              <a href="getAllUser"><button type="submit" class="btn btn-primary">Liste</button></a>
                            	
                                </div>
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
