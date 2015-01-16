var iJabConf =
{
    client_type:"xmpp",//调用协议
    app_type:"bar",//嵌入类型
    theme:"standard",//主体
    debug:false,//调试模式
    //avatar_url:"http://samespace.anzsoft.com/portal_memberdata/portraits/{username}",//获取用户头像
    avatar_url: getRootPath() + "/ijab/ijab/images/default_avatar.png",
    enable_roster_manage:false,//添加好友
    enable_talkto_stranger:true,//隐藏自己
    expand_bar_default:false,//扩展栏
    enable_login_dialog:true,//登陆框
    hide_online_group:true,//隐藏在线好友组
    disable_option_setting:true,
    disable_msg_browser_prompt:false,
    xmpp:{
        domain:"192.168.0.173",
        http_bind: getRootPath() + "/http-bind",
        host:"192.168.0.173",
        port:5222,
        server_type:"openfire",
        auto_login:false,
        none_roster:false,
        get_roster_delay:true,
        username_cookie_field:"username",
        token_cookie_field:"SID",
        anonymous_prefix:"",
        max_reconnect:3,
        enable_muc:false,
        muc_servernode:"",
        vcard_search_servernode:""
    },
    disable_toolbox:true,
    tools:
    [],
    shortcuts:
    [],
    ijabcometd:{
    }
};

var reloadFlag = false;//加载组织机构标示
var reDrawFlag = false;//重绘界面元素标示

window.onload = function(){
	if(console != undefined){
		console.log("HTTP-BIND地址：" + getRootPath() + "/http-bind");
	}
	
	setInterval(function(){//重绘界面元素
		if(!reDrawFlag){
			var alist = document.getElementsByTagName("a");
			for(var i = 0 ; i < alist.length ; i++){
				if(alist[i].title == "Manage gateway" || alist[i].title == "聊天记录"){
					alist[i].outerHTML = "";
				}
			}
			
			//为了兼容操蛋的IE所以使用了tdlist[i].getAttribute("className")的写法
			var tdlist = document.getElementsByTagName("td");
			for(var i = 0 ; i < tdlist.length ; i++){
				if(tdlist[i].getAttribute("className") == "tabMiddleCenter" || tdlist[i].getAttribute("class") == "tabMiddleCenter"){
					tdlist[i].outerHTML = "";
				}
			}
			
			var divlist = document.getElementsByTagName("div");
			for(var i = 0 ; i < divlist.length ; i++){
				if(divlist[i].getAttribute("className") == "ijab_tabsubtitle" || divlist[i].getAttribute("class") == "ijab_tabsubtitle"){
					divlist[i].outerHTML = "";
				}
			}
			
			reDrawFlag = true;
		}
	},100);
	
	setInterval(function(){//加载组织机构
		if(!reloadFlag){
			if(iJab != undefined && iJab.getStatus() == "STATUS_ONLINE"){
				triggerClick();
				triggerClick();
				reloadFlag = true;
			}
		}
	},100)
	
	
	setTimeout(function(){//自动登陆示例！！
		iJab.loginWithStatus("admin","admin","STATUS_INVISIBLE");
	},2000);
}

function triggerClick() {//为了解决组织机构初始不出现的问题
	var obj = "";
	var alist = document.getElementsByTagName("a");
	for(var i = 0 ; i < alist.length ; i++){
		if(alist[i].getAttribute("className") == "ijab-window-close" || alist[i].getAttribute("class") == "ijab-window-close"){
			obj = alist[i];
			break;
		}
	}
	
	if (document.createEvent) {
		var evObj = document.createEvent('MouseEvents');
		evObj.initEvent('click', true, false);
		obj.dispatchEvent(evObj);
	} else if (document.createEventObject) {
		obj.fireEvent('click');
	}
}

function getRootPath(){//获取项目根路径
//    var curWwwPath=window.document.location.href;
//    var pathName=window.document.location.pathname;
//    var pos=curWwwPath.indexOf(pathName);
//    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
//    return projectName;
	return "/JabberIM";
}

