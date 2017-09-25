// Write your function below. 
// Don't forget to call your function!
var sleepCheck = function(numHours)
if(numHours >= 8){
 return "You're getting plenty of sleep! Maybe even too much!";   
}
else
{
    return "Get some more shut eye!";
}
sleepCheck(10);
sleepCheck(5);
sleepCheck(8);
//--------------------------
var userChoice = prompt("Do you choose rock, paper or scissors?");
var computerChoice = Math.random();
console.log(computerChoice);
if (computerChoice < 0.33) {
    console.log("rock");
} else if (computerChoice < .067) {
    console.log("paper");
} else {
    console.log("scissors");
}
var compare = function(userChoice, computerChoice){
if (userChoice === computerChoice) {
return "The result is a tie!";
}
else if (userChoice === "rock");
if (computerChoice === "scissors") {
    return "rock wins";
}
else{
    return "paper wins";
}
};

//--------------------------------
var userChoice = prompt("Do you choose rock, paper or scissors?");
var computerChoice = Math.random();
if (computerChoice < 0.34) {
	computerChoice = "rock";
} else if(computerChoice <= 0.67) {
	computerChoice = "paper";
} else {
	computerChoice = "scissors";
}
console.log("Computer: " + computerChoice);

var compare = function(userChoice, computerChoice){
if (userChoice === computerChoice) {
return "The result is a tie!";
}
//rock - scissors
else if (userChoice === "rock") {
if (computerChoice === "scissors") {
    return "rock wins";
}
else{
    return "paper wins";
}
}
//rock - paper
else if (userChoice === "rock") {
if (computerChoice === "paper") {
    return "paper wins";
}
else {
    return "scissors wins";
}
}
//paper - rock
else if (userChoice === "paper") {
if (computerChoice === "rock") {
    return "paper wins";
}

}
//paper - scissors
else if (userChoice === "paper") {
if (computerChoice === "scissors") {
    return "scissors wins";
}

}
//scissors - rock
else if (userChoice === "scissors") {
if (computerChoice === "rock") {
    return "rock wins";
}

}
//scissors - paper
else if (userChoice === "scissors") {
if (computerChoice === "paper") {
    return "paper wins";
}

}
};