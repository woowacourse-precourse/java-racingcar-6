# 미션 - 자동차 경주
## 🚀 구현할 기능 사항
### - Car (Object)
- String carName
- String currentProgress
- setCarName
- getCarName
- addProgress
- getProgress
### - Input
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
### - Output
- printEveryStage (매 실행 결과 출력).
- printFinalResult (최종 우승자 출력).
### - Controller
- coinToss (조건에 따라 난수생성.)
- continueProgress (coinToss 결과에 따라 각 Car 결과 반영.)
### - Exception 