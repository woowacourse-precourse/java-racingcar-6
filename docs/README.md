### 기능 목록 정리

1. 사용자에게 경주 할 자동차 이름을 쉼표를 기준으로 입력 받는다. - `InputView#carNames()`
2. 컴퓨터는 쉼표를 기준으로 이름을 구분한 후, 경주에 참여할 자동차 목록을 만든다. - `Cars#splitCarNames()`
3. 시도할 횟수를 입력 받는다. - `InputView#attemptCount()`
4. 각 자동차마다 0에서 9사이의 무작위 값을 구한 후 4 이상일 경우 전진한다. - `Car#moveOrStop()`
5. 입력한 횟수만큼 아래 과정을 반복한다. - `RaceController#race()`
   1. 모든 자동차가 기능 목록 4번을 시행한다.
   2. 한 번 시행을 마칠때 마다 현재 상황을 출력한다. - `OutputView#printProcess()`
6. 실행이 끝나고 난 후, 가장 많이 전진한 자동차를 찾는다. - `Winners#Winners()`
7. 실행이 끝나고 난 후, 가장 많이 전진한 자동차 이름을 출력한다. - `OutputView#printWinners()`
   - 하나 이상일 수 있다.
***
### 예외 처리
- 자동차 이름이 공백일 경우 - `NameValidator#isNameEmpty()`
- 자동차 이름이 중복일 경우 - `NameValidator#isNameDuplicate()`
- 자동차 이름 길이가 5를 초과하는 경우 - `NameValidator#isNameLengthExceeded()`
- 자동차의 수가 2대 미만인 경우 - `NameValidator#isCarCountLessThanTwo()`
- 시도할 횟수가 0번이나 음수일 경우, 또는 정수가 아닌 경우 - `AttemptValidator#isPositiveDigit()`

*이름에 공백이 있을 경우, 예외 처리를 할지 고민했으나 car 1, car 2와 같이 가독성을 위해 띄어쓰기를 할 수도 있다고 판단해 예외 처리는 따로 하지 않았다.*

위 예외에 해당할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션이 종료된다.
***
### 1주차 코드 리뷰를 통해 학습한 내용
- stream()
- 일급 컬렉션을 활용
- enum 활용
- 객체지향에서 객체가 무엇이고 책임과 역할에 대한 고찰

