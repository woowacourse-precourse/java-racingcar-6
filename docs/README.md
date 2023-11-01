## 📄 기능 목록

* 입력 ✅
  * ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```를 활용하여 구현 ✅
  * 자동차 이름 ✅
    * 자동차 이름은 쉼표(,)를 기준으로 구분 ✅
    * 이름은 5자 이하만 가능하다. ✅
  * 이동 횟수 ✅
  * 예외 처리 ✅
    * ```IllegalArgumentException``` ✅
* 게임 진행 ✅
  * 입력 받은 이동 횟수를 반복 ✅
* 전진 ✅
  * 0에서 9 사이에서 무작위 값을 구하는 함수 ✅
    * ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()```를 사용하여 구현 ✅
    * 4 이상 : 전진 ✅
    * 4 미만 : 정지 ✅
* 출력 ✅
  * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. ✅
  * 각 이동 차수별 실행 결과 ✅
    * ```agsl
      pobi : --
      woni : ----
      jun : ---
      ```
  * 우승자 안내 문구 ✅
    * 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분 ✅
    * 단독 우승 ✅
      * ```agsl
        최종 우승자 : pobi ✅
        ```
    * 공동 우승 ✅
      * ```agsl
        최종 우승자 : pobi, jun ✅
        ```
* 테스트 코드 ✅
  * JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다
---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-racingcar-6](https://github.com/woowacourse-precourse/java-racingcar-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

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

---