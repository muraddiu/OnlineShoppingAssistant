<header class="header-login-signup">

    <div class="header-limiter">

        <h1><a href="index.jsp">Online Shopping <span>Assistant</span></a></h1>
        <% //String name = (String) request.getAttribute("username"); 
            String name = (String) session.getAttribute("username");
            if (name != null) {
                out.write("<ul><li>Welcome </li><li><a href=\"profile.jsp\">" + name + "</a></li></ul>");
            } else {
                      
            String uri = request.getRequestURI();

            String pageName = uri.substring(uri.lastIndexOf("/") + 1);
            session.setAttribute("path", pageName);
  
                            session.setAttribute("path", pageName);
                out.write("<ul><li><a href=\"logIn.jsp\">Login</a></li><li><a href=\"registration.jsp\">Sign up</a></li></ul>");
            }
        %>
    </div>

</header>