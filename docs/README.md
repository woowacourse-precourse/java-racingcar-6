# 기능 목록

- [ ] 자동차 생성한다. Game.makeCarNameList()
   - [ ] 이름은 5글자 이하만 입력받는다. Validator.validateLenOfCarNames()
   - [ ] 자동차는 최소 2대 이상 입력받는다. Validator.validateNumOfCars()
- [ ] 시도할 회수를 입력받는다. Game.getAttempts()
- [ ] 입력받은 시도만큼 자동차를 이동한다.
   - [ ] 무작위 값 만든다. Car.makeRandomValue()
   - [ ] 4 이상이면 전진한다. Game.makeCarMove()
- [ ] 각 시도마다 현재 상황을 출력한다. 
- [ ] 가장 많이 이동한 자동차가 우승한다. Game.selectWinners()
   - [ ] 가장 많이 이동한 자동차를 찾는다. Game.findMaxPosition()
- [ ] 우승자를 출력한다.