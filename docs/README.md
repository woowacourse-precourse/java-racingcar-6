# 🏎️ 자동차 경주

## 기능 목록
### 플레이어 입력
- [x] 자동차의 이름을 입력받는다. - InputView: readCarNames
  - [x] 예외 사항 : 이름이 5자를 초과하면 `IllegalArgumentException` 을 발생시킨다. - InputValidator: validateName
- [x] 시도할 횟수를 입력받는다. - InputView: readNumRound
  - [x] 예외 사항 : 횟수가 0 이하이면 `IllegalArgumentException` 을 발생시킨다. - InputValidator: validateNumRound
### 게임 진행 
- [x] 각 차수 마다 자동차를 정지 또는 전진 시킨다. - Cars : roundLevelMove
  - [x] 0에서 9 사이에서 무작위 값을 생성한다. - RandomNumberGenerator: createRandomNumber
  - [x] 무작위 값이 4 이상일 경우 전진한다. - Car: move
- [x] 각 차수마다 자동차의 이름과 전진 결과를 문자열로 출력한다. - OutputView: printResult
### 우승자
- [x] 최종 우승자를 구한다. - Cars: findWinner
- [x] 최종 우승자의 위치를 구한다. - Cars: findWinnerPosition
- [x] 모든 시도가 끝나면 최종 우승자를 출력한다. - OutputView: printWinner



---
## 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.


- 각 자동차에 이름을 부여할 수 있다. 
- 자동차 이름은 쉼표(,)를 기준으로 구분하며
- 이름은 5자 이하만 가능하다.


- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.


- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.


- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.


- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.


- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.