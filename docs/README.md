# 기능 요구 사항 정리
## 1. 경주할 자동차 이름 입력
- [ ] RacingGameController 작성
  - [ ] InputView 작성
    - [ ] readCarNames 메소드 작성
      - [ ] 입력값 받기
      - [ ] 입력값 변환
        - [ ] 문자열 split (",")
        - [ ] 각 문자열 trim
- [ ] InputView RacingGameController에 인스턴스 변수로 포함
- [ ] InputView RacingGameController에 인스턴스 변수로 포함
## 2. 자동차 객체 생성과 입력 데이터 검증
- [ ] carNames에 따라 Car 객체 생성
  - [ ] carName의 길이 1 이상
  - [ ] carName의 길이 5 이하
- [ ] `List<Car>` 를 담고 있는 일급컬렉션 Cars 객체 생성
  - [ ] 차량 이름 중복 검증
  - [ ] Car 대수 검증 (1대 이상)
## 3. 이동 시도 횟수 입력
- [ ] InputView 작성
- [ ] readTryCount 메소드 작성
  - [ ] 입력값 받기
## 4. RacingGame 객체 생성과 검증
- [ ] RacingGame 객체 생성
  - [ ] 입력값 검증
    - [ ] 최소 시도 횟수 1
    - [ ] 최대 시도 횟수 5
## 5. 단일 움직임 작성
- [ ] Car 움직임 메소드
  - [ ] isMovable 메소드 작성
    - [ ] Randoms.pickNumberInRange(0,9);
  - [ ] 이동 여부에 따라 스스로의 distance 갱신
  - [ ] toString() 은 현재 이동 상황에 따른 값 리턴
    - `"$name : $distanceString"`
- [ ] Cars의 움직임 메소드
  - [ ] 각 Car의 움직임 메소드 호출
## 5. 전체 움직임 작성
- [ ] RacingGame
  - [ ] 단일 움직임 메소드
  - [ ] 현재 상태에 대한 문자열을 리턴할 수 있는 메소드 작성
    - [ ] 이건 OutputView가 인자로 받아서 문자열을 생성해도 좋을 듯
    - [ ] GameController가 문자열 저장 혹은 즉시 출력?
## 6. 게임 결과 출력
- [ ] 최종 우승자 출력
  - [ ] 일급컬렉션에서 우승자를 가져오는 로직 추가
  - [ ] Outputview에서 출력

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