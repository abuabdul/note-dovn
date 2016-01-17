<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes/siteTags.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<tiles:insertAttribute name="metaTags"/>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="siteHeaderInclude"/>
</head>
<%-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function --%>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<tiles:insertAttribute name="topmenu"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="siteFooterInclude"/>
</body>
</html>
