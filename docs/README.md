# 기능 명세서

목표1: 이번에는 mvc패턴을 적용해보려고 노력하려고 한다. 
목표2: 핑계대지 말고 하루에 무조건 30분이상은 하려고 노력한다.

## 일단 기능들을 나열해보기

- [x] 자동차의 이름들을 입력받기 - inputRacingCarName()
  - [x] 콤마를 기준으로 이름들을 구분하기
  - [x] (예외처리)자동차의 이름은 5글자인지 확인한다. - checkCarNameLength() 
- [x] 구분한 자동차들에 대한 객체를 생성한다. - createRacingCar()
- [x] 시도할 횟수를 입력받는다. - inputRacingRoundTimes()
  - [x] (예외처리)시도할 횟수에 대해 입력받은 값이 숫자인지 확인한다 - checkIsNumber()
- [x] 주사위 값에 따라 자동차의 전진 혹은 정지를 결정한다. - isMove()
  - [x] 랜덤값이 4이상인지 확인한다. - checkRandomNumber()
  - [x] random값 결과에 따라 이를 저장한다. - accel()
  - [x] 전진 현황에 대한 출력문 함수를 만든다. - totalCurrentRoundResult()
- [x] 각 회차별 경기를 진행한다.- roundProgress()
- [x] 각 회차별 결과를 출력한다. - printCurrentRoundResult
- [x] 회차가 다 진행된 후 총 전진 결과를 집계한다. - caculateGameWinner()
- [x] 결과에 따른 우승자를 출력한다. - printGameResult()
  - [x] 우승자가 2명이상인 경우의 출력문도 고려한다. 

## 함수 기능 분리하기
- [x] roundProgress함수에서 차의 전진을 결정하는 기능을 분리
- [x] game setting과 game start 기능을 분리
- [x] 게임 결과 계산 기능과 게임 결과 출력 기능을 분리
- [x] 게임 결과 출력 기능을 우승자가 1명일 경우와 2명일 경우로 분리
- [x] OutputView와 Model을 분리

## 코드 리펙토링
- [x] 입력값 예외처리를 inputview가 하도록 변경
- [x] 게임결과를 계산하는 기능을 outputview에서 controller로 이동
- [x] Car 클래스에서 이동한 거리를 나타내는 문자열 필드를 만듬
- [x] Car 클래스에서 이동한 거리를 업데이트하는 함수 생성

## MVC 생각해보기

### Model
- [x] Car

### View
- [x] InputView
  - [x] 자동차 이름 입력받기
  - [x] 시도 횟수 입력받기
- [x] OutputView
  - [x] 각 차수별(경기 라운드별) 실행결과 출력
### Controller
- [x] RacingCarController

### Validator
- [x] InputValidator
  - [x] 시도횟수의 입력값이 숫자인가?
  - [x] 각 자동차의 이름 글자수가 5글자 이하인가?


## 예외처리

- [x] 회차 수를 입력받을 때 정상적인 숫자로 입력하는가?
- [x] 자동차 이름을 입력받을 때 콤마 사이에 아무값도 없을 때

## 테스트 함수 작성해보기
- [x] InputViewTest
  - [x] inputRacingCarName 자동차 이름 양옆에 공백이 있을 경우
  - [x] inputRacingRoundTimes 값이 숫자가 아닐 경우 illgegalArgumentException 처리

## 추가된 요구사항 명심할 것

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.