function Word(wordId, word, partOfSpeech, frequency){
	this.wordId = wordId;
	this.word = word;
	this.partOfSpeech = partOfSpeech;
	this.frequency = frequency;
}

Word.prototype.getWordId = function(){
    return this.wordId;
}

Word.prototype.setWordId = function(wordId){
    this.wordId = wordId;
}

Word.prototype.getWord = function(){
    return this.word;
}

Word.prototype.setWord = function(word){
    this.word = word;
}

Word.prototype.getPartOfSpeech = function(){
    return this.partOfSpeech;
}

Word.prototype.setPartOfSpeech = function(partOfSpeech){
    this.partOfSpeech = partOfSpeech;
}

Word.prototype.getFrequency = function(){
    return this.frequency;
}

Word.prototype.setFrequency = function(frequency){
    this.frequency = frequency;
}
