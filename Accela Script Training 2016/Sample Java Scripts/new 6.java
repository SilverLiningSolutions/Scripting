var coinFace = Math.floor(Math.random() * 2);

while(coinFace === 0){
	console.log("Heads! Flipping again...");
	var coinFace = Math.floor(Math.random() * 2);
}
console.log("Tails! Done flipping.");
//---------------------------------------------
var understand = true;

while( understand ){
	console.log("I'm learning while loops!");
	understand = false;
}

//----------------------------------------
//Remember to set your condition outside the loop!
for (var counter = 0; counter < 2; counter++) {
	console.log("Looped once!");
}
var loop = function(){
  var myCondition = true;

while(myCondition) {
    console.log("Looped once!");
    myCondition = false;
}
};

loop();

//-----------------------
var loopCondition = false;

do {
	console.log("I'm gonna stop looping 'cause my condition is " + loopCondition + "!");	
} while (loopCondition);
//--------------------------------
var getToDaChoppa = function(){
  // Write your do/while loop here!
  var loopCondition = false;

do {
	console.log("I'm gonna stop looping 'cause my condition is " + loopCondition + "!");	
} while (loopCondition);

};

getToDaChoppa();
//--------------------------------
// Write your code below!
var cities = ["Jason", "Krystal", "Shaley", "Dillon", "Demarie"];

for (var i = 0; i < cities.length; i++) {
    console.log("I would like to visit " + cities[i]);
}
var loop = function(){
  var myCondition = true;

while(myCondition) {
    console.log("Looped once!");
    myCondition = false;
}
};
var condition = false;
do {
    console.log("I'm printed once!");
} while(condition);

