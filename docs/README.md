## 기능 목록 

---
### 자동차 이동 기능 - MoveOrStopCar
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.  - moveOrStopCarsForGivenTimes()
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. - conditionAdvancing()

### 사용자 입력 기능 - InputMessage
- [ ] 사용자는 몇 번을 시도할 것인지를 입력할 수 있어야 한다. - userInputNumberOfAttempts()
- [ ] 사용자는 자동차 이름은 쉼표(,)를 기준으로 구분하며 입력한다. - userInputCarName()

### 출력 기능 - OutputMessage
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. - printMovingCarNames()
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. - printWinnerAfterRaceCompletion()

### 사용자 입력 검증 기능 - InputValidation
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다 아닐 경우 `IllegalArgumentException` 을 발생시킨다. - raiseErrorIfCarNameExceedsLimit()
- [ ] 시도할 회수가 문자거나 마이너스이면 `IllegalArgumentException` 을 발생시킨다. - raiseErrorIfAttemptCountIsInvalid()