## 흐름에 따른 미션 이해

1. 경주 자동차 이름 입력
   1. 유효성 검사
      1. 비어있지 않은지
      2. ,로 구분한 문자열이 1개 이상인지
      3. ,로 구분한 문자열의 길이가 5이하인지
      4. 위의 조건들을 불만족할 시 IllegalArgumentException 발생
2. 시도 횟수 입력
   1. 비어있지 않은지
   2. 입력 값이 숫자인지
   3. 1이상 값인지
   4. 위의 조건들을 불만족할 시 IllegalArgumentException 발생
3. 시도 횟수만큼 실행 결과 출력
4. 최종 우승자 출력

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
자동차 경주에 참가한 자동차 리스트를 저장해 놓는 클래스

- member instance
   - List <Car> racingCars : 자동차 경주에 참가한 자동차 리스트를 저장해 놓은 클래스
- member function
   - [ ] RacingCars(String) : racingCars 초기화
   - [ ] List <String> getWinners() : 최종 우승자의 리스트를 반환

### Car
자동차의 이름과 이동 거리를 저장해 놓는 클래스

- member instance
   - String name : 자동차 이름
   - int moveDistance : 이동 거리
- member function
   - [ ] Car(String) : name, moveDistance 초기화
   - [ ] String getName() : 자동차 이름 반환
   - [ ] int getMoveDistance() : 이동 거리 반환
   - [ ] void move() : 전진 조건을 만족하면 전진

### InputView
사용자로부터 입력받는 클래스

- member function
  - [ ] String inputRacingCarsName() : 자동차 이름 입력
  - [ ] String inputCount() : 시도 횟수 입력

### OutputView
사용자에게 출력하여 보여주는 클래스

- member function
   - [ ] void printResult(String, int) : 해당하는 차의 결과 출력
   - [ ] void printFinalWinners(List <String>) : 최종 우승자 출력

