/*Active Menu Handling*/
$(function() {
	switch (menu) {
	case "homeNav":
		$("#homeNav").addClass("active");
		break;
	case "about":
		$("#about").addClass("active");
		break;
	case "contact":
		$("#contact").addClass("active");
		break;
	case "allProducts":
		$("#allProducts").addClass("active");
		break;
	case "manageProducts":
		$("#manageProducts").addClass("active");
		break;
	default:
		$("#allProducts").addClass("active");
		$("#side_" + menu).addClass("active");
		break;
	}
});

/* PRODUCT DATA TABLE */
var $table = $('#productListTable');
if ($table.length) {

	$table
			.DataTable({
				lengthMenu : [
						[ 10, 20, 30, -1 ],
						[ '10 Products', '20 Products', '30 Products',
								'All Products' ] ],
				pageLength : 10,
				// scrollY : 400,
				responsive : true,
				ajax : {
					url : window.jsonUrl,
					dataSrc : ''
				},
				columns : [
						{
							data : 'productThumbnailUrl',
							mRender : function(data, type, row) {
								return '<img src ="'
										+ imageUrl
										+ data
										+ '" style="text-align: center; align-content: center; width: 100%; height: 140px;"/>';
							}
						},
						{
							data : 'productName',
							mRender : function(data, type, row) {
								var str = '';
								var name = data.split("#####")[0];
								var desc = data.split("#####")[1];
								str += '<strong>' + name + '</strong><br>'
										+ '<small>' + desc + '</small>';
								return str;
							}
						},
						{
							data : 'productUnitCost',
							mRender : function(data, type, row) {
								return '&#x20b9; ' + data
							}
						},
						{
							data : 'productQuantity',
							mRender : function(data, type, row) {
								if (data == 0)
									return '<strong style="color: red;">Out Of Stock!!</strong>';
								else
									return data;
							}
						},
						{
							data : 'productOverallRating',
							bSortable : false,
							mRender : function(data, type, row) {
								var str = '';
								switch (data) {
								case 1:
									str += '<small class="text-muted">&#9733; &#9734; &#9734; &#9734; &#9734;</small>';
									break;
								case 2:
									str += '<small class="text-muted">&#9733; &#9733; &#9734; &#9734; &#9734;</small>';
									break;
								case 3:
									str += '<small class="text-muted">&#9733; &#9733; &#9733; &#9734; &#9734;</small>';
									break;
								case 4:
									str += '<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>';
									break;
								case 5:
									str += '<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9733;</small>';
									break;
								default:
									str += '<small class="text-muted">&#9734; &#9734; &#9734; &#9734; &#9734;</small>';
								}
								return str;
							}
						},
						{
							data : 'productCode',
							bSortable : false,
							mRender : function(data, type, row) {
								var str = '';
								str += '<a href = "'
										+ showUrl
										+ data
										+ '" class = "btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a> &#160;<br>';

								if (row.productQuantity <= 0) {
									str += '<a href = "javascript:void(0)" class = "btn btn-success disabled"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>';

								} else {
									str += '<a href = "'
											+ cartUrl
											+ '/product/'
											+ data
											+ '" class = "btn btn-success"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>';
								}
								return str;
							}
						}, ]
			});

}	


