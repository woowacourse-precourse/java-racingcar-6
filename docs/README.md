# 기능 목록

## 진행 흐름

- 게임이 시작되는 메시지를 출력한다. (입력 메시지)
- 경주할 자동차의 이름을 부여한다.
- 자동차가 몇 번 이동할 지 입력한다.
- 0 ~ 9까지 랜덤한 숫자 중 4 이상일 경우 자동차가 전진한다.
- 게임이 진행된 상황을 보여준다.
- 이를 사용자가 입력한 횟수만큼 반복한다.
- 사용자가 입력한 회수만큼 진행 됐다면 최종 우승자를 발표한다.
- 게임이 종료된다.

## 클래스별 기능

### 게임 진행 관련 상수 (GameConfig)

- [x] 전진하는 기준
    - 변수명 : MAXIMUM_CAR_NAME_LENGTH
- [x] 자동차 최대 입력 길이
    - 변수명 : MINIMUM_NUMBER_FOR_FORWARD
- [x] 랜덤 수의 MINIMUM 값
  -변수명 : RANDOM_MINIMUM_RANGE
- [x] 랜덤 수의 MAXIMUM 값
    - 변수명 : RANDOM_MAXIMUM_RANGE

### 메시지 관련 상수 (Message)

- [x] 사용자 입력 메시지
    - 변수명 : CAR_NAME_INPUT_MESSAGE
- [x] 시도 횟수 입력 메시지
    - 변수명 : ATTEMPT_COUNT_MESSAGE
- [x] 우승자 출력 메시지
    - 변수명 : WINNER_MESSAGE
- [x] 실행 결과를 알리는 메시지
    - 변수명 : EXECUTION_RESULT_MESSAGE

### 기호 관련 상수 (CommonSymbol)

- [x] " : " 기호
    - 변수명 : SYMBOL_COLON_SPACE
- [x] "-" 기호
    - 변수명 : SYMBOL_HYPHEN
- [x] "," 기호
    - 변수명 : SYMBOL_COMMA
- [x] ", " 기호
    - 변수명 : SYMBOL_COMMA_SPACE

### Controller

- [x] 사용자가 입력한 입력을 쉼표(,) 기준으로 나누는 기능
- [x] names 를 인수로 받아 Car를 생성시킨 후 리스트를 반환하는 기능

### Car

- [x] 자동차가 전진하는 기능

### Race

- [x] names로 carList를 생성하는 기능
- [x] 최종 우승자를 반환하는 기능
- [x] 랜덤한 값이 4 이상이면 자동차를 전진시키는 기능
- [x] Race에 참여한 모든 차를 전진시키는 기능

### Validation

- [x] 이름이 5자 인지 확인하는 기능
- [x] 입력이 숫자인지 확인하는 기능

### InputView

- [x] 자동차 이름 입력 메시지 출력과 사용자의 입력을 받는 기능
- [x] 시도할 횟수 메시지 출력과 사용자의 입력을 받는 기능

### OutputView

- [x] Car의 진행 상황을 출력한다.
- [x] 최종 우승자를 출력한다.
- [x] 실행 결과 메시지

## 예외사항

- 자동차 이름은 5자 이하만 가능하다.
- 시도할 회수 입력에 숫자가 아닌 다른 수가 들어오면 안 된다.

## 사용 라이브러리

- camp.nextstep.edu.missionutils.Console의 readLine()
- camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()

## Test

### InputValidator

#### validateInputNameLength

- [ ] 설정된 값보다 긴 문자열이 들어오면 IllegalArgumentException 발생
- [ ] 설정된 값 범위 안에 들어온다면 통과

#### readAttemptCount

- [ ] 숫자가 아닌 값이 들어오면 IllegalArgumentException 발생
- [ ] 숫자가 들어오면 통과
