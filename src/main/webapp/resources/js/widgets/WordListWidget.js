function WordListWidget(){
    // Initialize parent's fields.
    Widget.apply(this, arguments);
}

//Create inheritance
WordListWidget.prototype = Object.create(Widget.prototype);

// Save the constructor
WordListWidget.prototype.constructor = WordListWidget;

/*
function create(wordList)
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
*/

WordListWidget.prototype.create = function (wordList)
{
	var translationURL = "https://www.vocabulary.com/dictionary/";
	
	var result = "<div class=\"container\">";
	
	result += "<h2>Word list</h2>";
	result += "<p>The following is the wordlist to lean:</p>";
	
	result += " <table class=\"table\">";
	result += "    <thead>";
	result += "      <tr>";
	result += "        <th>WordId</th>";
	result += "        <th>Word</th>";
	result += "        <th>Part of Speech</th>";
	result += "      </tr>";
	result += "    </thead>";
	    
	result += "    <tbody>";
	
	// Add the table content to the html
	wordList.forEach(function(element, index, wordList) {
		result += "<tr>";
		result += " <td>" + element.getWordId() + "</td>";
		result += " <td><a href=" + translationURL + element.getWord() + " target=\"_blank\">" + element.getWord() + "</a></td>";
		result += " <td>" + element.getPartOfSpeech() + "</td>";
		result += "</tr>";
	})
		    
	result += "	       </tbody>";
	result += "	   </table>";
	
	result += "	</div>";
	
    return result;   
    
}