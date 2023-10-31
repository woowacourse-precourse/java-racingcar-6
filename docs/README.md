# 우아한테크코스 프리코스 2주차

## 🚗 미션 - 자동차 경주

### ✅ 0점 방지 기본 규칙

- [x]  java -version 17 확인
- [ ]  프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [ ]  기능 구현을 모두 정상적으로 했더라도 요구사항에 명시된 출력값 형식을 지켜야 함
- [ ]  `./gradlew.bat clean test` BUILD SUCCESSFUL 확인

### ✅ 기능 요구 사항

- [ ]  주어진 횟수 동안 n대의 자동차는 전진 or 멈춤 가능
- [ ]  각 자동차에 이름 부여 가능, **전진하는 자동차**를 출력할 때 자동차 이름을 같이 출력
- [ ]  자동차 이름은 쉼표(,)를 기준으로 구분하고 이름은 5자 이하만 가능
- [ ]  사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 함
- [ ]  전진하는 조건은 0~9 사이에서 **무작위 값을 구한 후** 무작위 값이 4 이상일 경우
- [ ]  게임을 완료한 후 누가 우승했는지 알려줌, 우승자는 1명 이상 가능
- [ ]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분
- [ ]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생 시킨 후 Application 종료

### ✅ 구현할 기능 목록

**[ Domain ]**
-

- [ ]  **Car**

자동차의 움직임과 전진 진행 상태를 관리

- [ ]  **Race**

자동차 경주를 관리하고 우승자 결정

**[ View ]**
-

- [x]  **InputView**

사용자로부터 경주에 참여할 자동차의 이름과 시도할 횟수를 입력 받음

- [x]  **OutputView**

각 차수별 실행 결과와 최종 우승자 출력

**[ Controller ]**
-

- [ ]  **RacingCarController**

사용자 입력을 받아 경주를 시작하고 결과를 출력

**[ Constants ]**
-

- [x]  **MessageConstants**

프로그램 전체에서 사용되는 메시지 상수 제공

- [x]  **NumberConstants**

프로그램 전체에서 사용되는 숫자 상수 제공

**[ Validator ]**
-

- [ ]  **CarNameValidator**

입력된 자동차 이름의 유효성 검사

- [ ]  **TryCountValidator**

입력된 시도 횟수의 유효성 검사

### ✅ 프로그래밍 요구 사항

> 제출 전 확인 리스트
>
> - [ ]  JDK-17 사용
> - [ ]  프로그램 실행의 시작점은 `Application`의 `main()`
> - [ ]  `build.gradle` 변경 불가, 외부 라이브러리 사용 금지
> - [ ]  [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)가이드를 준수하며 프로그래밍
> - [ ]  프로그램 종료 시`System.exit()`를 호출 X
> - [ ]  프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
> - [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
>
> 추가된 요구 사항
>
> - [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현, 2까지만 허용
> - [ ]  3항 연산자 사용 X
> - [ ]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들 것
> - [ ]  JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
    >
    >     테스트 도구 사용법이 익숙하지 않다면`test/java/study`를 참고하여 학습한 후 테스트 구현
>
>
> 라이브러리 요구 사항
>
> - [ ]  JDK에서 제공하는 Random 및 Scanner API 대신`camp.nextstep.edu.missionutils`에서 제공하는`Randoms`및`Console`API를 사용하여 구현
    >
    >     Random 값 추출은`camp.nextstep.edu.missionutils.Randoms`의`pickNumberInRange()`를 활용
    >
    >     사용자가 입력하는 값은`camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용
>

### ✅ 과제 진행 요구 사항

- [x]  **[java-racingcar-6](https://github.com/hoonyworld/java-racingcar-6)** 저장소를 Fork & Clone
- [x]  docs/README.md에 구현할 기능 목록을 정리해 추가
- [ ]  완료 후 Pull Request
- [ ]  우아한테크코스 지원 플랫폼에 소감 작성 후 제출
- [ ]  제출한 후 결과 확인, 통과하지 못했다면 수정해 다시 제출

### ✅ 추가 학습 목표

- [x]  Google Java Style Guide 정독 및 적용
- [ ]  1주 차 공통 피드백 코드에 적용