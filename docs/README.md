## 흐름에 따른 미션 이해

1. 경주 자동차 이름 입력
   1. 유효성 검사 -> 조건 불만족 시 예외 발생
      1. 비어있지 않은지
      2. ,로 구분한 문자열이 1개 이상인지
      3. ,로 구분한 문자열들의 길이가 5자 이하인지
   2. 경주할 자동차 등록
2. 시도 횟수 입력
   1. 유효성 검사 -> 조건 불만족 시 예외 발생
      1. 비어있지 않은지
      2. 입력 값이 숫자인지
      3. 1이상 값인지
   2. 시도 횟수 등록
3. 실행 결과 출력
   1. 각 차수별 실행 결과 출력
      1. 각 자동차의 무작위 값 생성
      2. 전진 조건(무작위 값이 4이상이면 전진) 확인
      3. 전진 조건 성립한다면 자동차의 움직인 거리 1증가
      4. 해당 자동차의 움직인 거리 출력
4. 최종 우승자 출력
   1. 경주에 참가한 자동차들의 움직인 거리 비교
   2. 움직인 거리가 가장 긴 자동차의 이름 출력

## class별 기능 구현 목록

### CarRacing
자동차 경주 게임을 진행하는 클래스

- member instance
  - RacingCars racingCars : 자동차 경주에 참가한 자동차 리스트를 저장해 놓은 클래스
  - int count : 시도 횟수
- member function   
  - [ ] CarRacing(RacingCars, int) : racingCars, count 초기화
  - [ ] void race() : 자동차 경주 시도한 횟수만큼 진행
  - [ ] void showMove(Car) : 차가 이동한 거리 출력
  - [ ] void showFinalWinners() : 최종 우승자 출력

### InputValidator
사용자에게 입력받은 경주 자동차 이름과 시도 횟수의 유효성을 검사하는 클래스

- member function
  - [ ] : void validateRacingCarsName(String) : 입력받은 경주 자동차 이름의 유효성을 검사
  - [ ] : void validateCount(String) : 입력받은 시도 횟수의 유효성을 검사

### RacingCars
자동차 경주에 참가한 자동차 리스트를 저장해 놓은 클래스

- member instance
   - List<RacingCar> racingCars : 자동차 리스트
- member function
   - [x] RacingCars(RacingCarsListMaker) : racingCars 초기화
   - [x] List <String> getWinners() : 최종 우승자의 리스트를 반환

### RacingCarsListMaker
입력받은 자동차 이름을 자동차 리스트로 변환하여 저장해 놓은 클래스

- member instance
  - List<RacingCar> racingCarsList : 자동차 경주에 참가한 자동차 리스트
- member function
  - [x] void setRacingCarsList(String) : 입력받은 경주 자동차의 이름을 이용하여 자동차 리스트 초기화
  - [x] void getRacingCarsList() : 자동차 리스트를 반환하는 함수

### RacingCar
자동차의 이름과 이동 거리를 저장해 놓는 클래스

- member instance
   - String name : 자동차 이름
   - int moveDistance : 이동 거리
- member function
   - [x] Car(String) : name, moveDistance 초기화
   - [ ] String getName() : 자동차 이름 반환
   - [ ] int getMoveDistance() : 이동 거리 반환
   - [x] void move() : 전진 조건을 만족하면 전진

### InputView
사용자로부터 입력받는 클래스

- member function
  - [x] String inputRacingCarsName() : 자동차 이름 입력
  - [x] String inputCount() : 시도 횟수 입력

### OutputView
사용자에게 출력하여 보여주는 클래스

- member function
   - [x] void printResult(): 실행 결과 메시지 출력
   - [x] void printMove(String, int) : 자동차의 이동 결과 출력
   - [x] void printFinalWinners(List <String>) : 최종 우승자 출력

