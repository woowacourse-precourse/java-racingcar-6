# 자동차 경주 게임

## 기능 목록

### 입력

- [x] 자동차 이름을 입력받는다. - UserInputHandler#inputNames()
  - [x] 문자열을 쉼표(,)로 구분해 문자열 리스트로 얻을 수 있다. - UserInputHandler#makeSeparationNames()
- [x] 문자열 리스트 만큼 자동차를 만들 수 있다. - Game#createCars()
<br>

- [x] 레이싱 시도 횟수를 입력받는다. - UserInputHandler#InputRacingNumber()
  - [x] 주어진 횟수로 경주(게임)를 진행 횟수를 변경한다.
<br>

- [x] 사용자가 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시킨다. 
  - [x] 이름 입력에 관한 오류 - ExceptionInput#checkNameLength()
    - [x] 이름이 5자가 넘으면 프로그램 종료 
    - [x] 이름입력 끝이 쉼표(,)일 경우 프로그램 종료
    - [x] 이름입력 중간에 쉼표(,)가 연속 입력될 경우 프로그램 종료
  - [x] 레이싱 시도 횟수에 관한 오류
    - [x] 0 미만 수 입력 시 프로그램 입력 - ExceptionInput#checkRacingNumber()
<br>

### 게임 진행

- [x] 전체적인 게임 실행한다. - Game#start()
- [x] 레이싱을 하나씩 실행한다. - Cars#racing()
<br>

- [x] 0에서 9 사이에 무작위 값을 생성한다. - NumberGenerator#createRandomNumber()
- [x] 값이 일정 수(4) 이상인지 확인한다. - Car#checkValueGreaterNumber()
  - [x] 4이상 : 전진 - Car#forward()
  - [x] 4미만 : 멈춤 

<br>

- [x] 숫자 리스트에서 가장 높은 수의 자동차 이름 리스트(중복 고려)를 알 수 있다. - Cars#getMaxForwardCarNames()

<br>

### 출력

- [x] 각 자동차의 경주 결과를 출력한다. - Cars#printRoundRacingResult()
- [x] 최종 우승자를 알아낸다. - cars#getFinalWinners()
- [x] 최종 결과를 쉼표(,)를 이용하여 출력한다. - Game#printFinalResult()

<br>
<br>

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
