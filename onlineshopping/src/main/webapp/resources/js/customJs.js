$(function() {
	// active menu
	switch (menu) {
		case "home":
			$("#home").addClass("active");
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
		default:
			$("#allProducts").addClass("active");
			$("#side_"+menu).addClass("active");
			break;
	}
});



var $table = $('#productListTable');
if($table.length){
	
	$table.DataTable({
		lengthMenu : [[3,5,10,-1],['3 Records', '5 Records', '10 Records', 'All Records']],
		pageLength : 5,
		ajax : {
			url : window.jsonUrl,
			dataSrc : ''
		},
		columns : [
 			{
			data : 'productThumbnailUrl',
		}, {
			data : 'productName',
		}, {
			data : 'productUnitCost',
			mRender : function(data, type, row) {
				return '&#x20b9; ' + data
			}
		}, {
			data : 'productOverallRating',
		}, {
			data : 'productCode',
			bSortable : false,
			mRender : function(data, type, row) {
				var str = '';
				str += '<a href = "' + showUrl + data + '" class = "btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a> &#160;';
				str += '<a href = "'+cartUrl + '/product/' + data + '" class = "btn btn-success"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>';
				return str;
			}
		},
		]
	});
	
	
}