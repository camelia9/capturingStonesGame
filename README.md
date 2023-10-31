# capturingStonesGame 

Back-end: Java Spring Boot application
Versions: 
* Spring: 3.1.5
* Java: 17

  
Start: run CapturingStonesApplication class and Tomcat will start at port 8080 on localhost. The server will start a new game session once it is started

Front-end: Angular application
Versions:
* Angular: 13.2.0

  
Start: ng serve command will start the app at port 4200


Web interface:
![Screenshot 2023-10-31 at 17 08 51](https://github.com/camelia9/capturingStonesGame/assets/17930848/de8204d6-a23c-4c31-af26-46514546114a)

How to play:
* Start the back-end and front-end components and open http://localhost:4200/ in your browser.
* The cases with numbers represent the pile of stones available for each player. They are clickable, when a player clicks on one of the pile, they are moving the stones and distribute them to the following plies. The last pile is connected to the first pile of the oponenent.
* The last cases represent the big piles in which the stones are cumulating and they are not clickable because we cannot move sones from there.
* Only one player can move stones at one time, the active player will be displayed on the screen.
* When the last stone lands in the last pit, the current player gets an extraround.
*  When the last stone lands in an empty pile of the active player, they get to collect the stones in the oposite pile of the opponent.
* When the game starts, the status is ACTIVE and will remain ACTIVE until the game ends.
* The game ends when one of the players runs out of stones.
* The declared winner will be the one who has collected the most stones in the final pile.

Components:

![game drawio](https://github.com/camelia9/capturingStonesGame/assets/17930848/2bfc788a-f79f-447d-97bd-9633f5cf4c0e)
