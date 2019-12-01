<%-- 
    Document   : logIn
    Created on : Mar 5, 2018, 2:46:31 PM
    Author     : Solaiman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>another login panel</title>
      <link rel="stylesheet" href="properties/css/login_style.css">
</head>

<body>

  <div class="loginpanel">
  
      <form action="ValidateLogIn" method="POST">
      <div class="txt">
    <input id="user" type="text" placeholder="Email" name ="email" />
    <label for="user" class="entypo-user"></label>
  </div>
  <div class="txt">
    <input id="pwd" type="password" placeholder="Password" name ="password"/>
    <label for="pwd" class="entypo-lock"></label>
  </div>
  <div class="buttons">
    <input type="Submit" value="Login" />
    <span>
      <a href="registration.jsp" class="entypo-user-add register">Register</a>
    </span>
  </div>
      </form>
  
  <div class="hr">
    <div></div>
    <div>OR</div>
    <div></div>
  </div>
  
  <div class="social">
    <a href="javascript:void(0)" class="facebook"></a>
    <a href="javascript:void(0)" class="twitter"></a>
    <a href="javascript:void(0)" class="googleplus"></a>
  </div>
</div>

<span class="resp-info"></span>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

</body>

</html>
