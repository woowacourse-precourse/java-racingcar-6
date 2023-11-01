
## 기능 목록

### 사용자 입력
- [x] 사용자에게 이름을 입력받는 기능 -User#inputCarNames
- [x] 쉼표 기준으로 이름 분리 -User#splitCarNames
- [x] 이름 검증 
  - [x] 5자 이하인지 확인 -
    Checker#checkNameLength
  - [x] 중복인지 확인 -
    Checker#checkNameDuplication
- [x] 시도 횟수 입력 받는 기능 -User#inputNumberOfTurns
- [x] 횟수 입력값 검증 (정수인지 확인, 1 이상인지 확인) -
  Checker#checkValidTurn

### 게임 진행
- [x] 입력된 횟수만큼 턴 진행한다. -Race#playRounds
- [x] 각 자동차에게 0~9 사이에 발생하는 무작위 수가 할당된다. NumberGenerator#createRandomNumber()
- [x] 4 이상일 경우에는 전진한다. -Race#moveIfAble
- [x] 턴 진행 후 각 레이싱카의 실행 결과 출력한다. -Race#displayRoundResults

### 결과
- [x] 가장 많은 전진을 기록한 레이싱카를 우승자로 선정(중복 가능) -Game#determineWinners
- [x] 우승자 출력한다. -Game#displayWinners
