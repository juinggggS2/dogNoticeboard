<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>    
    
    
 <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">CUSTOMEDU</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <!-- Heading -->
            <div class="sidebar-heading">
                PAGES
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
                    aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>게시판</span>
                </a>
                <div id="collapsePages" class="collapse show" aria-labelledby="headingPages"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">LOGIN SCREENS:</h6>
                        <a class="collapse-item" href="${path }/user/login">Login</a>
                        <a class="collapse-item" href="${path }/user/register">Register</a>
                        <a class="collapse-item" href="${path }/user/forgetPswd">Forgot Password</a>
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">OTHER PAGES:</h6>
                        <a class="collapse-item" href="board">Board</a>
                        <a class="collapse-item" href="">Q&A</a>
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">ADMIN PAGES:</h6>
                        <a class="collapse-item" href="">Member management</a>
                    </div>
                </div>
            </li>

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>