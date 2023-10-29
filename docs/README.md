## 흐름에 따른 미션 이해

1. 경주 자동차 이름 입력
   1. 유효성 검사 -> 조건 불만족 시 예외 발생
      1. 비어있지 않은지
      2. 로 구분한 문자열들의 길이가 5자 이하인지
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

### RacingGameController
게임의 절차를 관리하는 클래스

- [x] 게임을 실행
- [x] 자동차 이름 입력받아 유효성 검사 후 저장
- [x] 시도 횟수 입력받아 유효성 검사 후 저장
- [x] 회차마다 경주 실행 & 결과 출력
- [x] 최종 우승자 출력

### RacingGame
자동차 경주 게임과 관련된 기능을 관리하는 클래스

- [x] 해당 회차의 자동차 경주 실행 
- [x] 해당 회차의 결과 반환
- [x] 최종 우승자 반환
  
### Car
자동차의 정보 저장 및 전진하는 클래스

- [x] 전진 조건을 만족하면 전진

### CurrentResultMap
회차마다 출력될 실행 결과를 생성하는 클래스

- [x] 실행 결과 생성 및 반환

### InputView
사용자로부터 입력받는 클래스

- member function
  - [x] String inputRacingCarsName() : 자동차 이름 입력
  - [x] String inputCount() : 시도 횟수 입력

### OutputView
사용자에게 출력하여 보여주는 클래스

- member function
   - [x] void printResult(): 실행 결과 메시지 출력
   - [x] void printMove(Map<String, Integer>) : 해당 회차의 실행 결과 출력
   - [x] void printFinalWinners(List <String>) : 최종 우승자 출력

### InputValidator
사용자에게 입력받은 경주 자동차 이름과 시도 횟수의 유효성을 검사하는 클래스

- member function
    - [x] : void validateRacingCarsName(String) : 입력받은 경주 자동차 이름의 유효성을 검사
    - [x] : void validateCount(String) : 입력받은 시도 횟수의 유효성을 검사

