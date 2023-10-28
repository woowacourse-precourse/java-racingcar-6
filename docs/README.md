## 레이싱카 게임

## 기능 목록

#### 자동차 이름 입력 기능
- [✅] 경주할 자동차 이름 입력한다. #InputView inputCarName()
  - [✅] 이름을 쉼표로 구분했는지 확인한다. #InputException isContainComma()
  - [✅] 이름이 5자 이하인지 확인한다. #InputException validateNameSize()
  - [✅] 이름이 중복되었는지 확인한다. #InputException validateNameDuplication()

#### 이동 횟수 입력 기능
- [✅] 몇 번의 이동을 할 것인지를 입력한다. #InputView inputNumberOfMoves()
  - [✅] 입력이 숫자인지 확인한다. - #InputException isNumber()

#### 전진하는 조건을 만족을 확인하는 기능
- [✅] 각 자동차마다 랜덤 값(0-9) 구한다. #GenerateRandomNumber generateRandomNumber()
- [ ] 랜덤 값이 4이상일 경우 전진한다.

#### 실행 결과 출력 기능
- [ ] 실행 결과를 출력한다. #Game - #OutputView printResult()
  - [ ] 각 자동차마다 전진한 횟수를 '-'로 표시한다.

#### 최종 우승자 출력 기능
- [ ] 최종 우승자를 출력한다. #Game - #OutputView printFinalWinner()
  - [ ] 가장 많이 전진한 자동차의 이름을 출력한다.
    - [ ] 우승자가 한 명일 경우 해당 우승자만 출력한다.
    - [ ] 우승자가 여러 명일 경우 쉽표(,)를 이용하여 구분한다.