# 미션 - 자동차 경주 기능

# 구현할 기능 목록
- [x] README.md 추가
## 사용자에게 입력받는 기능 구현
- [x] controller 패키지와 게임 전체 기능을 가진 RacingCarGame 추가
- [x] InputView 입력 요구 메시지 출력 기능 구현
- [x] InputUtils 자동차 이름들과 시도 회수를 입력받는 기능 구현
  - 입력 값을 변환하는 기능 구현
  - 입력 값의 빈값 검사, int 범위 검사
- [ ] Car, Cars 생성 및 검증 -> 5자 이하만 입력 가능, 공백 불가능으로 설정
- [ ] AttemptCount 생성 및 검증
- [ ] 예외 메시지 정리하기

## 경주 기능 구현
- [ ] Car, Cars 이동 기능 구현
- [ ] OutputView 전진하는 자동차 출력 기능 구현
## 우승자 출력 기능 구현
- [ ] 경주 결과 도출하는 기능 구현
- [ ] OutputView 경주 결과 출력 기능 구현




# 전체 체크리스트

## ✏️ 과제 진행 요구 사항
- [x] 미션은 [java-racingcar-6](https://github.com/woowacourse-precourse/java-racingcar-6) 저장소를 Fork & Clone해 시작한다.
- [x] **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [ ] **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [ ] [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- [ ] 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

## 🚀 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 🎯 프로그래밍 요구 사항 체크리스트

- [x] JDK 17 버전 사용
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`
- [ ] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [ ] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항 체크리스트

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리 체크리스트

- [ ] JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 🚨 과제 제출 전 체크 리스트
- [ ] 기능 단위로 커밋 항상 명심하기!
- [ ] 요구사항에 명시된 출력값 형식을 지켰는가? (입출력 요구 사항 확인)
- [ ] 모든 테스트가 성공하는가?
- [ ] 세 개의 요구사항을 만족하기 위해 최선을 다했는가?

