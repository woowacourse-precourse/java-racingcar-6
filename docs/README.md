# 🚗 자동차 경주 게임 (Racing Car Game)

## 기능 목록

## View

### 1. 사용자 입력 기능
#### Class: InputRaceView
- `readCarNames` 메서드:
    - 사용자로부터 경주할 자동차 이름을 입력.
    - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력.
- `readRaceCount` 메서드:
    - 사용자로부터 시도할 경주 횟수를 입력.
    - "시도할 회수는 몇회인가요?" 출력.

### 2. 게임 결과 출력 기능
#### Class: OutputRaceView
- `printRaceResult` 메서드:
    - 각 라운드 별로 자동차의 위치를 출력.
    - EX:
        - 실행 결과 <br>
          pobi : - <br>
          woni : <br>
          jun : -
- `printWinners` 메서드:
    - 경주 게임의 최종 우승자를 출력.
    - EX:
        - 최종 우승자 : pobi, jun

## Controller

### 1. 게임 라운드 실행 기능
#### Class: RaceController
- `startRace` 메서드:
  - 전체 게임의 라운드를 관리하고 결과를 출력.
- `conductRace` 메서드:
  - 경주 게임을 시작하는 기능을 수행
  - `RaceService`의 `start` 메서드를 호출하여 경주를 시작.
- `displayWinners` 메서드:
  - 경주 게임의 결과로 나온 우승자들을 화면에 표시한다.
  - `RaceService`의 `getWinner` 메서드를 통해 우증자 정보를 받아온 후, `OutputView`의 `PrintWinners` 메서드를 사용하여 우승자를 출력.


## Service

### 1. 자동차 정보 및 경주 기능
#### Class: RaceService
- `start` 메서드:
  - 게임을 시작하기 위한 전반적인 과정을 조정하며, 경주를 진행.
- `initializeCars` 메서드:
  - 사용자로부터 자동차 이름을 입력.
  - 입력받은 이름을 기반으로 Car 객체 리스트를 생성.
- `getRaceCount` 메서드:
  - 사용자로부터 경주를 진행할 횟수를 입력.
- `conductRaces` 메서드:
  - 입력받은 경주 횟수만큼 자동차 경주를 진행.
  - 각 경주가 끝날 때마다 해당 결과를 출력.
- `getWinners` 메서드:
  - 경주에 참여한 자동차 중 가장 멀리 나간 자동차(들)의 최대 거리를 계산.
  - 해당 거리를 기반으로 우승한 자동차(들)을 반환.

## Model

### 1. 자동차 객체 및 움직임 기능
#### Class: Car
- 자동차 이름 및 위치 정보를 관리.
- 주어진 숫자를 기반으로 자동차의 움직임 여부를 결정.

### 2. 경주 진행 기능
#### Class: Race
- `run` 메서드:
    - 주어진 자동차 목록에 대하여 각각의 자동차를 이동.

## Exception

### 1. 예외상황 처리 기능
#### Class: CarNameValidator
- `validate` 메서드:
    - 자동차 이름에 대한 유효성 검사:
        - 입력값이 null인 경우 예외 발생
        - 입력된 이름의 길이가 5자 초과인 경우 예외 발생
        - 입력된 이름의 길이가 1보다 작은 경우 예외 발생
    - 위의 조건 중 하나라도 만족하면 `IllegalArgumentException` 발생
