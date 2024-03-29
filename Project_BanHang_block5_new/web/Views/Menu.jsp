<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/Project_BanHang_prj301/loaddb">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.logged.role>=2}">
                <li class="nav-item">
                    <a class="nav-link" href="#">Manager Account</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.logged.role>=1}">
                <li class="nav-item">
                    <a class="nav-link" href="/Project_BanHang_prj301/managerproducts">Manager Products</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.logged.role>=0   }">
                    <li class="nav-item">   
                        <a class="nav-link" href="/Project_BanHang_prj301/loadprofile">${Hello}</a>
                </li>
                                    <li class="nav-item">
                    <a class="nav-link" href="/Project_BanHang_prj301/logout">Logout</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.logged==null}">
                     <li class="nav-item">
                    <a class="nav-link" href="/Project_BanHang_prj301/loadrememberme">Login</a>
                </li>
                </c:if>
               
            </ul>
            
            <form action="search" method="get" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${searchValue}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="/Project_BanHang_prj301/loadcartpage">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Albuquerque Shop</h1>
        <p class="lead text-muted mb-0">What do you do with a dead chemist? [Ba]rium</p>
    </div>
</section>
<!--end of menu-->
