## 자동차 경주

## 기능 목록

- [x] 자동차 이름을 입력한다. - inputCarNames()
  - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 이름은 5자 이하만 가능하다. (입력 오류 : IllegalArgumentException) - checkNamingError

- [x] 이동을 시도할 횟수를 입력한다. - inputNumberOfRaces()
  - [x] 숫자만 입력이 가능하다. (입력 오류 : IllegalArgumentException)

- [x] 각 자동차는 전진 또는 멈출 수 있다.
  - [x] 0에서 9 사이의 무작위 값을 생성한다.
  - [x] 무작위 값이 4 이상이면 전진이다. - generateAction()
  - [x] 각 자동차의 움직임을 저장한다. - recordCarAction()
  - [x] 매 시도마다 각 자동차의 이동 여부를 이름과 함께 "-" 형태로 출력한다. - printCarRace()
  - [x] 입력한 시도할 횟수만큼 반복한다.

- [x] 자동차 경주 게임 완료하면 누가 우승했는지 출력한다. - printWinner
  - [x] 누가 가장 많이 전진했는지 알 수 있다. - decideWinner()
  - [x] 우승자는 1명 이상일 수 있다.
  - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용해 구분한다.

## 리팩토링 작업에 고려할 주요 요구 사항

- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기.
  - [x] decideWinner() 함수에서 winner의 index를 구하는 기능을 별도 함수 extractWinnerIndex()로 분리.