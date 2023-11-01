# 자동차 경주

## 기능 구현

- [x] 자동차 이름을 쉼표(,)를 기준으로 여러대 입력받는다. - InputView#readCarName()
    - [x] 자동차의 이름이 5자 이하인지 검사한다. - CarNameValidator#validateLengthFiveOrLess()
    - [x] 자동차의 이름이 1자 이상인지 검사한다. - CarNameValidator#validateNotBlank()
- [x] 자동차를 몇 번 이동 할 것인지 입력 받는다. - InputView#readMoveCount()
    - [x] 입력이 숫자인지 검사한다. - NumberValidator#validateDigit()
- [x] 전진하는 자동차를 출력 한다. - OutputView#printRacingResult()
- [x] 최종 우승자를 출력 한다. - OutputView#printWinners()
- [x] 자동차는 랜덤 숫자가 4 이상이라면 전진한다. - Car#move()
    - [x] 무작위 값이 4 이상인지 여부를 반환한다. - Car#isMoveForward()
- [x] 레이싱 게임에 참여할 자동차를 추가한다. - RacingGame#addCar()
- [x] 레이싱 게임은 자동차를 이동시킨다. - RacingGame#moveCar()
    - [x] 0에서 9 사이의 무작위 값을 구해 반환한다. - RandomNumberGenerator#createRandomNumber()
- [x] 레이싱 게임 라운드 결과를 반환한다. - RacingGame#getResult()
- [x] 레이싱 게임 우승자를 반환한다. - RacingGame#getWinners()
- [x] 레이싱 게임을 시작한다. - RacingGameController#play()

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
