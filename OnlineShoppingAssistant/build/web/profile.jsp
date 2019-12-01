<%@page import="java.util.List"%>
<%@page import="com.osa.java.CartModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.osa.database.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="products_meta.jsp"></jsp:include>
<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href=""><i class="fa fa-phone"></i> +880 1914667359</a></li>
								<li><a href=""><i class="fa fa-envelope"></i> smensulaiman007@osa.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
                                                                <li><a href=""><i class="fa fa-facebook"></i></a></li>
								<li><a href=""><i class="fa fa-twitter"></i></a></li>
								<li><a href=""><i class="fa fa-linkedin"></i></a></li>
								<li><a href=""><i class="fa fa-dribbble"></i></a></li>
								<li><a href=""><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
                                                    <a href="index.jsp"><h1>Home</h1></a>
                                                </div>					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="profile.jsp" class="active"><i class="fa fa-shopping-cart"></i>Cart</a></li>                      
                                                                <li><a href="logout"><i class="fa fa-lock"></i>Log Out</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
	
					</div>

				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="index.jsp">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description">Name</td>
                                                        <td>Quantity</td>
							<td class="price">Price</td>
                                                        <td></td>
						</tr>
					</thead>
					<tbody>
                                            <%
                                               String tname = (String) session.getAttribute("tName");
                                               tname = tname.replaceAll("[^a-zA-Z0-9]", "");
                                               session.setAttribute("table", tname);
                                               Connection conn=null;
                                               PreparedStatement pst=null;
                                               ResultSet rs =null;
                                               List<CartModel> cartItem=new ArrayList();
                                               int total = 0;
                                               try{
                                               conn = DBConnection.connector();
                                               String sql= "select * from "+tname;
                                               System.out.println(sql);
                                               pst = conn.prepareStatement(sql);
                                               rs = pst.executeQuery();
                                                while(rs.next()){ 
                                                System.out.println("found");
                                                total +=Float.parseFloat(rs.getString("price").replaceAll(",", ""));
                                                System.out.println(total);
                                                String image = rs.getString("image");
                                                String name = rs.getString("pname");
                                                String price = rs.getString("price");
                                                cartItem.add(new CartModel(image,name,price));
                                                
                                            %>
						<tr>
							<td class="cart_product">
                                                            <a href=""><img src=<%= rs.getString("image") %> alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%= rs.getString("pname") %></a></h4>
                                                                <% int  i=1250; %>
                                                                <p>Web ID: <%=i++ %></p>
							</td>
                                                        <td>
                                                            <h2>1 </h2>                                                         							
							</td>
							<td class="cart_price">
								<p>$<%= rs.getString("price") %></p>
							</td>
							<td class="cart_price">
								<p></p>
							</td>
                                                        
                                                        <!-- <td>
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
                                                        -->
							<td class="cart_total">
								<p class="cart_total_price"></p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>
                                                <% } 
                                                
                                                    }catch(Exception e){

                                                                        }finally{
                                                                                session.setAttribute("cartList", cartItem);
                                                                                conn.close();
                                                                                pst.close();
                                                                                rs.close();
                                                                                    }
                                                %>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
				<p>You have to pay the money first.</p>
                                <p>Then put the transestion ID for proof.</p>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_option">
						<!--	<li>
								<input type="checkbox">
								<label>Use Coupon Code</label>
							</li>
							 -->
							
						</ul>
						<ul class="user_info">
							<li class="single_field">
								<label>Payment Method:</label>
								<select id="id1">
                                                                        <option>Select</option>
									<option>Bkash:(personal)01914667359</option>
									<option>Rocket</option>
									<option>DutchBangla</option>
									
                                                                </select>
								
							</li>
							<li class="single_field">
								<label>proof:</label>
								<select>
									<option>Select</option>
									<option>EX:Transaction</option>
									<option>EX:Rock ID</option>
									<option>EX:TRANSAC</option>
									
                                                                </select>
							
							</li>
							<li class="single_field zip-field">
								<label>Zip Code:</label>
								<input type="text">
							</li>
						</ul>
						
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
                                            <form action="cartProcessed" method="POST">
						<ul>
                                                    <li>Cart Sub Total <span><%= total %></span></li>
							<li>Eco Tax <span>00.00</span></li>
							<li>Delivary Cost <span>50</span></li>
							<li>Total <span><%= total+50.00 %></span></li>
                                                        <%
                                                        session.setAttribute("total", total);
                                                        %>
						</ul>
							<a class="btn btn-default update" href="DBDelete">Delete All</a>
                                                        <a class="btn btn-default update" href="Successfull">Continue Shopping</a>
                                                        
                                            </form>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->

<jsp:include page="products_footer.jsp"></jsp:include>
    <script src="properties/js/jquery.js"></script>
	<script src="properties/js/bootstrap.min.js"></script>
	<script src="properties/js/jquery.scrollUp.min.js"></script>
    <script src="properties/js/jquery.prettyPhoto.js"></script>
    <script src="properties/js/main.js"></script>
    <script type="text/javascript">
  function handleClick()
  {
    var value = $( "#id1 option:selected" ).text();
    alert(value);
  }
</script>
</body>
</html>
