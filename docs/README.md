## 기능 목록

  - n대의 자동차의 이름 : 쉼표(,) 기준으로 구분하여 받을 수 있어야 한다. Application
  - 이동 횟수 입력 받아 반복한다. Game.play()
  - 자동차 이름은 5자 이하로 구성되어야 한다. Car()
  - 0~9 사이에 무작위 값을 만든다. NumberGenerator.createRandomNumber()
  - 4 이상인지 비교가 가능하다. NumberGenerator.compare()
  - 4 이상은 이동을 한다. Car.move()
  - 1 게임은 모든차량에 대해 이동여부를 결정한다. Game.raceOne()
  - 매 회 자동차들의 전진 상태를 이름과 함께 출력해줘야 한다. Referee.reportNow()
  - 게임이 종료될 때 우승자 발표한다. 중복우승 시 쉼표로 구분. Referee.announceWinner()
  - 전달하는 메세지는 정해진 포맷에 맞게 작성되야 한다. MessageMaker

## 클래스
- [x] Application
  - 게임 횟수만큼 실행
- [x] NumberGenerator
  - [x] createRandomNumber()
  - [x] compare()
- [x] Car
  - [x] String name; int location;
  - [x] move()
- [x] Game
  - [x] int playNum; Car[] players;
  - [x] play()
  - [x] raceOne()
- [x] Referee
  - [x] announceWinner()
  - [x] reportNow()
- [x] MessageMaker
  - [x] winnerMessage()
  - [x] playerLocationMessage()
