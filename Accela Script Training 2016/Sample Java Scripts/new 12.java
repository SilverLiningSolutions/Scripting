var friends = {};
friends.bill = {
  firstName: "Bill",
  lastName: "Gates",
  number: "(206) 555-5555",
  address: ['One Microsoft Way','Redmond','WA','98052']
};
friends.steve = {
  firstName: "Steve",
  lastName: "Jobs",
  number: "(408) 555-5555",
  address: ['1 Infinite Loop','Cupertino','CA','95014']
};

var list = function(obj) {
  for(var prop in obj) {
    console.log(prop);
  }
};

var search = function(name) {
  for(var prop in friends) {
    if(friends[prop].firstName === name) {
      console.log(friends[prop]);
      return friends[prop];
    }
  }
};

list(friends);
search("Steve");
//--------------------------
(((3 * 90) === 270) || !(false && (!false)) || "bex".toUpperCase() === "BEX");
var answer=true;
//------------------------------------
// Here is an array of multiples of 8. But is it correct?
var multiplesOfEight = [8,16,24,32,40,58];

// Test to see if a number from the array is NOT a true
// multiple of eight. Real multiples will return false.
var answer = multiplesOfEight[5] % 8 !== 0;
//---------------------------------------
for (i=1; i<=20; i++) {

      if (i%5==0 && i%3==0) {
          console.log("FizzBuzz");
      } else if(i%3==0) {
          console.log("Fizz");
      } else if(i%5==0){
          console.log("Buzz");
      } else {
          console.log(i);
      }

    }
//------------------------------
var getReview = function (movie) {
switch(movie) {
case 'Toy Story 2':
return("Great story. Mean Prospector.");
break;
case 'Finding Nemo':
return("Cool animation, and funny turtles.");
break;
case 'The Lion King':
return("Great songs.");
break;
default:
return "I don't Know";
}
};
console.log(getReview(name));
//----------------------------------
console.log( "I'm ready for Objects!");
//------------------------------------
var bob = {}; 
//----------------------------------
var Spencer = {
  age: 22,
  country: "United States"
};

var me = {
  age: 22,
  country: "United States"
};
//---------------------------------
var bob = {
  name: "Bob Smith",
  age: 30
};
var susan = {
  name: "Susan Jordan",
  age: 25
};
// here we save Bob's information
var name1 = bob.name;
var age1 = bob.age;
// finish this code by saving Susan's information
var name2 = susan.name;
var age2 = susan.age
//-----------------------------------
// Take a look at our next example object, a dog
var dog = {
  species: "greyhound",
  weight: 60,
  age: 4
};

var species = dog["species"];
// fill in the code to save the weight and age using bracket notation
var weight = dog.weight
var age = dog.age
//-----------------------------------
// Our bob object again, but made using a constructor this time 
var bob = new Object();
bob.name = "Bob Smith";
bob.age = 30;
// Here is susan1, in literal notation
var susan1 = {
  name: "Susan Jordan",
  age: 24
};
// Make a new susan2 object, using a constructor instead
// Our bob object again, but made using a constructor this time 
var susan2 = new Object();
susan2.name = susan1.name;
susan2.age = susan1.age;
//----------------------------------
// help us make snoopy using literal notation
// Remember snoopy is a "beagle" and is 10 years old.
var snoopy = {
species: "beagle",
age: 10
};

// help make buddy using constructor notation
// buddy is a "golden retriever" and is 5 years old
var buddy = new Object();
  buddy.species = "golden retriever";
  buddy.age = 5;
//--------------------------------------
var bicycle = {
speed: 0,
gear: 1,
frame_material: "carbon fiber" };
//--------------------------------------
// Accepts a number x as input and returns its square
var square = function (x) {
  return x * x;
};

// Write the function multiply below
// It should take two parameters and return the product

var multiply = function (x,y) {
return multiply(x * y);
};
//-------------------------------------
// here is bob again, with his usual properties
var bob = new Object();
bob.name = "Bob Smith";
bob.age = 30;
// this time we have added a method, setAge
bob.setAge = function (newAge){
  bob.age = newAge;
};
// here we set bob's age to 40
bob.setAge(20);
// bob's feeling old.  Use our method to set bob's age to 20
//-----------------------------------------
var bob = new Object();
bob.age = 17;
// this time we have added a method, setAge
bob.setAge = function (newAge){
  bob.age = newAge;
};

bob.getYearOfBirth = function () {
  return 2014 - bob.age;
};
console.log(bob.getYearOfBirth());
//-------------------------------------
// here we define our method using "this", before we even introduce bob
var setAge = function (newAge) {
  this.age = newAge;
};
// now we make bob
var bob = new Object();
bob.age = 30;
// and down here we just use the method we already made
bob.setAge = setAge;
  
// change bob's age to 50 here
bob.setAge(50);
//--------------------------------------
// here we define our method using "this", before we even introduce bob
var setAge = function (newAge) {
  this.age = newAge;
};
// now we make bob
var bob = new Object();
bob.age = 30;
bob.setAge = setAge;
  
// make susan here, and first give her an age of 25
var susan = new Object();
susan.age = 25;
susan.setAge = setAge;
susan.setAge(35);
// here, update Susan's age to 35 using the method
//---------------------------------------
var rectangle = new Object();
rectangle.height = 3;
rectangle.width = 4;

// here is our method to set the height
rectangle.setHeight = function (newHeight) {
 this.height = newHeight;
 };

