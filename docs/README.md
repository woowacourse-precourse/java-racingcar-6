# 기능 목록
## 핵심 기능
- [ ] 자동차를 생성한다.
- [ ] 게임을 시작한다.
- [ ] 자동차를 이동한다.
- [ ] 우승자를 결정한다.

## 객체 도출
핵심 기능으로부터 객체를 도출한다.
- 자동차를 생성한다.
  - CarGenerator
- 게임을 시작한다.
  - Game
- 자동차를 이동한다.
  - Car
- 우승자를 결정한다.
  - Judge - Game

## 추가 기능 도출
핵심 기능은 아니지만 필요한 기능을 도출한다.
- [ ] 자동차 이름을 입력받는다.
- [ ] 자동차 이름을 쉼표(,)로 구분한다.
- [ ] 자동차 이름을 검증한다.
- [ ] 시도 횟수를 선택한다.
- [ ] 전진를 판단한다.
- [ ] 이전 결과와 전진 유무를 통해 이번 결과를 결정한다.
- [ ] 차수별 결과를 출력한다.
- [ ] 최종 우승자를 (,) 로 구분하여 출력한다.

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
- 전진 후 차들의 위치를 출력한다.
  - Car.position
- 차수별 결과를 출력한다.
  - Announcer
- 최종 우승자를 (,) 로 구분하여 출력한다.
  - Announcer

## 객체 분석

- Game
  - init()
  - playRound()
  - judgeWinner()
- Car
  - name
  - position
  - move()
- CarGenerator
  - generate()
- Viewer
  - inputCarNames()
  - inputTryCount()
  - validateCarNames()
- Announcer
  - announceRoundResult()
  - announceWinner()


# 예외
- 자동차 이름 입력 시 쉼표(,)로 구분되어 들어오지 않을 경우
- 자동차 이름이 5자를 초과할 경우
- 시도할 회수가 숫자가 아닌 경우
- 시도할 회수가 0이거나 0보다 작은 경우