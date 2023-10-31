# 2주차 과제 기능 정리

## RacingGame
게임 전체를 관리하는 클래스입니다. Application.main()이 실행되면 RacingGame 객체가 생성되어 게임을 진행합니다.

### initScoreBoard()
처음 게임 시작 후 선수들의 이름 리스트를 받습니다. 초기에 한 줄의 문자열을 받으면 그것을 쉼표 단위로 분할하고, checkName을 통해 각 이름의 오류를 검사합니다.
오류를 검사한 후에는 점수판 HashMap에 각 이름과 점수를 초기화합니다.

### checkName()
입력받은 이름 문자열의 오류를 검사합니다. 각 이름이 5자 제한을 넘는지, 입력값이 존재하지 않는 지 검사하여 오류 발생 시 예외를 생성해 반환합니다.

### raceProgress()
tryCount 인자를 통해 countForward 연산을 반복 진행합니다.

### countForward()
점수판 HashMap을 하나씩 탐색하며 전진 여부에 따라 점수를 추가하거나 그대로 통과합니다.
점수는 0에서 9 사이 정수를 받아 진행하고, 받은 값이 4를 넘으면 1을 추가합니다.

### chooseWinner()
점수판을 탐색하여 각 선수들의 점수 중 최대값을 찾습니다.
이후 갱신된 최대값으로 다시 점수판을 탐색해 승자들의 이름을 고르고, 이를 쉼표 단위로 출력합니다.

### run()
initScoreboard() 호출 후, tryCount를 입력받습니다. 입력에서 오류가 발생할 경우 예외를 호출해 프로그램을 종료합니다.
이후 raceProgress를 호출하여 레이싱을 진행하고, chooseWinner()로 승자를 출력하고 게임을 끝냅니다.

## Applicaion.main
RacingGame 객체를 생성하고 게임을 진행합니다.