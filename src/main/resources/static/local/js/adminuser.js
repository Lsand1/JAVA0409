function editAdminuser(adminId) {

    $.ajax({
        url: "/admin/adminuser/editAdminuser"
        , type: "post"
        , contentType: 'application/json'
        , data: JSON.stringify({"id": adminId})
        , success: function (res) {
            console.log(res)
            if (res > 0) {
                $("#msg").html("重置成功")
            } else {
                $("#msg").html("重置失败")
            }
        }
    })
}

$("#addtype").click(function () {
    let typeName = $("#gdtypeName").val().trim();
    if (typeName == "") {
        $("#msg").html("管理员姓名不能为空")
        $("#gdtypeName").val()
        return false;
    }

    $.ajax({
        url: "/admin/adminuser/addAdminuser"
        , type: "post"
        , data: {"name": typeName}
        , success: function (res) {
            console.log(res)
            if (res > 0) {
                $("#gdtypeName").val()
                $("#msg").html("用户添加成功")
            } else {
                $("#msg").html("用户添加失败")
            }
        }
    })
})
function goEditCategory(obj) {
    let $this = $(obj);
    let span = $this.parent().prev().children("span");
    let input = $this.parent().prev().children("input");
    span.hide();
    input.val(span.html())
    input.show();
}
function editCategory(obj, aId) {
    let $this = $(obj);
    console.log(aId + $this.val())

    $.ajax({
        url: "/admin/adminuser/mimaAdminuser"
        , type: "post"
        , contentType: 'application/json'
        , data: JSON.stringify({"id": aId, "password": $this.val()})
        , success: function (res) {
            console.log(res)
            if (res > 0) {
                $this.hide()
                $this.prev().html($this.val()).show();
                $("#msg").html("密码更改成功")
            } else {
                $("#msg").html("密码更改失败")
            }
        }
    })
}
$("#btnChPws").click(function (){
    let p1 = $("#psw").val();
    let p2 = $("#psws").val();
    if(p1!=p2){
        $("#msg").html("两次密码不一致");
        return false;
    }
    $.ajax({
        url: "editmimaAdminuser1"
        , type: "post"
        , contentType: 'application/json'
        , data: JSON.stringify({"id": $("input[name='id']").val(), "password": $("#psws").val()})
        , success: function (res) {
            console.log(res)
            $("#msg").html(res.message);
        }
    })
})
