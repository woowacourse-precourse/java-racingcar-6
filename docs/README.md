# 자동차 경주

## 기능 요구 사항
- [x] 0-9 사이의 무작위 값을 생성한다. NumberGenerator#createRandomNumber
- [x] 경주 할 자동차 입력 받는다. UserInputManager#inputCarName
- [x] 쉼표를 기준으로 구분한다. UserInputManager#splitInput
  - [x] 공백이 있으면 제거한다. UserInputManager#removeSpace 
  - [x] 자동차 이름은 1자 이상 5자 이하 InputValidator#checkCarNameLength
- [x] 시도할 횟수를 입력 받는다. UserInputManager#inputNumberOfAttempts
  - [x] 숫자가 아니면 안된다. InputValidator#isNumeric
- [x] 값이 4 이상인지 체크할 수 있다.Checker#checkAtLeast4
- [x] 값이 4 이상일 경우 전진. Car#goStright
- [x] 승리한 사람을 체크해야 함.(여러명 가능) Checker#checkWinners
- [x] 전진하는 자동차를 출력 시 자동차 이름을 같이 출력 Application#printTurnInfo
- [x] 승리한 사람을 알려줘야 함. Application#printWinners


## 지켜야 할 사항
- [x] indent depth 3을 넘기지 않도록 구현한다.
- [x] 3항 연산자 사용 금지
- [x] 함수가 한 가지 일만 하도록 최대한 작게 구성
- [x] JUnit 5와 AssertJ를 사용한 기능 목록 정상 동작 테스트 코드 작성
- [x] camp.nextstep.edu.missionutils.Console의 readLine() 활용
- [x] camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용
- [x] 잘못된 입력을 사용하면 IllegalArgumentException 발생 후 종료