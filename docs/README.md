# 기능 요구 사항 정리
## 1. 경주할 자동차 이름 입력
- [x] RacingGameController 작성
  - [x] InputView 작성
    - [x] readCarNames 메소드 작성
      - [x] 입력값 받기
      - [x] 입력값 변환
        - [x] 문자열 split (",")
        - [x] 각 문자열 trim
- [x] InputView RacingGameController에 인스턴스 변수로 포함
## 2. 자동차 객체 생성과 입력 데이터 검증
- [x] carNames에 따라 Car 객체 생성
  - [x] carName의 길이 1 이상
  - [x] carName의 길이 5 이하
- [x] `List<Car>` 를 담고 있는 일급컬렉션 Cars 객체 생성
  - [x] 차량 이름 중복 검증
  - [x] Car 대수 검증 (1대 이상)
## 3. 이동 시도 횟수 입력
- [x] InputView
  - [x] readAttemptCount 메소드 작성
    - [x] 입력값 받기
      - [x] 입력값 숫자 검증
## 4. RacingGame 객체 생성과 검증
- [x] RacingGame 객체 생성
  - [x] 입력값 검증
    - [x] 최소 시도 횟수 1
## 5. 단일 움직임 작성
- [x] Car 움직임 메소드
  - [x] isMovable 메소드 작성
    - [x] Randoms.pickNumberInRange(0,9);
  - [x] 이동 여부에 따라 스스로의 distance 갱신 (moveForward, attemptToMove)
    - `"$name : $distanceString"`
- [x] Cars의 움직임 메소드
  - [x] 각 Car의 움직임 메소드 호출
## 5. 전체 움직임 작성
- [x] RacingGame
  - [x] 단일 움직임 메소드
  - [x] 현재 상태에 대한 정보를 가지고 있는 클래스 RacingGameState 작성
- [x] 게임 진행 로직 RacingGameController에 추가
## 6. 게임 결과 출력
- [x] 단계별 이동 상황 출력
- [ ] 최종 우승자 출력

---  
# MVC 적용 사항 정리
- view
  - InputView.java
    - readCarNames
      - split -> 문자열 , 기준으로 쪼개기
      - validate
    - readTryCount
      - validate
  - OutputView.java
    - printCarState -> 각 단계의 차량 출력
    - printWinners
- controller
  - RacingGameController.java
    - InputView 포함
    - OutputView 포함
    - RacingGame 포함
- domain
  - Car.java
  - Cars.java
  - RacingGame.java