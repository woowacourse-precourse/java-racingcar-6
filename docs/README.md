# 자동차 경주 기능 구현 목록

## main Package

### Application
Game 타입의 CarRaceGame 객체를 생성한다.<br>
CommandLineController 객체에 Game을 주입해 생성한다.<br>
CommandLineController 객체의 start 메서드를 실행한다.

## controller Package

### controller (interface)
- start() 프로그램을 시작하는 메서드

### CommandLineController
- 멤버변수
  - Game
- 메서드
  - start() 프로그램을 시작한다.

## game Package

### Game (interface)
- 메서드
  - startGame() 게임을 시작한다.
  - 
### CarRaceGame
- 멤버변수
  - CarRaceLogic
  - int 게임을 시도할 횟수

- 생성자
  - CarRaceLogic을 초기화하는 매개변수 없는 생성자
  
- 메서드
  - startGame() 자동차 경주 게임을 시작한다.
  - saveRaceRound(String input) 사용자의 입력을 받아 레이스 라운드를 추가한다.
  - printRaceResult() 1회의 레이스 결과를 출력한다.
  - repeatHyphen() 자동차의 위치를 매개변수로 받아 매개변수만큼 하이픈을 반복해 리턴한다.
  - printFinalResult() 레이스의 최종 결과를 출력한다.

## service Package

### CarRaceService
- 멤버변수
  - Cars

- 생성자
  - Cars를 외부에서 주입받는 생성자

- 메서드
  - addCars(String input) 사용자의 입력을 받아 자동차를 추가한다.
  - moveCars() 자동차들을 이동한다.
  - getCarName() 자동차의 이름을 반환
  - getCarLocation() 자동차의 위치를 반환
  - getWinners() 우승한 자동차들의 이름을 반환
  - shouldMoveForward() 자동차가 전진할지 말지 boolean으로 리턴


## domain Package
### Car
- 멤버변수
  - String name 자동차의 이름
  - int location 자동차의 현재위치

- 생성자
  - name을 주입받고 location을 0으로 초기화하는 생성자

- 메서드
  - getName() 자동차의 이름을 리턴한다.
  - getLocation() 자동차의 현재위치를 리턴한다.
  - increaseLocation() 자동차의 위치를 1증가시킨다

### Cars
- 멤버변수
  - List<Car> cars 자동차 리스트

- 생성자
  - cars를 외부에서 주입받는 생성자

- 메서드
  - saveCars(String input) 사용자의 입력을 받아 car들을 리스트에 저장
  - validateInput 사용자의 입력값을 검증한다.
  - size() 리스트의 사이즈를 반환한다.
  - moveCar(int index) 인덱스를 받아와 특정 자동차를 움직인다.
  - getCarsInfo() 자동차의 이름과 위치를 맵에 담아 반환한다.
  - getNames() 자동차들의 이름을 리스트로 반환한다.
  - getLocations() 자동차들의 위치를 리스트로 반환한다.
  - getMaxLocation() 자동차들중에 가장 멀리간 위치를 반환한다.
  - getCarsByLocation() 매개변수로 위치를 받고 위치가 동일한 자동차들을 리스트로 반환한다.

### RandomGenerator
- 메서드
  createRandomNumber() 난수를 생성해서 리턴한다.

## constant Package

### CarRaceMessage
- 자동차 경주 게임의 메시지

### CarRaceConstant
- 자동차 경주 게임의 상수

## validate Package

### validate
- 숫자인지 확인하는 메서드
- 자동차 이름이 5자 이하인지 체크하는 메서드