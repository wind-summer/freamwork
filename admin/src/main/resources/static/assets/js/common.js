window.onload=function(){
    getPath();
}
var path;
function getPath(){

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    alert(result);
    path = result;
}