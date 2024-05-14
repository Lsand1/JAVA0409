$(function () {
    let url = window.location.href;
    $("#btnFresh").click(function () {
        window.location.href = url;
    })

    $("#btngoBack").click(function () {
        window.location.href ="http://localhost:8080/admin/goods/getGoodsList";
    })

    $("tr").hover(function () {
            $(this).addClass("trbg")
        }
        ,
        function () {
            $(this).removeClass("trbg")
        })
})