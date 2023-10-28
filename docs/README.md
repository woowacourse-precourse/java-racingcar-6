## 🚀 구현할 기능 목록

---

### 자동차 클래스 - `Car`

#### `Randoms.pickNumberInRange()`
- 0에서 9 사이에서 무작위 값을 구한다.
- 이 값을 반환한다.

#### `moveForward()`
- 전진한다.
  - 거리를 1 증가한다.

#### `stop()`
- 멈춘다.

#### `decideMoveForwardOrStop()`
- 전진할지 멈출지 결정한다.
  - `Randoms.pickNumberInRange()`의 반환값이
    -  4 이상인 경우
      - `moveForward()` 호출
    -  4 미만인 경우
      - `stop()` 호출

#### `toString()` (`Object`의 `toString()` 메서드 오버라이딩)
- 이름을 부여한다.

--- 

### 사용자 클래스 - `User`

#### `setCar()`
- 경주할 자동차의 모든 이름을 설정한다.
  - Console API의 readLine()을 사용해 입력값을 받고 저장한다.
  - Console API의 close()을 사용해 입력값을 닫는다.
  - 입력값에 쉼표가 없는 경우면 `IllegalArgumentException`을 발생시킨다.
  - 입력값에 쉼표가 있는 경우면
    - 입력값을 쉼표 기준으로 분리한다.
    - 분리한 각각의 이름에 대해
      - 이름이 5자 초과면
        - `IllegalArgumentException`을 발생
      - 이름이 5자 이하면
        - 자동차 인스턴스 생성을 반복한다.
        - 이들을 모두 저장한다.

#### setTrial()
- 전진 또는 멈춤 시도(실행) 횟수를 설정한다.
  - Console API의 readLine()을 사용해 입력값을 받고 저장한다.
  - Console API의 close()을 사용해 입력값을 닫는다.
  - 입력값이 정수가 아니면 `IllegalArgumentException`을 발생시킨다.
    - 입력값이 0 이하면 `IllegalArgumentException`을 발생시킨다.
    - 입력값이 1 이상이면 이 값을 저장한다.

---

### 자동차 경주 게임 클래스 - `CarRacingGame`

#### `execute()`
- (자동차 경주 게임을) 실행한다.
  - 실행 횟수만큼 다음을 반복한다.
    - 모든 자동차들에 대해 `decideMoveForwardOrStop()`를 한다.
    - 사용자에게 해당 결과를 알려준다.

#### `rankWinner()`
- 최종 우승자를 추려낸다.
  - 모든 자동차들에 대해 최대 거리 값을 가진 자동차들을 추려낸다.
  - 사용자에게 해당 결과를 알려준다.
    - 자동차 개수가 1개인 경우 그냥 출력한다.
    - 자동차 개수가 2개 이상인 경우 쉼표로 구분해 출력한다.

---