## 기능 목록

1. 게임 준비
- [x] 경주 할 자동차 이름을 입력받는다. AskCarName#askCarName()
  - [x] 입력받은 값에 ','이 포함 되어 있는지 확인한다. AskCarName#checkCarName()
  - [x] 각 자동차의 이름을 ','를 기준으로 구분한다. AskCarName#splitCarName()
  - [x] 자동차의 이름은 5자 이하만 가능하다. AskCarName#validateLengthOfCarName()

- [x] 플레이어에게 몇 번의 이동을 할 것인지를 입력받는다. AskHowManyPlayGame#askHowManyPlayGame()
- [x] 플레이어에게 입력받는 값이 숫자인지 검증한다. AskHowManyPlayGame#askHowManyPlayGame()
- [x] 플레이어에게 입력받은 값을 int형으로 반환한다. AskHowManyPlayGame#askHowManyPlayGame()

2. 게임 진행
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. OutputCarName#outputCarName()
- [x] 0에서 9사이의 무작위 값을 생성한다. NumberGenerator#createRandomNumber()
- [x] 무작위 값이 4 이상이면 전진한다. NumberGenerator#checkMoreThanFour()

3. 게임 종료
- [x] 우승자는 한 명 이상일 수 있다. GameResult#checkWinnerCar()
- [x] 게임 종료 후 우승한 자동차 이름을 알려준다. GameResult#outputWinnerCarName()
- [x] 우승자가 여러 명일 경우 ','를 이용하여 구분한다.

# 공통
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
- [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.


## 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다.
전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 프로그래밍 요구사항

JDK 17 버전에서 실행 가능해야 한다.
JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.
프로그램 실행의 시작점은 Application의 main()이다.
build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
프로그램 종료 시 System.exit()를 호출하지 않는다.
프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다.
테스트가 실패할 경우 0점 처리한다.
프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.


## 추가된 요구사항

indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
3항 연산자를 쓰지 않는다.
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.

## 라이브러리

JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
