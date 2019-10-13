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