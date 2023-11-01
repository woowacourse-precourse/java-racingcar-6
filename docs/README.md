# Feature Specification
## The Rule of Racing Car Game

1. **Input** - Racing Car
    + The Number of Car
      + maximum # car is 16 
      + if user set more numbers of car than 16, error message will be printed(IllegalArgumentException)
    + The name of car 
      + maximum length of name is 5
      + english, special character, number are allowed
      + does not be allowed duplication
      + does not be allowed white-space

2. **Input** - The Number of Trial
    + Only be accepted INTEGER
    + Maximum value of INTEGER is same as the maximum value of int data type
   
3. **Progress** - Rule of Game
    + each car has two actions: 'go', 'stop'
    + in each trial, all cars take a random natural number within range 1 ~ 9
        >Randoms.pickNumberInRange(0,9);
    + if random number is larger than 3, the car 'go' (else 'stop')
4. **Output**
    + in each trial, print out the present status
    + when the game is over, print out the winner
      + if multiple winners do exist, separate them with commas


## Functions

**class** *GameManager*
1. it roles taking some inputs needed to play the game from user
2. send inputs to *Discriminator* to prove validation
3. play game by calling *RacingCarGame*  

**class** *Discriminator*
1. it validate user input
2. its validating list is as follows:

| object     | description                                                        |
|------------|--------------------------------------------------------------------|
| carNumber  | its range (1,16)                                                   |
| carName    | is it empty? length is more than 5 ? does it have any white-space? |
| trialCount | is it positive integer? size of input < 4097 ?                     |

**class** *RacingCarGame*
1. it plays actual game logic.
2. determinate whether each car 'go' or 'stop'
3. print out status of each round
4. print out winner

### The Rule of Commit Messages

> [title]\: [brief description] <br>
> [specific description]

| title     | description                                            |
|-----------|--------------------------------------------------------|
| init      | configuration (install package etc)                    |
| implement | implement large-scale features                         |
| add       | add a new feature                                      |
| fix       | fix a bug (in: location, for: reason)                  |
| remove    | remove (from: location)                                |
| move      | move code or files                                     |
| rename    | change the name of something                           |
| hotfix    | fix a critical bug                                     |
| refactor  | refactor code                                          |
| chore     | miscellaneous tasks such as comments, formatting, etc. |
| docs      | write or update documentation                          |

