## 🚀 구현할 기능 목록

### 자동차 클래스 - `Car`

#### `Car()`
- 이름을 부여한다.

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

#### `getDistance()`
- 거리를 반환한다.

#### `getName()`
- 이름을 반환한다.

#### `toString()` (`Object`의 `toString()` 메서드 오버라이딩)
- 자동차의 현재 상태를 실행 결과 예시(이름 : - * (distance))와 같이 반환한다.

----

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

#### `setCar()`
- 경주할 자동차를 설정한다.
  - Console API의 readLine()을 사용해 입력값을 받고 저장한다.
  - 입력값에 쉼표가 없는 경우면 `IllegalArgumentException`을 발생시킨다. (`hasComma()`)
  - 입력값에 쉼표가 있는 경우면
    - 입력값을 쉼표 기준으로 분리한다.
    - 분리한 각각의 이름에 대해
      - 중복되는 이름이 있거나(`isDistinct()`) 이름이 5자 초과면 (`isElementLengthAbove5`)
        - `IllegalArgumentException`을 발생
      - 그 외
        - 자동차 인스턴스 생성을 반복한다.
        - 이들을 모두 저장한다.

#### `hasComma()`
- String에 (,)가 있는지 확인한다.

#### `isDistinct()`
- String 배열에 중복되는 요소가 없는지 확인한다. 

#### `isElementLengthAbove5()`
- String 배열 각 요소의 길이가 5가 넘지 않는지 확인한다. 

#### `setTrialInput()`
- 전진 또는 멈춤 시도(실행) 횟수를 설정한다.
  - Console API의 readLine()을 사용해 입력값을 받고 저장한다.
  - 입력값이 정수가 아니면 `IllegalArgumentException`을 발생시킨다.
    - 입력값이 0 이하면 `IllegalArgumentException`을 발생시킨다.
    - 입력값이 1 이상이면 이 값을 저장한다.

----