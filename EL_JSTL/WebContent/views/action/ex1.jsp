<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.Date"%>

<% String year = String.format("%tY", new Date()); 
	// 현재 년도를 year 변수에 저장
%>

<p>
	copyright ⓒ 2005 - <%= year %> 이 웹페이지의 저작권은 KH정보교육원에 있습니다.
</p>




