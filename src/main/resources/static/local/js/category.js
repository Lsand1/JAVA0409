function delCategory(obj, cId) {
    let $this = $(obj)

    $.ajax({
        url: "/admin/category/delCategory/" + cId
        , type: "get"
        , success: function (res) {
            if (res > 0) {
                $this.parent().parent().remove();
                $("#msg").html("删除成功")
            } else {
                $("#msg").html("删除失败")
            }
        }
    })
}

function goEditCategory(obj) {
    let $this = $(obj);
    let span = $this.parent().prev().children("span");
    let input = $this.parent().prev().children("input");
    span.hide();
    input.val(span.html())
    input.show();
}

function editCategory(obj, gId) {
    let $this = $(obj);
    console.log(gId + $this.val())

    $.ajax({
        url: "/admin/category/editCategory"
        , type: "post"
        , contentType: 'application/json'
        , data: JSON.stringify({"id": gId, "name": $this.val()})
        , success: function (res) {
            console.log(res)
            if (res > 0) {
                $this.hide()
                $this.prev().html($this.val()).show();
                $("#msg").html("编辑成功")
            } else {
                $("#msg").html("编辑失败")
            }
        }
    })
}

$("#addtype").click(function () {
    let typeName = $("#gdtypeName").val().trim();
    if (typeName == "") {
        $("#msg").html("商品类别名不能为空")
        $("#gdtypeName").val()
        return false;
    }

    $.ajax({
        url: "/admin/category/addCategory"
        , type: "post"
        , data: {"name": typeName}
        , success: function (res) {
            console.log(res)

            if (res > 0) {
                $("#gdtypeName").val()
                $("#msg").html("商品类别添加成功")
            } else {
                $("#msg").html("商品类别添加失败")
            }
        }
    })
})
