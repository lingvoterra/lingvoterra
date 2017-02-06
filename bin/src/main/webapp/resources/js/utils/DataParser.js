function DataParser(){
	
}

DataParser.prototype.formWordList = function(responseText){
	
	var wordListData = JSON.parse(responseText);
	var wordList = new WordList();
		
	for (var i = 0; i < wordListData.length; i++){
		var word = new Word(wordListData[i]["wordId"],
							wordListData[i]["word"],
							wordListData[i]["partOfSpeech"],
							wordListData[i]["frequency"]);
		
		wordList.getWordList().push(word);
	}
	
	return wordList;
}