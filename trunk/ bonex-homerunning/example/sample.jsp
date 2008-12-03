<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@ include file="../common/ext-header.jsp"%>

<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
var hiddenFrame = null;
function getHiddenFrame(){
    if (hiddenFrame) return hiddenFrame;
    else{
        var id = Ext.id();
        var frame = document.createElement('iframe');
        frame.id = id;
        frame.name = id;
        frame.className = 'x-hidden';
        if(Ext.isIE){
            frame.src = Ext.SSL_SECURE_URL;
        }
        document.body.appendChild(frame);
        if(Ext.isIE){
           document.frames[id].name = id;
        }
        hiddenFrame=frame;
        return hiddenFrame;
    }
}
var tbar=null;
var win=null;
var txt = new Ext.form.TextField({fieldLabel:"Hello2", value: ""});
var form=null;
    var ds=new Ext.data.JsonStore({
        url:'<%=contextPath%>/example/Ext.action',
        root : 'root',
        fields: ['words','name']
    });
function loadWin(method){

    ds.load();
    var alarm = function (){
    var na=ds.getAt(0).get("words")[0];
    alert(na);
        var name = ds.data.items[0].json.words;
        document.getElementById("name").value=name;
    };

    form = new Ext.form.FormPanel({
           url:'<%=contextPath%>/example/Ext.action',
           layout:"form",
           defaultType : "textfield",
           labelAlign:"right",
           width : 300,
           items : [{id:"ssa",fieldLabel:"Hello", value: ""},
           txt],
           deferHeight : true//,
           //submit : submitForm
        });
    //动态生成Toolbar
    xbar = new Ext.Toolbar({deferHeight : true, items:[{text:'test'}]});
    if (method == "1"){
        tbar = new Ext.Toolbar.Button({text:'name'});
        txt.setValue("damn");
        }
    else
        tbar = new Ext.Toolbar.Button({text:'name'},{text:'name2'});;
    
     win= new Ext.Window({
           layout:"fit",
           title: "hello world",
           height: 400,
           width:300,
           //tbar : [tbar],
//           topToolbar : xbar,
            tbar:xbar,
           items : [form],
           buttons: [{text:'btn1',handler : normalSubmit},{text:'btn2',handler:changeTbar}]
        });
    //win.on("submit",submitForm);
    win.show(document.body);
    }
    var setView=function(){
        loadWin("1");
        };
    
    function changeTbar(){
       if (tbar.length == 2 ) {
        txt.setValue("damn");
        }
        //动态增加按钮
        xbar = win.topToolbar;
        xbar.addSeparator();
        xbar.addButton({text:'faint'});
        //form.items.remove(form.items.get(0));
        //form.items.insert(0,new Ext.form.TextField({fieldLabel:"dam"}));
        form.doLayout();
        //alert(form.items.get(0).getName());
        
        form.items.get(0).TextField({fieldLabel:"die"});
        
        //dom表单提交
        //oform = document.forms[0];
        //改变dom的提交方向
        //oform.action="/blog/example/Ext.action";
        //oform.method="get";
        //oform.submit();
        //ExtJs表单提交
        //params为提交到parameter的参数
        //默认使用FormPanel定义的url
        //form.form.submit({params:{method:"post",name:"good",failure:true}});
        
    }
    function normalSubmit() {
        hiddenFrame = getHiddenFrame();
        var formEl = form.getForm().getEl().dom;
        formEl.target = hiddenFrame.id;
        formEl.action = "<%=contextPath%>/example/Ext_write.action";
        formEl.submit();
    }
    function extAlarm(){
        Ext.MessageBox.alert("111","333");
    };        
    Ext.onReady(setView);
</script>
</html>