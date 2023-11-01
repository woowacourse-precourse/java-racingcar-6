# 기능 목록

자동차 경주의 우승자는 **가장 멀리간 자동차**이다. 우승자는 1명 이상일 수 있다.

## ExceptionMessage enum 클래스
예외 발생시 나타나는 메세지들의 모임

## InputMessage enum 클래스
입력시 나오는 메세지들의 모임

## OutputMessage enum 클래스
출력시 나오는 메세지들의 모임

## Car 클래스
자동차에 필수적으로 필요한 부분을 미리 선언하는 추상클래스

- name 멤버 변수 선언
- 주행한 거리를 저장하는 맴버 변수 선언

### moveCar 함수
매개변수가 4이상일 경우 전진한다.

### getName 함수
자동차의 이름을 리턴한다.

### toString 함수
- "[자동차의 이름] : [주행 거리]" 형식으로 출력한다.

## RacingCar
Car 클래스를 상속받은 구현체 클래스

## RacingCars 클래스
경기에 출전하는 자동차들을 저장하는 컬렉션만을 멤버 변수로 갖는 일급 객체

- Car을 요소로 갖는 컬렉션를 멤버 변수 선언

### findLongestDistanceDriverOfLength 함수
- 컬렉션에서 가장 빠른 자동차의 주행거리의 길이를 반환

### findLongestDistanceDriverOfNames 함수
- 컬렉션에서 가장 빠른 자동차의 이름을 출력

### moveCars 함수
- 각각의 자동차들에게 무작위 수를 받아 전달한다.

### toString 함수
- 컬렉션에서 자동차의 실행 결과들을 출력

## Input 클래스
### inputCarName 함수
- 자동차의 이름은 5자 이하만 가능
- 쉽표(,)를 제외한 다른 방법으로 구분하지 않는다.
- 경기에 참여하는 자동차의 수는 2대 이상이다.

위의 경우를 어기면, **IllegalArgumentException**을 발생시킨 후, 종료한다.

### inputMovingNumber 함수
- 시도할 횟수에서 숫자를 제외한 글자등으로 입력 받을 경우

위의 경우를 어기면, **IllegalArgumentException**을 발생시킨 후, 종료한다.

## Output 클래스
### printExecutionResult 함수
- 숫자가 0일때만 "실행 결과"를 출력한다.

### printFinalWinner 함수
- "최종 우승자 : "를 먼저 출력후, 옆에 우승자를 표시한다.

## Random 인터페이스
### generate 추상함수
0과 9사이의 수들 중 랜덤한 값을 반환한다.

## Game 클래스
자동차의 경기를 위한 클래스
- Input 객체를 멤버변수로 갖는다.
- Output 객체를 멤버변수로 갖는다.

### play 함수
경기의 개최를 담당하는 함수
- Input 객체를 통해 자동차의 이름과 시도할 회수를 입력 받는다.
- 자동차들이 출발한다.
- 자동차 경기의 최종 우승자를 OutPut 객체에 전달한다.

### start 함수
경기의 시작을 담당하는 함수
- 자동차들을 이동시키고, Output 객체를 통해 실행 결과를 출력한다.

## InputException 클래스
입력을 받을 때, 발생하는 예외처리하는 클래스 

### inputSeparatorException 함수
- 정규식을 통해 정해진 문자 외에 구문자가 있으면, 예외 발생

### inputCarsSizeException 함수
- 자동차의 이름이 5자를 초과하면 예외 발생

### inputCarNameOfLengthException 함수
- 참여한 자동차의 수가 2대 미만이면 예외 발생 함수

### inputMovingNumberException 함수
- 숫자외에 영어, 한글, 특수문자가 있으면, 예외 발생