<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        img {
            max-width: 200px;
            max-height: 120px;
        }
    </style>
</head>
<body>
    <a href="/Project_BanHang_prj301/loadprofile" style="margin-left: 16px">Return</a>
    <div class="container">
        <h1 class="page-header">User Profile</h1>
        <div class="row">
            <div class="col-md-3">
                <c:if test="${image == null}">
                    <img src="Views/img/default.jpg" alt="User Image" class="img-responsive">
                </c:if>
                <c:if test="${image != null}">
                    <img src="Views/img/${image}" alt="User Image" class="img-responsive">
                </c:if>
            </div>
            <div class="col-md-9">
                <form id="profileForm" action="editprofile02" method="post">
                    <p class="text-danger">${checkanswer01}</p>
                    <div class="form-group">
                        <label for="image" class="col-md-3 control-label">Image:</label>
                        <div class="col-md-9">
                            <input type="text" id="image" name="image" value="${image}">
                        </div>
                    </div><br><br>
                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">Name:</label>
                        <div class="col-md-9">
                            <input type="text" id="name" name="name" value="${name}">
                        </div>
                    </div><br>
                    <div class="form-group">
                        <label for="email" class="col-md-3 control-label">Email:</label>
                        <div class="col-md-9">
                            <input type="text" id="email" name="email" value="${email}">
                        </div>
                    </div><br>
                    <div class="form-group">
                        <label for="phoneNumber" class="col-md-3 control-label">Phone Number:</label>
                        <div class="col-md-9">
                            <input type="text" id="phoneNumber" name="phonenumber" value="${phonenumber}">
                        </div>
                    </div><br>
                    <div class="form-group">
                        <label for="address" class="col-md-3 control-label">Address:</label>
                        <div class="col-md-9">
                            <input type="text" id="address" name="address" value="${address}">
                        </div>
                    </div><br>
                    <div class="form-group">
                        <label for="securityQuestion" class="col-md-3 control-label">Security Question:</label>
                        <div class="col-md-9">
                            <input type="text" id="securityQuestion" name="question" value="${question}">
                        </div>
                    </div><br>
                     <div class="form-group">
                        <label for="securityQuestion" class="col-md-3 control-label">Security Answer:</label>
                        <div class="col-md-9">
                            <input type="text" id="answer" name="answer" placeholder="Put your answer here!!">
                        </div>
                    </div><br>
                    <h1> ${warning}</h1>
                    
                     
                      <div class="form-group">
                        <div class="col-md-9 col-md-offset-3">
                            <input type="submit" value="Save Profile" class="btn btn-primary">
                        </div>
                    </div>
                    
                     <input type="number" value="${questionid}" hidden>
                    
                   
                </form>
                    
                    </div><br>
                   
      

                  
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
