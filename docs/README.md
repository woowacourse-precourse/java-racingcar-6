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
- 전체 게임의 라운드를 진행하는 `startRace` 메서드:
    - `RaceService`를 활용하여 게임 시작
    - `OutputRaceView`를 통해 게임 결과 출력

## Service

### 1. 자동차 정보 및 경주 기능
#### Class: RaceService
- 게임을 시작하고, 자동차를 생성하고 경주를 진행하는 `start` 메서드
- 경주의 우승자를 가져오는 `getWinners` 메서드

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
#### Class: RaceException
- `validateCarName(String name)` 메서드:
    - 자동차 이름에 대한 유효성 검사:
        - 입력값이 null인 경우 예외 발생
        - 입력된 이름의 길이가 5자 초과인 경우 예외 발생
        - 입력된 이름의 길이가 1보다 작은 경우 예외 발생
    - 위의 조건 중 하나라도 만족하면 `IllegalArgumentException` 발생
