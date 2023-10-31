## 기능 목록

- [x] 자동차는 전진할지 말지 결정할 수 있다. - RaceCar#forward()
- [ ] 자동차는 주어진 횟수만큼 경주한다. - RaceCar#race()
- [ ] 가장 많이 전진한 자동차는 우승한다. - RaceCar#winner()
- [x] 0부터 9 사이의 무작위 값을 자동차의 수만큼 생성한다. - Generator#createRandomNumbers()
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하여 입력 가능하다. - UserInput#carName()
- [ ] 사용자는 몇 번의 이동을 할 것인지 입력 가능하다. - UserInput#moveNumber()
- [ ] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다. - InvalidValue#throwIllegalArgumentException()
  - [ ] 자동차 이름은 5자를 초과할 수 없다. - InvalidValue#isFiveLetters()
  - [ ] 사용자가 몇 번의 이동을 할 지 입력할 때 자연수만을 입력해야 한다. - InvalidValue#isNaturalNumber()
