# 이 주차 미션 - 자동차 경구

## 프로그램 흐름

### Player : car

1. 게임 시작
    - 경주 할 자동차들 (,를 기준으로 구분하여) 입력받음
    - 시도 회수 입력 받음

2. 게임 진행
    - 시도 횟수 만큼 반복
      - 각 자동차에서 랜덤 수를 발급 받아 4이상 나올 시 전진

3. 게임 종료
    - 가장 앞에 있는 자동차의 이름을 출력 (여러 대 가능)

## 구현 요구 사항 정리

### EXCEPTION
- [ ] InputErrorException (유효한 값이 아닐 시 IllegalArgumentException 발생 후 종료)
    - [ ] CarNameInputErrorException
      - [x] 각 이름의 길이가 5자 초과 확인
      - [ ] 같은 이름을 가진 자동차가 있는 지 확인
      - [x] 이름이 1자 미만일 경우
      - [ ] 빈 배열이 들어올 경우
    
    - [ ] TryCountInputErrorException
      - [ ] 숫자 이외의 값이 들어오는지 검사
      - [ ] 아무 값도 입력 안할 경우 (1자 미만)
      - [ ] 빈 배열이 들어올 경우

### UTIL
- [ ] MessageUtil (enum)
  - [ ] 필요한 메시지 나열
  - [ ] 메시지 print 메소드
  - [ ] 메시지 println 메소드

- [ ] RandomNumberGenerator
  - [ ] 자동차의 전진 조건인 랜덤 숫자 (0~9) 만들어주는 기능

### MODEL
- [ ] Car
  - [ ] 이름과 현재 위치 담을 생성자
  - [ ] 랜덤한 수를 받아 전진할지 , 가만있을지 구분
  - [ ] 위치 하나 전진하는 메소드
  - [ ] 이름과 현재 위치를 출력할 메소드
  - [ ] 이름만 출력

- [ ] GameResult
  - [ ] 우승 객체를 담을 List<Car> 생성자 
  - [ ] 가장 전진해있는 Car 객체 찾는 메소드

### VIEW
- [ ] InputView (ErrorException으로 입력 값 검증)
  - [ ] 자동차 이름 입력 받기 (Console.readLine() 사용)
  - [ ] 시도 횟수 입력 받기 (Console.readLine() 사용)

- [ ] OutputView
  - [ ] 자동차 이름 입력 문구 출력
  - [ ] 시도 횟수 입력 문구 출력
  - [ ] 실행 결과 출력
  - [ ] 최종 우승자 출력

### CONTROLLER
- [ ] GameController
  - [ ] 게임 시작
    - [ ] 자동차 이름 입력 받기
    - [ ] 입력 받은 값 유효성 검사
    - [ ] 검사 후 Car 객체 만들기

  - [ ] 게임 진행
    - [ ] 시도 회수 입력 받기
    - [ ] 시도 회수 유효성 검사
    - [ ] RandomGenerator를 사용해 각 시도 회수 만큼 자동차 전진
  
  - [ ] 게임 종료
    - [ ] GameResult 객체 생성
    - [ ] GameResult 안에서 각 Car의 위치를 계산해 객체에 우승 자동차 담기
    - [ ] 우승 자동차 이름 출력
