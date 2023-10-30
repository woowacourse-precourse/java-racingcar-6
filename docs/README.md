
# 2주차 프리코스 과제

## 구현할 기능 목록

### NumberGenerator 인터페이스를 생성한다.
추상메소드 generate를 정의한다.

###  RandomGenerator클래스를 생성한다 NumberGenerator 인터페이스를 구현한다.
* generate를 재정의 한다. Randoms.pickNumberRange를 이용하여 랜덤값을 생성하여 리턴한다.

### domain패키지 Car 클래스 생성
* String name, int position, NumberGenerator를 필드로 가진다.
* NumberGenerator에 의해 생성되는 숫자가 4이상이면 position필드값이 1 증가하는 moveByRandomInput구현
* 결과 출력을 위한 getter 구현

### domain패키지 일급컬렉션 Cars클래스를 생성한다
* List<Car>를 필드로 갖는다.
* move를 구현한다. cars에 저장되어 있는 모든 Car객체의 moveByRandomNumber를 실행한다.
* 최대 이동 거리를 얻는  getMaxPosition() 구현한다.
* 우승자 이름 리스트를 얻는 getWinnerNameList() 구현.
* getCars구현

### domain패키지 Game 클래스 생성
* 일급컬렉션 Cars와 int givenAttemptCount를 필드로 가지고, 생성자에서 주입받는다.
* int currentAttemptCount를 필드로 가지며 0에서 시작한다.
* 게임 종료를 확인하는 메서드 isGameOver 구현
    * 한 번의 Race를 시행하는 메서드 carRaceOnce 구현
    * 현재 시도 횟수 currentAttemptCount를 증가시키는 increaseCurrentAttemptCount구현
* getCars, getWinner구현

### 사용자의 입력을 요청하고, 게임을 진행하는 controller패키지 Controller클래스 생성
* 사용자 입력의 유효성을 검사하는 Validator를 필드로 가진다.
* Parser 문자열 입력을 파싱하는 Parser를 필드로 가진다
* 게임을 진행하는 Game 클래스를 필드로 가진다.

#### 입력 요청을 출력하는 view패키지 InputView 클래스 생성
    - 자동차 이름 입력을 요청 메시지 출력하는 printCarNameRequest() 구현
    - 시도 횟수 입력 요청 메시지 출력하는 printAttemptCountRequest() 구현

#### 유효성 검사를 진행하는 util패키지 Validator 클래스 생성
    - validateLengthForCarNameInput() 구현 : 5글자 이상시 IllegalArgumentException 발생
    - validataBlankForCarNameInput() : 주어진 문자열이 비어있을 시 IllegalArgumentException 발생
    - validateDuplicateForCarNameInput() : 중복된 이름이 있을 시 IllegalArgumentException 발생
    - validateAttemptCountUserInput : 입력 문자열이 숫자가 아닐 경우	 IllegalArgumentException 발생
#### 입력 문자열을 파싱하는 util패키지 Parser 클래스 생성
    - 입력된 문자열을 쉼표로 구분하여 List<String> 반환하는 parseCarNameUserInput() 구현
    - 입력된 문자열을 정수로 파싱해 반환하는 parseAttemptCountUserInput() 구현

* 사용자로부터 자동차 이름을 얻는 getCars() 구현
* 사용자로부터 시도 횟수룰 얻는 getAttemptCount()구현
#### 게임 결과를 출력하는 view패키지 OutputView 클래스 생성
    - 매 시도마다 레이스 상황을 출력하는 printRaceStatus() 구현
    - 우승자를 출력하는 printWinnerName() 구현
* 어플리케이션 전체 동작을 실행하는 run메서드 구현