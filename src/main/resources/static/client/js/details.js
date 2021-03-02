define(['common'],function(common){

    var movieNo = $("#title").attr("data-movieno");
    console.log(movieNo)
    //登录
    function loadDetails(){
        var movie;
        $.ajax({
            url:baseUrl+"getMovieInfo",
            type:"post",
            data:{movieId: movieNo},
            xhrFields: {withCredentials: true},
            crossDomain: true,
            success:function(data){
                //判断是否查找成功
                if(data.status==0){
                    movie = data.data;
                    //数据库中没有存储movie具体信息，调用imdb平台api
                    if (data.data.poster==null){
                        console.log("getMovieLink");
                        $.ajax({
                            url:baseUrl+"getMovieLink",
                            type:"post",
                            data:{movieId: movieNo},
                            xhrFields: {withCredentials: true},
                            crossDomain: true,
                            success:function (data1){
                                if (data1.status != 0){
                                    alert("数据异常！");
                                } else {
                                    //调用imdb平台api补全信息
                                    $.ajax({
                                        url:"http://www.omdbapi.com",
                                        type:"get",
                                        data:{apikey: "b6a32045", i: "tt" + formatZero(data1.data.imdb_id, 7)},
                                        xhrFields: {withCredentials: false},
                                        crossDomain: true,
                                        success:function(data2){
                                            if (data2.Response != "False"){
                                                console.log("padMovieInfo");
                                                $.ajax({
                                                    url:baseUrl+"padMovieInfo",
                                                    type:"post",
                                                    data:{movie_id: movieNo, actors: data2.Actors,
                                                        country: data2.Country, director: data2.Director,
                                                        imdb_rating: data2.imdbRating, language: data2.Language,
                                                        plot: data2.Plot, poster: data2.Poster,
                                                        runtime: data2.Runtime,
                                                        writer: data2.Writer, year: data2.Year},
                                                    xhrFields: {withCredentials: true},
                                                    crossDomain: true,
                                                    success:function(data3){
                                                        if (data3.status == 0){
                                                            movie = data3.data;
                                                        } else{
                                                            alert("数据异常！")
                                                            return;
                                                        }
                                                        console.log(movie);
                                                    }
                                                })
                                            }
                                        }
                                    })
                                }
                            }
                        })
                    }
                    $("#title").html(movie.title);
                    $("#genres").html(movie.genres);
                    $("#plot").html(movie.plot);
                    $("#runtime").html(movie.runtime);
                    $("#year").html(movie.year);
                    $("#rating").html(movie.imdb_rating);

                }else{
                    alert("数据异常！");
                }
            }
        });
    }

    function formatZero(num, len) {
        if(String(num).length > len) return num;
        return (Array(len).join(0) + num).slice(-len);
    }

    return {
        loadDetails: loadDetails,
        formatZero: formatZero
    };

});
