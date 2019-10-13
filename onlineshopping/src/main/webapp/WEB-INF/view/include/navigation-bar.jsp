<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
	
<core:url var = "about" value = "/about"/>
<core:url var = "home" value = "/home"/>
<core:url var = "contactUs" value = "/contactUs"/>
<core:url var = "allProducts" value = "/allProducts"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">E-Kart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="${home}" id="home">Home
						<!-- <span class="sr-only">(current)</span> -->
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${allProducts}" id="allProducts">View Products</a></li>
				<li class="nav-item"><a class="nav-link" href="${about}" id="about">About</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${contactUs}" id="contact">Contact</a></li>
			</ul>
		</div>
	</div>
</nav>