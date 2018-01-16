function getHref_Param(){
    // 获取最后的参数
    // 例获取http://localhost:8888/user?userid=1&username=2中的userid=1&username=2
    var items = window.location.href.split("?")[1];
    //判断是否有多个参数，及是否有&符号存在
    if(items.indexOf('&') != -1){// 多个参数
        items = items.split('&');
    }

    // 将items转换成map
    var map = {};// 定义map

    for(var i=0;i<items.length;i++){
        var key = items.split('=')[0];
        var value = items.split('=')[1];

        map[key] = value;
    }
    return map;
}