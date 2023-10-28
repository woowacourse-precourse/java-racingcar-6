# 🚗 자동차 경주 게임 기능 명세서 🏁


## 경주할 자동차들의 이름을 입력받는다.
- [ ] 쉼표로 구분된 이름을 분리한다. - Registration#getCarName()
- [ ] 각 자동차의 이름과 위치값을 가진 클래스의 배열을 생성한다. - Registration#createCarList()
- [ ] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 던진다.
  - [ ] 이름을 1개만 입력할 경우(쉼표 구분이 없는 경우) - Validator#validateCompetitor()
  - [ ] 5자가 넘는 이름을 입력할 경우 - Validator#validateNameLength()
  - [ ] 이름이 중복일 경우 - Validator#checkDuplicatedName()


## 전진 시도 횟수를 입력받는다.
- [ ] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 던진다.
  - [ ] 0~9로 이루어진 문자열이 아닌 경우 - Validator#checkIsDigit()
  - [ ] 1 미만의 수를 입력한 경우 - Validator#checkUnder1()


## 모든 자동차에 대해
  - [ ] 0부터 9까지의 숫자 중 무작위 값을 뽑는다. - NumberGenerator#createRandomNumber()
  - [ ] 무작위 값이 4 이상이면 전진한다. - Car#moveForward()
  - [ ] 실행 결과를 출력한다. - MessageContainer#printResult()
  - [ ] 사용자가 입력한 시도 횟수만큼 반복한다.


## 게임 종료 후 자동차들의 위치를 비교한다.
  - [ ] 자동차들의 위치값 중 최대값을 찾는다. - Judgment#findMaxValue()
  - [ ] 최대위치값을 가진 자동차들의 이름을 리턴한다. - Judgment#getWinnerNames()


## 우승자를 알려준다.
  - [ ] 우승자 안내 문구를 출력한다. - MessageContainer#printWinners()
    - [ ] 공동 우승자는 쉼표로 구분하여 출력한다.


## `IllegalArgumentException`이 발생하면 애플리케이션을 종료한다.