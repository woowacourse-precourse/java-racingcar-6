# 레이싱 게임

## 구현할 기능 목록
- [x] 자동차 이름을 분리하는 기능 - CarGenerator#splitNames()
- [x] 이름 배열을 받아 자동차를 생성하는 기능 - CarGenerator#createCars()

- [x] 자동차가 움직일지 결정하는 기능 - Car#canMove()
- [x] 자동차가 움직인 거리를 변경하는 기능 - Car#move()
- [x] 자동차가 움직인 거리를 구하는 기능 - Car#getDistance()
- [x] 자동차 이름을 받아오는 기능 - Car#getName()
- [x] 각 자동차의 움직인 거리를 출력하는 기능 - Printer#printDistance()

- [x] 가장 멀리 움직인 거리를 구하는 기능 - Referee#findMaxDistance()
- [x] 우승자를 구하는 기능 - Referee#findWinner()
- [x] 우승자를 출력하는 기능 - Printer#printWinner()

- [x] 입력값이 올바른 이름 형식인지 확인하는 기능 - Validation#validNames()
- [ ] 입력값이 숫자인지 확인하는 기능 - Validation#validNumber()


## 프로그래밍 요구 사항
Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.

추가된 요구 사항
indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
3항 연산자를 쓰지 않는다.
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.
라이브러리
JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.