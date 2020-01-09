//基于此函数发送ajaxGet请求
function doAjaxGet(url,params,callback){
	//debugger //bug调试
	//console.log("url:",url);
	//1.创建ajax请求对象
	var xhr=new XMLHttpRequest();
	//2.注册事件监听(监听客户端与服务端的通讯状态)
	xhr.onreadystatechange=function(){
		//readyState==4表示与服务端的通讯结束
		//status==200表示服务端响应正常
		if(xhr.readyState==4&&xhr.status==200){
			//console.log("result",xhr.responseText)
			callback(xhr.responseText);
		}
	};
	//3.建立与服务端的连接
	xhr.open("GET",url+"?"+params,true); //true表示异步，false表示同步
	//4.发送请求
	xhr.send(null);//GET请求，此方法内部不传任何参数
}

//基于此函数发送ajaxPost请求
function doAjaxPost(url,params,callback){
	var xhr=new XMLHttpRequest();
	//2.注册事件监听(监听客户端与服务端的通讯状态)
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			callback(xhr.responseText);
		}
	};
	//3.建立与服务端的连接
	xhr.open("POST",url,true); //true表示异步，false表示同步
	//post请求必须设置如下请求头
	xhr.setRequestHeader("Content-Type",
	"application/x-www-form-urlencoded");
	//4.发送请求
	xhr.send(params);//POST请求，参数放到send方法内
}