## 기능목록

---

## model

### Name

`String name` 래퍼 클래스

- `Name()` 검증 후 값 설정 생성자 함수
- `getName()` name 메서드

### MovingCount

`int movingCount` 래퍼 클래스

- `MovingCount()` 검증 후 값 설정 생성자 메서드
- `increase()` 증가 함수
- `getMovingCount()` movingCount 반환 메서드

### Car

`Name name`, `MovingCount movingCount`를 갖는 클래스

- `increaseMovingCountIfGreater()` 임의의 수가 기준 숫자보다 크면 movingCount 증가시켜주는 메서드
- `isSameMovingCount()` 다른 Car클래스와 같은 movingCount 갖고 있는지 판별 메서드
- `compareTo()` 비교 오버라이드 메서드
- `toString()` 이름과 movingCount만큼 "-" 반환 메서드

### Cars

`List<Car>`를 갖고있는 일급 컬렉션

- `Cars()` 검증 후 값 설정하는 생성자 메서드
- `winner()` 가장 높은 수의 플레이어 반환 메서드

---

## controller

### RacingController

전체적인 자동차 경주 게임의 흐름을 제어

- `playGame()` 게임 시작

---

## view

### InputView

입력시 사용되는 view

- `getCarsNameFromUserInput()` 자동차의 이름을 입력받는 메서드
- `getAttemptsFromUserInput()` 시도 횟수 입력받는 메서드

### OutputView

출력시 사용되는 view

- `displayResult()` 결과 출력 메서드
- `displayFinalWinner()` 최종 우승자 출력 메서드
- `displayCurrentRacingStatus()` 현재 경주 상황 출력 메서드

--- 

## validation

### InputValidator

검증 메서드 관련된 클래스

- `validateNameLength()` 이름 길이 검증 메서드
- `validateNumericInput()` 숫자 입력 검증 메서드

---

## utils

### RandomNumberGenerator

임의의 숫자 생성 클래스

- `generateRandomNumber()` 임의의 숫자 반환 메서드
