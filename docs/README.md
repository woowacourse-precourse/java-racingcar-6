# 기능 목록

## 핵심 기능

- [x] 자동차를 생성한다.
- [x] 게임을 시작한다.
- [x] 자동차를 이동한다.
- [x] 우승자를 결정한다.

## 객체 도출

핵심 기능으로부터 객체를 도출한다.

- 자동차를 생성한다.
    - CarFactory
- 게임을 시작한다.
    - Game
- 자동차를 이동한다.
    - Car
- 우승자를 결정한다.
    - Judge - Game

## 추가 기능 도출

핵심 기능은 아니지만 필요한 기능을 도출한다.

- [x] 자동차 이름을 입력받는다.
- [x] 자동차 이름을 쉼표(,)로 구분한다.
- [x] 자동차 이름을 검증한다.
- [x] 자동차 이름 사이에 공백이 있는 경우 공백을 제거한다.
- [x] 자동차의 초기 위치는 0이다.
- [x] 시도 횟수를 선택한다.
- [x] 전진를 판단한다.
- [x] 이전 결과와 전진 유무를 통해 이번 결과를 결정한다.
- [x] 차수별 결과 내역을 출력한다.
- [x] 최종 우승자를 (,) 로 구분하여 출력한다.

## 추가 객체 도출

추가 기능으로부터 객체를 도출한다.

- 자동차 이름을 입력받는다.
- 자동차 이름을 쉼표(,)로 구분한다.
    - Viewer
- 자동차 이름을 검증한다.
    - Viewer
- 시도 횟수를 선택한다.
    - Viewer
- 무작위 값을 생성한다.
    - RandomNumberGenerator
- 전진를 판단한다.
    - Game
- 전진 후 차들의 위치 내역을 생성한다.
    - History
- 차수별 내역을 출력한다.
    - Announcer
- 최종 우승자를 (,) 로 구분하여 출력한다.
    - Announcer

## 객체 분석

- Game
    - init()
    - play()
    - race()
    - end()
- Car
    - name
    - position
    - moveForward()
- History
    - makeHistory()
- CarFactory
    - generate()
    - validateCarNameLength()
    - validateCarDuplication()
- Viewer
    - inputCarNames()
    - inputTryCount()
    - validateCarNames()
- Announcer
    - announceToInputCarNames()
    - announceToInputTryCount()
    - announceRaceHistories()
    - announceRaceHistory()
    - announceWinner()

# 예외

- 자동차 이름 입력 시 쉼표(,)로 구분되어 들어오지 않을 경우
- 자동차 이름 자체에 공백이 있는 경우
- 자동차 이름이 5자를 초과하거나 null인 경우
- 자동차 이름이 중복인 경우
- 시도할 회수가 숫자가 아닌 경우
- 시도할 회수가 0이거나 0보다 작은 경우