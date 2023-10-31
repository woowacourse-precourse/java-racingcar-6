# 레이싱 카 게임

## Car 클래스
- 게임 내의 자동차를 나타냄

- 속성
  - name : 자동차 이름
  - position : 자동차 현재 위치
  
- 메서드
  - move() : 무작위로 자동차를 움직이며, 무작위 값이 4 이상인 경우만 이동
  - getPositionString() : 자동차 위치를 나타내는 하이픈(-) 문자열을 반환
  - printPosition() : 자동차의 이름과 위치 문자열을 출력
  - isMovable(int randomValue) : 무작위 값에 기반하여 자동차가 이동 가능한지 여부를 결정

## RacingGame 클래스
- 게임의 핵심 기능을 관리

- 속성
  - cars : 게임 내의 자동차를 나타내는 Car 객체의 목록
  - tryCount : 시뮬레이션할 라운드 수
  
- 메서드
  - runGame() : 지정된 라운드 수를 시뮬레이션하고 승자를 발표하여 게임을 실행
  - initializeCars(String[] carNames) : 사용자가 제공한 이름으로 자동차를 초기화
  - raceOneRound() : 모든 자동차의 한 라운드를 시뮬레이션
  - printRoundResult() : 한 라운드 이후 모든 자동차의 위치를 출력
  - announceWinners() : 게임의 승자를 결정하고 발표
  - findMaxPosition() : 모든 자동차 중에서 최대 위치를 찾아낸다.
  - findWinners(int maxPosition) : 최대 위치를 가진 자동차들을 찾음
  - getCars() : 자동차 목록에 액세스하기 위한 getter 메서드

## InputView 클래스
- 자동차 이름과 라운드 수에 대한 사용자 입력을 처리

- 메서드
  - getCarNames() : 사용자에게 자동차 이름을 요청하고, 유효성을 검사한 후 쉼표로 구분된 문자열로 반환
  - isValidCarNames(String carNamesInput) : 자동차 이름의 길이와 비어 있지 않음을 유효성 검사
  - getTryCount() : 사용자에게 라운드 수를 요청하고 정수로 반환

## Application 클래스
- 게임을 실행하기 위한 main 메서드를 포함하며, InputView에서 자동차 이름 및 라운드 수를 입력받고, 게임을 실행하기 위해 RacingGame을 초기화합니다.
