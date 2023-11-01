# 미션 - 자동차 경주

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
  - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
  - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 17인지 확인한다.
  Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,
  Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

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

## 💡기능 구현 목록
### ✅ 입력
- [x] 게임문구 출력 InputView
  - [x] 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) InputView#promptCarNames
  - [x] 시도할 회수는 몇회인가요? InputView#promptTryCount
- [x] 쉼표를 기준으로 n개의 자동차 입력받음(자동차 이름은 5자 이하) InputView#promptCarNames
- [x] 시도할 횟수를 입력받음 (n 대의 자동차가 전진 또는 멈추는 횟수) InputView#promptTryCount
- [x] 경주할 자동차 이름을 입력받는 부분은 빈 칸이면 안된다. checkIsEmptyInput
- [x] 경주할 자동차 이름을 입력받는 부분에서 문자의 개수는 , 의 개수 +1 이어야한다. checkInputFormat
- [x] 자동차 이름 값은 5자 이하이어야 한다. CarNameValidator

<br/>

### ✅ 프로그램
- [x] 입력받은 횟수로 랜덤한 값을 생성한다 GameNumber#generateRandomNumber
- [x] 0-3사이인 경우 멈추고, 4이상 9 이하인 경우 전진한다 Car#checkProcess
- [x] 모든 횟수를 다 돈 후 가장 길이가 긴(전진을 많이 한) 자동차가 승리한다 GameController#findWinners

<br/>

###  ✅ 출력
- [x] 승리한 자동차가 두개 이상이라면 쉼표를 기준으로 출력하고 한 개라면 그냥 출력한다. 



## 👍🏻 이런 점에 주목했어요!
### ✅ static 키워드를 잘 사용하려고 노력했어요.
 - [x] GameController, Cars, CarNameValidator, InputView, OutputView 에서는 모든 인스턴스에서 변수와 메서드가 공유돼도 상관없어 static 키워드를 사용했어요
 - [x] Car, GameNumber 와 같이 인스턴스 마다 다른 값을 가져야 하는 클래스에 대해서는 인스턴스 변수와 인스턴스 메서드를 사용했어요
### 🙋🏼‍♀️ static 키워드의 장점
- Heap 영역이 아닌 Static 메모리 영역에 저장되어 고정된 메모리 영역을 사용하기 매번 인스턴스를 생성하여 낭비되는 메모리를 줄일 수 있다.
- 객체를 생성하지 않 사용가능하기 때문에 속도가 빠르다

### ✅ [자바 코딩 컨벤션](https://myeonguni.tistory.com/1596)을 지키려고 노력했어요.

### ✅ 객체 지향적으로 코드를 짜기 위해 노력했어요.
- [x] 하나의 클래스는 하나의 역할, 책임만 가져야한다. - SRP(단일 책임 원칙)

### ✅ MVC 디자인 패턴을 지키려고 노력했어요.
- [x] controller 에서만 model 과 view를 참조하고 변경할 수 있게 코드를 짜려고 노력했어요.



## ✔️ PR CHECKLIST
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍했는가?
- [ ] 한 메서드에 오직 한 단계의 들여쓰기(indent)만 허용했는가?
    - Validator#checkCarNameLength 제외
    - GameController#findWinners 제외
- [ ] else 예약어를 쓰지 않았는가?
    - Car#checkProcess 제외
- [ ] 모든 원시값과 문자열을 포장했는가?
- [ ] 콜렉션에 대해 일급 콜렉션을 적용했는가?
- [x] 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
- [ ] getter/setter 없이 구현했는가?
- [x] 메소드의 인자 수를 제한했는가?
- [x] 코드 한 줄에 점(.)을 하나만 허용했는가?
- [x] 메소드가 한가지 일만 담당하도록 구현했는가?
- [x] 클래스를 작게 유지하기 위해 노력했는가?

> 👀 최대한 지키려고 했으나 체크 안된 PR CHECKLIST 에 대해 의견이나 제안 사항 있으시면 자유롭게 댓글달아주시면 감사하겠습니다:)