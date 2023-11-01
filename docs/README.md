# 미션 - 자동차 경주

## 구현할 기능 목록 정리

### 1️⃣ 입/출력 관련
- [x] 경주 시작 안내 문구를 출력하기
- [x] 자동차 이름을 쉼표로 구분하여 입력 받기
- [x] 시도 횟수를 입력 받기
- [x] 실행 결과를 출력하기
- [x] 우승자를 출력하기

### 2️⃣ 자동차 등록 관련
- [x] 쉼표를 기준으로 구분하여 이름을 등록한다.
- [x] 이름은 5자 이하여야 한다.

### 3️⃣ 자동차 이동 관련
- [x] 0에서 9 사이에서 무작위 값을 구해 4 이상인 경우 전진한다.

### 4️⃣ 경기 결과 관련
- [x] 우승자를 판단한다.

### 테스트
- [ ] 1️⃣이름 입력 관련
  - [ ] 이름이 5글자가 넘는 경우 예외가 던져지는지
  - [ ] 이름이 5글자가 넘지 않는 경우 예외가 발생하지 않고 등록되는지
  - [ ] 이름이 공백인 경우 예외가 던져지는지

- [ ] 2️⃣ 시도 횟수 입력 관련
  - [ ] 숫자가 아닌 경우 예외가 던져지는지

- [ ] 3️⃣ 자동차 이동 관련
  - [ ] 한 칸 전진할 경우 위치가 하나 증가하는지

- [ ] 4️⃣ 경기 결과 관련
  - [ ] 우승자가 여러명일 경우 여러명을 출력하는지
  - [ ] 우승자가 한명일 경우 한명을 출력하는지

### 👀 요구사항 관련
- [x] indent depth 가 3이 넘지 않도록 구현한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 메서드가 한 가지 일만 하도록 작게 만든다.
- [ ] 테스트 코드로 정리한 기능 목록이 동작하는 것을 확인한다.

### 🍀 각 메서드의 역할 정리하기
- Car
  - validateLengthOfName : 자동차의 이름이 요구사항인 5글자 이하에 적합한지 확인
  - moveForward : 자동차의 위치를 하나 앞으로 이동
  - getLocation : 자동차의 위치를 반환
  - addToWinner : Winners 에 해당 자동차의 이름을 추가
  - toString : 자동차의 이름과 위치를 이용해 문자열로 변환
- Game
  - run : 게임의 흐름에 알맞는 메서드들을 호출
  - showWinners : 출력 형태에 맞게 우승자들을 출력
  - moveCarsRepeatedly : 반복적으로 자동차를 이동시키고 이에 해당하는 결과를 출력
  - readTrialNumber : 시도횟수를 읽어들임
  - showResult : 자동차의 이동 결과를 출력
  - readNamesOfCars : 자동차의 이름들을 읽어들이고 이를 등록함
  - moveCars : 자동차들을 조건에 맞는 경우 이동시킴
  - shouldMoveForward : 랜덤한 숫자의 결과를 기반으로 전진해야 하는지 여부를 판단
- Referee
  - findLocationOfWinner : 우승자의 위치를 찾음
  - findWinners : 우승자의 위치에 해당하는 경우 Winners 객체에 자동차의 이름을 추가
- Winners
  - addNameOfWinner : 우승자의 이름을 추가함
  - toString : 출력 형태에 맞게 우승자 수에 따라 적절한 문자열로 변환
- Parser
  - splitStringBySplitter : 문자열을 구분자를 기준으로 잘라 문자열 List 로 반환
  - stringToInteger : 문자열을 Integer 로 반환
- NumberPicker
  - pickRandomNumberInRange : 범위에 해당하는 숫자를 랜덤으로 뽑는다 >> 리팩
- InputView
  - readValue : 콘솔로 들어온 입력값을 읽는다
- OutputView
  - print : 인자로 들어온 문자열을 출력한다
  - printNewLine : 빈 줄을 출력한다
  - println : 인자로 들어온 문자열을 출력하고 줄을 바꾼다

## 🚀 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

#### 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

#### 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

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

최종 우승자 : pobi, jun
```

---

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```java
Randoms.pickNumberInRange(0,9);
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-racingcar-6](https://github.com/woowacourse-precourse/java-racingcar-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
