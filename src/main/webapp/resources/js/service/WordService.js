function WordService()
{
}

WordService.prototype.getWordList = function(event){
 // Send a request
   var xhr = new XMLHttpRequest();

   var body = '';

   xhr.open("POST", '/goeaselystepbystep/getwordlist', true);
   xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
   xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

   xhr.onreadystatechange = function() {
	   
	   if (this.readyState != 4) return;
	   var dataParser = new DataParser();
	   
	   var wordList = dataParser.formWordList(this.responseText);
	   buildWordListTable(wordList.getWordList());
	 }

   xhr.send(body);
}

function buildWordListTable(wordListData){
 
   // Build widget
   var wordList = $('#wordList');
   wordList.empty();
   
   var wordListWidget = new WordListWidget();
   
   var widgetHtml = wordListWidget.create(wordListData);
   wordList.append(widgetHtml);
}
