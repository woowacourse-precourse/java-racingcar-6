### `class` RacingCarGame
  -  [x] run

    - 자동차 경주 게임을 실행합니다.

  - [x] moveCars

    - 자동차들을 각각 한 번씩 움직입니다.

### `class` Car
  - [x] move

    - 자동차를 움직입니다.

  - [x] getStatus

    - 자동차의 정보를 String 형태로 반환합니다.

  - [x] (static) parseCars

    - 문자열을 기반으로 Car 리스트를 반환합니다.

    - 단, 입력이 아래 조건에 맞지 않을 경우, `IllegalArgumentException`을 발생시킨다.

      - 자동차의 이름은 쉼표로 구분된다.
      - 자동차의 이름은 5자 이하이다.

### `class` Controller
  - [x] (static) inputNames

    - 사용자로부터 자동차 이름들을 입력받습니다.

  - [x] (static) inputCount

    - 사용자로부터 이동 횟수를 입력받습니다.

### `class` RandomManager
  - [x] (static) isMovingCar

    - 자동차가 움직이는지 반환합니다.

    - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우입니다.

    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용합니다.

### `class` OutputMessage

  - 출력할 문구를 관리하는 class 입니다.