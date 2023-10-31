# 자동차 경주

## 기능 목록
- [x] 경주할 자동차의 이름을 ','를 기준으로 입력받는다. - Game#inputCars()
  - [] 이름은 5자 이하만 가능하다. - Game#correctLength()
  - [] 잘못된 입력에 경우 IllegalArgumentException을 발생시킨다.
- [] 사용자가 몇 번의 이동을 할지 입력받는다. - Game#inputMoveNum()
- [] Game#operate()
  - [] 전진 조건에 의해 4이상인지 확인한다. - Game#verfityMoveCondition()
  - [] 전진 조건에 적합하면 이동한다. - Game#moveCar()
  - [] 이동 현황을 출력한다 - Game#printCurrentState()
- [] 우승자의 기록을 찾는다. - Game#searchMaxDist()
- [] 우승자를 선별 후 출력한다. - Game#printVitory()


### 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

e.g. input : pobi,woni,jun

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

e.g. input : 5

입력 받은 이동 횟수 만큼 자동차를 이동한다. 
이때 전진 조건은  0에서 9 사이의 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

e.g.

pobi : --

woni : ----

jun : ---


우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

e.g. 최종 우승자 : pobi, jun

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.