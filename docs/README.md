# Controller
### RacingGame
- cars : List<Car>
- dice : Dice
- playTime : Integer
- print : Print
- RacingGame(List<Car>)
- input() : void
  - 자동차 입력 값(이름)에 대한 처리
  - **동일한 자동차 이름 입력 시, 오류 발생**
- run() : void
  - 반복 횟수를 입력받고, 해당 반복횟수만큼 과정 실행 후 결과 출력
  - **반복 횟수가 음수일 시, 오류 발생**
  - **반복 횟수에 정수가 아닌 값을 입력 시, 오류 발생**
- winningCarsLogic(List<Car>) : List<Car>
- toString()
# Model
### Car
- name : String
- forwardValue : Integer
- Car(String)
  - 자동차 이름을 매개변수로 입력받음에 따라 해당 자동차 생성
  - **이름의 길이가 5를 초과할 시, 오류 발생**
- getName() : String
- getForwardValue() : Integer
- forward() : void
- toString()
### Dice
- value : Integer
- Dice()
- getValue() : Integer
- rolling() : void
# View
- print()
  - inputCarNames() : void
  - howMuchRepeat() : void
  - runningResult() : void
  - step(List<Car>) : void
  - winner(List<Car>) : void
    - singleCarOutput(List<Car>) : void
    - multiCarsOutput(List<Car>) : void