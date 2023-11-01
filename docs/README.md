## 📝 구현할 기능 목록
👊입력
- [x] 자동차 이름 입력
  - [x] 이름은 5자 이하만 가능
  - [x] ,를 기준으로 구분
  - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료
    - [x] 중복된 이름을 입력해도 예외 발생
- [x] 시도할 횟수 입력
  - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료

✋출력
- [x] 게임 메시지 클래스 만들기
- [x] 시작 프롬프트 출력
- [x] 입력 프롬프트 출력
- [x] 종료 프롬프트 출력
- [x] 실행 결과 진행 상황 출력
  - [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
- [x] 최종 우승자 출력
  - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분 후 출력
- [x] 예외 처리 메시지 클래스 만들기

🚗기능
- [x] 자동차 클래스 구현
  - [x] 이름, 위치 값을 가짐.
  - [x] 전진 기능
  - [x] 위치 반환 메서드
- [x] 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진
- [x] thread 사용하여 자동차 동시에 출발 -> 테스트 케이스 실패
- [x] 게임을 진행하는 클래스 생성

🎸기타
- [x] 상수값을 담는 클래스 생성
- [x] 자동차의 이름으로 자동차 객체를 생성시켜주는 메서드


## 💯 추가된 요구 사항
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 테스트 코드 작성
- [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 클래스 별 역할
#### Game
- start method: 로직 실행
   1. PrintHandler를 이용하여 프롬프트 및 형식문 출력
   2. InputHandler를 이용하여 입력 값 처리
   3. CarFactory를 이용하여 Car 객체 생성
   4. moveCarsIterator를 이용하여 Car들의 경주 시작
   5. findFinalWinner를 이용하여 최종 우승자를 정함
- moveCarsIterator method: RandomMainpualtor 객체를 CarMover에 주입, 입력한 횟수만큼 carMover.moveCars 반복.
- findFinalWinner method: findMaxLocation을 이용하여 우승자의 이름들을 리스트에 저장하고, 이 리스트를 반환.
- findMaxLocation method: Car들의 Location중 가장 큰 값을 반환
#### InputHandler
- readLine method: 입력 값 반환
- convertCarNames method: 한 줄로 입력받은 차 이름을 구분자로 나누고 List 형태로 반환, Validator를 이용하여 입력 값 검증
- convertTrialNumber method: String으로 입력받은 시도 횟수를 Integer형태로 반환, Validator를 이용하여 입력 값 검증
#### PrintHandler
- resultRunning method: 경주 실행 결과 출력 메서드
- finalWinner method: 최종 우승자 출력 메서드
- printLocation method: 차의 현재 location값을 RESULT_LOCATION_EXPRESSION 형태로 출력
#### Car
- 생성자: 이름을 인자로 받고, location은 0으로 초기화
- move method: 차 전진, MOVING_DISTANCE만큼 location값을 더해줌
#### CarFactory
- createCars method: Car들의 name을 가진 List로 Car객체들 생성
#### CarMover
- 생성자: RandomManipulator를 주입 받음
- moveCars method: 반복문으로 car들을 동시에 전진, random값을 isMove()에 전달하고 반환 값이 true면 car를 전진
- isMove method: CONDITION_RANDOM_VALUE를 기준으로 전진 or 정지 결정
#### Constants
- MOVING_DISTANCE: 한 번에 전진할 거리
- INPUT_SEPARATOR: 입력 값의 구분자
- MIN_CAR_NAME_LEN: Car의 name 길이의 최소값
- MAX_CAR_NAME_LEN: Car의 name 길이의 최대값 
- MIN_RANDOM_VALUE: Random값의 최소값
- MAX_RANDOM_VALUE: Random값의 최대값
- CONDITION_RANDOM_VALUE: 전진조건의 기준이 되는 값
#### ExceptionMessage
- 예외처리 메시지 상수로 선언
#### RacingGameMessage
- 프롬프트, 형식문을 상수로 선언
#### RandomManipulator
- pickNumber method: MIN_RANDOM_VALUE와 MAX_RANDOM_VALUE을 기준으로 random값을 뽑고 반환
#### StringManipulator
- splitSeparator method: String을 separator를 기준으로 나누고 String 배열 반환
- toList method: String 배열을 List로 변경 후 반환
#### Validator
- checkValidCarNames method: CarNames의 유효성을 검증
- checkValidTrialNumber method: 시도 횟수 입력 유효성 검증
- isValidLength: CarNames의 길이 조건 검증
- hasDuplicates: CarNames의 중복 검증
- isValidNames: CarName가 올바른 형식의 문자로 구성되었는지 검증
- isValidTrialNumbe: 시도 횟수가 1이상의 숫자인지 검증
