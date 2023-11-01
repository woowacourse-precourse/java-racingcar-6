# 🚗 초간단 자동차 경주 게임 기능 목록
[상세구현으로 바로가기](#상세-구현)

### 1. 자동차 객체
   - 이름 부여 기능
     - 이름은 최대 5자까지만 허용한다.
     - 이름은 쉼표(,)로 구분한다.
   - 전진 기능
     - 0에서 9 사이의 무작위 값을 구한다.
     - 만약 값이 4 이상이면 자동차는 전진한다.

### 2. 게임 시작
   - 사용자로부터 자동차 이름 입력 받기 
     - 잘못된 이름(5자 초과)이 입력되면 IllegalArgumentException 발생
   - 사용자로부터 시도할 횟수 입력 받기
     - 잘못된 횟수(음수 또는 문자)가 입력되면 IllegalArgumentException 발생

### 3. 경주 진행
   - 주어진 횟수 동안 각 자동차는 전진 또는 멈출 수 있다.
   - 각 라운드의 결과를 출력한다.
     - 자동차별로 전진한 거리를 출력한다. (자동차 이름과 함께 전진한 거리, ex. jjaegii: --)

### 4. 경주 결과 출력
   - 우승자를 결정하여 출력한다.
     - 가장 멀리 전진한 자동차(들)가 우승자다.
     - 우승자가 여러 명일 경우, 쉼표(,)로 구분하여 출력한다.

### 5. 테스트 관리
   - JUnit 5와 AssertJ를 사용하여 테스트 코드를 작성한다.
     - 각 클래스의 주요 메소드에 대한 단위 테스트를 구현한다.
       - 예: Car 클래스의 move() 메소드의 기능을 테스트하는 코드 작성.
     - 경주 결과 및 우승자 결정 로직에 대한 테스트를 구현한다.
     - 입력 값 검증 로직에 대한 테스트를 구현한다.
   - 테스트 코드 작성 시, 테스트 케이스는 다양한 시나리오를 고려한다.

## 상세 구현
### 1. 자동차 객체 (Car 클래스)
- 멤버 변수
     - String name: 자동차의 이름.
     - int position: 자동차의 현재 위치.
- 생성자: 이름을 받아 초기화한다. 위치는 0으로 초기화한다.
- move(): 무작위 값(0~9)을 생성하고 4 이상이면 position을 1 증가시킨다.
- getPosition(): 현재 위치를 반환한다.
- getName(): 자동차의 이름을 반환한다.

### 2. 입력 관리 (InputManager 클래스)
- getCarNames(): 사용자로부터 자동차 이름을 입력 받아서 String 배열로 반환한다.
- isValidName(String name): 5자 초과일 경우 IllegalArgumentException 발생.
- getTryCount(): 사용자로부터 시도할 횟수를 입력 받아서 int로 반환한다.
- isValidNum(): 음수 또는 문자가 입력되면 IllegalArgumentException 발생.

### 3. 게임 관리 (RaceManager 클래스)
- 멤버 변수
     - List<Car> cars: 참가하는 자동차 리스트.
     - int rounds: 진행할 라운드 수.
- 생성자: 참가하는 자동차 리스트와 라운드 수를 받아 초기화한다.
- race(): 주어진 라운드 수만큼 경주를 진행한다. 각 라운드의 결과를 출력한다.
- getWinners(): 우승자 목록을 반환한다. 가장 멀리 전진한 자동차(들)를 반환한다.

### 4. 출력 관리 (OutputManager 클래스)
- printRaceResult(List<Car> cars): 주어진 자동차 리스트의 경주 결과를 출력한다.
- printWinners(List<Car> winners): 주어진 우승자 리스트를 출력한다.

### 5. Main 클래스
- main 메소드에서 위의 클래스들을 조합하여 게임을 실행한다.
- InputManager를 통해 입력을 받는다.
- RaceManager를 생성하여 경주를 진행한다.
- OutputManager를 통해 결과를 출력한다.

### 6. 테스트 관리
- CarTest 클래스 작성
     - move_forward_when_random_number_is_greater_than_or_equal_to_4: 4 이상의 숫자가 나왔을 때, 자동차가 전진하는지 확인한다.
     - stay_in_position_when_random_number_is_less_than_4: 4 미만의 숫자가 나왔을 때, 자동차가 제자리에 있는지 확인한다.
- InputManagerTest 클래스 작성
     - throw_exception_for_invalid_car_name_length: 5자 초과의 이름이 주어졌을 때 예외가 발생하는지 확인한다.
     - throw_exception_for_invalid_try_count: 잘못된 시도 횟수(음수 또는 문자)가 입력되었을 때 예외가 발생하는지 확인한다.
- RaceManagerTest 클래스 작성
     - return_correct_winners: 주어진 자동차들 중에서 올바른 우승자(들)를 반환하는지 확인한다.