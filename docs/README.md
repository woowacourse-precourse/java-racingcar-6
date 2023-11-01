# 자동차 경주 게임

## 구현할 기능 목록
- 경주할 자동차의 이름을 입력받는 기능
    - 유효하지 않은 값이 입력된 경우 예외 발생 후 애플리케이션 종료
- 시도할 횟수를 입력받는 기능
    - 유효하지 않은 값이 입력된 경우 예외 발생 후 애플리케이션 종료
- 무작위 값을 반환하는 기능
- 값이 4 이상이면 자동차를 전진하는 기능
- 현재 게임 진행 상황을 출력하는 기능
- 최종 우승자를 출력하는 기능

## 입력 유효성 확인
- **자동차 이름 입력**:
  - 입력의 길이는 1 이상이어야 합니다.
  - 구분자 ','로 문자열을 나눠 얻은 자동차 이름의 개수는 구분자 ','의 개수보다 1개 더 많아야 합니다.
  - 구분자 ','로 문자열을 나눠 얻은 자동차 이름의 길이는 5 이하여야 합니다.

- **시도 횟수 입력**:
  - 입력은 0 이상 2147483647 이하의 정수여야 합니다.

## 흐름도

시작 --> [게임 시작] --> [자동차 이름 입력] --> (입력 유효성 확인) --> [시도 횟수 입력] --> (입력 유효성 확인) --> (시도 횟수 반복) --> [시도] --> (무작위 값 계산) --> [전진 여부 확인] --> (전진) --> [현재 상태 출력] --> [다음 시도 또는 게임 종료] --> (게임 종료) --> [우승자 출력] --> 종료

## Java Class 설계

- 자동차(Car)
  1. 기능
     - void moveForward()
     - String getName()
     - int getPosition()
  2. 속성
     - private final String name
     - private int position
  3. 생성자
     - Car(String name)

- 게임(RacingCarGame)
  1. 기능
     - void startGame()
     - void attemptMove(Car car)
     - void printCurrentState()
     - void printWinners()
     - List\<Car> getCarsFromInputString()
     - int getNumberOfAttemptsFromInputString()
  2. 속성
     - int numberOfAttempts
     - int numberOfCars
     - List\<Car> cars

- NumberGenerator
  1. 기능
     - static int createRandomNumber(int maxNumber)
