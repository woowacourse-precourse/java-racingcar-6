# Mission
우아한 테크코스 2주차 프리코스 미션 - 레이싱카

---------------
### 개발 환경
- `Java 17.0.9`
- `Eclipse`
---------------
### 개발 목표
  1. Console.close(); 를 빼먹지 않는다.
  2. test사용법을 숙지한다.
  3. 주석을 너무 과하지 않게 쓴다.
  4. Class명과 메서드명의 의미를 정확하게 하여 주석없이도 이해가능하도록 만든다.
  5. 작동하는 Application에서는 RacingGame.start();만 호출해보자! 

---------------
### 개발 작업
- Application.java 의 main에서 작동
- 게임로직 관리를 위한 racinggame패키지 내에 RacingCarGame interface작성
```
 startGame();
```
- RacingCarGameImpl에 필요한 메서드 구현
```
startGame();        : 게임에 필요한 메서드들 호출
```
-Input을 위한 interface작성
```
 carName();
 attemtsNumber();
```
-InputImpl에 필요한 메서드 구현
```
 carName(); : n대의 차랑의 이름을 입력받는 메서드
 attemtNumber(); : 시도할 횟수를 입력받는 메서드
```
-Print를 위한 interface작성
```
 printCarPosition();
 winner();
```
-PrintImpl에 필요한 메서드 구현
```
 printCarPosition(); : 실행결과에서 자동차의 현재 위치를 찍어주는 메서드
 winner(); : 우승자를 출력할 메서드
```
-GameItem을 위한 interface작성
 ```
 carMove();
 checkWinner();
 carPosition();
```
-GameItemImpl에 필요한 메서드 구현
```
 carMove(); : 자동차가 이동하는지 확인
 checkWinner(); : 우승자를 확인하는 메서드
 carPosition(); : 자동차의 위치를 기억하는 메서드
```
--------------
