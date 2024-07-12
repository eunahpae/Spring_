<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>

<%
// 1. 브라우저와 연결된 세션 객체를 강제 종료
session.invalidate();

// 2.  
response.sendRedirect("login.jsp");
%>
