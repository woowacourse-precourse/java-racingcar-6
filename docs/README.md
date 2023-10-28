## 게임 진행 과정
1. 자동차 입력
2. 자동차 생성
3. 횟수 입력
4. 게임 진행 
   - 각 횟수 진행 결과 출력
5. 우승자 출력

## 클래스
- RaceView
  - 자동차 경주 게임에 전체적인 입력, 출력 담당
- Car
  - 자동차 이름, 위치 그리고 이동 메소드 포함
- CarList
  - Car 리스트를 감싸는 일급컬렉션
- RacingUtil
  - 유틸리티 클래스

## 자동차 입력 기능
- [x] RaceView : `getCarListInput` 메서드
  - 사용자로부터 자동차 목록을 입력받는다.
- [x] Application : `validateCarListInput` 메서드
  - 문자열을 인수로 받아 자동차 목록 입력 형식으로서 유효한지 검사한다.
    - 빈 문자열이라면 `IllegalArgumentException` 발생
      - [x] `validateCarListInputBlank` 메서드
        - [x] `validateCarNameBlank` 메서드
    - 자동차 이름 중 5자를 초과하는 이름이 있다면 `IllegalArgumentException` 발생
      - [x] `validateCarListInputLength` 메서드
        - [x] `validateCarNameLength` 메서드
    - 자동차 이름에 중복이 있다면 `IllegalArgumentException` 발생
      - [x] `validateCarListInputUnique` 메서드
- [x] RacingUtil : `createCarsFromNames` 메서드
  - 자동차 이름 리스트를 인수로 받아 Car 객체 리스트를 만들어 반환한다.

## 자동차 생성 기능
- [x] Car `생성자`
  - 자동차 이름을 인수로 받아 Car 객체 생성
- [x] CarList `생성자`
  - Car 리스트를 인수로 받아 Car 리스트를 감싸는 객체 생성

## 시도 횟수 입력 기능
- [ ] RaceView : `getAttemptInput` 메서드
  - 사용자로부터 시도 횟수 입력
- [ ] Application : `validateAttemptInput` 메서드
  - 문자열을 인수로 받아 시도 횟수 입력 형식으로서 유효한지 검사한다.
    - 숫자가 아니라면 `IllegalArgumentException` 발생
    - 음수라면 `IllegalArgumentException` 발생

## 게임 진행 기능
- [x] RaceCarList : `moveRandomEachCars` 메서드
  - 각 자동차를 랜덤한 확률로 움직인다.
- [x] Car : `move` 메서드
  - int를 인수로 받아 4이상이라면 전진한다.
- [x] RacingUtil : `generateRandomPower` 메서드
  - 랜덤 0~9 사이 무작위 수를 생성한다

## 각 수행 횟수에 결과 출력 기능
- [ ] RaceView : `printRaceProgress` 메서드
  - CarList 객체를 인수로 받아 현재 각 자동차들의 위치 출력

## 우승자 출력
- [x] RaceCarList : `findWinners` 메서드
  - 가장 앞에있는 자동차를 찾아 Car 리스트 반환
  - [x] `findMaxPosition` 메서드
    - 가장 앞에있는 자동차의 위치를 반환
- [ ] RaceView : `printWinners` 메서드
  - Car 리스트를 인수로 받아 우승자 출력