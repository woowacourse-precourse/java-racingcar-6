자동차 경주
========

# 기능 목록
- [x] 게임을 시작한다. - RacingCarGame.start()
- [x] 자동차 이름 입력 받는다. - User.getCarNames()
- [x] 자동차 이름을 확인한다. - Validation.validateCarNames()
    - [x] 자동차 이름들이 쉼표로 구분 되어있는지 확인한다. - Validation.validateDivision()
    - [x] 각 자동차의 이름이 5자 이내인지 확인한다. - Validation.validateLength()
- [x] 각 자동차의 이름을 지정한다. - Car.getName() -> 생성자 활용
- [x] 이동 횟수를 입력 받는다. - User.getMoveNumber()
- [x] 이동 횟수를 확인한다. - Validation.validateMoveNumber()
    - [x] 횟수가 숫자인지 확인한다. Validation.validateInteger()
- [x] 자동차를 이동 (전진 & 정지)한다. - RacingCarGame.moveCars()
    - [ ] 각 자동차를 이동 한다. - Car.move()
    - [ ] 각 자동차마다 0에서 9 사이의 무작위 값을 구한다. - Car.getRandomNumber()
    - [ ] 무작위 값이 4 이상이면 전진, 아니면 멈춘다. - Car.goOrStop()
    - [ ] 각 자동차마다 총 거리를 계산한다. - Car.totalDistance()
    - [ ] 자동차의 이동을 출력한다. - Car.printPosition()
- [ ] 우승자를 출력한다. - RacingCarGame.printFinishCarNames()
    - **완주 조건**은 정해진 이동 시도 횟수가 모두 끝난 뒤 가장 멀리 전진한 경우를 의미한다.