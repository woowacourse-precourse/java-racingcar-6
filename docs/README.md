## 기능 요구 사항

자동차 경기에서 최종 우승한 자동차를 구하는 게임이다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- (n >= 2) 이라고 가정한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.


- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

e.g. 자동차 이름이 pobi,woni,jun일 때, 사용자가 5회 시도한다.

woni를 제외한 pobi, jun이 무작위 값이 5회 모두 4 이상일 경우라고 가정해본다.

pobi : -----

woni : ----

jun : -----

최종 우승자 : pobi, jun

## 기능 목록

### InputView 
- [x] 경주할 자동차 이름을 입력한다. -  inputCarNames()
  - [x] 이름은 쉼표(,) 기준으로 구분한다.
- [x] 시도 횟수를 입력한다. - inputAttemptCount()

### InputValidator
- [x] 쉼표(,)를 기준으로 이름을 나뉘었는지 검증한다. - validateDivisionCarNames()
- [x] 숫자로 입력했는지 검증한다. - validateNumeric()

### InputMapper
- [x] 자동차 입력을 받으면 Cars를 반환한다. - toCars
- [x] 시도할 횟수를 받으면 숫자형태로 반환한다. - toInt

### InputManager
- [x] Controller에서 자동차들 이름 입력을 관리한다. - inputCarNames()
- [x] 시도할 횟수 입력을 관리한다 - inputAttemptCount()

### OutputView
- [x] 게임 진행 메시지를 출력한다.
- [x] 실행 결과를 출력한다. - printExecutionResultMessage()
- [x] 최종 우승자를 출력한다. - printFinalWinners()


### Car
- [x] 자동차 이름과 이동 위치를 저장한다. - Car()
  - [x] 자동차 이름은 5자 이하만 가능하다. - validateNameLength()
- [x] 자동차 위치를 움직인다. - movePosition()
- [x] 자동차의 현재 위치 상태를 알 수 있다. - statusCarPosition()

### Cars
- [x] 자동차들을 저장한다. - Cars()
  - [x] 자동차들의 최소 개수는 2개이다. - validateCarsCount()
- [x] 자동차들의 현재 위치를 알 수 있다. - statusCarsPosition()
- [x] 자동차들의 최대 위치를 찾을 수 있다. - findMaxCarPosition()
- [x] 자동차들의 최종 우승자를 알 수 있다. - getFinalWinners()
  - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### MovingCondition
- [x] 자동차가 움직일 수 있는 조건을 판별한다. - canMove()
  - [x] 0~9사이의 무작위 수 생성
  - [x] 4 이상인지 판별

### RacingCarController
- [x] 게임을 실행한다. - run()
- [x] 레이싱을 시작한다. - startRacing()

### RacingCarService
- [x] 레이싱카들이 레이싱을 한다. - startRacing()
- [x] 시도횟수에 따른 진행 상태을 판별한다. - isProcessing()

## 예외 목록
- CarNameLengthException
  - [x] 자동차 이름 길이 예외
- CarsCountException
  - [x] 자동차들 최소 개수 예외
- DivisionCarNamesException
  - [x] 자동차 이름 구분자 예외
- InputNumericException
  - [x] 숫자 입력 예외
- NotFoundCarPositionException정
  - [x] 자동차 위치 찾기 예외

## 상수 목록
- ErrorMessage
  - [x] 에러 메시지 상수
- GameResultElement
  - [x] 게임 결과 화면요소 상수
- InputPattern
  - [x] 입력값 정규식 상수
- ProgressMessage
  - [x] 게임 진행 메시지 상수
- RacingCarRole
  - [x] 레이싱카 규칙 상수