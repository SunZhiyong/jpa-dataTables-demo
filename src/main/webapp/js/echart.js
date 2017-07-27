var myChart = echarts.init(document.getElementById('main'));

// 指定图表的配置项和数据
var option = {
title: {
text: '学生信息',
 show: true,
textAlign: 'left'
},
tooltip: {},
legend: {
data:['专业人数'],
align: 'right'
},
xAxis: {
data: []
},
yAxis: {},
series: [{
name: '专业人数',
type: 'bar',
data: []
}]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
        
$(document).ready( function () {
	myChart.on('click', function (params) {
        console.log(params);
    });
	var major = $('#major-search').val();
	$('#table_id_example').hide();
	$('#search').click(table);
	$('#search').click(echarts);
    } );

function echarts() {
	$.get('countByMajor').done(function (data) {
	    // 填入数数据
	    myChart.setOption({
	        xAxis: {
	            data:[]
	            },
	        series: [{
	            // 根据名字对应到相应的系列
	            name: '销量',
	            data:[]
	        }]
	    });
	});
}

function table(){
	var major = $('#major-search').val();
	if (major==null) {
		alert("11222");
	}
	$('#table_id_example').show();
	var table = $('#table_id_example').DataTable({
        "searching": false,
        "aLengthMenu": [
                          [5,10,15,20],
                          ["五","十","十五","二十"]
                       ],
        "PaginationType" : "full_numbers",
        "serverSide":true,
        "oLanguage": {
            "sProcessing" : "加载中...",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "sSearch" : "搜索:", 
            "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "前一页",
            "sNext": "后一页",
            "sLast": "尾页",
            "sJump" : "跳转"
            },
            "oAria" : {  
                "sSortAscending" : ": 以升序排列此列",  
                "sSortDescending" : ": 以降序排列此列"  
              }
        },
        "ajax": {
              "url":"pageone" 
        },
        "columns": [
                    {"data":"stuId"},
                    {"data":"stuName"},
                    {"data": "stuSex"},
                    {"data": "year"},
                    {"data": "department"},
                    {"data": "address"}      
        ]
    });
    
    $('#table_id_example tbody').on( 'click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } ); 
    //给按钮绑定点击事件
    $("#table_id_example_button").click(function () {
        var stuId = table.row('.selected').data().stuId;
        var stuName = table.row('.selected').data().stuName;
        alert("第一列内容："+stuId + "；第二列内容： " + stuName);
    });
}