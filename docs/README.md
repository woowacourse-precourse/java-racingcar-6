- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.

1. 경주할 자동차 이름과 시도할 회수 입력 받기 -> Controller 가 요청 받고 Domain으로 전달하여 저장
2. 자동차 전진 기능 -> 전진 조건은 0~9 사이 무작위 값(단. 난수가 4이상이여야 전진) -> Service단
3. 우승 결과 출력 -> 시도 횟수를 모두 소모하면 가장 많이 전진한 자동차 이름을 출력(우승자는 1명 이상, 여러명이라면 쉼표(,)로 구분)
4. 필수) 사용자가 잘못 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료


+ 요구사항 ->  프로그램 종료 시 System.exit()를 호출하지 않는다.

+ 요구사항 ->  3항 연산자를 쓰지 않는다.

+ 요구사항 ->  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
         예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
          힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

+ 요구사항 ->  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

+ 요구사항 ->  JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
             테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.

  - 라이브러리
    JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
        Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
            ex) 0~9까지의 정수 중 한 개의 정수 반환 -> Randoms.pickNumberInRange(0,9);