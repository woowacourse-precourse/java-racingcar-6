# 자동차 경주

# 구조 리팩터링
### 책임을 더 나누기 위해 MVC 패턴 적용
### 일급 컬렉션 사용
### 함수는 한가지 기능만 수행하도록
### 별도의 예외 처리 클래스 -> 예외가 생각보다 많아짐.






***
# 리팩터링 이전 구조 
## 기능 목록
- [X] 자동차 이름 입력 : Application#inputCarNames()
  - [X] 각 이름은 쉼표로 구분 : Application#extractCarName()
  - [X] 이름은 5자이하 가능 : Car#checkCharacterLimit()
  - [X] 게임에 자동차 추가 : GameHost.addCars() 
  - [X] 잘못된 입력 : IllegalArgumentException
- [X] 자동차 이동 횟수 입력 : Application#inputMoveCount()
  - [X] 잘못된 입력 : IllegalArgumentException
- [X] 게임 진행 : GameHost#playOneTurn()
  - [X] 자동차 전진 : 0~9의 무작위 값이 4이상일 경우 - Car#moveForward()
  - [X] 게임 진행 정보 확인 : 자동차 이름 , 적산거리 출력 - Car#toString()
- [X] 게임 완료 후, 우승자 출력 : GameHost#announceWinner()
  - [X] 우승자 쉼표로 구분하여 출력 - GameHost#getWinner()

# Class

## 사용자(Application) 
### 메서드
자동차 이름 입력 : inputCarName()
이동횟수 입력 : inputMoveCount()


## 자동차(Car)
### 프로퍼티
이름 : name

적산거리 : odometer


### 메서드
전진하기 : moveForward()

이름 + 적산 거리 출력 : toString()

## 게임 진행자(GameHost) :
### 프로퍼티
+ Enum

INPUT_CAR_NAME: 경주할 자동차 이름 질문

TRY_COUNT: 시도할 회수 질문

GAME_RESULT: 실행 결과 출력문

WINNER: 우승자 출력문

+ 자동차 리스트 : carList

+ 진행 회수 : moveCount

### 메서드
게임 진행 : playGame()
게임 한번 진행 : playOneTurn()



## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
