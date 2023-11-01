# 미션 - 자동차 경주

## 📖피드백 정리
### 1. 구현 하고자 하는 기능을 요구사항으로 작성해준다.
  - 바로 코드를 작성하지 않는다.
  - 코드 작성 전에는 구현하고자 하는 기능을 나눠 요구 사항을 작성한다. 
    - 기능 설명 - 클래스명#메서드명
    - [ ] 기능 설명 - className#MethodName()
### 2. 디렉토리 구조(direcoty = package)
#### 2-1. 빌드 도구
- gradle -> mavenCentral에서 해당 dependencies에 있는 라이브러리를 불러온다.
- main directory
  - 실제 배포할 코드가 들어있는 디렉토리
  - 서비스에서 사용할 코드만 들어가 있다.
#### 2-2. Test
  - 프로덕션을 테스트 하기 위한 테스트 코드만 들어가 있다. 
  - 실제 서비스와 영향이 없는 코드가 들어 있는 디렉토리
  - 테스트 하고자 하는 영역이 들어있는 디렉토리
  - A~Z까지의 테스트를 위한 것이 아닌 프로덕션에 있는 서비스를 테스트 하기 위한 테스트 코드만 담겨 있다.
#### 2-3. Java(main 하위 디렉토리)
  - 자바는 함수가 단독으로 실행 불가하기 때문에 `.class`가 필수로 필요하다.
  - main method를 만들어 프로그램 시작점을 만들어야 한다.
  - java에서는 package = directory이고 패키지가 있으면 해당 클래스가 어떤 것과 관련되어 있음을 알수 있다.
  - 생성자
  - 메서드(기능)
  - 필드
### 3. package
#### 3-1. Model or Domain
- 실제 다루고자 하는 서비스의 비지니스 영역이 담겨 있는 것을 모델 혹은 도메인이라고 표현한다.
>ex) baseball.domain (baseball과 관련된 도메인이란 것을 패키지만 보고도 유추 가능)
- class는 java의 file로 생각한다.
- 작성한 클래스 이름답게 기능을 동작 해야 한다.

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
## 🚀 기능 요구 사항
### 1. 기능 목록
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - [x] 0 ~ 9까지의 값 중 무작위로 고른 값이 4 이상일 때 자동차는 전진 한다.(`-`를 1번 전진으로 본다.) - Car#IsCarMovingForward()
  - [x] 0 ~ 9까지의 값 중 무작위로 고른 값이 4 이하일 때는 멈춘다. - Car#IsCarMovingForward()
- 입력값
  - [x] 경주할 자동차 이름을 입력 받는다. (각 자동차마다 이름을 부여할 수 있다.) - Car#createCarName()
    - [x] 자동차의 이름은 5글자 이하로 입력 받아야 한다. - CarValidator#validateCarName()
    - [x] 자동차의 이름은 영문 혹은 한글로만 입력 받아야 한다. - CarValidator#validateCarLength()
  - [ ] 시도할 횟수를 입력 받는다. - Application-main()
  - [ ] 입력 받은 자동차 이름을 쉼표(,)를 기준으로 구분한다. - Car#spiteCarNames()
  - [ ] 입력 받은 자동차를 <자동차 이름, 전진 횟수>로 저장할 수 있게 Map 자료 구조로 만들어 준다. - getCarNameInfoMap()
- 출력값
  - 경기가 끝나면 우승자를 출력한다.
    - [ ] 각 자동차마다 전진한 거리를 구한다 - Car#countDistance()
    - [ ] 단일 우승자의 경우엔 바로 출력 해준다.
    - [ ] 우승자가 여러 명일 경우에는 쉼표(,)를 이용하여 구분한다.
- 종료
  - [x] Systeom.exit() 이외의 방법으로 애플리케이션 종료 
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료한다.
    - [x] 차 이름이 5글자가 넘는 경우
    - [x] 차 이름에 영문, 한글 이외의 글자가 작성된 경우
