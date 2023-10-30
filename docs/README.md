## 게임 진행 과정
1. 자동차 입력
2. 자동차 생성
3. 횟수 입력
4. 게임 진행 
   - 각 횟수 진행 결과 출력
5. 우승자 출력

## 자동차 입력 기능
- [x] RacingView : `printCarListInputMessage` 메서드
  - 입력 안내 메시지 출력
- [x] RacingView : `getCarListInput` 메서드
  - 사용자로부터 자동차 목록을 입력받는다.
- [x] Cars : `validateCarNamesUnique` 메서드
  - 문자열 리스트를 인수로 받아 중복된 이름이 있다면 `IllegalArgumentException` 발생
- [x] CarName : `validateCarName` 메서드
  - 문자열을 인수로 받아 자동차 이름 형식으로 적합한지 검증
    - 빈 문자열이라면 `IllegalArgumentException` 발생
    - 문자열의 길이가 5자리를 초과한다면 `IllegalArgumentException` 발생
- [x] Cars : `createCarsFromNames` 메서드
  - 자동차 이름 리스트를 인수로 받아 Car 객체 리스트를 만들어 반환한다.

## 자동차 생성 기능
- [x] Car `생성자`
  - 자동차 이름을 인수로 받아 Car 객체 생성
- [x] Cars `생성자`
  - 문자열 리스트를 인수로 받아 Car 리스트를 감싸는 객체 생성

## 시도 횟수 입력 기능
- [x] RacingView : `printAttemptInputMessage` 메서드
  - 시도 횟수 입력 안내 메시지 출력
- [x] RacingView : `getAttemptInput` 메서드
  - 사용자로부터 시도 횟수 입력
- [x] Application : `validateAttemptInput` 메서드
  - 문자열을 인수로 받아 시도 횟수 입력 형식으로서 유효한지 검사한다.
    - 숫자가 아니라면 `IllegalArgumentException` 발생
      - [x] `validateNumber` 메서드
    - 음수라면 `IllegalArgumentException` 발생
      - [x] `validatePositiveNumber` 메서드

## 게임 진행 기능
- [x] RaceCarList : `moveRandomEachCars` 메서드
  - 각 자동차를 랜덤한 확률로 움직인다.
- [x] Car : `moveAttempt` 메서드
  - 자동차를 랜덤하게 움직이는 메서드
    - 0~9 사이의 무작위 값을 뽑아서 4이상이라면 전진한다.
  - [x] RacingUtil : `generateRandomPower` 메서드
    - 0~9 사이 무작위 값을 반환한다.
  - [x] Car : `isMovablePower` 메서드
    - 정수를 인수로 받아 4이상이라면 true를 반환한다.
  - [x] Car : `move` 메서드
    - 자동차를 전진시킨다.

## 각 수행 횟수에 결과 출력 기능
- [x] RacingView : `printProgress` 메서드
  - Map<String, Integer> 타입을 인수로 받아 진행 상황을 출력한다.
    - key: 자동차 이름
    - value: 자동차 위치

## 우승자 출력
- [x] Racing : `isEnd` 메서드
  - 시도 횟수만큼 게임을 진행했다면 true 반환
- [x] Racing : `findWinners` 메서드
  - 가장 앞선 자동차 이름 리스트 반환
  - [x] Cars : `findMaxPosition`
    - 가장 앞에있는 자동차의 위치 반환
  - [x] Cars : `findCarNamesAt` 메서드
    - 위치를 인수로 받아 해당 위치에 있는 자동차 이름 리스트 반환
- [x] RacingView : `printWinners` 메서드
  - 문자열 리스트를 인수로 받아 우승자 출력