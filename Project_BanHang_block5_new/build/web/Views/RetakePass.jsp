<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="/Project_BanHang_prj301/Views/css/login.css" rel="stylesheet" type="text/css"/>
        <title>retake password Form</title>
    </head>
    <body>     
        <div id="logreg-forms"> 
           
            <form class="form-signin" action="/Project_BanHang_prj301/retakepass" method="post">   <!--action="../login" fix mai moi xong-->
               <p class="text-danger">${alert}</p>
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Retake Password</h1>
                <input name="user" type="text" id="user-name" class="form-control" placeholder="User name" required="" autofocus="">
                <select name="questionid" style="width: 380px;height: 45px;border-radius: 2%">
                    <c:forEach  items="${listquestion}" var="o">
                        <option value="${o.getQuestionid()}">
                            ${o.getQuestion()}
                        </option>
                    </c:forEach>
                </select>
                <input name="answer" type="text"  class="form-control" placeholder="Answer here" required autofocus="">
                <input name="newpass" type="password" id="user-pass" class="form-control" placeholder="new Password" required autofocus="">
                <input name="newrepass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">

                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Submit</button>
                <a href="Login.jsp" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>

            
            <br>

        </div>
      
    </body>
</html>