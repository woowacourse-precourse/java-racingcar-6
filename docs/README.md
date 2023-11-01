# 미션 - 자동차 경주

## 기능 목록

### model 패키지
+ Car 클래스
  - [x] 자동차를 전진시킨다. - moveForward()
  - [x] 현재 위치를 반환한다 - getLocation()
+ NumberGenerator 클래스
  - [x] 0에서 9까지 무작위 정수를 반환. - createRandomNumber()
+ Judgement 클래스
  - [x] 우승자들을 구한다. - findWinner()
  - [x] 가장 많이 이동한 위치를 구한다 findMaxLocation()
+ RunGame 클래스
  - [ ] 자동차의 이동여부를 반환한다. - moveOrStop()
  - [ ] 각 차수를 진행한다. - runGameIteration()

### view 패키지
+ Input 클래스
  - [x] 경주할 자동차 이름을 입력받는다. - inputNames()
  - [x] 시도할 횟수를 입력받는다. - inputTryCount()
  - [x] 입력된 이름을 ,기준으로 구분하여 리스트를 만들어 반환한다 - stringToList()
+ Output 클래스
  - [x] 차수 별 실행 결과를 출력한다. - printResultByIteration()
  - [x] 우승자를 출력한다. - printWinner()

### controller 패키지
+ GameController 클래스
  - [x] Input 클래스의 InputNames와 stringToList를 호출하여 자동차 이름 리스트를 세팅한다. - setInputNameList()
  - [x] 자동차 이름 리스트를 입력받아 자동차 객체 리스트를 세팅한다. - setCarList()
  - [x] 시도할 회수를 세팅한다. - setTryCount()
  - [x] 게임을 실행한다. - playGame()

### constants 패키지
+ StringStore 클래스 - 사용할 문자열 리터럴이 저장되어 있는 클래스


## 기능 요구 사항
+ 초간단 자동차 경주 게임을 구현한다.
+ 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
+ 각 자동차에 이름을 부여할 수 있다. 
+ 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
+ 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
+ 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
+ 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
+ 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
+ 우승자는 한 명 이상일 수 있다.
+ 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
+ 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
