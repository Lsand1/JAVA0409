$("#input").change(function (e){
    Array.from(e.target.files).map((f=>{
        // 构造form表单格式数据
        let formData = new FormData();
        formData.append("file",f);
        axios.post("/admin/uploadFile",formData).then(res=>{
            let imageUrl = "/local/image/goods/"+res.data;
            $("#img").attr("src",imageUrl).css("display","block")
            $("#gdimage").attr("value",imageUrl);
        })

    }))
});