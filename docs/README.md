## ✅ 기능 목록

- 입력 및 검증
  - [X] "경주할 자동차 이름을 입력하세요.(이름은 `쉼표(,)` 기준으로 구분)" 메시지 출력
    - [X] n대의 자동차 이름 입력
  - [X] "시도할 회수는 몇회인가요?" 메시지 출력
    - [X] m회 시도할 회수 입력
  - [X] 게임 시작 전 입력 값 검증
    - [X] 자동차 이름이 5자 이하인지 확인
    - [X] 자동차 이름이 `쉼표(,)`로 구분되어 있는지 확인
    - [X] 자동차 이름이 중복되지 않는지 확인
    - [X] 시도할 회수가 숫자인지 확인
    - [X] 입력 값이 잘못되었다면 `IllegalArgumentException` 발생
  - [X] 시도할 회수 입력 후 `\n(개행)` 출력


- 게임 진행
  - [X] n대의 자동차 생성
  - [X] "실행 결과" 메시지 출력
  - [X] m회 결과 출력
    - [X] 각 자동차는 0에서 9 사이에서 무작위 값을 구하기
      - [X] 무작위 값이 4 이상일 경우 전진
    - [X] n개의 `자동차 이름과 전진 결과`를 출력
      - [X] 자동차 이름과 전진 결과 사이는 `콜론(:)`으로 구분
      - [X] 전진 결과는 `-(하이픈)`으로 표시
    - [X] 각 회차의 결과는 `\n(개행)`으로 구분


- 게임 종료
  - [X] 우승자 출력
    - [X] 단독 우승자
    - [X] 공동 우승자
      - [X] `쉼표(,)`를 이용하여 구분

## 🚀 테스트 진행 목록

- `controller 패키지`
- `domain 패키지`
- `util 패키지`

## ✏️ 클래스 설계

### RacingGameConsole

- `RacingGameConsole`은 게임의 진행을 담당합니다.
-  `run()`을 통해 게임을 실행합니다.
- `InputView`을 통해 입력 값을 받습니다.
- `InputValidator`를 통해 입력 값을 검증한다.
- `ResultStringifier`를 통해 게임 결과를 문자열로 변환한다.
- `OutputView`을 통해 게임 결과를 출력한다.

### Car

- `Car`는 경주에 참여하는 자동차를 의미합니다.
- `name`과 `position`을 가지고 있습니다.
- `move()`를 통해 자동차를 전진시킵니다.

### Cars

- `Cars`는 경주에 참여하는 자동차 목록을 의미합니다.
- `List<Car>`를 가지고 있습니다.
- `getCar`를 통해 불변한 자동차 목록을 반환합니다.
- `moveAll()`을 통해 모든 자동차를 전진시킵니다. (moveStrategy를 사용합니다.)
- `findWinners()`를 통해 불변한 우승자 목록을 반환합니다.

### Race

- `Race`는 경주를 의미합니다.
- `Cars`와 `MoveStrategy`를 가지고 있습니다.
- `getCars()`를 통해 불변한 자동차 목록을 반환합니다.
- `executeOneRound()`를 통해 한 라운드를 진행합니다.
- `getWinnerNames()`를 통해 불변한 우승자 이름 목록을 반환합니다.

### MoveStrategy

- `MoveStrategy`는 자동차가 전진할지 말지를 결정합니다. (움직임 전략입니다.)
- `move()`를 통해 자동차가 전진할지 말지를 결정합니다.
- `MoveStrategy`는 `RandomMoveStrategy`가 있습니다.
- `RandomMoveStrategy`는 무작위로 전진할지 말지를 결정합니다. (무작위 규칙은 게임 규칙과 동일합니다.)

### InputValidator

- `InputValidator`는 입력 값을 검증합니다.
- `validateCarNames()`를 통해 입력받은 자동차 이름을 검증합니다.
- `validateRound()`를 통해 입력받은 라운드 수를 검증합니다.

### ResultStringifier

- `ResultStringifier`는 게임 결과를 문자열로 변환합니다.
- `generateProgressString()`을 통해 게임 진행 상황을 문자열로 변환합니다.
- `generateWinnersString()`을 통해 우승자를 문자열로 변환합니다.

### InputView

- `InputView`는 입력할 정보를 안내하고 입력 값을 받습니다.
- `inputCarNames()`을 통해 자동차 이름을 입력받습니다.
- `inputRound()`을 통해 라운드 수를 입력받습니다.

### OutputView

- `OutputView`는 게임 진행 상황과 결과를 출력합니다.
- `printProgress()`를 통해 게임 진행 상황을 출력합니다.
- `printWinners()`를 통해 우승자를 출력합니다.

### Application

- `Application`은 프로그램의 시작점입니다.
- `main()`을 통해 프로그램을 실행합니다.
- `RacingGameConsole` 객체를 통해 자동차 경주 게임을 실행합니다.