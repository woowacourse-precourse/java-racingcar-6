## 자동차 경주 기능 목록

- [x] 주어진 횟수 만큼 경기 수행 및 결과 출력 - RacingcarGame#run()
    - [x] 경기 시작 전 사용자 입력 및 객체 생성 - RacingcarGame#ready()
    - [x] 경기 시작 전진 또는 멈춤 수행 - RacingcarGame#playcar()
    - [x] 경기 중간 결과 출력 - RacingcarGame#currentResult()
- [x] 각 자동차에 이름을 부여 - Car#createName()
    - [x] 각 자동차가 전진한 수 저장을 위한 Map 객체 초기화 - Car#createNameMap()
    - [x] 자동차 이름이 5자 이하 검증 - Car#validateName()
    - [x] 자동차 이름을 쉼표(,)를 기준으로 구분 및 문자열 리스트 변환 - Car#splitToName()
    - [x] 각 자동차 운행 - Car#driving()
    - [x] 자동차 전진 수 변경 - Car#changeValue()
    - [x] 단독/공동 우승자만 골라내어 반환 - Car#winnerList()
    - [x] 우승자 찾기 - Car#findWinner()
- [x] 사용자가 이동할 횟수 입력 - Player#moveOnInput()
    - [x] 사용자가 입력한 이동 횟수 검증 - Player#validateCount()
    - [x] 사용자가 입력한 이동 횟수가 0보다 큰 정수 확인 - Player#isCountRange()
- [x] 0에서 9사이 무작위 값을 구한다. - Utils#randomNumberGenerator()
    - [x] 0에서 9사이 무작위 값을 검증 - Utils#isNumberRange()
    - [x] 무작위 값이 4 이상일 경우 전진 - Car#moveToGo()
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지 알린다. - OutputView#printToResult()
    - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분 - OutputView#winnersToMulti()
- [x] 자동차 경주 게임 중간 결과를 알린다. - OutputView#resultForMiddle()
    - [x] 각 자동차가 전진한 만큼 표시한다. - OutputView#currentOnGo()
- [x] 사용자가 잘못된 값을 입력한 경우 `IllegalArgumentException` 발생 - ExceptionMessage

[기능 요구 사항]
초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

[추가된 요구 사항]
indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
3항 연산자를 쓰지 않는다.
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.