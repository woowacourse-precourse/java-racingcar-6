# 기능 명세서

### RacingGameController : 사용자 입력과 자동차 모델 처리
- RacingGameModel, RacingGameView 의존
**레이싱 게임 시작(startRacingGame)**
- 자동차 이름과 시도 횟수 입력받는 기능 -> inputCarNamesAndAttempts
- 시도 횟수만큼 게임 진행하는 기능 -> playRacingGame
- 우승자 출력해주는 기능 -> printWinnders

### RacingGameModel : 게임 로직과 데이터 처리
- 입력받은 자동차 이름 저장하는 기능 -> setCarNames
- 입력받은 자동차 이름 조건 검증하는 기능 -> validateCarName
- 자동차 움직이는 기능 -> moveCars
- 시도 횟수 getter, setter -> getAttempts(),setAttempts
- 라운드 종료했을때 자동차 위치에 따른 우승자 결정해주는 기능 -> getWinners

### RacingGameView : 사용자 인터페이스 출력
- 사용자 입력 처리
  - 사용자의 자동차 입력처리 기능 -> readCarNamesFromConsole
  - 시도 횟수 입력 및 Int 변환 -> convertAttemptsToIntFromConsoleStringInput
- 각 차수별 실행 결과 보여주는 기능 -> printRoundResults
- 우승자 보여주는 기능 -> printWinners
  - 단독 우승자 -> printSingleWinner
  - 공동 우승자 -> printMultipleWinners

## 객체
### Car
[변수]
- 이름
- 현재 위치

[기능]
- 이동(전진)하는 기능
- 현재 이름 반환(getter)
- 현재 위치 반환(getter)
- 현재 위치 표현 -> getPositionString

### 테스트 코드
- 전진 정지
- 이름에 대한 예외 처리
- 무작위 값이 나올 때, 4이상은 전진, 4미만은 정지하는 과정 테스트
- 단독 우승자 출력 테스트
- 공동 우승자 출력 테스트