/* ADMIN DATA TABLE */
var $adminTable = $('#adminProductsTable');
if ($adminTable.length) {
	$adminTable.DataTable({
		lengthMenu : [
			[ 20, 50, 100, -1 ],
			[ '20 Products', '50 Products', '100 Products',
					'All Products' ] ],
		pageLength : 20,
		scrollY : 700,
		responsive : true,
		ajax : {
			url : window.adminJsonUrl,
			dataSrc : ''
		},
		columns : [
			{data : 'productId'},
			{data : 'productPortraitUrl',
				mRender : function(data, type, row){
					return '<img src ="'
					+ imageUrl
					+ data
					+ '" style="text-align: center; align-content: center; width: 100%; height: 140px;"/>';
					}
			},
			{data : 'productCode'},
			{data : 'productName',
				mRender : function(data, type, row){
					return '<strong>'+data+'</strong><br> <small>'+row.productDescription+'</small>';
				}
			},
			{data : 'productUnitPrice',
				mRender : function(data, type, row) {
					return '&#x20b9; ' + data
				}
			},
			{data : 'productQuantity'},
			{data : 'productIsActive',
				mRender : function(data, type, row){
					var str = '';
					if(data == true){
						str += '<div class="toggle-btn active"><input type="checkbox" checked class="cb-value" value = "' + row.productCode + '"/> <span class="round-btn"></span></div>';
					}else{
						str += '<div class="toggle-btn"><input type="checkbox" class="cb-value" value = "' + row.productCode + '"/> <span class="round-btn"></span></div>';
					}
					return str;
				}
			},
			{data : 'productCode',
				mRender : function(data, type, row){
					return '<a href="'+editUrl + row.productCode +'/edit" class="btn btn-success"><i class="fa fa-pencil" aria-hidden="true"></i> </a>';
				}
			}
		],
		initComplete : function(){
			var api = this.api();
			api.$('.cb-value').click(
					function() {
						var mainParent = $(this).parent('.toggle-btn');
						var productCodeFromCheckBox = $(this).val();
						var message = '';
						var confirmText = '';
						if ($(mainParent).find('input.cb-value').is(':checked')) {
							message += "Are you sure you want to Activate this product?";
							confirmText += "Activate";
						} else {
							message += "Are you sure you want to De-Activate this product?"
							confirmText += "De-Activate";
						}
						swal.fire({
							title : confirmText + " Product?",
							text : message,
							type : "warning",
							showCancelButton : true,
							confirmButtonClass : "btn-danger",
							confirmButtonText : confirmText,
						}).then((res) => {
							console.log(res);
							console.log(res.value);
			                if(res.value){
			                		var postUrl = activationUrl + productCodeFromCheckBox + '/activation';
			                		console.log(postUrl);
			                		$.post(postUrl, function(data){
			                			if(data == true){
			                				if(confirmText == 'Activate'){
						                		$(mainParent).addClass('active');
						                	}else{
						                		$(mainParent).removeClass('active');
						                	}
			                				Swal.fire({
					    						type : 'success',
					    						title : 'Product '+ confirmText+'d!',
					    						showConfirmButton : false,
					    						timer : 1000,
					    						footer : "The Product has been successfully " + confirmText + "d."
					    					});
			                			}else{
			                				Swal.fire({
			                					  type: 'error',
			                					  title: 'Oops...',
			                					  text: 'Failed To Update Product Status. Please Try Again!!',
			                					  footer: '<a href>Why do I have this issue?</a>'
			                					});
			                			}
			                		});
			                }else{
			                	if(confirmText == 'Activate'){
			                		$(mainParent).find('input.cb-value').prop("checked", false);
			                	}else{
			                		$(mainParent).find('input.cb-value').prop("checked", true);
			                	}
			                }
			            });
					});
		}
	});
}

/* Create category validation */
var $categoryForm = $("#createNewCategory");
console.log("Category Form: " + $categoryForm);
if($categoryForm.length){
	console.log("Category Form Is Visible");
	$categoryForm.validate({
		rules : {
			categoryName : {
				required : true,
				minLenth : 5,
			},
			categoryDescription : {
				required : true
			},
			categoryThumbnail : {
				required : true
			}
		},
		messages : {
			categoryName :{
				required : "Please Provide A Category Name",
				minLenth : "Category Name Should Not Be Less Than 5 Characters"
			},
			categoryDescription :{
				required : "Please Provide Some Description For The Category"
			},
			categoryThumbnail : {
				required : "Please Select A Thumbnail Image To Be Displayed Along With The Category"
			}
		},
		errorElement : 'div',
		errorPlacement : function(error, element){
			console.log('Placing Error');
			error.addClass('error-tip');
			error.insertAfter(element);
		}
	});
}