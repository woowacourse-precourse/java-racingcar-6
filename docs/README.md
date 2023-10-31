# 자동차 경주

## 기능 목록 V4

- [x] 경주에 참여하는 자동차를 생성한다.CreateCar
  - [x] 자동차 이름을 입력 받는다. CreateCar#inputCarNames()
    - [x] 예외 처리를 모두 거친 자동차 이름을 반환한다. CreateCar#validateCarNames()
      - [x] 입력 받은 값은 빈 문자열이 아니다. CreateCar#validateCarNameNotEmpty()
      - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다. CreateCar#splitCarName()
        - [x] 공백을 제거한다. CreateCar#trimCarName()
      - [x] 자동차 이름은 5자 이하만 가능하다. CreateCar#validateCarNameLength() 
      - [x] 자동차 이름은 중복될 수 없다. CreateCar#validateCarNameDuplicate()
      - [x] 자동차의 수는 2대 이상 10대 이하여야 한다. CreateCar#validateCarCount()
- [x] 자동차의 이름과 전진 값을 담아두는 racingStateMap 만든다. CreateCar#racingStateMap()

-[x] 자동차는 특정 조건에 따라 전진 또는 멈출 수 있다. Forward
  - [x] 0에서 9 사이에서 무작위 값을 구한다. Forward#randomNumber()
  - [x] 무작위 값이 4 이상일 경우 전진한다. Forward#canForward()
  - [x] 자동차가 전진하면 racingStateMap 전진 값을 증가시킨다. Forward#updatePosition()

- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. (1회 이상 10회 이하) RacingGame#inputTryCount()
  - [ ] 예외 처리를 모두 거친 시도 횟수를 반환한다. RacingGame#validateTryCount()
    - [ ] 입력 받은 값은 빈 문자열이 아니다. RacingGame#validateTryCountNotEmpty()
    - [ ] 입력 받은 값은 숫자이다. RacingGame#validateTryCountNumber()
    - [ ] 입력 받은 값은 1이상 10이하 이다. RacingGame#validateTryCountRange()

- 

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

e.g. <br/><br/>
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) <br/>
pobi,woni,jun <br/>
시도할 회수는 몇회인가요? <br/>
5 <br/>

실행 결과 <br/>
pobi : - <br/>
woni : <br/>
jun : - <br/>

pobi : -- <br/>
woni : - <br/>
jun : -- <br/>

pobi : --- <br/>
woni : -- <br/>
jun : --- <br/>

pobi : ---- <br/>
woni : --- <br/>
jun : ---- <br/>

pobi : ----- <br/>
woni : ---- <br/>
jun : ----- <br/>

최종 우승자 : pobi, jun
