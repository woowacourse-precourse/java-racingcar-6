# 자동차 경주

## 기능 요구 사항

자동차 경주 게임을 구현한다.

- 사용자는 자동차의 이름과 횟수를 입력한다.
- 각 자동차는 전진 조건에 따라 매 횟수마다 전진하거나 멈춘다.
- 게임을 완료한 후 우승자를 출력한다.
- 우승자는 한 명 이상일 수 있다.
- 잘못된 값을 입력할 시 예외를 발생시킨 후 애플리케이션은 종료된다.

## 기능 목록

- [x] 자동차 게임 객체를 생성한다. - RacingGame()
    - [x] 자동차들의 이름을 입력받아 쉼표를 기준으로 구분한다. - Player#makeCarList()
        - [x] 이름은 5자 이하만 가능하다. - Player#validateInput()
    - [x] 시도할 횟수를 입력받는다. - Player#inputAttemptsCount()
    - [x] 입력받은 자동차의 이름을 각각의 Car 인스턴스로 생성한다. - Leaderboard#makeCarInstanceList
- [x] 게임을 진행시킨다. - RacingGame#run()
    - [x] 0에서 9사이에서 무작위 값을 구한 후 4이상일 경우 전진한다. - Leaderboard#race()
    - [x] 각 시도마다 실행 과정을 출력한다. - Leaderboard#printRaceProgress()
    - [x] 완료한 후 우승자를 출력한다. - Leaderboard#printResult()
- [x] 잘못된 값을 입력할 경우 예외 발생 후 애플리케이션은 종료된다. - Player#validateInput()