##                     

1. 게임을 시작한다.
    - 시작할 때 시작 메세지를 출력시킨다.
2. 레이싱 자동차들의 이름을 `.`단위로 입력받는다.
    - ","단위로 Car 객체 생성
        - Car객체 : 이름, 전진 횟수
    - 이름의 길이가 5를 넘어가는지 확인
3. 레이싱 횟수(count)를 입력받는다.
    - 레이싱 횟수가 0인지 확인
    - 레이싱이 빈값인지 확인
5. 입력받은 횟수만큼 Car객체들에 대해서 랜덤숫자를 구한다.(0-9)
    - 4이상일 경우만 전진한다.
6. 이후 Car객체들의 위치(결과)를 출력한다.
7. 3번에서 입력받은 count만큼 5,6번을 반복한다.
8. count민큼 반복했으면 가장 많이 전진한 횟수를 구하고 그 횟수를 가진 Car객체의 이름들을 출력한다.

## 클래스 설명

### domain

#### 1. Car.class

- 레이싱 자동차에 대한 객체
- `name` : 자동차 이름
- `moveCount` : 전진한 횟수
- `validataeNameBlank()` : 자동차 객체를 생성하기 전 이름이 빈값으로 들어오는지 체크하는 메서드
- `validataeNameLength()` : 자동차 객체를 생성하기 전 이름의 길이가 유효한 길이인지 체크하는 메서드
- `move()` : 매개변수로 받은 값이 유효한 지 확인하고 자동차를 전진시키는 메서드
    - `isMovable()` : `move()`에서 매개변수로 받은 값을 전달받아 유효한 값인지 확인하는 메서드

#### 2. Cars.class

- 레이싱 자동차들을 List타입의 멤버변수로 가지는 객체
- `carList` : 입력받은 자동차 정보를 통해 만든 Car List
- `validateDuplicateCar()` : 자동차들의 이름을 기준으로 중복값이 존재하는지 체크하는 메서드
- `moveCars()` : carList에 있는 Car객체들의 `move()`를 호출하고, 이때 random number를 전달해준다.
- `generateRandomNumber()` : random number를 생성하는 메서드
- `getMaxPosition()` : Car객체들이 가지고 있는 position의 값중 가장 큰 position의 값을 구하는 메서드
- `getWinner()` : `getMaxPosition()`을 통해 구한 position값을 이용하여 게임 우승자를 찾고 List<String> 타입으로 return하는 함수
    - List<String> 타입으로 return하는 이유는 출력을 용이하게 하기 위함

### controller

#### 1. RacingController.class

- `run()` : 게임을 동작시키는 함수
- `startRacing()` : 레이싱을 시작시키는 함수
- `endRacing()` : 레이싱이 종료되면 레이싱 결과를 출력하는 함수

### service

#### 1. RacingService

- `Cars` : carList를 멤버변수로 가지는 변수
- `racingCount` : 진행해야하는 레이싱 횟수
- `playRacing()` : 레이싱을 한 회차 실행시키는 메서드
- `isPlayRacing()` : `racingCount`가 1이상인지 확인하는 메서드
- `getCars()` : `Cars`객체를 return하는 메서드

### util

#### 1. ErrorException

#### 2. Message

### view

#### 1. InputView.class

#### 2. OutputView.class
