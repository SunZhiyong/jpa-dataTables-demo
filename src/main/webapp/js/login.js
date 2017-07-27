  // login.js
currentpage = 0;
$(function(){
	$("#query").click(getPage);
	$('#firstpage').click(firstpage);
	$('#prepage').click(prepage);
	$('#nextpage').click(nextpage);
	$('#lastpage').click(lastpage);
});

function getPage(){
	$('#student').empty();
	/*if(!($("#currentpage").val())){
	currentpage = $("#currentpage").text();
	}*/
	var url='./pageone';
	var pageSize = $('#pagesize').val();
	
	console.log(currentpage);
	console.log(pageSize);
	var data = {"page":currentpage, 
			"pagesize":pageSize};
    $.post(url, data, function(result){
        
        if(result.state == 1){
        	var studentInfo = result.data;
            var studentList = studentInfo.content;
            console.log(studentInfo);
            console.log(studentInfo.totalElements);
            console.log(studentInfo.totalPages);
        	$('#currentpage').text(currentpage+1);
        	$('#totalitems').text(studentInfo.totalElements);
        	$('#totalpages').text(studentInfo.totalPages);
        	$('#current').show();
        	$('#firstpage').show();
        	$('#prepage').show();
        	$('#nextpage').show();
        	$('#lastpage').show();
        	$('caption').text("学生信息");
        	$('#student').append("<caption><h4>"+"学生信息"+"</h4></caption>");
        	$('#student').append("<tr>"+
        			"<th>"+"学号"+"</th>" +
        	  		"<th>"+"姓名"+"</th>" +
        	  		"<th>"+"性别"+"</th>" +
        	  		"<th>"+"出生日期"+"</th>" +
        	  		"<th>"+"院系"+"</th>" +
        	  		"<th>"+"家庭地址"+"</th>" +
        	  				"</tr>");
            var length = studentList.length;
            for(var i=0;i<length;i++)
            	{
            	  $('#student').append("<tr>"+
            			"<td>"+studentList[i].stuId+"</td>" +
            	  		"<td>"+studentList[i].stuName+"</td>" +
            	  		"<td>"+studentList[i].stuSex+"</td>" +
            	  		"<td>"+studentList[i].year+"</td>" +
            	  		"<td>"+studentList[i].department+"</td>" +
            	  		"<td>"+studentList[i].address+"</td>" +
            	  				"</tr>");
            	}
            
        }
        else {
            var msg = result.message;
            alert(msg);
        }
    });
}

function firstpage(){
	currentpage=0;
	getPage();
}

function prepage(){
	if(currentpage>0){
		currentpage=currentpage-1;
	}
	else{
		currentpage=0;
		alert("到第一页！");
	}
	getPage();
}

function nextpage(){
	var totalpages =$('#totalpages').text();
	if(currentpage<totalpages-1){
		currentpage=currentpage+1;
	}
	else{
		currentpage=totalpages-1;
		alert("最后一页了！");
	}
	getPage();
}

function lastpage(){
	var totalpages =$('#totalpages').text();
	currentpage=totalpages-1;
	getPage();
}

