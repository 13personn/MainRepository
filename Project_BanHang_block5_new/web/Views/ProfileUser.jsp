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
    <a href="/Project_BanHang_prj301/loaddb" style="margin-left: 16px">Home</a>
    <div class="container">
        <h1 class="page-header">User Profile</h1>
        <div class="row">
            <div class="col-md-3">
                 <c:if test="${image==null}">
                    <img src="Views/img/default.jpg" alt="User Image" class="img-responsive">
                </c:if>
                    <c:if test="${image!=null}">
                    <img src="Views/img/${image}" alt="User Image" class="img-responsive">
                </c:if>
                
            </div>
            <div class="col-md-9">
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">Name:</label>
                    <div class="col-md-9">
                        <span id="name">${name}</span>
                    </div>
                </div><br>
                <div class="form-group">
                    <label for="email" class="col-md-3 control-label">Email:</label>
                    <div class="col-md-9">
                        <span id="email">${email}</span>
                    </div>
                </div><br>
                <div class="form-group">
                    <label for="phoneNumber" class="col-md-3 control-label">Phone Number:</label>
                    <div class="col-md-9">
                        <span id="phonenumber">${phonenumber}</span>
                    </div>
                </div><br>
                <div class="form-group">
                    <label for="address" class="col-md-3 control-label">Address:</label>
                    <div class="col-md-9">
                        <span id="address">${address}</span>
                    </div>
                </div><br>
               
                
                

                <!-- Add other user profile information here -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a href="editprofile" id="editProfile" class="btn btn-primary">Edit Profile</a>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
