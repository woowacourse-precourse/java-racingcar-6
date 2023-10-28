# 자동차 경주 게임

---

## 구현 기능 리스트 (구현 전)

---

- [x] 자동차의 이름을 입력받는다. UserInput#inputCarNames()


- [x] 자동차에 이름을 부여한다. Race#setCarNames()
    - [x] 입력받은 모든 자동차의 이름을 쉼표(,)로 나누어 저장할 수 있어야 한다.
    - [ ] 이름이 5자 초과면 예외가 발생해야 한다. ExceptionChecker#checkNameLength5()


- [x] 몇 번의 이동을 할 것인지 입력받는다. UserInput#inputRound()


- [x] 총 몇 번의 이동을 할 것인지 설정한다. Round()#Round()
    - [ ] 숫자가 아니라면 예외가 발생해야 한다. ExceptionChecker#isNumber()


- [x] 매 번 이동마다 각각의 자동차가 전진하거나 멈춘다. Race#moveCars()
    - [x] 자동차를 전진시킨다. Car#moveForward()
        - [x] 0에서 9사이의 무작위 값을 생성해야 한다. RandomGenerator#createNumber()
        - [x] 무작위 값이 4 이상일 때만 한 칸 전진해야 한다.
    - [x] 자동차의 이동 결과를 출력한다. UserOutput#printResult()
        - [x] 자동차의 이름과 전진한 칸이 출력되어야 한다.


- [x] 우승자를 계산한다. Race#getWinners()
    - [x] 가장 멀리 간 자동차를 우승자로 저장해야 한다. Race#getMaxDistance()
    - [x] 동점인 경우 여러 명을 저장해야 한다.


- [ ] 우승자를 출력한다. UserOutput#printWinners()
    - [ ] 우승자가 여러 명인 경우 쉼표와 공백(, )으로 구분해야 한다.

---

## 구현 기능 리스트 (구현하며 추가한 기능)

- [x] 남은 이동이 있는지 확인한다. Round#isRoundRemaining()


- [x] 이동 회수를 1회 줄인다. Round#subtractOneRound()


- [x] 레이스에 참여한 자동차들의 이름 리스트를 반환한다. Race#getCarNames()
    - [x] 자동차의 이름을 반환한다. Car#getName()


- [x] 매 번 이동마다 자동차들의 이동 거리를 반환한다. Race#getRoundResult()
    - [x] 자동차의 전진 거리를 반환한다. Car#getDistance()