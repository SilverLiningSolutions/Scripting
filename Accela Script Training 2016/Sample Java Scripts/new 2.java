// Below is the greeting function!
// See line 7
// We can join strings together using the plus sign (+)
// See the hint for more details about how this works.

var greeting = function (name) {
    console.log("Great to see you," + " " + name);
};

// On line 11, call the greeting function!

greeting("Jason");

// Write your foodDemand function below.
// Last hint: In your reusable block of code, end each line
// with a semicolon (;)
var foodDemand = function(foodDemand)
  console.log("I want to eat" + " " + food);
  foodDemand("Cookies");
  
// Nicely written function:
var calculate = function (number) {
    var val = number * 10;
    console.log(val);
};

// Badly written function with syntax errors!

var greeting = function(name){
    console.log("name");
    greeting("Jason");
    } 
//15	
var orangeCost = function (orangeCost) {
    var price = number * 5;
    console.log(val);
    orangeCost("2.00");
};

// Parameter is a number, and we do math with that parameter
var timesTwo = function(number) {
    return number * 2;
};

// Call timesTwo here!
var newNumber = timesTwo(5);
console.log(newNumber);
// Define quarter here.
var quarter = function (quarter) {
    var quarter = quarter / 4;
    console.log(quarter);
}



if (quarter() % 3 === 0 ) {
  console.log("The statement is true");
} else {
  console.log("The statement is false");
}

var my_number = 7; //this has global scope

var timesTwo = function(number) {
    var my_number = number * 2;
    console.log("Inside the function my_number is: ");
    console.log(my_number);
}; 

timesTwo(7);

console.log("Outside the function my_number is: ")
console.log(my_number);
//11
var nameString = function (name) {
console.log("Hi, I am" + " " + name);
  nameString("Jason");
};

//12
// Write your function below. 
// Don't forget to call your function!
var sleepCheck = function(numHours){
if(numHours >= 8){
 return "You're getting plenty of sleep! Maybe even too much!";   
}
else
{
    return "Get some more shut eye!";
}
}