# 자동차 경주 게임

---

## 구현 기능 리스트 (구현 전)

---

- [x] 자동차의 이름을 입력받는다. UserInput#inputCarNames()


- [x] 자동차에 이름을 부여한다. Race#setcarNames()
    - [x] 입력받은 모든 자동차의 이름을 쉼표(,)로 나누어 저장할 수 있어야 한다.
    - [ ] 이름이 5자 초과면 예외가 발생해야 한다. ExceptionChecker#checkNameLength5()


- [ ] 몇 번의 이동을 할 것인지 입력받는다. UserInput#inputRound()
- [x] 레이스에서 총 몇 번의 이동을 할 것인지 설정한다. Race#setRound()
    - [ ] 숫자가 아니라면 예외가 발생해야 한다. ExceptionChecker#isNumber()


- [ ] 매 번 이동마다 각각의 자동차가 전진하거나 멈춘다. Game#
    - [ ] 자동차를 전진시킨다. Car#moveForward()
        - [ ] 0에서 9사이의 무작위 값을 생성해야 한다. Car#makeRandomNumber()
        - [ ] 무작위 값이 4 이상일 때만 한 칸 전진해야 한다. Car#canMove()
    - [ ] 자동차를 출력한다. UserOutput#printCars()
        - [ ] 자동차의 이름과 전진한 칸이 출력되어야 한다.


- [ ] 우승자를 계산한다. Race#setWinner()
    - [ ] 가장 멀리 간 자동차를 우승자로 저장해야 한다. Race#compareCars()
    - [ ] 동점인 경우 여러 명을 저장해야 한다.


- [ ] 우승자를 출력한다. UserOutput#printWinners()
    - [ ] 우승자가 여러 명인 경우 쉼표와 공백(, )으로 구분해야 한다.

---

## 구현 기능 리스트 (구현하며 추가한 기능)