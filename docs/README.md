# 자동차 경주

## 기능 목록
### view package
 - output class
   + [o] 경주할 자동차 이름을 입력해야 함을 출력하는 기능 - carNameManual
   + [0] 경주 시도 횟수를 입력해야 함을 출력하는 기능 - numberOfRacingManual
   + [0] 경기 시도 횟수 만큼 실행결과를 출력하는 기능 - racingResult
   + [0] 최종 우승자를 출력하는 기능 - racingWinner
- input class 
   + [0] 경주할 자동차 이름을 입력받는 기능 - CarName
   + [0] 경주 시도 횟수를 입력받는 기능 - numberOfRacing

### model package
 - transform class
   + [0] view가 받은 경주할 자동차 이름을 list로 전환 - carNameToList
   + [0] 자동차 숫자만큼 경기 결과 저장 list를 0으로 초기화 - resultListReset
 - validation class
   + [0] 0부터 9사이의 무작위 값 중 4이상 값이 나오는지 판단하는 기능 randomMoreFour
   + [0] 각 자동차의 경기 결과를 판단하는 기능 racingResult
   + [0] 최종 우승자를 판단하는 기능 racingWinner

### controller package
 - racingCarGameManager class
   + [0] view,model 활용해 게임 진행 기능 - racingStart
   + [0] 자동차 이름 입력을 유도하고 입력값을 변형하는 기능 - carNameInputProcess
   + [0] 경기 횟수 입력을 유도하고 입력값을 변형하는 기능 - numberOfRacingProcess
   + [0] 게임 로직을 실행하는 기능 - gameLogicProcess
   + [0] 로직 결과에 따라 우승자를 출력하는 기능 - racingWinnerOutputProcess
 
### utility package
 - validateException class
   + [0] 6이상인 자동차 이름이 입력될 경우 - 예외 처리 CarNameInvalid

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