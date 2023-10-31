## 레이싱 게임

## 🚀 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 구현 목록

### GameSetting
- [ ] 경주 할 자동차 이름을 부여한다. - `GameSetting`#`createCarName()`
  - [ ] 사용자로부터 자동차 이름을 입력 받는다. - `InputDataHandler`#`getStringFromPlayer()`
  - [ ] 자동차 이름을 쉼표를 기준으로 분리한다. - `InputDataHandler`#`separateString()`
  - [ ] 자동차 이름이 5자리 이하인지 검사한다. 잘못된 입력이면 `IllegalArgumentException`을 발생시키고 종료한다. - `InputValidator`#`checkStringLength()`
- [ ] 시도 횟수를 입력 받는다. - `GameSetting`#`createAttemptNumber()`
  - [ ] 사용자로부터 시도 횟수를 입력 받는다. - `InputDataHandler`#`getNumberFromPlayer()`
  - [ ] 시도 횟수를 제대로 입력 받았는지 검사한다. 잘못된 입력이면 `IllegalArgumentException`을 발생시키고 종료한다. - `InputValidator`#`checkNumber()`

### Racing
- [ ] 자동차 이름 입력 스크립트를 출력 한다. - `ScriptHandler`#`printGetCarNameScript()`
- [ ] 시도 횟수 입력 스크립트를 출력 한다. - `ScriptHandler`#`printGetAttemptScript()`
- [ ] 0-9사이의 난수를 생성 한다. - `NumberGenerator`#`createRandomNumber()`
    - [ ] 난수를 판단 한다. (4이상 전진 or Nothing) - `Judgement`#`isOverFour()`
- [ ] 각 차수별 실행 결과를 출력한다. - `ScriptHandler`#`printCarMovement()`
- [ ] 제일 멀리간 우승자를 판별한다. - `Judgement`#`checkWinner()`
    - [ ] 단독 우승, 공동 우승을 판별 한다. - `Judgement`#`checkWinnersNumber()`
    - [ ] 우승자를 출력한다. - `ScriptHandler`#`printSoloWinner()`,`printJointWinner()`
