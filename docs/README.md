# `package racingcar.component`

## `class Racing`

### 목적

레이싱 정보 입력, 게임 진행 및 상태 출력

### Field

`List<Car> cars`: 차량 목록

`int trial`: 시행 횟수

### Method

`void getInfor(void)`: 레이싱 정보 입력

`void start(void)`: 시행 횟수만큼 시행, 각 시행마다 결과 출력

`void printMoves(void)`: 모든 차량 상태 출력

`void printWinner(void)`: 승자 출력

`List<String> getPositionMatches(int)`: 해당 위치와 같은 차량 목록 반환

`int getMaxPosition(void)`: 위치 최댓값 반환

## `class Car`

### 목적

자동차 이름, 위치 정보 저장

### Field

`String name`: 차량 이름

`int position`: 위치

`NumberCondition numberCondition`: 해당 정수가 4 이상인지 체크하기 위한 식별자

### Method

`void printMoves(void)`: 차량 움직임 출력

`void trial(void)`: 랜덤한 정수를 생성한 뒤, 4 이상이면 위치+1

`String getName(void)`: 차량 이름

`int getPosition(void)`: 차량 위치

---

# `package racingcar.IO`

## `class NameInput`

### 목적

차량 이름 입력 처리

### Field

해당 사항 없음

### Method

`static void inputNames(List<Car>)`

1. `readLine` 입력 토큰화
2. 각 이름에 대해 유효성 검사
3. 새로운 `List<Car>` 객체 생성
4. 빈 배열(parameter)에 새로운 배열 삽입

## `class TrialInput`

### 목적

시행 횟수 입력 처리

### Field

해당 사항 없음

### Method

`static int inputTrial(void)`

1. `readLine` 입력
2. 유효성 검사
3. 정수형으로 형변환 후 값 반환

---

# `package racingcar.validation`

## `interface Validation`

### 목적

이름과 시행 횟수 유효성 검증

### Method

`void isValid(String)`: 유효성 검증

## `class NameValidation`

### 목적

이름 유효성 검증

### Field

`static Predicate<String> isEmpty`: 빈 문자열인지 체크

`static Predicate<String> isTooLong`: 6자 이상인지 체크

### Method

`void isValid(String)`: 조건에 맞지 않으면 `IllegalArgumentException` 생성

## `class TrialValidation`

### 목적

시행 횟수 유효성 검증

### Field

`static Predicate<String> isEmpty`: 빈 문자열인지 체크

`static Predicate<String> isNotNumber`: 문자열의 글자가 숫자가 아닌지 체크

### Method

`void isValid(String)`: 조건에 맞지 않으면 `IllegalArgumentException` 생성