# 기능 요구 사항 정리

## 1. 경주할 자동차 이름 입력
- [ ] RacingGameController 작성
  - [ ] InputView 작성
  - [ ] InputView RacingGameController에 주입
    - readCarNames 메소드 작성
      - [ ] 5자 이하
      - [ ] 차량은 여러대 입력 가능
        - [ ] 이름은 쉼표 기준으로 구분 -> ex) pobi,woni,jun
      - [ ] 입력값 변환
        - [ ] 문자열 split
        - [ ] 각 문자열 trim
        - [ ] 입력값 변환 실패시 `IllegalArgumentException` 발생 후 종료 

## 2. 이동 시도 횟수 입력
- [ ] InputView 작성
- [ ] 시도할 횟수 입력
  - [ ] 최대 시도 횟수 5 -> 시도 횟수란 움직임 횟수
    - [ ] 입력값 변환 실패시 `IllegalArgumentException` 발생 후 종료
    - [ ] 입력 범위 추가시 `IllegalArgumentException` 발생 후 종료

## 3. 자동차 객체와 이를 담을 일급컬렉션 작성
- [ ] 일급컬렉션 Cars 작성
  - [ ] String[] 입력으로 초기화
    - [ ] 내부에서 Car 객체 생성해서 리스트 할당
      - [ ] 입력값 검증
        - [ ] 5자 이상인 이름이 있으면 `IllegalArgumentException` 발생 후 종료


## 4. 단일 움직임 작성
- [ ] Car
  - [ ] 무작위 값 구해서 이동여부 결정
    - [ ] Randoms.pickNumberInRange(0,9);
  - [ ] 이동 여부에 따라 distance 갱신
  - [ ] toString() 은 현재 이동 상황에 따른 값 리턴
    - 형식 - "pobi : --"

## 5. 전체 움직임 작성
- [ ] 일급컬렉션 Cars의 메소드 moveCars 작성
- [ ] 단위 움직임 결과 문자열을 리턴할 수 있는 메소드 작성
- [ ] GameController가 문자열 저장 혹은 즉시 출력

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
    - InputView 사용
    - OutputView 사용
    - Cars 사용
    - play()
- domain
  - Cars -> 일급 컬렉션 -> 경기 진행 상황은 그때그때 라운드별로 GameController에서 관리?
    - List<Car> cars
    - moveCars() -> 각 Car의 단위 움직임을 실행
    - getCarStates() -> 모든 차량의 현재 포지션 리턴? toString()?
  - Car -> 불변객체
    - name
    - distance
    - move()
      - canGo()
      - go()
    - toString() 재정의