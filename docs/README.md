# 🚗 자동차 경주 게임 기능 명세서 🏁

> - 기능 명세서는 프로그램 실행 흐름에 따라 작성한다.
> - 기능 구현은 주요 기능부터 먼저 구현한다.
> - 경주는 2개 이상의 자동차가 참가해야 가능하므로 2개 이상의 이름을 입력해야 게임을 진행할 수 있다.


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
  - [X] 0부터 9까지의 정수 중 무작위 값을 1개 뽑는다. - NumberGenerator#pickNumberFrom0To9()
  - [X] 무작위 값이 4 이상이면 전진한다. - Car#moveForward()
  - [X] 자동차의 이름과 현재 위치를 나타내는 문자열을 생성한다. - MessageContainer#showCarResult()
  - [ ] 한 라운드 실행 결과를 출력한다.
  - [ ] 사용자가 입력한 시도 횟수만큼 반복한다.


## 게임 종료 후 자동차들의 위치를 비교한다.
  - [X] 자동차들의 현재 위치값 중 최대값을 찾는다. - Judgment#findMaxPosition()
  - [ ] 최대위치값을 가진 자동차들의 이름을 리턴한다. - Judgment#getWinnerNames()


## 우승자를 알려준다.
  - [ ] 우승자 안내 문구를 생성한다. - MessageContainer#showWinners()
    - [ ] 공동 우승자는 쉼표로 구분하여 표기한다.


## 안내 메시지를 출력한다.
- [ ] 자동차 이름 입력 안내 문구를 리턴한다 - MessageContainer#enterCarNames()
- [ ] 시도 횟수 입력 안내 문구를 리턴한다 - MessageContainer#enterTotalRounds()
- [ ] 실행 결과 문구를 리턴한다 - MessageContainer#executionResult()


## `IllegalArgumentException`이 발생하면 애플리케이션을 종료한다.