# 자동차 경주

## 기능 목록

- [x] 자동차 이름을 입력받는다.
  - [x] 자동차 리스트를 생성한다. - Generator#carList()
  - [x] 이름이 5자 이하의 자연수인지 확인한다. - Validation#nameLength()
  - [x] 이름이 중복되는지 확인한다. - Validation#duplication()
  - [x] 만들어진 리스트가 비었는지 확인한다. - Validation#empty()


- [x] 이동할 횟수를 입력받는다.
  - [x] 입력값이 숫자인지 확인한다. - InputValidation#isNumber()


- [x] 각 자동차별로 이동한다. - Race#phase()
  - [x] 자동차가 이동한다. - Car#move()
  - [x] 각 자동차의 이동 현황을 출력한다. - View#showPhase()


- [x] 누가 우승했는지 확인한다. - Race#checkWinner()


- [x] 우승자를 출력한다. - View#showResult()
