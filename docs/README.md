
## 기능 목록

### 사용자 입력
- [ ] 사용자에게 이름을 입력받는 기능 -User#inputCarNames
- [ ] 쉼표 기준으로 이름 분리 -User#splitCarNames
- [ ] 이름 검증 
  - [ ] 5자 이하인지 확인 -
    Checker#checkNameLength
  - [ ] 중복인지 확인 -
    Checker#checkNameDuplication
- [ ] 시도 횟수 입력 받는 기능 -User#inputNumberOfTurns
- [ ] 횟수 입력값 검증 (정수인지 확인) -
  Checker#checkIsNumber

### 게임 진행
- [ ] 입력된 횟수만큼 턴 진행한다. -Race#playRounds
- [ ] 각 자동차에게 0~9 사이에 발생하는 무작위 수가 할당된다. NumberGeneraor#createRandomNumber()
- [ ] 4 이상일 경우에는 전진한다. -Race#moveIfAble
- [ ] 턴 진행 후 각 레이싱카의 실행 결과 출력한다. -Race#displayRoundResults

### 결과
- [ ] 가장 많은 전진을 기록한 레이싱카를 우승자로 선정(중복 가능) -Game#determineWinners
- [ ] 우승자 출력한다. -Game#displayWinners
