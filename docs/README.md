# [우아한테크코스] 백엔드 프리코스 2주차 미션 - 자동차 경주

## 기능 요구 사항

### 게임 개요

- 주어진 횟수 동안 n대의 자동차는 전진 또는ㄴ 멈출 수 있다.
- 각 자동차에 이름을 부여하고, 전진하는 자동차를 출력할 때, 자동차 이름을 같이 출력한다.
    - 자동차 이름은 쉼표(,)를 기준으로 구분, 이름은 5자 이하
- 자동차를 몇 번 이동시킬지 입력을 받는다.
- 0과 9사이의 무작위 값을 생성, 무작위 값이 4 이상인 경우 전진한다.
- 자동차 경주 게임이 완료되면 우승자를 출력, 우승자는 한명 이상일 수 있음.
- 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분

### [입력]

- (차량 이름) 경주할 자동차 이름(각 이름은 쉼표를 기준으로 구분)
- 몇 번의 이동을 할 지

### [출력]

- (게임 시작 시 문구) 경주할 자동차를 입력하세요.(이름은 쉼표(,) 기준으로 구분)
- (이동 시도 횟수 입력) 시도할 횟수는 몇회인가요?
- (게임 실행 시) 실행 결과
- 렌덤 함수를 사용하여 각 차량이 이동한 정도를 '-'를 증가시켜 표시
- (게임 종료 시) 최종 우승자 출력

## 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능
- 프로그램 실행 시작점은 Application의 main()
- build.gradle 파일 변경 불가, 외부 라이브러리 사용 안함
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수
- 프로그램 종료 시 `System.exit()` 호출 안함
- `ApplicationTest`의 모든 test 성공

### 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용
- Random값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberRange()`를 활용
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

## [ JAVA setting ]

- JAVA version: openjdk-17 (Oracle OpenJDK version 17.0.1)
- [File] - [Project Structure...] - [Project] 에서 'SDK' version, 'Language Level' = 17
- [File] - [Project Structure...] - [Modules] 에서 'Language Level' = 17
- [IntelliJ IDEA] - [Preferences] 에서 Gradle 검색, 'Gradle JVM' = 17