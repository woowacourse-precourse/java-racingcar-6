## 기능 목록

- [X] 게임을 시작 한다. - RacingCarGame#startGame()

- [X] 자동차 이름 입력 문구를 출력 한다. - InputView#printCarNameInputMsg()
- [X] 시도 횟수 입력 문구를 출력 한다. - InputView#printTryCountInputMsg()

- [X] 실행 결과를 출력한다.
  - [X] 실행 결과 문구를 출력한다. OutputView#printGameResultMsg()
  - [X] 자동차들의 위치를 출력한다. OutputView#printCarsPosition()
  - [X] 우승자를 출력한다. OutputView#printWinnersName()

- [X] 값을 입력할 수 있다.
  - [X] 자동차 이름을 부여한다. - User#inputCarName()
    - [X] 값을 검증할 수 있다. - validateCarName()
  - [X] 시도 횟수를 정한다. - User#inputTryCount()
    - [X] 값을 검증할 수 있다. - validateTryCount()

- [X] 자동차는 전진 혹은 멈출 수 있다. Car#canMove()
  - [X] 0과 9사이에 무작위 값을 생성한다. - Car#generateRandomNumbers()
  - [X] 값이 4이상이면 자동차를 전진한다. - Car#move()

- [X] 우승자를 가려낼 수 있다. - Judge#decideWinner()
  - [X] 각 자동차들의 위치를 알 수 있다. - Car#getPosition()

- [X] 예외사항
  - [X] 이름이 5자를 초과한다.
  - [X] 이름이 공백으로 입력된다.
  - [X] 시도 횟수가 입력되지 않는다.
  - [X] 시도 횟수가 숫자가 아닌 다른 값이 입력된다.
  - [X] 가장 많이 간 자동차가 여러 대임에도, 우승자가 여러 명이 아니다.
  - [X] 가장 많이 간 자동차가 우승자가 아니다.

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.