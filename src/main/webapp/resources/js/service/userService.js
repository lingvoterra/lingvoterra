function sendRequestToUserController(event)
{

   var login = $('#login').val();
   var pass = $('#pass').val();
   var email = $('#email').val();
   
   // Send a request
   var xhr = new XMLHttpRequest();

   var body = 'userLogin=' + encodeURIComponent(login) +
              '&userPass=' + encodeURIComponent(pass) + 
              '&userEmail=' + encodeURIComponent(email);

   xhr.open("POST", '/lingvoterra/createuser', true)
   xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
   xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

   xhr.onreadystatechange = function() {
	   if (this.readyState != 4) return;

	   alert( "A user has been created");
	 }

   xhr.send(body);
}
		 
// Test user controller
function findUserRequest(event)
{
   var userId = $('#userId').val();
   
   // Send a request
   var xhr = new XMLHttpRequest();

   var body = 'userId=' + encodeURIComponent(userId);

   xhr.open("POST", '/lingvoterra/finduser', true)
   xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
   xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

   xhr.onreadystatechange = function() {
	   if (this.readyState != 4) return;
	   
	   var user = JSON.parse(this.responseText);
	   
	   var userInfo = $('#userInfo');
	   userInfo.empty();
	   userInfo.append(createUserWidget(user));
	 }

   xhr.send(body);
}