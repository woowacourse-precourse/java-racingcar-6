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

### void setName(String name)

name을 파라미터 값으로 초기화 하는 함수

### void printNameAndStateOfCar() 
자동차의 이름과 전진 상황을 프린트 해주는 함수


# Game Model

## 멤버 변수

### int numberOfAttempts
게임의 시도 횟수를 담는 변수

### List&lt;Car&gt; cars  
자동차 객체인 Car를 담는 리스트 변수

### List&lt;String&gt; winners
경주 승지라의 name을 담는 리스트 변수

## 멤버 함수

### ### void findWinners()
자동차들의 전진 상황을 비교하여 우승자를 저장하는 함수

# GameController

## 멤버 변수

### Game game

### GameView gameView

## 멤버 함수

### void init()

게임을 초기화 하고 진행하는 함수로
시도할 횟수만큼의 loop 안에서 게임을 진행함,
메인 함수에서 호출


# GameView

### void inputNameOfCars()

경주할 자동차들의 이름을 입력 받는 함수로,
해당 함수 호출 후 void validateUserInput(String userInput) 함수를 호출하여
입력값에 대해 유효성을 검사

### void inputNumberOfAttempts

### void printResult()

"실행 결과"를 출력하는 함수

### void printResultOfRound()

해당 라운드의 자동차들의 전진 결과를 출력하는 함수

### void printWinners()

게임의 우승자를 출력하는 함수


# ExceptionHandler

### void validateUserInput(String userInput)
입력값에 대해 유효성을 검사하는 함수

### void validateCarName(String name)
자동차 이름 입력값이 5글자가 넘지 않는지 유효성을 검사하는 함수

### void validateAttempt(String Attempt)
시도 횟수 입력값에 대해 유효성을 검사하는 함수


