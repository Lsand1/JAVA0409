$(function () {
    $("img").viewer();

    $(".width150").on("mouseenter", function () {
        var that = this;
        var text = $(this).find("input").val();
        layer.tips(text, that, {
            tips: 1,
            time: 2000         //设置显示时间
        });
    });
})


function delGoods (obj,gId) {
    let $this = $(obj)
    $.ajax({
        url: "/admin/goods/delGoods/" + gId
        ,type: "delete"
        ,success:function (res){
            if(res){
                $this.parent().parent().remove();
                $("#msg").html("删除成功")
            }else{
                $("#msg").html("删除失败")
            }
        }
    })
}