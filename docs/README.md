# 레이싱카 기능 목록 문서

### ✨ 구현 기능 목록

- 자동차 이름 입력 기능
  - 쉼표(,)를 기준으로 구분
  - 자동차 이름 검증
    - 5자 이하로만 가능
- 이동 시도 횟수 입력 기능
- 자동차 전진 기능
- 차수별 실행 결과 출력 기능
- 우승자 출력 기능
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분

### 🎉 체크 리스트

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.