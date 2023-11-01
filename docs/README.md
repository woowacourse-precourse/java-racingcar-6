## 목차

------

[1. 기능 작성 전 확인 사항!](#span-stylebackground-colore8d5951--기능-작성-전-확인-사항-) <br>
[2. 🚗 자동차 경주 🚗 의 기능 목록](#span-stylebackground-colore8d5952--자동차-경주--의-기능-목록) <br>
[3. 저번 1주차 피드백 정리하기](#span-stylebackground-colore8d5953-저번-1주차-피드백-정리-신경쓰자) <br>
[4. 목표](#span-stylebackground-colore8d595-4-목표) <br>
[5. 구현하며 신경써야 할 점들!](#span-stylebackground-colore8d595-5-구현하며-신경-써야-할-점들) <br>
[6. 결과](#span-stylebackground-colore8d595-6-결과)

## <span style="background-color:#E8D595">**1. ✅ 기능 작성 전 확인 사항! ✅**

---

- [x] `java -version` 으로 자바의 버전이 17인지 확인한다!
- [x] `./gradlew clean test` 명령어로 테스트가 통과되는지 확인한다!

## <span style="background-color:#E8D595">**2. 🚗 자동차 경주 🚗 의 기능 목록**

---

- 자동차
    - 상태
        - [x] 자동차는 N개가 있다.
        - [x] 자동차에게는 이름이 있다.
        - [x] 자동차에게는 거리가 있다.
- 입력
    - 진행
        - [x] 자동차의 이름을 ,을 기준으로 입력할 수 있다.
            - [x] ,으로 나누기 전 공백을 제거한다.
        - [x] 몇 번 이동할 것인지 입력할 수 있다.
        - 에러
            - [x] 이름이 `5`자 이상 혹은 0자 일 경우 IllegalException을 발생시킨다.
            - [x] 이동 양이 숫자가 아닐 경우 IllegalException을 발생시킨다.
            - [x] 이름이 1개 이하일 경우 게임이 불가능하기 때문에 Illegal Excpetion을 발생시킨다.
- 자동차 게임
    - 비교
        - [x] 자동차가 전진 양이 4이상일 경우에만 전진한다.
    - 공통
        - [x] `0`에서 `9` 사이의 무작위 값을 구한다.
- 출력
    - 결과
        - [x] 누가 우승했는지를 알려준다.
- 공통
    - 쉼표
        - [x] 쉼표를 기준으로 분해한다.
        - [x] 쉼표를 기준으로 붙인다.

## <span style="background-color:#E8D595">**3. 저번 1주차 피드백 정리 (신경쓰자!)**

---

[장유진 1주차 회고](https://velog.io/@nellroll/%EC%9A%B0%EC%95%84%ED%95%9C-%ED%85%8C%ED%81%AC-%EC%BD%94%EC%8A%A4-6%EA%B8%B0-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-1%EC%A3%BC%EC%B0%A8-%ED%9A%8C%EA%B3%A0)

<br>

- 접근 제어자를 **습관처럼 정해서 작성하지 말자.**
- 직접 구현하기 보다는 **자료구조를 이용**할 수는 없을지 고민해보자
- **네이밍을 좀 더 명확하게** 하자. 어렵다면 어울리는 네이밍을 찾아보자!
- **예외 테스트를 많이** 작성해보는 버릇을 들여보자! 어렵더라도 많은 시도를 해보기
- **내부에서 관리, 외부에서 관리에 대한 생각**을 조금 더 해보고 작성하자!
- **생성자는 상단**에 작성하자!
- **테스트를 하기 간편한 방식**으로 코드를 짜려고 노력해보자
- **사용하는 함수는 최대한 알아보고** 사용할 것! (성능도 고려하기)
- **공통으로 사용하는 부분**을 조금 더 넓게 생각해보기 (Strike 개수 3처럼!)
- **습관적으로 Wrapping 하지 말자** 이유 있게 사용하자!
- for문에 사용되는 변수도 i보다는 **이유 있게 네이밍** 하자!
- 공통되는 부분이 있다면 **Interface, Abstract도 고려**해보자

## <span style="background-color:#E8D595"> **4. 목표**

---

- [x] `le2sky` 님이 말씀하신 테스트에 더 적절한 방식... 적용해보기!
- [x] 피드백들을 많이 신경써서 2주차엔 새로운 피드백을 얻어보기!
- [x] 요구사항 잘 확인하기!
- [x] 테스트를 많이 작성해보는 경험을 가져가기!

## <span style="background-color:#E8D595"> **5. 구현하며 신경 써야 할 점들!**

---
<br>

- [x] indent(인덴트, 들여쓰기) **depth를 3이 넘지 않도록 구현**하자. 어렵다면 함수로 분리하기!
- [x] 3항 연사자를 쓰지 말것!
- [x] 함수(또는 메서드)가 **한 가지 일만** 하도록 최대한 작게 만들자!
- [x] **JUnit 5와 AssertJ를 이용**하여 내 기능이 잘 돌아가는지 확인할 테스트 코드를 작성하자!
- [x] https://gist.github.com/stephenparish/9941e89d80e2bc58a153 에 있는 커밋 메시지 컨벤션을 지키자!

## <span style="background-color:#E8D595"> **6. 결과**

- 자동차 경주 작동 결과

![Animation2](https://github.com/woowacourse-precourse/java-racingcar-6/assets/105053478/56539588-070e-4a32-93ce-4b1ee5406199)

- 혼자 자동차 경주 시도

![Animation2](https://github.com/woowacourse-precourse/java-racingcar-6/assets/105053478/30cdcab2-5dcd-49a4-8b5f-c4147f98d276)

- 자동차 이름 6글자일 경우

![Animation2](https://github.com/woowacourse-precourse/java-racingcar-6/assets/105053478/1efcad35-f4ad-473a-94a4-b05622c7e206)
