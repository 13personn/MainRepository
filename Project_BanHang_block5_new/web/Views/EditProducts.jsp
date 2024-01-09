<%-- 
    Document   : Edit
    Created on : Oct 24, 2023, 10:29:15 PM
    Author     : LAPTOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="Views/css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body
        
        <!-- Edit Modal HTML -->
        <div  >
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="editp" method="post">
                        <p class="text-light" style="color: greenyellow">${checkanswer}</p>
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <a  href="managerproducts" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
                        </div>
                        <div class="modal-body">
                             <div class="form-group">
                                 <label>Product Id</label>
                                <input value="${eid}" type="text" name="ename" class="form-control" required readonly>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input value="${name}" type="text" name="ename" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>image</label>
                                <input value="${image}" type=text name="eimage" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input value="${price}" type=text name="eimage" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Title</label>
                                <input value="${title}" type="text" class="form-control" name="etitle" required>
                            </div>					
                            <div class="form-group">
                                <label>Quantity</label>
                                <input value="${quantity}" type="number" class="form-control" name="equantity" required>
                            </div>					
                            <div class="form-group">
                                <label>Description</label>
                                <input value="${description}" type="text" class="form-control" name="edescription" required>
                            </div>
                      
                             <div class="form-group">
                                <label>Category</label>
                                <c:set var="categoryInt" value="${categoryedit}" scope="page" />
                                <select  name="ecategory" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listC}" var="o" >
                                        <option value="${o.cid}"  <c:if test="${o.cid eq categoryInt}" >selected="selected"</c:if> >${o.cname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                           
                        </div>
                        <div class="modal-footer">
                            <a href="managerproducts" class="btn btn-info" >Cancel</a>
                            <input type="submit" class="btn btn-info" value="edit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
