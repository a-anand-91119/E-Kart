<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored = "false" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<core:url var = "allProducts" value = "/allProducts"/>

 <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
      <h1 class="display-3">A few clicks is all it takes.</h1>
      <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
      <a href="${allProducts}" class="btn btn-primary btn-lg">Shop Now</a>
    </header>
	
    <!-- Page Features -->
    <div class="row text-center">

		<core:forEach items="${categoryData}" var="category">

			<div class="col-lg-3 col-md-6 mb-4">
				<div class="card h-100">
					<img class="card-img-top" src="http://placehold.it/500x325" alt="${category.categoryName}">
					<div class="card-body">
						<h4 class="card-title">${category.categoryName}</h4>
						<p class="card-text">${category.categoryDescription}</p>
					</div>
					<div class="card-footer">
						<a href="category/${category.categoryId}/products"
							class="btn btn-primary">Find Out More!</a>
					</div>
				</div>
			</div>

		</core:forEach>

	</div>
    <!-- /.row -->

  </div>
  <!-- /.container -->