## 구현 기능 목록

### `23.10.30 17:00

1. Race, Car, 클래스, 메소드 만들기

- Race
    - Member 변수 : `ArrayList<Cars> cars`, `int laps`,
    - method :
    - 구현완료 기능 : 1. 사용자로부터 입력을 받아 자동차 정보, 시도 횟수를 멤버변수로 할당한다. 2. 경주를 시작하고 매 시도횟수마다의 진행상황을 출력한다. 3. 승자를 출력한다.

- Car
    - Member 변수 : `String name`, `int moveCount`, `final int MOVE_CONDITION`
    - method : `decideMoveOrNot(), move(), getName(), getMoveCount(), printMoveResult()`
    - 구현완료 기능 : 1. Random 숫자에 따라 전진 혹은 정지한다. 2. 현재까지 움직인 횟수만큼 진행상황을 출력한다.

### `23.11.01 12:00

1. TestCode 짜기
2. Test Case에 맞는 예외 처리 추가
3. Style 수정
4. Validator 추가
   `carNameLength(String carName), onlyWhiteSpace(String carName), inputStartsWithComma(String input),
   inputEndsWithComma(String input), parsableToNumber(String input), numberIsOverZero(Integer num), distinctNameOnly(ArrayList<Car> cars)`
