# 자동차 경주

## 기능 목록
- [X] 대회를 진행할 수 있다. - Refree#playRace()
  - [X] 입력에 대한 예외 상황을 처리한다. - Refree#carNameInputError()
  - [X] n개의 자동차를 생성한다. - CarGenerator#createCar()
    - [X] 모든 자동차가 한 번씩 턴을 진행한다. - Refree#playTurn()
      - [X] 0 ~ 9 사이 무작위 값을 생성한다. - NumberGenerator#createRandomNumber()
      - [X] 자동차가 전진할 수 있는지 알 수 있다. - Refree#isForward()
      - [X] 자동차의 이름과 전진 상황을 출력할 수 있다 - Car#printStatus()
      - [X] 자동차는 전진할 수 있다. - Car#moveForward()
- [X] 대회의 우승자를 판단할 수 있다. - Refree#getWinners()
- [X] 대회의 우승자를 출력할 수 있다. - Refree#printWinners()


## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.