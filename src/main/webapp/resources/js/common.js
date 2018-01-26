$(document).ready(function() {

    var title = new Vue({
        el: 'title',
        data: {
            message: 'Добро пожаловать'
        }
    });

    var menu = new Vue({
        el: '.top_mnu ul',
        data: {
            topMenu: [
                {text: 'Книги', link: '' },
                {text: 'Рецензии', link: 'reviews'},
                {text: 'Авторы', link: 'authors' },
                {text: 'Люди', link: 'people' },
                {text: 'Блог', link: 'blog' }
            ]
        }
    });


    $(".comment .close, .reviews .close").click(function(){
        var $button = $(this);
        var commentId = this.id; // обрежем id чтобы получить число

        // делаем POST запрос на сервер
        $.post("/book/deleteComment/" + commentId, function( serverResponse ){
            $button.parent().remove(); // удаляем HTML комментария
        });
    });


    $(".listcomment .like .jslike button, .reviews .like .jslike button").click(function(){
        var $button = $(this);
        var commentId = this.id; // обрежем id чтобы получить число

        $.post("/book/like/" + commentId, function( serverResponse ){

            if( serverResponse === 'Yes' ) {
                var count = parseInt($button.parent().children("span#count_like").html());
                $button.parent().children("span#count_like").html(count+1);
            } else {
                alert("Error! Вы уже оценивали этот комментарий!");
            }
        });

        return false;
    });

    $(".listcomment .like .jsdislike button, .reviews .like .jsdislike button").click(function(){
        var $button = $(this);
        var commentId = this.id; // обрежем id чтобы получить число

        $.post("/book/dislike/" + commentId, function( serverResponse ){
            if( serverResponse === 'Yes' ) {
                var count = parseInt($button.parent().children("span#count_dislike").html());
                $button.parent().children("span#count_dislike").html(count+1);
            } else {
                alert("Error! Вы уже оценивали этот комментарий!");
            }
        });

        return false;
    });

    $(".listcomment .like .unauthorized button, .reviews .like .unauthorized button").click(function () {
        alert("Войдите, чтобы оценить рецензию!");
    });

    $(".link .blue").click(function() {
        if ($(".link ul").hasClass("active")){
            $(".link ul").removeClass("active");
        } else {
            $(".link ul").addClass("active");
        }
    });

    $("body").click(function(e) {
        if ($(e.target).closest(".link .blue").length==0)
            $(".link ul").removeClass("active");
    });

    $('.auth_magnific').magnificPopup({
        type: 'inline',
        midClick: true
    });

	$(".portfolio_item").each(function(i){
		$(this).find(".popup_content").attr("href", "#work_" + i);
		$(this).find(".port_descr").attr("id", "work_" + i)
	});

//	$(".auth_forms").animated("fadeInDown", "fadeOutUp");


	//Плавный скролл до блока .div по клику на .scroll
	//Документация: https://github.com/flesler/jquery.scrollTo
	$("a.scroll").click(function() {
		$.scrollTo($(".div"), 800, {
			offset: -90
		});
	});


	//Кнопка "Наверх"
	//Документация:
	//http://api.jquery.com/scrolltop/
	//http://api.jquery.com/animate/
	$("#top").click(function () {
		$("body, html").animate({
			scrollTop: 0
		}, 800);
		return false;
	});

});

// Адаптивные скрипты, которые срабатывают только при определенном разрешении экрана
// Документация: https://github.com/maciej-gurban/responsive-bootstrap-toolkit
(function($, document, window, viewport) {
	function resizeWindow() {
		// $("a").click(function() {
		// 	if (viewport.is("lg")) {
		// 		return false;
		// 	};
		// });
	};
	$(document).ready(function() {
		resizeWindow();
	});
	$(window).bind("resize", function() {
		viewport.changed(function(){
			resizeWindow();
		});
	});
})(jQuery, document, window, ResponsiveBootstrapToolkit);