# 자동차 경주 기능 구현 목록
가장 큰 범위의 패키지를 mvc패턴으로 나누었다.

## Application
Game 타입의 CarRaceGame 객체를 생성한다.<br>
controller 타입의 CommandLineController 객체에 Game을 주입해 생성한다.<br>
CommandLineController 객체의 start 메서드를 실행한다.

## Model

### Car
- 멤버변수
  - 자동차의 이름
  - 자동차의 현재위치
- 생성자
  - 이름을 매개변수로 받고 현재위치를 0으로 초기화하는 생성자
- 메서드
  - getName() 자동차의 이름을 반환
  - getLocation() 자동차의 현재위치를 반환
  - increaseLocation() 자동차의 현재위치를 1증가
### Cars
- 멤버변수
  - 자동차 타입의 List
- 생성자
  - List를 초기화하는 생성자
- 메서드
  - saveCars(String input) 자동차를 List에 추가
  - size() 리스트의 size를 반환
  - moveCar(int index) 매개변수와 동일한 index의 car 위치를 이동
  - getNames() 자동차들의 이름을 반환
  - getLocations() 자동차들의 위치를 반환
  - getMaxLocation() 가장 멀리간 자동차의 위치를 반환
  - getCarsByLocation(int location) 매개변수와 동일한 위치의 자동차 List를 반환 
### RandomGenerator
- 메서드
  createRandomNumber() 난수를 생성해서 리턴한다.
### CarRaceService
- 멤버변수
  - Cars 객체
- 생성자
  - Cars를 초기화 하는 생성자
- 메서드
  - addCars(String input) 사용자의 입력을 받아 자동차들을 추가
  - moveCars() 자동차들을 이동
  - moveCar(int index, boolean shouldMove) true면 index의 자동차를 이동
  - shouldMoveForward() 자동차가 이동할지 말지 boolean으로 리턴
  - getCarName() 자동차의 이름을 반환
  - getCarLocation() 자동차의 위치를 반환
  - getWinners() 우승한 자동차들의 이름을 반환
### CarRaceMessage
- 자동차 경주 게임의 메시지
### CarRaceConstant
- 자동차 경주 게임의 상수
### validate
- 숫자인지 확인하는 메서드
- 자동차 이름이 5자 이하인지 체크하는 메서드
- 숫자가 아닌지 확인하는 메서드

## view

### Game (interface)
- 메서드
  - startGame() 게임을 시작한다.
### CarRaceGame
- 멤버변수
  - CarRaceService 객체
  - gameRound 게임을 시도할 횟수
- 생성자
  - CarRaceService를 초기화하고 gameRound를 0으로 초기화하는 생성자
- 메서드
  - startGame() 게임을 실행
  - saveRaceRound(String input) 사용자의 입력을 받아 게임을 시도할 횟수를 설정
  - printRaceResult() 1회의 레이스 결과를 출력
  - repeatHyphen() 매개변수만큼 하이픈을 반복해 String으로 반환
  - printFinalResult() 레이스의 최종 결과를 출력

## controller

### controller (interface)
- start() 프로그램을 시작
### CommandLineController
- 멤버변수
  - Game
- 메서드
  - start() 프로그램을 시작