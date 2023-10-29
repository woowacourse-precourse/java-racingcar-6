## 🌠 기능 목록 설계


- [ ] 사용자 입력을 받는다. `InputView`
  - [x] 경주 할 자동차 이름을 받는다.
  - [x] 자동차의 이동 횟수를 입력 받는다.


- [x] 자동차 이름 입력을 검증한다. `CarNameInputValidator`
  - [x] 입력 값이 존재 하는가? 확인한다.
  - [x] 구분자가 쉼표인가? 확인한다.
  - [x] 이름이 5자 이하인가? 확인한다.
    - [x] 그 전에 이름의 공백을 제거한다.
  - [x] 중복 이름이 있는가? 확인한다.


- [ ] 이동 횟수 입력을 검증한다. `TriesCountInputValidator`
  - [ ] 입력 값이 존재 하는가? 확인한다.
  - [ ] 정수인가? 확인한다.


- [ ] 게임에 필요한 문구를 출력한다. `OutputView`
  - [x] 자동차 이름 입력 받을 때 필요한 문구를 출력한다.
  - [x] 시도할 회수 입력 받을 때 필요한 문구를 출력한다.
  - [x] 실행 결과 안내 문구를 출력한다.
  - [x] 각 이동 결과를 출력한다.
  - [x] 우승자를 출력한다.


- [x] OutputView 에서 사용할 출력문을 정의한다. `ConstantView`
  - [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
  - [x] "시도할 회수는 몇회인가요?"
  - [x] "실행 결과"
  - [x] 줄바꿈


- [ ] IllegalArgumentException이 터질 때의 출력할 메세지를 정의한다. `ErrorMessage`
  - [ ] 입력 값이 존재하지 않는 경우에 대한 정의
  - [ ] 자동차 이름의 구분이 잘못된 경우에 대한 정의
  - [ ] 이름 규칙이 맞지 않는 경우(5자 이하여야 한다.)에 대한 정의
  - [ ] 이동 횟수가 정수로 입력되지 않은 경우에 대한 정의


- [x] 자동차의 정보를 저장한다. `Car`
  - [x] 이름을 갖는다.
  - [x] MoveStrategy에 의해 정해진 n번의 전진/정지 여부를 갖는다.
  - [x] 현재 위치를 저장한다.
  - [x] 한 번 이동할 때마다, 현재 상태를 보여줄 수 있다.
  - [x] 이동할 때마다 이동 횟수는 1씩 증가한다.함


- [x] 각 자동차 별 이동 횟수를 정의 한다. `RandomMoveStrategy`
  - [x] 0에서 9 사이에서 무작위 값을 구한 후, 무작위 값이 4 이상일 경우 전진으로 정의한다.
  - [x] 각 Car가 n번의 전진/정지 여부를 가질 수 있도록 한다.


- [ ] 우승자를 선정한다. `WinnerDeterminationService`
  - [ ] 총 시도 횟수 동안 가장 많은 전진을 한 자동차를 찾아 정의한다.
  - [ ] 우승자는 중복을 허용한다.


- [ ] 우승자 정보를 저장한다. `Winner`
  - [ ] 최종 우승자를 makeWinnerService로부터 입력 받아 결과를 보여준다.
  - [ ] 여러 명의 우승자가 있을 때 정렬 조건이 필요하다.
    - [ ] 게임 시작 시 입력 받은 이름 순으로 저장된다.


- [ ] 게임을 관리한다. `RacingCarGameController`


- [ ] 애플리케이션을 관리한다. `Application`
  - [ ] IllegalArgumentException이 발생한 경우 애플리케이션을 종료한다.

---

### 리펙토링 해야 할 부분
- [ ] @Override toString 제거하고 공통된 출력 형태 view로 빼기.
- [ ] 이동 횟수 관련 이름들 moves->tries로 통일시키기.
- [ ] depth 낮추기
- [ ] 테스트코드 메서드명 수정

---

## 🚀 기능 요구 사항

### 입력
- 각 자동차에 이름을 부여할 수 있다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

```java
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
```

- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

```java
시도할 회수는 몇회인가요?
5
```

### 연산
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

### 출력
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

```java
실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----
```

- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

```java
최종 우승자 : pobi, jun
```

### 종료 조건
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.


---

## 🎯 프로그래밍 요구 사항

- [x] JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [ ] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 
  - [ ] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - [ ] 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - [ ] 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- [ ] JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    -  [ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    -  [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```java
Randoms.pickNumberInRange(0,9);
```

---

## ✏️ 과제 진행 요구 사항

-[x] 미션은 [java-racingcar-6](https://github.com/woowacourse-precourse/java-racingcar-6) 저장소를 Fork & Clone해 시작한다.
-[ ] **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
-[ ] **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
-[ ] 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.