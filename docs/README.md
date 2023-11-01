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
- [x] InputErrorException (유효한 값이 아닐 시 IllegalArgumentException 발생 후 종료)
    - [x] CarNameInputErrorException
      - [x] 각 이름의 길이가 5자 초과 확인
      - [x] 같은 이름을 가진 자동차가 있는 지 확인
      - [x] 이름이 1자 미만일 경우
      - [x] 빈 배열이 들어올 경우
    
    - [x] TryCountInputErrorException
      - [x] 숫자 이외의 값이 들어오는지 검사
      - [x] 빈 값이 들어올 경우

### UTIL
- [x] MessageUtil (enum)
  - [x] 필요한 메시지 나열
  - [x] 메시지 print 메소드
  - [x] 메시지 println 메소드

- [x] RandomNumberGenerator
  - [x] 자동차의 전진 조건인 랜덤 숫자 (0~9) 만들어주는 기능

- [x] TransferUtil
  - [x] String -> List<String>으로 변환 기능
  - [x] CarStatusDto를 각 출력 값에 맞게 변환

### MODEL
- [x] Car
  - [x] 이름과 현재 위치 담을 생성자
  - [x] 랜덤한 수를 받아 전진할지 , 가만있을지 구분
  - [x] 위치 하나 전진하는 메소드
  - [x] 이름과 position의 Getter

- [x] Cars
  - [x] 게임 진행 시 생선된 자동차 목록을 담을 List<Car>, RandomNumberGenerator 생성자
  - [x] 우승 포지션 찾아서 반환
  - [x] 각 자동차 움직이기
  - [x] 각 자동차의 현재 상태 Dto로 전달

- [x] GameResult
  - [x] 우승 객체를 담을 List<Car>, 가정 전진해 있는 winPosition 생성자
  - [x] winPosition에 있는 Car를 winnerCarList에 추가하는 메소드
  - [x] 우승 차들 이름 Dto로 전달

### VIEW
- [x] InputView (ErrorException으로 입력 값 검증)
  - [x] 자동차 이름 입력 받기 (Console.readLine() 사용)
  - [x] 시도 횟수 입력 받기 (Console.readLine() 사용)

- [x] OutputView
  - [x] 자동차 이름 입력 문구 출력
  - [x] 시도 횟수 입력 문구 출력
  - [x] 실행 결과 출력
  - [x] 최종 우승자 출력
  - [x] 개행 메소드

### CONTROLLER
- [x] GameController
  - [x] 게임 시작
    - [x] 자동차 이름 입력 받기
    - [x] 검사 후 Car 객체 만들기
    - [x] 시도 회수 입력 받기
    - [x] 시도 회수 유효성 검사
    - [x] 시도 횟수 만큼 게임 진행 반복
    - [x] 게임 종료 메소드 실행

  - [x] 게임 진행 (시도 회수 만큼 반복) 
    - [x] 각 시도 회수 만큼 자동차 전진
    - [x] OutputView로 자동차의 이름과 현재 위치 출력

  - [x] 게임 종료
    - [x] GameResult 객체 생성
    - [x] GameResult 안에서 각 Car의 위치를 계산해 객체에 우승 자동차 담기
    - [x] 우승 자동차 이름 출력

## 리팩토링

### 상수
- [x] 상수 따로 관리
  - [x] 에러 메시지 상수
  - [x] 자동차에 필요한 상수