// help by finishing this method
rectangle.setWidth = function(newWidth){
this.width = newWidth;
};
// here change the width to 8 and hight to 6 using our new methods
//rectangle.setHeight = setHeight;
//rectangle.setWidth = setWidth;
rectangle.setHeight(6); 
rectangle.setWidth(8);
//----------------------------------------
var square = new Object();
square.sideLength = 6;
square.calcPerimeter = function() {
return this.sideLength * 4;
};
// help us define an area method here
square.calcArea = function() {
return this.sideLength * this.sideLength;
};

var p = square.calcPerimeter();
var a = square.calcArea();
//-------------------------------------
// here we make bob using the Object constructor
var bob = new Object();
bob.name = "Bob Smith";
bob.age = 20
// add bob's age here and set it equal to 20
//--------------------------------------------
function Person(name,age) {
  this.name = name;
  this.age = age;
}

// Let's make bob and susan again, using our constructor
var bob = new Person("Bob Smith", 30);
var susan = new Person("Susan Jordan", 25);
// help us make george, whose name is "George Washington" and age is 275
var george = new Person("George Washington", 275);
//-------------------------------------------
function Cat(age, color) {
  this.age = age;
  this.color = color;
}

// make a Dog constructor here
function Dog(myParameter) {  
    this.property = myParameter;
};
//--------------------------------
function Person(name,age) {
this.name = name;
this.age = age;
this.species = "Homo Sapiens";
}

var sally = new Person("Sally Bowles",39);
var holden = new Person("Holden Caulfield",16);

console.log("sally's species is " + sally.species + " and she is " + sally.age + " " );
console.log("holden's species is " + holden.species + " and he is " + holden.age+ " " );
//-------------------------------------------
function Rectangle(height, width) {
  this.height = height;
  this.width = width;
  this.calcArea = function() {
      return this.height * this.width;
  };
  // put our perimeter function here!
  this.calcPerimeter = function(){
    return 2*(this.height + this.width);
  }
}

var rex = new Rectangle(7,3);
var area = rex.calcArea();
var perimeter = rex.calcPerimeter();
//-----------------------------------------
function Rabbit(adjective) {
this.adjective = adjective;
this.describeMyself = function() {
console.log("I am a " + this.adjective + " rabbit");
};
}

// now we can easily make all of our rabbits

var rabbit1 = new Rabbit("fluffy");
var rabbit2 = new Rabbit("happy");
var rabbit3 = new Rabbit("sleepy");

console.log (rabbit1.describeMyself());
console.log (rabbit2.describeMyself());
console.log (rabbit3.describeMyself());
//-----------------------------------
// Our person constructor
function Person (name, age) {
    this.name = name;
    this.age = age;
}

// Now we can make an array of people
var family = new Array();
family[0] = new Person("alice", 40);
family[1] = new Person("bob", 42);
family[2] = new Person("michelle", 8);
family[3] = new Person("timmy", 6);
// add the last family member, "timmy", who is 6 years old

//---------------------------------------------------
// Our Person constructor
function Person(name, age){
this.name = name;
this.age = age;
};
// Now we can make an array of people
var family = [];
family[0] = new Person("alice", 40);
family[1] = new Person("bob", 42);
family[2] = new Person("michelle", 8);
family[3] = new Person("timmy", 6);

// loop through our new array
for (var i = 0; i < family.length; i++) {
console.log(family[i].name);
};
//------------------------------------
// Our person constructor
function Person (name, age) {
this.name = name;
this.age = age;
}

// We can make a function which takes persons as arguments
// This one computes the difference in ages between two people
var ageDifference = function(person1, person2) {
return person1.age - person2.age;
}

var alice = new Person("Alice", 30);
var billy = new Person("Billy", 25);

// get the difference in age between alice and billy using our function
var diff = ageDifference(alice,billy);
//--------------------------------------


// Our person constructor
function Person (name, age) {
this.name = name;
this.age = age;
}

// We can make a function which takes persons as arguments
// This one computes the difference in ages between two people
var ageDifference = function(person1, person2) {
return person1.age - person2.age;
};

// Make a new function, olderAge, to return the age of
// the older of two people
var olderAge = function(alice, billy) {
if (alice.age < billy.age){
return(billy.age);
}
else
{
return(alice.age);
}
};

// Let's bring back alice and billy to test our new function
var alice = new Person("Alice", 30);
var billy = new Person("Billy", 25);

console.log("The older person is "+olderAge(alice, billy));

//------------------------------------------
var spencer = {
  age: 22,
  country: "United States"
};

// make spencer2 here with constructor notation
var spencer2 = new Object();
spencer2.age = 22;
spencer2.country = "United States";
//--------------------------------------
var snoopy = new Object();
snoopy.species = "beagle";
snoopy.age = 10;

// save Snoopy's age and species into variables
// use dot notation for snoopy's species
var species = snoopy.species;

// use bracket notation for snoopy's age
var age = snoopy["age"];
//------------------------------------
// 3 lines required to make harrypotter
var harrypotter = new Object();
harrypotter.pages = 350;
harrypotter.author = "J.K. Rowling";

// A custom constructor for book
function Book (pages, author) {
this.pages = pages;
this.author = author;
}

// Use our new constructor to make the_hobbit in one line

var the_hobbit=new Book(320, "J.R.R. Tolkien");
//-----------------------------------------------
function Circle (radius) {
    this.radius = radius;
    this.area = function () {
        return Math.PI * this.radius * this.radius;
        
    };
    this.perimeter = function() {

return 2 * Math.PI * this.radius;
    }   
};
//---------------------------------------


