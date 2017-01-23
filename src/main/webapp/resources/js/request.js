/**
 * Tests the http calls from javaScript.
 */

function httpCall(){
	
	var userName = $("#userName").val();
	var userCountry = $("#userCountry").val();
	var host = 'http://goeaselystepbystep-forpublic.rhcloud.com';
	
	var url = host + "/welcome/" + userCountry + "/" + userName;
	
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);
	xhr.send(); // (1)
	
	xhr.onreadystatechange = function() { // (3)
	  if (xhr.readyState != 4) return;
	
	  $("#button1").innerHTML = 'Ready!';
	
	  if (xhr.status != 200) {
	    alert(xhr.status + ': ' + xhr.statusText);
	  } else {
	    alert(xhr.responseText);
	  }
	}
	
	 $("#button1").innerHTML = 'Loading...'; // (2)
	 $("#button1").disabled = true;
}

function callJson(){
	
	var host = 'http://goeaselystepbystep-forpublic.rhcloud.com';
	
	var url = host + "/taskjson";
	
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);
	xhr.send(); // (1)
	
	xhr.onreadystatechange = function() { // (3)
	  if (xhr.readyState != 4) return;
	
	  $("#button2").innerHTML = 'Ready!';
	
	  if (xhr.status != 200) {
	    alert(xhr.status + ': ' + xhr.statusText);
	  } else {
	    alert(xhr.responseText);
	  }
	}
	
	 $("#button2").innerHTML = 'Loading...'; // (2)
	 $("#button2").disabled = true;
}
