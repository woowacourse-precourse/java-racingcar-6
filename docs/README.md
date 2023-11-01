# 개요

---
## main
#### [Application]
  - RacingGame을 실행한다.
#### [view]
  - OutputView
    - 각 라운드 마다 결과를 출력한다.
      - carName + forwardCriterion + raceLength
    - 마지막 우승자 car리스트를 받아서 출력한다.
  - InputUser
    - 문제에 맞는 문구 출력과 사용자 입력을 받는다.
      - carNameString
      - inputroundLength(String)
    - 잘못된 사용자 입력을 확인해서 예외처리를 한다.
#### [controller]
  - RacingGame
    - roundLength와 carName들을 받아온다.
    - 라운드 횟수만큼 라운드를 진행한다.
    - 우승자를 선정한다.
  - Round
    - 각 carName마다 전진을 결정(desicionMove)한다.
    - OutputView를 실행한다.
    - decisionMove
      - 조건(isMoveForward)에 따라 각 carName마다 raceLength에 oneStep을 누적한다.
    - isMoveForward
      - randomNumber에 따라 forwardCriterion과 비교하여 전진을 결정한 후
      - boolean으로 반환한다.
  - InputException
    - 사용자 입력이 잘못되었을 경우 예외 호출한다.
      - CarName 입력시
        - car이름이 중복될 경우
        - 입력 형식이 맞지 않을 경우
        - 이름이 5자 초과일 경우
      - RoundLength 입력시
        - 숫자가 아닐 경우
        - 0이하일 경우
#### [model]
  - Car
    - carNameArray
    - carIdArray
    - winner
    - raceLength
    - oneStep
  - GameState
    - forwardCriterion
    - roundLength
  - GameViewMessage (enum)
    - writeCarNameMessage
    - writeRaceLengthMessage
    - outputFirstLineMessage
    - outputWinnerMessage
    - colonString
  - ExceptionString (enum)
    - inputZeroRoundErrorMessage
    - inputMinusRoundErrorMessage
    - inputStringRoundErrorMessage
    - carNameTooLongErrorMessage
    - duplicateCarNameErrorMessage