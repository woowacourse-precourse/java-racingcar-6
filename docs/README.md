# 자동차 레이싱 게임
## 기능 목록
[readyRace]
1. 레이싱 게임을 위해 사용자에게 **입력값**을 받는다. - `readyRace`
   1. 경주에 참가할 **자동차 이름**을 받는다. - `RacePreparation#askCarNames`
      1. 각 자동차의 이름은 쉼표 기준으로 구분한다.  - `InputValidation#splitNamesByComma`
      2. 각 자동차의 이름은 5자를 넘어서는 안 된다. - `InputValidation#isLimitFiveString`

   2. 경주차가 이동을 **시도할 횟수**를 입력받는다. -`RacePreparation#askExecuteCount`
      1. 입력받은 시도 횟수는 숫자형이어야 한다. - `InputValidation#isInt`

[startRace]
2. 레이스 경기를 시작한다 - `startRace`
   1. 경주를 시작하기 전 **빈 레이스 로그**를 만든다. -`RaceLog#createEmptyRaceLog`
   2. 각 참가 경주차마다 0 ~ 9사이의 **무작위 값을 구한다.** -`RaceStart#createRandomNumbers`
   3. 무작위 값에 따라 각 경주차가 제자리에 있거나 전진하며 레이싱 기록을 **업데이트**한다. - `RaceStart#updateRaceLog`
      1. 각 무작위 값이 4보다 작은지 혹은 4보다 크거나 같은지 확인한다. - `RaceLog#isCarAdvance`
      2. 각 경주차의 무작위 값이 4보다 작으면 제자리, 4보다 크거나 작으면 전진하는 레이싱기록을 남긴다 -`RaceLog#addEachCarsRaceLog`
   4. 무작위 수를 각 자동차가 구할때마다 **"실행결과"** 를 각 자동차의 이름 앞에 **"-"** 로 표현하여 반환한다.-`RaceStart#showRaceLog`

[prizeWinner]
3. 최종우승자는 공동 우승자가 가능하며 쉼표로 구분하여 출력한다. -`prizeWinner`
   1. 각 경주차의 **레이싱 기록의 길이**를 확인한다. - `WinnerCalculator#calculateWinner`
   2. 레이싱 길이의 길이 중 **가장 큰 값**을 가지는 경주차가 우승자가 된다. - `WinnerCalculator#calculatePathLength`

