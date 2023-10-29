


# 자동차 경주

## 기능 목록
### view package
 - outputView class
   + [o] 경주할 자동차 이름을 입력해야 함을 출력하는 기능 - printRacingCarName
   + [0] 경주 시도 횟수를 입력해야 함을 출력하는 기능 - printNumberOfRacing
   + [0] 경기 시도 횟수 만큼 실행결과를 출력하는 기능 - printRacingResult
   + [0] 최종 우승자를 출력하는 기능 - printRacingWinner
- inputView class 
   + [0] 경주할 자동차 이름을 입력받는 기능 - inputRacingCarName
   + [0] 경주 시도 횟수를 입력받는 기능 - inputNumberOfMatch

### model package
 - validateRacingValue class
   + [0] view가 받은 경주할 자동차 이름을 list로 전환 - carNameInputToList
   + [ ] 자동차 숫자만큼 경기 결과 저장 list를 0으로 초기화 - raceResultListReset
   + [ ] 0부터 9사이의 무작위 값 중 4이상 값이 나오는지 판단하는 기능 validateRandomMoreFour
   + [ ] 각 자동차의 경기 결과를 판단하는 기능 validateRacingResult
   + [ ] 최종 우승자를 판단하는 기능 validateRacingWinner

### controller package
 - racingCarGameManager class
   + [] view,model 활용해 게임 진행 - racingStart
 
### utility package 
#### - model, view에 특수하게 개입할 필요가 있을 때 사용
 - validateException class
   + [ ] 6이상인 자동차 이름이 입력될 경우 - 예외 처리 racingCarNameInvalid
   + [ ] 경기 시도 횟수 입력시 int가 아닌 값이 입력될 경우 - 예외 처리 numberOfRacingInvalid
 - manageConstantValue class
   + [ ] outputView에서 고정된 출력값들 enum으로 관리 - constantOutputView
   + [ ] 각 기능에서 활용되는 메직넘버들 상수 값으로 관리 - replaceMagicNumberToConstant

   
## 기능 요구 사항 

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.