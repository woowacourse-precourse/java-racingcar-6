# 자동차 레이싱 게임
## 기능 목록
[readyRace]
1-(1). 사용자(User)에게 경주에 참가할 자동차 이름을 받는다. - 
   1. 각 자동차의 이름은 쉼표 기준으로 구분한다.  - `RaceService.splitCarNames`
   2. 각 자동차의 이름은 5자를 넘어서는 안 된다. - `RaceService.isLimitFiveChar`
   3. 안내문구(**"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"**) 다음 줄에 자동차 이름을 입력받는다. - `UserInputMessage.askParticipants`

1-(2). 경주차가 이동할 횟수를 입력받는다. - `RaceService.askTryCount`
   1. 입력받을 때 안내문구는 **"시도할 회수는 몇회인가요?"** 이다. - `UserInputMessage.askExecuteNumber()`
   2. 입력받은 시도 횟수는 숫자형이어야 한다. - `RaceService.isInt`

[startRace]
2. 각 참가 자동차마다 0 ~ 9사이의 무작위 값을 구한다. -`rollRandomNumbers`
3. 이 무작위 값이 4보다 크거나 같으면 전진, 4보다 작으면 제자리에 있는다. - `isCarAdvance`
4. 전직 or 제자리 결과에 따라 레이싱기록을 업데이트한다. - `updateRaceLog`
5. 무작위 수를 각 자동차가 구할때마다 **"실행결과"** 를 각 자동차의 이름 앞에 **"-"** 로 표현하여 반환한다.-`showRaceLog`

[prizeWinner]
6. 입력받은 이동 횟수가 모두 끝났을 때 가장 많이 전진한 자도차가 우승하게 된다.
   1. 최종우승자는 공동 우승자가 가능하며 쉼표로 구분하여 출력해야한다.
   2. 반환 문구는 **"최종 우승자 : "** 의 형태이다.

