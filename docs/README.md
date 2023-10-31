# 미션 - 자동차 경주

# 구현 기능 목록 [x]

# 테스트 코드가 존재하는 기능에 대한 테스트 동작 확인 여부 [complete]

- [x]사용자가 입력한 총 게임 회수와 자동차 이름을 배열로 반환한다. - Player#createPlayerCarList, Player#setLapsOfRace
- 입력 값이 올바른지 검사한다.
  - [x][complete] 입력한 자동차 이름이 5자 이하인지 검사한다. - Validators#isListElementOverFive
  - [x][complete] 입력한 게임 회수가 정수로 변환 가능한지 검사한다. - Validators#isInteger
- 1턴동안 자동차가 1칸 전진 또는 멈추고, 이를 주어진 횟수 동안 반복한다. Game#startRace
  - [x][complete] 0~9 사이의 임의의 숫자 1개를 생성한다. - NumberGenerator#createRandomNumber
  - [x] 전진 조건을 충족했는지 검사한다. - Judgement#moveForward
  - [x] 플레이어별로 전진 가능한지 비교한다. - Judgement#playerMoveForward
  - [x][complete] 1턴 게임 결과를 출력한다. - Game#printTotalLapResult, playerLapResult
- 최종 우승자를 출력한다.
    - [x][complete] 마지막 게임 결과를 가지고 플레이어 간 비교를 통해 가장 많이 이동한 사람을 알 수 있다. - Referee#compares
    - [x][complete] 최종 우승자를 출력한다. - Referee#printWinners