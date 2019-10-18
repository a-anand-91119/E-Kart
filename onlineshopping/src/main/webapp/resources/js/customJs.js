$(function() {
	// active menu
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
			$("#side_"+menu).addClass("active");
			break;
	}
});



var $table = $('#productListTable');
if($table.length){
	
	$table.DataTable({
		lengthMenu : [[10,20,30,-1],['10 Products', '20 Products', '30 Products', 'All Products']],
		pageLength : 10,
		//scrollY : 400,
		responsive: true,
		ajax : {
			url : window.jsonUrl,
			dataSrc : ''
		},
		columns : [
 			{
			data : 'productThumbnailUrl',
			mRender : function(data, type, row) {
				return '<img src ="' + imageUrl + data + '" style="text-align: center; align-content: center; width: 100%; height: 140px;"/>';
			}
		}, {
			data : 'productName',
			mRender : function(data, type, row){
				var str = '';
				var name = data.split("#####")[0];
				var desc = data.split("#####")[1];
				str += '<strong>'+name+'</strong><br>'+'<small>'+desc+'</small>';
				return str;
			}
		}, {
			data : 'productUnitCost',
			mRender : function(data, type, row) {
				return '&#x20b9; ' + data
			}
		}, {
			data : 'productQuantity',
			mRender : function(data, type, row) {
				if(data == 0)
					return '<strong style="color: red;">Out Of Stock!!</strong>';
				else
					return data;
			}
		}, {
			data : 'productOverallRating',
			bSortable : false,
			mRender : function(data,type,row) {
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
		}, {
			data : 'productCode',
			bSortable : false,
			mRender : function(data, type, row) {
				var str = '';
				str += '<a href = "' + showUrl + data + '" class = "btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a> &#160;<br>';

				if(row.productQuantity <= 0){
					str += '<a href = "javascript:void(0)" class = "btn btn-success disabled"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>';

				}else{
					str += '<a href = "'+cartUrl + '/product/' + data + '" class = "btn btn-success"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>';
				}
				return str;
			}
		},
		]
	});
	
	
}