<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Main menu</title> 
</head> 
<body> 
<form method="post" action="/ProjectJEE/CtrlMain"> 
 <table> 
 <tr> 
  <td> 
   <input type="submit" name="formOk" value="listaDocenti"> 
  </td> 
 </tr> 
 <tr> 
  <td> 
   <input type="submit" name="formOk" value="insertDocenti"> 
  </td> 
 </tr>
 <tr> 
  <td> 
   <input type="submit" name="formOk" value="deleteDocenti"> 
  </td> 
 </tr>
 <tr> 
  <td> 
   <input type="submit" name="formOk" value="updateDocenti"> 
  </td> 
 </tr>
</table>
<br>
<br>
<br>
<table>
  <tr> 
  <td> 
   <input type="submit" name="formOk" value="listaDiscenti"> 
  </td> 
 </tr> 
  <tr> 
  <td> 
   <input type="submit" name="formOk" value="insertDiscenti"> 
  </td> 
 </tr>
  <tr> 
  <td> 
   <input type="submit" name="formOk" value="deleteDiscenti"> 
  </td> 
 </tr>
 <tr> 
  <td> 
   <input type="submit" name="formOk" value="updateDiscenti"> 
  </td> 
 </tr>
</table> 
</form> 
</body> 
</html>