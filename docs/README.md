## 기능 목록 정리
### 🎲 생성
- 랜덤 숫자 생성
  - 0~9까지의 무작위 값
  - 규칙 : 무작위 값이 4 이상일 경우 전진, 미만일 경우 멈춤
  
### 📝 입력
- 경주할 자동차 이름
  - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)" 문구 출력
  - 쉼포기준으로 구분
  - 5자 이하(이상일 경우 `IllegalArgumentException` 발생시키고 종료)
- 시도할 횟수
  - "시도할 횟수는 몇회인가요?" 문구 출력
  - 숫자만 입력 가능(다른 값 입력할 경우 `IllegalArgumentException` 발생시키고 종료)

### 🧾 출력
- 각 차수별 실행 결과
- 단독/공동 우승자 안내 문구

### ⌛ 게임 종료 조건
- 사용자가 입력한 시도할 횟수가 모두 끝났을 때

## 라이브러리

- JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 추가 요구 사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.
