# 🚀 레이싱 게임

## 기능 요구 사항 분석

### 게임 시작 시 사용자 입출력
- 게임 시작 시 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"를 출력
- 사용자의 자동차 이름 입력 - 제한: 쉼표(,)로 구분, 이름은 5글자 이하
- 사용자로부터 이동을 시도할 횟수를 입력받기
- 잘못된 사용자 값 입력시 IllegalArgumentException

### 자동차 이동
- 0~9 사이 무작위 값 생성
- 생성 값 4이상이면 이동 (-)
- 실행결과(이동 현황) 출력

### 우승자 출력
- 누가 우승했는지 출력 - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

## 클래스 기능 명세

### 📝 Car.class
- name: 자동차 이름
- position: 자동차 현재 위치
- carMove(): 랜덤 생성 값에 따라, 4 이상이면 position 이동

### 📝 Referee.class
- playRound() : 한 판 진행
- determineWineer() : 최종 우승자 결정 로직

### 📝 RacingGame.class
- prepareGame() : f레이싱 게임 설정, Car 및 Referee 객체 초기화
- startGame() : 레이싱 게임 진행
- printRoundResults() : 회차별 결과 출력
- printGameWinner() : racingWinner() : 최종 우승자 반환 및 출력

### 📝 InputValidator.class
- validateInput(): 사용자 입력 값이 유효한지 검사
- validateCarName(): 자동차 이름이 유효한지 검사
- validateRounds(): 시도 횟수 입력이 유효한지 검사
