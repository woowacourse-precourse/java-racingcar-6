## [구현할 기능 목록]

### I/O 클래스

input과 ouput을 담당하는 클래스

#### Input

- inputCarNames : 자동차 이름을 입력받는 메서드. 이름을 검증하고 , 단위로 나눠서 분리한 뒤 String 배열에 저장한다.
- inputNumberOfAttempts : 시도 횟수를 입력받는 메서드. 한 자리의 숫자인지 검증하고 Integer로 리턴한다.

#### Output

- outputCarNameInputRequest ,outputNumberOfAttemptsInputRequest,assertThatThrownBy : 단순 메시지 출력
- outputRacingStatus : 레이싱의 진행 상황을 출력하는 메서드
- outputResult : 최종 우승 자동차의 이름을 출력하는 메서드, 동점자가 있다면 ", "를 붙이며 출력한다

### Game 클래스

- start : IO 클래스로부터 입력한 값을 받아서 run 메서드를 동작시킨다.
- run : output 메서드를 활용하고, 자동차가 전진할지 멈출지 판단하는 메서드를 호출한다.
- determineCarMove : 자동차가 전진할지 멈출지 판단한다.
- findMaxValueInMap : Map의 Value 중 최대값을 찾는 메서드
- generateMapFromArray : Array를 Map으로 생성해주는 메서드