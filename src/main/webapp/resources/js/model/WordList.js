function WordList(){
	this.wordList = [];
}

WordList.prototype.getWordList = function(){
	return this.wordList;
}

WordList.prototype.setWordList = function(wordList){
	this.wordList = wordList;
}
