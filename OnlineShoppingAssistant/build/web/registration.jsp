<%-- 
    Document   : registration
    Created on : Mar 5, 2018, 2:56:56 PM
    Author     : Solaiman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Register form</title>  
        <link rel="stylesheet" href="properties/css/reg_style.css">
    </head>
    <body>  
        <div class="step-bar">
            <ul>
                <li>
                    <div class="number active">1</div>
                    <div class="text">account setup</div>
                </li>
                <li> 
                    <div class="number">2</div>
                    <div class="text">profiles</div>
                    <div class="line"></div>
                </li>
                <li> 
                    <div class="number">3</div>
                    <div class="text">details</div>
                    <div class="line"></div>
                </li>
            </ul>
        </div>
        <h1>Create new account</h1>
        <form id="reg" action="UserRegistration" method="GET">
            <div class="account-setup register-form">
                <h2>Step 1</h2>
                <input name="email" type="email" placeholder="Email"/>
                <input name="password" type="password" placeholder="Password"/>
                <input name="confirmPassword" type="password" placeholder="Confirm Password"/>
                <div class="button firstNext">Next</div>
            </div>
            <div class="user-details register-form">
                <h2>Step 2</h2>
                <input name="name" type="text" placeholder="Full name"/>
                <input name="address" type="text" placeholder="address"/>
                <input name="phone" type="text" placeholder="Phone No"/>
                <div class="button firstPrev">Back</div>
                <div class="button secondNext">Next</div>
            </div>
            <div class="finish-step register-form">
                <h2>Step 3</h2>
                <label for="birth-day">Birth date</label>
                <input class="error" name="birth-day" type="date"/>
                <div class="error-text">*This field is required</div>
                </label>
                <div class="button secondPrev">Back</div>
                <div class="button" id="submit">Register</div>
            </div>
        </form>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script  src="properties/js/index.js"></script>
    </body>
</html>

