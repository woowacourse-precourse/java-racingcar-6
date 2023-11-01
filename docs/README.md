# 기능 목록

## Application

메시지 파일 경로를 인자로 받아 생성된 뷰 인스턴스와 게임 클래스를 게임 컨트롤러에 인자로 주입해 컨트롤러 인스턴스를 생성하는 팩토리다.

| 구현                 | 메서드    | 기능                                                                                                      |
|--------------------|--------|---------------------------------------------------------------------------------------------------------|
| :white_check_mark: | `run`  | `Game`, `GameView`, `GameController` 구현체와 메시지 파일 경로를 주입받아 `Application`인스턴스를 생성하는 동시에 `run()`메서드를 실행한다. |
| :white_check_mark: | `init` | `Game`의 `Supplier`와 `GameView`를 생성해 `GameController`를 생성하고 `play()` 메서드를 실행한다.                          |

## RacingCarGame

`Game` 인터페이스를 구현한 자동차 경주 게임 클래스이다.

| 구현                 | 메서드                | 기능                                                        |
|--------------------|--------------------|-----------------------------------------------------------|
| :white_check_mark: | `validateAttempts` | player가 입력한 횟수를 검증한다.                                     |
| :white_check_mark: | `validateCarName`  | player가 설정한 자동차 이름을 검사한다.                                 |
| :white_check_mark: | `goAhead`          | 조건에 맞는 경우 해당하는 차를 전진시킨다.                                  |
| :white_check_mark: | `play`             | player의 입력과 설정을 검증하고 게임을 실행해 그 결과를 저장한다.                  |
| :white_check_mark: | `makeCars`         | player가 입력한 자동차 이름을 검증하고 `,`를 기준으로 분리해 `List<Car>`로 저장한다. |
| :white_check_mark: | `saveSettings`     | player가 입력한 자동차 이름을 저장한다.                                 |
| :white_check_mark: | `continues`        | game이 진행중인지를 확인한다.                                        |
| :white_check_mark: | `checkWinners`     | game 우승자를 알아낸다.                                           |
| :white_check_mark: | `getWinners`       | Getter of `winners`.                                      |
| :white_check_mark: | `getCarList`       | Getter of `carList`.                                      |

## Car

| 구현                 | 메서드           | 기능                        |
|--------------------|---------------|---------------------------|
| :white_check_mark: | `move`        | `Car`의 position을 1 증가시킨다. |
| :white_check_mark: | `getName`     | Getter of `name`.         |
| :white_check_mark: | `getPosition` | Getter of `position`.     |

## RacingCarGameView

생성 시 인자로 받은 메시지 파일 경로를 통해 메시지를 Properties로 로드한다.

| 구현                 | 메서드                                  | 기능                   |
|--------------------|--------------------------------------|----------------------|
| :white_check_mark: | `showInputRequiredMessage`           | 입력이 필요하다고 메시지를 출력한다. |
| :white_check_mark: | `showRepeatingNumberRequiredMessage` | 횟수를 입력하라고 메시지를 출력한다. |
| :white_check_mark: | `showProgressOf`                     | 게임의 진행상황을 출력한다.      |
| :white_check_mark: | `showResultOf`                       | 게임의 결과를 출력한다.        |
| :white_check_mark: | `showResultMessage`                  | `실행 결과`를 출력한다.       |

## RacingCarGameController

게임 클래스와 뷰 인스턴스를 받아 인스턴스를 생성한다.

| 구현                 | 메서드        | 기능                                 |
|--------------------|------------|------------------------------------|
| :white_check_mark: | `play`     | 게임 인스턴스를 생성해 게임이 완료될 때까지 게임을 진행한다. |
| :white_check_mark: | `quitGame` | 게임 인스턴스를 생성해 게임이 완료될 때까지 게임을 진행한다. |
| :white_check_mark: | `race`     | 경주가 종료될 때까지 게임을 진행한다.              |

## messages.properties

게임 내 메시지를 따로 메시지 파일로 분리

## RacingCarGameTest

| 구현                 | 메서드                  | 기능                                                                        |
|--------------------|----------------------|---------------------------------------------------------------------------|
| :white_check_mark: | `숫자가아닌시도횟수입력`        | player가 시도할 횟수로 숫자를 입력하지 않았을 때 `IllegalArgumentException`을 던지는 것을 검증한다.   |
| :white_check_mark: | `자동차이름5자초과`          | player가 입력한 자동차 이름 길이가 5자를 넘는 경우 `IllegalArgumentException`을 던지는 것을 검증한다. |
| :white_check_mark: | `stopWhenpicked3`    | 값이 3인 경우 자동차가 전진하지 않는 것을 검증한다.                                            |
| :white_check_mark: | `goAheadWhenpicked4` | 값이 4인 경우 자동차가 전진하는 것을 검증한다.                                               |

## RacingCarGameViewTest

| 구현                 | 메서드           |     | 기능                           |
|--------------------|---------------|:----|------------------------------|
| :white_check_mark: | `입력필요메시지출력`   |     | 입력이 필요하다고 메시지를 출력하는 것을 검증한다. |
| :white_check_mark: | `횟수입력필요메시지출력` |     | 횟수가 필요하다고 메시지를 출력하는 것을 검증한다. |
| :white_check_mark: | `게임진행상황출력`    |     | 게임 진행상황을 출력하는 것을 검증한다.       |
| :white_check_mark: | `게임결과메시지출력`   |     | 게임의 결과 출력을 검증한다.             |
| :white_check_mark: | `실행결과메시지출력`   |     | `실행 결과` 출력을 검증한다.            |
