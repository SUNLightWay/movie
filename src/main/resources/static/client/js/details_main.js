require.config({
    paths: {
        "jquery": "jquery-3.5.1.min",
    },
});


require(['jquery','common','details'],function (jquery, common, details){
    $(function(){
        details.loadDetails()
    });
});