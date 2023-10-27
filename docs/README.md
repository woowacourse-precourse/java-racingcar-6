# 자동차 경주

## 기능 목록

- [x] 자동차들의 이름을 입력받아 쉼표를 기준으로 구분한다. - Player#makeCarList()
    - [x] 이름은 5자 이하만 가능하다. - Player#validateInput()
- [x] 시도할 횟수를 입력받는다. - Player#inputAttemptsCount()
- [x] 0에서 9사이에서 무작위 값을 구한 후 4이상일 경우 전진한다. - Leaderboard#race()
- [x] 각 시도마다 실행 과정을 출력한다. - Leaderboard#printRaceProgress()
- [x] 완료한 후 우승자를 출력한다. - Leaderboard#printResult()
- [x] 잘못된 값을 입력할 경우 예외 발생 후 애플리케이션은 종료된다. - Player#validateInput()

## 기능 요구 사항