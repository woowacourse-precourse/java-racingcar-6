### 학습 목표
* 함수 분리
* 함수별 테스트 작성
* 기능 단위로 커밋하기

### 기능 목록

- [ ] 자동차 이름을 입력받는다.
  - [ ] 자동차 이름은 5자 이하이다. - 예외처리
  - [ ] 쉽표(,)를 기준으로 구분하여 입력받는다.
-[ ] 이동 횟수를 입력받는다.
  -[ ] 1 이상의 수를 입력받는다. - 예외처리
-[ ] 자동차는 전진한다.
  -[ ] 0에서 9 사이의 랜덤값을 구한다.
  -[ ] 랜덤값이 4 이상일 경우 전진한다.
  -[ ] 랜덤값이 3 이하일 경우 멈춘다.
-[ ] 이동시 모든 자동차는 전진을 수행한다.
-[ ] 이동 결과를 출력한다.
-[ ] 우승자를 뽑는다.
  -[ ] 우승자는 한 명 이상일 수 있다.
-[ ] 우승자를 출력한다.
  -[ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 구현 객체 목록

* VO
  * CarName
    * name
    * validateNameMaximumLength()
      * 5자 이하
    * toString()
  * Position
    * position
    * goForward()
      * position++
    * getPosition()
  * DriveCount
    * driveCount
    * validateBiggerThanZero()
      * 0보다 큰 수 
    * getDriveCount()

* Domain
  * Driver
    * isGoForward()
      * 4 이상일 경우 true
      * 3 이하일 경우 false
  * Car
    * Driver
    * CarName
    * Position
    * goForward()
      * 랜덤 이동
  * Cars
    * List<Car>
    * move()
    * maxPosition()
    * getMaxPositionCars()
    * addCar()
  * Racing
    * DriveCount
    * Cars
    * race() 
    * getWinners()
    * registerCar()

* Controller
  * Racing
  * InputView
  * OutputView
  * run()

* View
  * InputView
    * inputCarNames()
    * inputTryCount()
  * OutputView
    * printMoveResult()
    * printWinners()

### 고민한 점
* 모든 값을 포장하는게 맞을까?
  * CarName이나 Position은 너무 책임들이 적은 것 같아 굳이 포장해야 되나 싶다.
  * 문제점
    * 값 객체 사용시 메모리 사용량이 증가한다.
    * 코드 복잡성이 올라간다.
  * 장점
    * 불변성을 제공할 수 있다.
    * 가변값의 경우 메소드로만 값을 변경하게 할 수 있다.
    * 유효성을 검증할 수 있다.
    * 값의 의미를 명확하게 할 수 있다.
  * 결론
    * 일단, 다양한 경우에서의 원시 값 포장 경험을 위해 최대한 포장해보자.
    
* getter를 사용하지 말자?
  * why?
    * 객체지향 생활체조 원칙에 getter/setter/property를 사용하지 말라고 한다.
    * 이 원칙이 말하는 바가 무엇인지 이해는 된다.
    * 외부에서 내부의 상태를 이용해 비즈니스 로직을 수행하는 것 보다는, 객체에 메시지를 전달하여 내부에서 비즈니스 로직을 수행하게 하는 것이 좋다.
    * 또한, getter로 노출하는 값이 객체인 경우에는 불변성을 보장할 수 없게된다.
    * 이러한 문제들을 방지하고자 getter/setter/property를 사용하지 말라고 하는 것 이다. 
    * 하지만, MVC 패턴에서 출력에 해당하는 역할을 View에 위임하였다.
    * View는 Model의 상태를 보고 출력을 담당한다.
    * View에서 Position의 값을 보고 "----"와 같은 출력 형식을 만들어 주어야한다.
    * 따라서, Position의 값을 가져오는 getter를 사용해야만 한다.
    * 물론 getter를 사용하지 않고, Position의 값을 출력하는 메소드를 만들어서 사용할 수 있다.
    * 하지만, View의 역할을 Domain에서 수행하게 되는 것이다.
  * 결론
    * getter 사용을 지양하자.
    * 어쩔 수 없이 사용해야 하는 경우는 getter를 사용하자.
    * 대신 getter로 객체를 노출하는 경우는 불변성을 보장할 수 없으므로 주의하자.
    * unmodifiableList()와 같은 불변성을 보장할 방법을 찾아서 적용하자.

* Car의 이동 방식은 랜덤한데, 어떻게 테스트를 수행할 수 있을까?
  * 랜덤성이 들어간 로직은 테스트하기 어렵다.
  * 랜덤성을 제거하고 테스트를 수행해야 한다.
  * 랜덤성을 제거하는 방법은 랜덤값을 외부에서 주입받는 것이다.
  * 랜덤값 주입의 역할을 하는 Driver를 구현한다면 테스트를 수행할 수 있다.
  * Driver는 랜덤값을 주입받아서 랜덤값을 반환하는 역할을 수행한다.
 