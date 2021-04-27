var addbox;//添加用户窗口
var saveOrModify;//true保存，false 修改

//超级函数，特点是页面加载完成后马上执行的一个函数
$(function () {
    //查询数据库，显示数据
    //js语言是脚本语言，运行在浏览器上，浏览器只能请求和接收
    //实现局部刷新Ajax技术，jquery框架提供的ajax函数实现ajax请求
    selectAll();

})


//***************************
function selectUser() {
    var xingming  = $("#xingming").val();
    //清除table表体数据
    $("#userList tbody").empty();
    $.ajax({
        type:"post",
        url:ctx+"/user?op=selectUser",
        dataType:"json",
        data:{
            xingming:xingming,
        },
        success:function (data) {
            //显示用户信息
            //data是json数据，多条用户信息，得到的data是一个json数组
            var num = data.length;
            for(var i=0;i<num;i++){
                var n = i+1;
                $("#userList tbody").append("<tr>\n" +
                    "      <td align='center'>"+n+"</td>\n" +
                    "      <td align='center'>"+data[i].xingming+"</td>\n" +
                    "      <td align='center'>"+data[i].zhuanye+"</td>\n" +
                    "      <td align='center'>"+data[i].banji+"</td>\n" +
                    "      <td align='center'>"+data[i].xingbie+"</td>\n" +
                    "      <td align='center'><a href='#' onclick='modify("+data[i].id+")'>修改</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a  href='#' onclick='deleteUser("+data[i].id+")'>删除</a></td>\n" +
                    "  </tr>");
            }

        },
        error:function (data) {
            // alert('error');
        }

    });
}
function selectAll() {
    //清除table表体数据
    $("#userList tbody").empty();
    $.ajax({
        type:"post",
        url:ctx+"/user?op=selectAll",
        dataType:"json",
        data:{},
        success:function (data) {
            //显示用户信息
            //data是json数据，多条用户信息，得到的data是一个json数组
            var num = data.length;
            for(var i=0;i<num;i++){
                var n = i+1;
                $("#userList tbody").append("<tr>\n" +
                    "      <td align='center'>"+n+"</td>\n" +
                    "      <td align='center'>"+data[i].xingming+"</td>\n" +
                    "      <td align='center'>"+data[i].zhuanye+"</td>\n" +
                    "      <td align='center'>"+data[i].banji+"</td>\n" +
                    "      <td align='center'>"+data[i].xingbie+"</td>\n" +
                    "      <td align='center'><a href='#' onclick='modify("+data[i].id+")'>修改</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a  href='#' onclick='deleteUser("+data[i].id+")'>删除</a></td>\n" +
                    "  </tr>");
            }

        },
        error:function (data) {
            // alert('error');
        }

    });
}
//删除用户
function deleteUser(id) {
    $.ajax({
        type:"post",
        url:ctx+"/user?op=deleteUser",
        dataType:"json",
        data:{
            id:id,
        },
        success:function (data) {
          alert("删除成功！");
          selectAll();
        },
        error:function (data) {
            alert("删除失败！");
        }

    });
}
//打开修改界面
function  modify(id) {
    saveOrModify  = false;
    addbox = new Boxy($("#user") //显示内容
        ,
        {
            title: "用户添加", //对话框标题
            modal: true, //是否为模式窗口
            afterHide: function(e) { }, //隐藏时的回调函数
            afterShow: function(e) {  }, //显示时的回调函数
            closeText: "关闭",   //关闭功能按钮的标题文字
            y:10
        });

    addbox.tween(450 ,300); //设置对话框的大小450宽，300高

    //加载数据
    $.ajax({
        type:"post",
        url:ctx+"/user?op=modify",
        dataType:"json",
        data:{
            id:id,
        },
        success:function (data) {
            $("#id").val(data.id);
            $("#name").val(data.name);
             $("#pass").val(data.pass);
            $("#axingming").val(data.xingming);
            $("#banji").val(data.banji);
            $("#zhuanye").val(data.zhuanye);
            $("#xingbie").val(data.xingbie);
        },
        error:function (data) {
        }

    });
}
//打开添加窗口
function openAdd() {
    saveOrModify = true;
    //清空数据
    $("#id").val("");
    $("#name").val("");
    $("#pass").val("");
    $("#axingming").val("");
    $("#banji").val("");
    $("#zhuanye").val("");
    $("#xingbie").val("");
    addbox = new Boxy($("#user"), //显示内容,
        {
            title: "用户添加", //对话框标题
            modal: true, //是否为模式窗口
            afterHide: function(e) { }, //隐藏时的回调函数
            afterShow: function(e) {  }, //显示时的回调函数
            closeText: "关闭",   //关闭功能按钮的标题文字
            y:10
        });

       addbox.tween(450 ,300); //设置对话框的大小450宽，300高


}
//保存或修改用户信息
function save() {
    if(saveOrModify){
        addbox.hide(function () {
            //关闭添加窗口后执行的代码
            //保存数据库
            var name = $("#name").val();
            var pass = $("#pass").val();
            var xingming = $("#axingming").val();
            var banji = $("#banji").val();
            var zhuanye = $("#zhuanye").val();
            var xingbie = $("#xingbie").val();

            $.ajax({
                type:"post",
                url:ctx+"/user?op=add",
                data:{
                    name:name,
                    pass:pass,
                    xingming:xingming,
                    banji:banji,
                    zhuanye:zhuanye,
                    xingbie:xingbie
                },
                success:function (data) {
                    alert("保存成功！");
                    selectAll();
                },
                error:function (data) {
                    alert("保存失败！");
                }

            });
        });
    }else{//修改
        addbox.hide(function () {
            //关闭添加窗口后执行的代码
            //保存数据库
            var id = $("#id").val();
            var name = $("#name").val();
            var pass = $("#pass").val();
            var xingming = $("#axingming").val();
            var banji = $("#banji").val();
            var zhuanye = $("#zhuanye").val();
            var xingbie = $("#xingbie").val();

            $.ajax({
                type:"post",
                url:ctx+"/user?op=update",
                data:{
                    id:id,
                    name:name,
                    pass:pass,
                    xingming:xingming,
                    banji:banji,
                    zhuanye:zhuanye,
                    xingbie:xingbie
                },
                success:function (data) {
                    alert("修改成功！");
                    selectAll();
                },
                error:function (data) {
                    alert("修改失败！");
                }

            });
        });
    }

}

