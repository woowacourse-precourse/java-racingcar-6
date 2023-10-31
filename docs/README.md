# 미션 - 자동차 경주
## ✏️ 구현할 기능 사항
### 1.사용자 입력
  - 입력에 대한 유효성을 판단하고 예외처리에 주의한다.
  - 차량 이름 입력
    - 사용자의 입력을 쉼표(,)를 기준으로 구분하여 차량의 이름을 받는다.
  - 게임의 시행 횟수 입력.
    - 경주를 몇번 시도할 지에 대하여 입력받는다.

### 2. 경주
  - 사용자가 요구한 횟수 만큼 난수(0부터 9까지)를 생성한다.
  - 난수 생성의 결과(4이상)에 따라 진행도를 출력한다.

### 3. 우승자 판단
  - 사용자가 요구한 횟수 만큼 경주를 진행한 후 가장 진행도가 큰 차량을 우승자로 출력한다.


## ✏️ 구체적인 구현.
### - Model
- Car
  - String carName
  - String currentProgress
  - int progressCounter
  - setCarName
  - getCarName
  - addProgress
  - getProgress

### - View
- InputView
  - inputCarNames (경주할 자동차의 이름을 입력받기)
    - 경주할 자동차의 이름들을 한줄로 입력받는 method
    - 쉼표(,)를 기준으로 구분하는 method
    - exceptions
      - 명확한 예외
        1. 5자를 초과한 경우.
      - 명확하지 않은 예외
        1. 공백문자가 입력된 경우.
        2. 중복된 차량 이름이 입력된 경우.
  - inputGameCounts (시도할 횟수 입력받기)
    - exceptions
      1. 입력값이 숫자가 아닌 경우.
      2. 입력값이 1보다 작은 경우.
  - OutputView
    - printEveryStage (매 실행 결과 출력).
    - printFinalResult (최종 우승자 출력).
### - Controller
  - GameController
    - runGame()
    - Validator
      - validCarName()