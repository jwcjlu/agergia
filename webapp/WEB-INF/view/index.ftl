<!DOCTYPE html>
<#macro showPage pager>
<table border="1">
<tr><td>id</td><td>模块名称</td><td>是否已审核</td></tr>
<#list pager.data as testing>
<tr><td>${testing.id}</td><td>${testing.name}</td><td>${testing.status?string('true','false')}</td></tr>
</#list>
</table>
</#macro>
<html>
<p>我们${haha}</p>  
<p>你好:${maplist.name}</p>   
<p>你的地址：${maplist.address}</p>  
<p>你的公司：${maplist.company!}</p>  
  
Welcome ${user!}!  
Welcome ${user!'your name'}!  
或者  
${user?if_exists}  
${user?default('your name')} 
<@showPage testingPage>
</@showPage> 
</html> 