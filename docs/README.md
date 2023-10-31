# 1. 구현할 기능 목록
***
### 1. 자동차 이름을 입력받는 기능을 구현한다.
- 쉼표(,)로 구분하며, 5자 이하의 자동차 이름을 입력받아야 한다.
- 이름 앞, 뒤의 공백을 제거해야 한다.
- 두 명이상의 플레이어가 있어야 하고, 중복되는 이름은 있으면 안된다.

### 2. 경주 횟수를 입력받는 기능을 구현한다.
- 양의 정수 외 다른 문자를 입력받으면 예외처리한다.

### 3. 무작위를 추출하여 게임을 진행하는 기능을 구현한다.
- `pickNumberInRange()`를 활용하여 무작위 정수를 추출한다.

### 4. 게임 진행상황을 출력하는 기능을 구현한다.
- `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` -> 게임 당 1회 출력한다.
- `시도할 회수는 몇회인가요?` -> 게임 당 1회 출력한다.
- 각 차수별 실행 결과를 출력한다.
- 최종 우승자를 출력하는 기능을 구현한다.
  - 우승자는 한명 이상이다.

### ETC. 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- JUnit 5와 AssertJ를 이용한다.
- `test/java/study`를 참고하여 학습한다.

> 차와 플레이어가 상호작용을 하고, 게임 진행자가 규칙에 따라 게임을 진행하며,
차의 이름을 정하거나 게임 횟수를 받을 때, 게임 진행자는 도구를 통해 **유효**한가를 판단할 수 있어야 한다.

# 2. 구현 계획
***
### Application 클래스
- Game 클래스 인스턴스의 게임 시작 메서드를 실행한다.

### Car 클래스
- 생성자를 통해 자동차의 이름을 입력받고 변경할 수 없게 구현한다.
- 랜덤 정수를 바탕으로 행동을 선택하는 기능을 구현한다.
- getter를 통해 위치를 반환하는 기능을 구현한다. 우승자 출력을 위해 해당 기능 구현이 필요할 것으로 예상된다.

### Game 클래스
- 시작 문구출력하는 기능을 구현한다.
- 차들의 이름, 게임 횟수 입력받고 파싱하는 기능을 구현한다.
- 파싱이 끝나면 Validator를 통해 값이 유효한지 확인하는 기능을 구현한다.
- 유효한 값으로 Car 클래스 배열을 생성하고, Car 인스턴스를 배열에 생성한다.
- 각각 Car 인스턴스가 주어진 횟수에 맞춰 행동을 결정할 수 있게하는 기능을 구현한다.
- Car 인스턴스의 위치를 비교하여 우승자를 출력하는 기능을 구현한다.

### Validator 클래스
- 플레이어 수가 한 명보다 많은지 체크하는 기능을 구현한다.
- 자동차의 이름이 5자 이하인지 체크하는 기능을 구현한다.
- 중복된 자동차 이름이 있는 지 체크하는 기능을 구현한다.
- 게임 횟수가 양의 정수인 지 체크하는 기능을 구현한다.
- 파싱 후, 또는 파싱하면서 검사를 진행하는 한다.

# 3. 실제 구현 기능
***
### Application 클래스
- Game 클래스 인스턴스의 `play()` 메서드를 실행한다.

### Car 클래스
- 이름과 위치를 속성으로 가진다.
- 생성자를 통해 이름이 있는 인스턴스를 생성할 수 있게한다.
- `public String getName()`: 이름을 반환하는 메서드이다.
- `public int getPosition()`: 위치를 반환하는 메서드이다.
- `public void choosePosition()`: 랜덤 정수를 통해 전진 또는 정지를 결정하는 메서드이다.

### Game 클래스
- 참가자 목록(자동차 이름 ArrayList)과 횟수를 속성으로 가진다.
- `public void play()`: Game 클래스의 메서드를 순차적으로 동작하는 메서드이다.
- `public String[] parser(String readLine)`: 입력받은 이름 값을 쉼표(,)로 구분하고 공백을 없앤 뒤, 
Validator 인스턴스의 `isNameValidated()` 메서드를 통해 값의 유효성을 검사하는 메서드이다.
- `private void addCar(String[] cars)`: Car 인스턴스를 생성하고 ArrayList에 추가하는 메서드이다.
- `private void setTimes()`: 입력받은 횟수 값을 Validator 인스턴스의 `isTimesValidated()` 메서드를 통해 값의 유효성을 검사하고,
String을 Int로 바꿔주는 메서드이다.
- `public void moveCar()`: 입력받은 횟수에 맞춰 Car 인스턴스의 `choosePosition()` 메서드를 통해,
각 인스턴스들이 전진 또는 정지의 행동을 결정할 수 있게하는 메서드이다.
- `public void printWinner()`: Car 인스턴스의 `getPosition()` 메서드를 통해, 최종 우승자를 구하는 메서드이다.

### Validator 클래스
- `public void isNameValidated(String[] strings)`: 자동차 이름 입력 값을 예외처리를 하는 메서드이다.
- `public void isTimesValidated(String string)`: 게임 횟수 입력 값을 예외처리를 하는 메서드이다.
- `public boolean isValidatedPlayerNum(String[] strings)`: 플레이어 숫자에 이상이 있으면, false를 반환하는 메서드이다.
- `public boolean isValidatedLength(String[] strings)`: 자동차 이름의 길이가 5자 초과 시, false를 반환하는 메서드이다.
- `public boolean isValidatedDuplication(String[] strings)`: 중복되는 자동차 이름이 있으면, false를 반환하는 메서드이다.