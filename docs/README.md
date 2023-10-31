
# 자동차 경주

## 요구사항 분석

- [x] 자동차 경주 게임을 구현한다.
  - [x] 사용자의 입력을 받는다
    - [x] n대의 자동차의 입력을 받는다.
      - [x] 자동차의 이름은 쉼표(,)로 구분되어 들어온다.
      - [x] 자동차의 이름은 최대 5글자 이다.
    - [x] 몇번의 이동을 할것인지 (차수를) 입력한다. 
    - [x] 잘못된 값이 들어온 경우 IllegalArgumentException을 발생시키고 종료한다.
  - [x] 사용자가 입력한 차수만큼 반복한다.
  - [x] 자동차는 전진 혹은 멈출 수 있다.
    - [x] 각 턴마다 0 ~ 9 사이의 무작위 값을 구해 4 이상인 경우 전진시킨다.
    - [x] 4 미만인 경우는 정지한다.
  - [x] 가장 많이 전진한 자동차들이 우승한다. (한명 이상일 수 있다.)
  - [x] 게임의 진행상황을 출력한다.
    - [x] 입력에 필요한 적절한 문구를 출력한다.
    - [x] 각 차수마다 자동차의 이름과 나아간 거리를 출력한다.
      - [x] 나아간 거리 만큼 '-'를 출력한다.
    - [x] 최종 우승자(들)를 출력한다.

## 플로우 차트
![java-racingcar-6-flowchart.jpg](asset%2Fjava-racingcar-6-flowchart.jpg)

## 객체 설계

지난번 과제에서 MVC 모델로 객체를 나눴었다. 이번에도 비슷한 구조로 나누면 좋을것 같아 보인다.
다만 저번주에 공부한 내용을 기반으로 조금더 잘 나누고 자세하게 설계 해보려 한다.

### 각 모듈이 해야할 역할 정리
#### Model
- 비즈니스 로직을 수행한다.
  - 받아온 입력을 분리한다.
  - 자동차의 위치를 저장하고 이동시킨다.
#### View
- 입출력을 담당한다.
  - 사용자의 입력을 받는다.
  - 사용자에게 필요한 문구를 출력한다.
#### Controller
- Model과 View에게 메시지를 보내 프로그램을 동작시킨다.
  - 적절한 순서로 Model과 View에게 메시지를 보낸다
  - 차수만큼 반복한다.
  - 자동차 수 만큼 반복한다.

### 아이디어
- "pobi,woni,jun" 형식의 입력을 String.split() 을 이용해 나누면 좋을 것 같다.
- ~~자동차의 위치를 저장할때 Map을 이용하면 좋을 것 같다. 다만 일반 Map 구현체는 순서를 저장하지 않으므로 LinkedHashMap 을 이용해야겠다.~~
- 자동차를 저장하는건 ArrayList로 저장한다.

### 객체 분리
#### Model
- CarInput
  - 역할 : 자동차 목록 입력을 리스트 형식으로 만들어 저장한다. 
  - 책임 : 
    - ','으로 나눠진 문자열을 리스트 형태로 파싱해 저장한다.
    - ','으로 나눠진 문자열을 검사한다.
    - 만든 리스트를 제공한다.
  - 상호작용
    - RacingController : 요청을 받으면 문자열 리스트를 제공한다.
- RoundCountInput
  - 역할 : 몇번 반복할지에 대한 입력을 파싱하고 검사한다.
  - 책임 : 
    - 숫자를 파싱한다.
    - 입력을 검사한다.
    - 파싱한 숫자를 제공한다.
  - 상호작용
    - RacingController : 요청을 받으면 차수를 제공한다.
