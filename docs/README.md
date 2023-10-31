# 구현할 기능 목록

### 자동차 이름, 시도할 횟수 입력

- 쉼표(,)를 기준으로 구분해 `camp.nextstep.edu.missionutils.Console`의 `readLine()`를 이용해 자동차 이름을 입력받는다.
  - 이름이 5자 초과일 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
  - 입력값이 없을 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
  - 쉼표(,) 뒤 빈 문자열이 저장될 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`를 이용해 시도할 횟수(몇 번의 이동을 할 것인지)를 입력받는다.

### 자동차 경주 게임 기능 구현

- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 이용해 0~9사이의 무작위 값 생성
- 시도할 회수 1회당 모든 자동차가 무작위 값 생성한다.
    - 무작위 값이 4 이상일 경우 전진
    - 무작위 값이 4 미만일 경우 정지
- 시도할 회수 1회마다 실행결과를 보여준다.

### 게임 결과

- 자동차 경주 게임을 완료한 후 우승자를 알려준다.
    - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.