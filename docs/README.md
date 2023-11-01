# 🌈 구현할 기능 목록

# Car Model

## 멤버 변수

### String name

자동차의 이름을 저장하는 변수

### String forwardMovementState

전진 상황을 저장하는 변수

### int randomNumber

전진 여부를 결정하는 랜덤 정수 변수


## 멤버 함수

### void pickRandomNumber()
랜덤 숫자를 만들고 randomNumber 에 저장하는 함수

### boolean checkRandomNumber()
랜덤 숫자가 기준 숫자(이 게임 규칙의 경우 4) 이상인지 확인하는 함수

### void forward()
전진하는 함수 즉, 전진 상황을 나타내는 forwardMovement에 "-" 을 추가하는 함수

### void playRound()
랜덤 숫자를 뽑고 랜덤 숫자가 4 이상이라면 전진! pickRandomNumber() 호출 → checkRandomNumber()가 true 면 forward() 호출 

### String getNameAndStateOfCar() 
자동차의 이름과 전진 상황을 String 형태로 리턴해주는 함수

### int getForwardMovementStateOfLength()
자동차의 전진 횟수를 반환하는 함수

### String getName()
자동차 이름을 반환하는 함수

# Game Model

## 멤버 변수

### int numberOfAttempts
게임의 시도 횟수를 담는 변수

### List&lt;Car&gt; cars  
자동차 객체인 Car를 담는 리스트 변수

### List&lt;String&gt; winners
경주 승지라의 name을 담는 리스트 변수

## 멤버 함수

### void addCar(String nameOfCar)
자동차 이름을 넘겨 받아 자동차 객체를 car에 추가하는 함수

### void addCars(String userInput)
userInput 을 받아 name을 분리하고 cars 리스트에 car 를 추가하는 함수

### void startRound() 
cars 리스트에 저장된 car 객체들이 한 라운드를 수행하도록 하는 함수

### void printResultOfRound()
각 라운드의 자동차들 전진 결과를 출력하는 함수

### void findMaxForwardMovement()
가장 많이 전진한 자동차의 전진 횟수를 리턴하는 함수

### void findWinners()
자동차들의 전진 상황을 비교하여 우승자를 저장하는 함수

### boolean checkIsSoloWinner()
단독 우승자인지 확인하는 함수

### String getWinnersResult()
최종 우승자를 출력할 결과를 String으로 반환하는 함수

### int getNumberOfAttempts()
시도 횟수 반환하는 함수

# GameController

## 멤버 변수

### Game game

### GameView gameView

## 멤버 함수

### void start()
게임을 진행하는 함수, 메인 함수에서 호출

### void init()
게임을 초기화하는 함수로 사용자 입력을 받아 게임 초기화

### void play()
시도할 횟수 만큼 게임을 진행하는 함수

### void finish()
게임을 종료하며 우승자를 출력하는 함수

# GameView

### String inputNameOfCars()
경주할 자동차들의 이름을 입력 받는 함수로,
해당 함수 호출 후 void validateUserInput(String userInput) 함수를 호출하여
입력값에 대해 유효성을 검사

### int inputNumberOfAttempts()
시도횟수를 입력 받는 함수

### void printResult()
"실행 결과"를 출력하는 함수

### void printResultOfRound(Game game)
해당 라운드의 자동차들의 전진 결과를 출력하는 함수

### void printWinners()
게임의 우승자를 출력하는 함수


# ExceptionHandler

### void validateUserInput(String userInput)
입력값에 대해 유효성을 검사하는 함수

### void validateNumberOfAttempts(String Attempt)
시도 횟수 입력값에 대해 유효성을 검사하는 함수


