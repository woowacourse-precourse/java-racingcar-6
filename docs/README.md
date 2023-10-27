## 자동차 경주

## 기능 목록

- [x] 자동차 이름을 입력한다. - inputCarNames()
  - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 이름은 5자 이하만 가능하다. (입력 오류 : IllegalArgumentException) - checkNamingError

- [x] 이동을 시도할 횟수를 입력한다. - inputNumberOfRaces()
  - [x] 숫자만 입력이 가능하다. (입력 오류 : IllegalArgumentException)

- [ ] 각 자동차는 전진 또는 멈출 수 있다. - tryToGo()
  - [ ] 0에서 9 사이의 무작위 값을 생성한다.
  - [ ] 무작위 값이 4 이상이면 전진이다.
  - [ ] 매 시도마다 각 자동차의 이동 여부를 이름과 함께 "-" 형태로 출력한다.

- [ ] 자동차 경주 게임 완료하면 누가 우승했는지 출력한다. - decideWinner()
  - [ ] 누가 가장 많이 전진했는지 알 수 있다. - measureDistance()
  - [ ] 우승자는 1명 이상일 수 있다.
  - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용해 구분한다.