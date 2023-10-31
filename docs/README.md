## 구현 기능

1. Main
    - racingGame() 구현 : Racing Game의 로직이 전체적으로 실행되고 호출하는 메서드
    - print 기능 구현 
      - 자동차의 현재 포지션을 print 하는 printCurreuntStatus() 구현
      - 최종 우승자를 출력하는 printWinners() 기능 구현

2. Car Class 
    - Racing 게임에 사용될 자동차를 생성하는 클래스
    - 자동차의 name, position의 정보를 저장.
    - move()를 통해 자동차가 움직일지, 정지할지 결정
    - Position에 따른 움직임을 보여주는 Position method 구현

3. validator class
    - 유저가 입력하는 입력값들을 검증하는 클래스
    - tryCount, carName 등 유저가 입력하는 값을 검증하고, 올바르지 않을 시 IllegalArgumentException을 발생 시킨다.

4. 각각의 기능들을 테스트하는 단위 테스트 만들기