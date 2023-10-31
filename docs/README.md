# 자동차 경주

## 기능 목록

- [x] 자동차는 주행한다. - Car#driving()
  - [x] 각각의 자동차는 0에서 9 사이의 무작위 값을 가진다. - Car#createRandomNumber()
  - [x] 무작위 값이 4 이상이면 자동차는 전진한다. - Car#moveForward()
- [x] 사용자는 N대의 자동차를 만든다. - User#makeCars()
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [x] 사용자가 입력한 횟수만큼 자동차가 주행한다. - User#tryDriving()
- [x] 게임 매니저는 게임이 끝난 후 누가 우승했는지 알려준다. - GameManager#announceWinner()
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
  