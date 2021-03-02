require.config({
	 paths: {
			 "jquery": "jquery-3.5.1.min",
			 },
 });

require(['jquery','common','register'],function (jquery,common,register){
	$(function(){
		register.registBtn();
	});	
});