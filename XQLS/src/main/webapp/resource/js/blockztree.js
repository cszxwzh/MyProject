	//文本框中下拉tree的设置
	var setting2 = {
		view: {
				dblClickExpand: false
			},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeClick: beforeClick,
			onClick: onClick1
		}
	};
	
	//判断选择的节点是否为父级节点
	function beforeClick1(treeId, treeNode) {
			var check = (treeNode && !treeNode.isParent);
			if (!check) alert("只能选择城市...");
			return check;
		}
	
	//点击事件，如果不是父级节点。设置对应的文本框的值为点击的节点的名称
	function onClick1(e, treeId, treeNode) {
		var zTree = jQuery.fn.zTree.getZTreeObj("treeSelect"),
		nodes = zTree.getSelectedNodes(),
		v = "";
		id = "";
		nodes.sort(function compare(a,b){return a.id-b.id;});
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
			id += nodes[i].id+","
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		if (id.length > 0 ) id = id.substring(0, id.length-1);
		var cityObj = $("#blocksel");
		if($("#blocksel option").length>0){
		$("#blocksel").empty();
		}
		cityObj.append("<option value='"+id+"'>"+v+"</option>");
		hideMenu();
	}
	
	//在选择了区块之后联动获取对应的设备
	function getequip(blockNum){
		dw.ajax({
			url:"${request.contextPath}/equip/selbyblock",
			type:"post",
			data:{"blockNum":blockNum},
			dataType:"json",
			success:function(msg){
			if($("#equipsel option").length>0){
				$("#equipsel").empty();
			}
			for(var i =0;i<msg.length;i++){
				$("#equipsel").append("<option value='"+msg[i].equipId+"'>"+msg[i].equipName+"</option");
			}
			}
			});
	}
	
	//通过ajax查询出需要显示的内容，s为需要显示树形图的元素的id，set为上面的setting json数据
	function showtree(s,set) {
		dw.ajax({
					url : "${request.contextPath}/block/treeresult",
					type : "post",
					dataType : "json",
					success : function(data) {
						//初始化，ztree的显示
						zTreeObj = jQuery.fn.zTree.init($("#"+s),
								set, data);
					}
				});
	}