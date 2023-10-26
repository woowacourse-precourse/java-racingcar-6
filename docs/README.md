# 기능 목록
- [x] Car
  - 자동차 클래스
  - name : 자동차 이름
  - position : 자동차 위치

- [x] RacingGame
  - 게임 진행 클래스
  - cars : 자동차 리스트
  - maxRound : 게임 진행 횟수
  - startGame() : 게임 시작 및 정보 입력
  - runGame() : 게임 진행
  - round() : 각 라운드마다 차량 위치 변경
  - randomGoOrStop() : 랜덤으로 전진 또는 멈춤 결정
  - setMaxRound() : 게임 진행 횟수 입력

- [x] Validator
  - 입력값 검증 클래스
  - carNamesInputValidator() : 자동차 이름 입력값 검증
  - isProperLength() : 자동차 이름 길이 검증
  - roundsInputValidator() : 게임 진행 횟수 입력값 검증

- [x] UI
  - 게임 입출력 클래스
  - inputCarNames() : 자동차 이름 입력
  - inputRounds() : 게임 진행 횟수 입력
  - showResult() : 라운드별 게임 결과 출력
  - showFinalResult() : 최종 우승자 출력