- RacingCar
  - 역할 : 각 턴마다 전진 또는 정지하며 위치를 가지고 있다.
  - 책임 : 
    - 전진을 할 수 있다.
    - 정지를 할 수 있다.
    - 전진을 할 조건이 필요하다.
    - 라운드를 진행한다.
    - 지금 음직인 거리를 알려준다.
  - 상호작용 :
    - CarList : 요청을 받아라운드를 진행한다. 
    - RandomNumberGenerator : 임의의 수를 요청한다.
- CarList
  - 역할 : ArrayList를 이용해 RacingCar 객체를 저장한다.
  - 책임 : 
    - 이름을 받아 RacingCar를 저장한다.
    - 각 자동차들이 라운드를 진행하게한다.
    - 우승한 자동차들의 리스트를 뽑아낸다.
  - 상호작용 :
    - RacingCar : 각 자동차들이 라운드를 진행하도록 요청한다.
    - RacingController : 
      - 요청을 받아 RacingCar를 추가한다.
      - 우승자 리스트를 반환한다.
- RandomNumberGenerator
  - 역할 : 1 ~ 9의 임의의 수를 생성한다.
  - 책임 :
    - 1~9의 수를 생성한다.
  - 상호작용 : 
    - RacingCar : 임의의 수를 제공해준다.

#### View
- InputView
  - 역할: 사용자 입력을 받는다.
  - 책임: 
    - 사용자 입력을 받는다.
- OutputView
  - 역할: 사용자에게 문구를 출력한다.
  - 책임: 
    - 사용자에게 문구를 출력한다.

#### Controller
- RacingController
  - 역할 : 레이싱을 진행한다.
  - 책임 :
    - 레이싱을 진행한다.
  - 상호작용 : 
    - CarList : 맴버변수로 carList을 가지고 있는다.
    - OutputView : static 메서드를 이용해 출력을 요청한다.
    - InputView : static 메서드를 이용해 입력을 요청한다.
    - CarInput : 지역 변수로 생성하여 이름 리스트를 요청한다.
    - RoundCountInput : 지역 변수로 생성하여 정수형인 차수를 요청한다.

### 메서드 기술
각 객체의 책임에서 메서드를 도출한다.

- CarInput
  - ','으로 나눠진 문자열을 리스트 형태로 파싱한다. -> private List<String> split(String userInput)
  - ','으로 나눠진 문자열을 검사한다.-> private void validate()
  - 만든 리스트를 제공한다. -> public List<String> getNameList()
- RoundCountInput
  - 차수를 파싱한다. -> private int parseRoundCount(String userInput)
  - 차수을 검사한다. -> private void validate()
  - 파싱한 차수를 제공한다. -> public int getRoundCount()
- RacingCar
  - 전진을 할 수 있다. -> private void moveForward()
  - 정지를 할 수 있다. -> private void stop()
  - 전진을 할 조건이 필요하다. -> private boolean isMovable()
  - 라운드를 진행한다. -> public void excuteRound()
  - 자동차의 이름을 알려준다. -> public int getName()
  - 지금 음직인 거리를 알려준다. -> public int getDistance()
- CarList
  - 이름을 받아 RacingCar를 저장한다. -> public void add(String name)
  - 각 자동차들이 라운드를 진행하게한다. -> public void excuteRound() 
  - 우승한 자동차들의 리스트를 뽑아낸다. -> public List<String> getWinners()
- RandomNumberGenerator
  - 1~9의 수를 생성한다. -> public int generateRandomNumber() 
#### View
- InputView
  - 사용자 입력을 받는다. -> public static String readLine() 
- OutputView
  - 사용자에게 문구를 출력한다. -> public static void println(String message)
#### Controller
- RacingController
  - 레이싱을 진행한다. -> public void playRacing()

### 클래스 다이어그램
지난주 리뷰에서 각 클래스의 관계도가 있는 코드는 구조를 파악하기 쉬워 코드 리뷰하기 수월했다. 나도 한번 만들어봤다.

![class-diagram-java-racingcar-6.jpg](asset%2Fclass-diagram-java-racingcar-6.jpg)
