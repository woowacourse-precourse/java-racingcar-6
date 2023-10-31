# 초간단 자동차 경주 게임


## MVC 패턴을 이용한 기능 목록
### Controller
#### GameController
- 게임의 전체적인 흐름을 통제한다.
- [ ] 게임을 시작한다. GameController#startGame()
- [ ] 게임을 완료한 후 우승자를 결정한다. - GameController #determineWinner()

#### Judgement
- [ ] 무작위 값이 4이상인지 판별한다. - Judgement #isNumberMoreThan4()


### View
- 사용자가 입력하는 프롬포트를 구성하는 view 역할을 한다.
#### RaceView
- 차량 이름, 위치, 우승자를 표시하는 메서드
- [ ] 우승자를 출력한다.(여러명일 경우 쉼표를 사용해 구분) -RaceView #printWinner()
- [ ] 회수 별 실행 결과를 출력한다. - RaceView #printExecutionResults()


### Model
#### Car
- 자동차의 이름과 위치를 나타낸다
#### Race
- 레이스 로직을 나타내며, 자동차 목록과 시도 횟수를 보유하고 승자를 결정한다.
#### NumberGenerator
- 난수를 생성하는 기능
- [ ] 0부터 9 까지의 임의의 수 를 자동차 개수만큼 생성한다. - NumberGenerator #createRandomNumbers()


### utils
#### UserInputManager
- 사용자 입력 및 유효성 검사를 처리한다.
- [ ] 자동차의 이름을 입력받는다 - UserInputManager #inputCarNames()
- [ ] 시도 횟수를 입력받는다 - UserInputManager #inputAttempts()
- [ ] 자동차의 이름이 5자 이하인지 검증한다.- UserInputManager #verifyCarNameLength()
- [ ] 입력이 잘못되면 IllegalArgumentException 을 발생시킨다. - UserInputManager #validateUserInput()
- 
## 기능 요구 사항

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

각 자동차에 이름을 부여하며 출력할 때 자동차 이름을 같이 출력한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


## 추가된 요구 사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다. 
  - 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.

## 라이브러리 사용
- JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 추가 작업
- push 전에 gitignore 작성하기(DS_Store,.class 파일 등)