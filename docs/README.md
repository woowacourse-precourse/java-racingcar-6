# 자동차 경주 구현 기능 목록

## 기능 목록
- [x] 게임을 시작하는 문구를 출력 한다. InputView#startGame

- [x] n 대의 자동차 이름을 입력 받는다. InputView#inputCarName
  - [x] 자동차 이름은 쉼표를 기준으로 5자 이하 (1 ~ 5)로 입력 받는다. (split 메소드 사용)
  - [x] 사용자 입력 예외 처리 InputValidation 클래스
        [x] 1. 사용자가 아무 값을 입력하지 않은 경우 validationName 메소드
        [x] 2. 6 자 이상의 이름을 입력할 경우 validationName 메소드
        [x] 3. 쉼표로 구분하여 입력하지 않은 경우 validateAndSplit 메소드
        [x] 4. 2 이상의 자동차 이름을 입력 하지 않은 경우 validateAndSplit 메소드
        [x] 5. 입력한 자동차의 이름이 같은 경우 carSameNameValidation 메소드
  
- [x] '시도할 회수는 몇회인가요?' 출력 한다. inputview#tryGameNumber 메소드
- [x] 사용자가 몇 번 이동할지 숫자 값을 입력 받는다. Inputview#carNumericValue 메소드
- [x] 사용자 입력 예외 처리 InputValidation#carNumericValidation 메소드
      [x] 1. 사용자가 숫자가 아닌 다른 값을 입력했을 경우 예외 처리

- [] 0에서 9까지의 무작위 값을 구한다. util 패키지. GoStopCar 클래스. pickNumberInRange 메소드.
  - [] 4 ~ 9 이상의 값일 경우 자동차가 전진한다. controller 패키지. RacingCarController 클래스. 
    - [] "자동차 이름 : " + "-" (추가) view 패키지. Outputview 클래스. outputViewCar 메소드.
  - [] 1 ~ 3 의 값일 경우 자동차는 멈춘다. domain 패키지. Car 클래스.
    - [] "자동차 이름 : " 만 출력 view 패키지. OutputView 클래스. outputViewCar 메소드.
  - [] 사용자가 이동할 숫자 값 까지 무작위 값을 호출한다. 
  
- [] 우승자를 출력 한다. 
  - [] random 숫자에서 (4 ~ 9) 값이 나온 자동차를 ++ 처리한다. controller 패키지
  - [] 숫자를 더한 값 중 가장 높은 값의 자동차가 우승 한다. controller 패키지
  - [] "최종 우승자 : " + 우승 자동차 view 패키지. OutputView 클래스.
   

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

  * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
  * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  * 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  * 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  * 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
  * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.