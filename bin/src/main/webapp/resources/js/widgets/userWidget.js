


function createUserWidget(user)
{
	var attrMap = new Map();
	
	attrMap.set("Id", user.userId);
	attrMap.set("Login", user.login);
	attrMap.set("Pass", user.pass);
	attrMap.set("E-mail", user.email);

	var result = "<div id = 'userWidget' class = 'rounded-corners'>" +
		   	"<table>"; 

	// Add the table content to the html
	attrMap.forEach(function(value, key, attrMap) {
		  result +=  "<tr><td class = 'align-cell-text-right'><b>" + key + ":</b></td><td>" + value + "</td></tr>";
	})
	
	result += "</table></div>";
    return result;    
}

// This could be done when a list of users will be available

/*
function createUserWidgetTableView(userList)
{
	
	var attrMap = new Map();
	
	attrMap.set("Id", user.userId);
	attrMap.set("Login", user.login);
	attrMap.set("Pass", user.pass);
	attrMap.set("E-mail", user.email);
	
	
	<div class="container">
	  <h2>Basic Table</h2>
	  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            
	  <table class="table">
	    <thead>
	      <tr>
	        <th>Id</th>
	        <th>Login</th>
	        <th>Pass</th>
	        <th>E-mail</th>
	      </tr>
	    </thead>
	    
	    <tbody>
	      
		      <tr>
		        <td>John</td>
		        <td>Doe</td>
		        <td>john@example.com</td>
		      </tr>
		      <tr>
		        <td>Mary</td>
		        <td>Moe</td>
		        <td>mary@example.com</td>
		      </tr>
		      <tr>
		        <td>July</td>
		        <td>Dooley</td>
		        <td>july@example.com</td>
		      </tr>
	    
	      </tbody>
	  </table>
	</div>
	
	var result = "<div id = 'userWidget' class = 'rounded-corners'>" +
		   	"<table>"; 

	// Add the table content to the html
	attrMap.forEach(function(value, key, attrMap) {
		  result +=  "<tr><td class = 'align-cell-text-right'><b>" + key + ":</b></td><td>" + value + "</td></tr>";
	})
	
	result += "</table></div>";
    return result;   
    
}*/