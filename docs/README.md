# 기능 목록

## Application

메시지 파일 경로를 인자로 받아 생성된 뷰 인스턴스와 게임 클래스를 게임 컨트롤러에 인자로 주입해 컨트롤러 인스턴스를 생성하는 팩토리다.

| 구현                   | 메서드    | 기능                                                                                                      |
|----------------------|--------|---------------------------------------------------------------------------------------------------------|
| :white_large_square: | `run`  | `Game`, `GameView`, `GameController` 구현체와 메시지 파일 경로를 주입받아 `Application`인스턴스를 생성하는 동시에 `run()`메서드를 실행한다. |
| :white_large_square: | `init` | `Game`의 `Supplier`와 `GameView`를 생성해 `GameController`를 생성하고 `play()` 메서드를 실행한다.                          |

## RacingCarGame

`Game` 인터페이스를 구현한 자동차 경주 게임 클래스이다.

| 구현                   | 메서드                | 기능                                                        |
|----------------------|--------------------|-----------------------------------------------------------|
| :white_large_square: | `pickRandomNumber` | 0에서 9 사이에서 무작위 값을 구한다.                                    |
| :white_large_square: | `validateAttempts` | player가 입력한 횟수를 검증한다.                                     |
| :white_large_square: | `validateCarName`  | player가 설정한 자동차 이름을 검사한다.                                 |
| :white_large_square: | `goAhead`          | 조건에 맞는 경우 해당하는 차를 전진시킨다.                                  |
| :white_large_square: | `play`             | player의 입력과 설정을 검증하고 게임을 실행해 그 결과를 저장한다.                  |
| :white_large_square: | `makeCars`         | player가 입력한 자동차 이름을 검증하고 `,`를 기준으로 분리해 `List<Car>`로 저장한다. |
| :white_large_square: | `saveSettings`     | player가 입력한 자동차 이름을 저장한다.                                 |
| :white_large_square: | `continues`        | game이 진행중인지를 확인한다.                                        |
| :white_large_square: | `checkWinners`     | game 우승자를 알아낸다.                                           |
| :white_large_square: | `getWinners`       | Getter of `winners`.                                      |
| :white_large_square: | `getCarList`       | Getter of `carList`.                                      |

## Car

| 구현                   | 메서드           | 기능                        |
|----------------------|---------------|---------------------------|
| :white_large_square: | `move`        | `Car`의 position을 1 증가시킨다. |
| :white_large_square: | `getName`     | Getter of `name`.         |
| :white_large_square: | `getPosition` | Getter of `position`.     |

## RacingCarGameView

생성 시 인자로 받은 메시지 파일 경로를 통해 메시지를 Properties로 로드한다.

| 구현                   | 메서드                        | 기능                                                             |
|----------------------|----------------------------|----------------------------------------------------------------|
| :white_large_square: | `showInputRequiredMessage` | 입력이 필요하다고 메시지를 출력한다.                                           |
| :white_large_square: | `showResultOf`             | 알맞은 게임 인스턴스가 아니면 `IllegalArgumentException`을 던지고 게임의 결과를 출력한다. |

## RacingCarGameController

게임 클래스와 뷰 인스턴스를 받아 인스턴스를 생성한다.

| 구현                   | 메서드    | 기능                                 |
|----------------------|--------|------------------------------------|
| :white_large_square: | `play` | 게임 인스턴스를 생성해 게임이 완료될 때까지 게임을 진행한다. |

## messages.properties

게임 내 메시지를 따로 메시지 파일로 분리

## RacingCarGameTest

| 구현                   | 메서드                  | 기능                                                                        |
|----------------------|----------------------|---------------------------------------------------------------------------|
| :white_large_square: | `시도횟수로숫자가아닌문자입력`     | player가 시도할 횟수로 숫자를 입력하지 않았을 때 `IllegalArgumentException`을 던지는 것을 검증한다.   |
| :white_large_square: | `자동차이름5자이상`          | player가 입력한 자동차 이름 길이가 5자를 넘는 경우 `IllegalArgumentException`을 던지는 것을 검증한다. |
| :white_large_square: | `stopWhenpicked3`    | 값이 3인 경우 자동차가 전진하지 않는 것을 검증한다.                                            |
| :white_large_square: | `goAheadWhenpicked4` | 값이 4인 경우 자동차가 전진하는 것을 검증한다.                                               |
| :white_large_square: | `게임결과확인`             | player가 입력한 문자열을 검증하고 게임의 결과를 저장한다.                                       |

## RacingCarGameViewTest

| 구현                   | 메서드         |     | 기능                           |
|----------------------|-------------|:----|------------------------------|
| :white_large_square: | `입력필요메시지출력` |     | 입력이 필요하다고 메시지를 출력하는 것을 검증한다. |
| :white_large_square: | `게임결과출력`    |     | 게임의 결과 출력을 검증한다.             |

## RacingCarGameControllerTest

| 구현                   | 메서드      | 기능                       |
|----------------------|----------|--------------------------|
| :white_large_square: | `게임실행확인` | 게임 인스턴스 생성과 실행 여부를 검증한다. |
