
/**
 * Common functionality for all widgets.
 * 
 * @returns
 */
function Widget(){
	this.name;
}

Widget.prototype.getName = function(){
	return this.name;
}

Widget.prototype.setName = function(name){
	
	if (name != null || name != undefined){
		this.name = name;
	} else {
		var msg = "Widget. Data error.";
		console.log(msg);
		throw new SyntaxError(msg);
	}
}