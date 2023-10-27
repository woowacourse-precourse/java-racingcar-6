# 자동차 경주 기능 구현 목록

## Main Package

### Application
Game 타입의 CarRaceGame 객체를 생성한다.<br>
UserInterface 객체에 Game을 주입해 생성한다.<br>
UserInterface 객체의 start 메서드를 실행한다.

## UI

### UserInterface
- 멤버변수
  - Game
- 메서드
  - start() 프로그램을 시작한다.

## Game Package

### Game (interface)
- 메서드
  - startGame() 게임을 시작한다.
  - stopGame() 게임을 종료한다.

### CarRaceGame
- 멤버변수
  - CarRaceLogic
  - int 게임을 시도할 횟수

- 생성자
  - CarRaceLogic을 초기화하는 매개변수 없는 생성자
  
- 메서드
  - startGame() 자동차 경주 게임을 시작한다.
  - stopGame() 자동차 경주 게임을 종료한다.
  - saveRaceCount(String input) 사용자의 입력을 받아 레이스 횟수를 추가한다.
  - printRaceResult() 1회의 레이스 결과를 출력한다.
  - printFinalResult() 레이스의 최종 결과를 출력한다.

## Logic Package

### CarRaceLogic
- 멤버변수
  - Cars

- 생성자
  - Cars를 초기화하는 생성자

- 메서드
  - addCars(String input) 사용자의 입력을 받아 자동차를 추가한다.
  - moveCars() 자동차들을 이동한다.
  - getCarName() 자동차의 이름을 반환
  - getCarLocation() 자동차의 위치를 반환
  - getWinners() 우승한 자동차들을 반환
  - shouldMoveForward() 자동차가 전진할지 말지 boolean으로 리턴


## Domain Package
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

### RandomGenerator
- 메서드
  createRandomNumber() 난수를 생성해서 리턴한다.

### CarRaceConstants
- 애플리케이션을 유지보수하기 쉽게 출력할 문자열들과 상수를 저장한다.
