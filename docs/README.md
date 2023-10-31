* ## 🛠 기능 구현 목록

* `RacingCar`: 레이싱 카
    * [x] : 레이싱 카 이름이 주어지면, 이름이 5자리 이하인지 확인하고 생성한다.
    * [x] : 이름이 5자를 초과하면 예외를 던진다.
    * [x] : 숫자를 받으면 조건에 따라 이동하거나 이동하지 않는다.

* `MoveCondition` : 전진하는 조건을 제시한다.
    * [x] : 값이 4 이상 경우 true, 미만인 경우 false를 반환한다.

* `RandomNumberFactory` : 랜던 수 만들기 장치
    * [x] : 0 ~ 9 사이의 랜덤 값을 만든다.
    * [x] : 대역을 사용해 테스트하기 쉬운 코드로 바꾼다.

* `RacingGame` : 경주차 게임을 진행한다.
    * [x] : RacingGameRq를 활용해 게임을 1회 진행한 후 RacingGameRs를 반환한다.

* `InputView` : 사용자의 입력을 받는다.
    * [x] : 경주할 차 이름을 입력 받는다.
    * [x] : 대역을 사용해 테스트하기 쉬운 코드로 바꾼다.
    * [x] : 시도할 횟수를 입력 받는다. 숫자가 아니면 예외를 던진다!

* `OutputView` : 값을 화면에 출력한다.
    * [x] : 경주 시작 멘트를 출력한다.
    * [x] : 경주 실행 결과를 출력한다.
    * [x] : 최종 우승자를 출력한다.

* `RacingCarGameController` : model과 view가 상호작용하도록 돕는다.
    * [x] : RacingCarGame 에게 게임을 시작하라고 요청한다.
    * [x] : 게임을 사용자가 요청한 만큼 반복 실행한다.
      * [x] : view에게 입력하라는 메시지를 보낸다.
      * [x] : view에게 출력하라는 메시지를 보낸다.
    * [x] : 시도한 횟수가 0 이면 모두 우승자가 된다.

* `Application`
    * [x] : 레이싱 카 경주를 시작한다.

* `ApplicationContext`
    * [x] : Application이 실행되면, 객체들을 조립한다.
      * [x] : RandomService의 기본 구현체 생성
      * [x] : ConsoleService의 기본 구현체 생성