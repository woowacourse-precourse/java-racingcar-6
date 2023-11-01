## 기능 요구 사항
### 초간단 자동차 경주 게임을 구현한다.

- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. <br>
- [X] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.<br>
- [X] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.<br>
- [X] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.<br>
- [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.<br>
- [X] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.<br>
- [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.<br>
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.<br>

## 추가 요구 사항
- [X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.<br>
- [X] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.<br>
- [X] 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.<br>
- [X] 3항 연산자를 쓰지 않는다.<br>
- [X] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.<br>
- [X] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.<br>
- [X] 테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.<br>

## 라이브러리
- [X] JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.<br>
- [X] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.<br>
- [X] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.<br>
--------------------------------------------------------
## 구현할 기능 list
### 입력 
- [X] 경주할 자동차 이름을 입력 받는다. (이름은 쉼표(,)로 구분)<br>
    - [X] * 예외처리 : 이름이 6자 이상인 경우 ->  IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.<br>

- [X] 시도할 회수를 입력 받는다.<br>
    - [X] * 예외처리 :숫자가 아닌 수를 입력한 경우 or 0이하의 숫자 입력 ->  IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.<br>
      - (0을 예외처리로 하여 출발을 하지 않는 것이기에 예외처리를 해야할 지, 모두를 공동 우승자로 해야 할 지에 대한 고민이 있었으나, 레이싱을 시작하지 않는다고 간주하여 0도 예외처리 했음.)

### 출력
- [X] 각 차수 별 실행 결과 출력<br>

- [X] 우승자 출력<br>
    - [X] case 1. 단독 우승자 안내 문구 출력<br>
    - [X] case 2. 공동 우승자 안내 문구 출력<br>

### 로직
-Car 상태 관련 메소드 만들기
  - [X] Car 객체 생성자 만들기
    - [X] 이름 반환하는 메소드 만들기
    - [X] 위치 반환하는 메소드 만들기
    - [X] Car 이동 시키는 메소드 만들기
  - [X] 게임 시작하는 메소드 만들기
  - [X] 라운드 별 게임 진행 만들기
        - [X] 입력 받은 횟수에 따라 무작위 값 생성<br>
        - [X] 4 이상인 경우 -> 전진<br>
        - [X] 3 이하인 경우 -> 정지<br>
- [X] 우승자 판별<br>

### 테스트
- [X] 문자열 값을 제대로 분리하고 판단하는지
    - [X] 메소드로 주어진 값을 구분 (쉼표에 따라 값 구분하는지)
    - [X] 메소드 사용시 구분자가 포함되지 않은 경우 값을 그대로 반환
    - [X] 메소드 사용시 최대 길이를 초과하는지 아닌지 확인
- [X] 숫자를 제대로 읽는지, 입력외 처리를 잘 처리하는지
  - [X] 사용자가 입력한 숫자가 정상적으로 읽히는지 확인
  - [X] 숫자 입력이 최소값 이하인지 확인
- [X] 무작위 숫자를 제대로 생성하는지 확인
- [X] 숫자 값에 따라 자동차 이동 자동차 멈출지 제대로 판단하는지 확인
- [X] 경주 결과가 제대로 출력되는지 확인
- [X] 우승자가 정확하게 확인되는지 확인
----------------------------------------------------------------

## MVC

### Model
- Car 
  - 자동차 객체 생성
  - 자동차 이름 반환
  - 자동차 현재 위치 반환
  - -자동차 움직이는 메소드

### View
- inputView
  - 경주할 자동차 이름 입력 받음
  - 시도할 횟수 입력 받음
  - 
- -outputView
  - 승자 뷰 만들기 
    - 공동 우승
    - 단독 우승

### Controller
- CarRacing
  - 게임 시작 (자동차 이름, 이동 횟수 받아서 초기화)
  - 게임 진행 (자동차 이동 시킴)
  - 우승자 판별
- -----------

## 디렉토리 구조


docs
    ├─ README.md
    ├─ study_MVC.md



src ├─main
    │  └─java
    │      └─racingcar
    │          │  Application.java
    │          │
    │          ├─Controller
    │          │      RacingCar.java
    │          │
    │          ├─Model
    │          │      Car.java
    │          │
    │          ├─Validator
    │          │      NumberValidator.java
    │          │      StringValidator.java
    │          │
    │          └─View
    │                  InputView.java
    │                  OutputView.java
    │
    └─test
    └─java
    ├─racingcar
    │      ApplicationTest.java
    │      CarTest.java
    │      DisplayTest.java
    │      NumberTest.java
    │      RacingCarTest.java
    │      StringTest.java
    │
    └─study
    StringTest.java
