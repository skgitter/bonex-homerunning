Ext.namespace("test");
/**
 * 锟矫碉拷一锟斤拷锟斤拷锟截碉拷MainForm锟斤拷锟斤拷锟节凤拷锟斤拷锟斤拷锟斤拷
 * @return {Ext.form.BasicForm}
 */
test.getHiddenMainForm=function(){
    if (test.hiddenMainForm) {
        var form=test.hiddenMainForm.getEl().dom;
        if (form.enctype!="application/x-www-form-urlencoded")
            form.enctype="application/x-www-form-urlencoded";
        if (form.method!="post") form.method="post";
        test.clearFormInputValue(form);
        return test.hiddenMainForm;
    }
    else{
        var id = Ext.id();
        var form = document.createElement('form');
        form.id = id;
        form.name = id;
        form.className = 'x-hidden';
        form.method="post";
        document.body.appendChild(form);
        
        var f=new Ext.form.BasicForm(form,{});
        test.hiddenMainForm=f;
        return test.hiddenMainForm;
    }
}
/**
 *
 */
var datagrid = null;
/**
 *
 */
test.gridColumn = [];
/**
 *
 */
test.initGrid = function() {
    grid = Ext.grid.GridPanel({
    
    })
}
test.initView = function(){
    var hiddenForm = test.getHiddenMainForm();
    //alert(test.contextPath + "/example/Ext_initColumn.action");
    hiddenForm.submit({
        url : test.contextPath + "/example/Ext_initColumn.action",
        method : "post",
        waitTitle : "1",
        waitMsg : "2",
        failure : function(){
            alert(0);
        },
        success : function(form,action){
            test.gridColumn = action.result.data
            var grid = new Ext.Panel({
                width : 800,
                height: 600,
                layout: 'fit',
                items: test.initGrid()
            })
            grid.render("gridview");
        }
    })
}

/**
 * 初始化数据表格
 * 
 * @return {Ext.grid.GridPanel}
 */
test.initGrid = function() {

    var reader = new Ext.data.JsonReader({
        fields : test.gridColumn,
        root : 'data',
        totalProperty : 'results'
    });
    var pageSize = 20;
    var store = new Ext.data.Store({
        url : test.contextPath + '/example/Ext_getGridData.action',
        reader : reader,
        remoteSort : true,
        baseParams : {
            limit : pageSize
        },
        sortInfo : {
            field : test.gridColumn[0]
        }
    });


    var sm = new Ext.grid.CheckboxSelectionModel();
    function getColums(sm) {
        var columns = [];
        columns.push(sm);
        for (var i=0;i<test.gridColumn.length;i++) {
            columns.push({
                id : test.gridColumn[i],
                header : test.gridColumn[i],
                dataIndex : test.gridColumn[i],
                width : 110
            })
        }
       return columns;
    }
    var grid = new Ext.grid.GridPanel({
        region : 'center',
        store : store,
        title : '帳簿',
        border : true,
        sm : sm,
        columns : getColums(sm),
        bbar : new Ext.PagingToolbar({
            store : store,
            pageSize : pageSize,
            displayInfo : true
        })
    });
    test.mainGrid = grid;
    grid.on("rowdblclick", test.viewRecHandler);
    store.load();
    return grid;
}
Ext.onReady(test.initView);