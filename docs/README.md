### **🌟 기능 목록**

1. 📥 **사용자 입력 처리 기능:**
   - [x] 사용자로부터 각 자동차의 이름을 입력받는 기능.
     - [x] `,`을 기준으로 문자열 파싱
     - [x] Players 저장
   - [x] 사용자로부터 이동 횟수를 입력받는 기능.

2. 📊 **사용자 관련 출력 기능:**
   - [x] 사용자로부터 받은 자동차 이름 및 이동 횟수 출력 기능
     - [x] `pobi,woni,jun`처럼 `이름,이름,이름`으로 `,` 사이 공백 없음 주의

3. 🚗 **자동차 이동 관련 기능:**
   - [x] 자동차 클래스 생성
   - [x] 각 자동차에 대해 0 ~ 9 사이의 난수를 생성하는 기능
   - [x] 난수가 4 이상일 경우 전진하도록 하는 기능.

4. 📊 **자동차 관련 출력 기능:**
   - [x] 각 이동마다 자동차의 이름과 현재 위치를 출력하는 기능.
      - [x] `pobi : --`처럼 `이름: 위치`으로 `콜론(:)` 사이의 공백 주의
      - [x] 현재 위치 출력시 - 사용하기
     
5. 🏆 **우승자 결정 기능:**
   - [x] 경주가 끝난 후 가장 멀리 간 자동차(들)를 판별하여 우승자를 결정하는 기능.

6. 🏅 **우승자 출력 기능:**
   - [x] 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력하는 기능.
     - [x] `최종 우승자 : pobi, jun`처럼 `최종우승자 : 이름, 이름`으로 `,`, `콜론(:)` 사이 공백 존재 주의

7. ⚠️ **예외 처리 기능:**
   - [ ] 사용자의 잘못된 입력에 대해 적절한 예외를 처리하고 프로그램을 종료하는 기능.(필수기능)
     - [x] 쉼표(,)를 기준으로 입력 확인 → 공백 및  특수문자 불허로 공백 존재시 에러 발생
     - [x] 입력시 공백 확인 → 공백 및  특수문자 불허로 공백 존재시 에러 발생
     - [x] 이름은 최소 1자에서 최대 5자 이하(대문자, 소문자, 숫자 허용 | 특수문자, 공백 불허)
     - [x] 중복된 이름이 있는지 확인
     - [x] 입력된 값이 숫자인지 확인
     - [ ] 너무 큰 값 입력 OOM 발생 확인
---
### **🌟 클래스 목록**

### 🏃‍♂️ Class: Player

#### Properties:
- `int distance`: 플레이어의 이동 거리를 나타내는 변수
- `String playerName`: 플레이어의 이름을 저장하는 변수

#### Constructor:
- `Player(String playerName)`: 주어진 이름으로 플레이어 객체를 생성합니다.

#### Methods:
1. `public String getPlayerName()`: 플레이어의 이름을 반환합니다.
2. `public int getDistance()`: 현재 플레이어의 이동 거리를 반환합니다.
3. `public void move(int randomNumber)`: 주어진 랜덤 숫자에 따라 플레이어를 이동시킵니다. 숫자가 4 이상일 경우에만 플레이어의 이동 거리를 증가시킵니다.

### 🏎️ Class: Game

#### Properties:
- `List<String> players`: 게임 플레이어들의 리스트

#### Constructor:
- `Game()`: 게임 시작 메시지를 출력하고 플레이어 이름을 입력받아 리스트에 저장합니다.

#### Methods:
1. `public void play()`: 게임을 실행하는 메소드입니다.
2. `private void playRounds(List<Player> playerObjects, int tryNumber)`: 라운드를 실행하는 메소드입니다.
3. `private void raceCars(List<Player> playerObjects)`: 한 라운드에서 자동차 경주를 진행하는 메소드입니다.
4. `private int getMaxDistance(Map<String, Integer> playerDistanceMap)`: 최대 이동 거리를 찾는 메소드입니다.
5. `private List<String> findFindWinner(Map<String, Integer> playerDistanceMap, int maxDistance)`: 우승자를 찾는 메소드입니다.

### 📜 Enum: GameMessage

#### Constants:
1. `GAME_START`: 게임 시작 시 출력할 메시지를 저장합니다.
2. `TRY_COUNT`: 시도할 회수를 묻는 메시지를 저장합니다.
3. `FINAL_WINNER`: 최종 우승자를 알리는 메시지를 저장합니다.

#### Properties:
- `String message`: 각각의 상수에 해당하는 메시지를 저장합니다.

#### Constructor:
- `GameMessage(final String message)`: 주어진 메시지로 각 상수의 메시지를 설정합니다.

### 🖨️ Class: Output

#### Constructors:
- `private Output()`: 외부에서 인스턴스화를 방지하기 위한 private 생성자

#### Static Methods:
1. `static void printGameStartMessage()`: 게임 시작 메시지를 출력합니다.
2. `static void printPlayersName(List<String> players)`: 플레이어 이름을 출력합니다.
3. `static void printTryCountMessage()`: 시도할 회수를 묻는 메시지를 출력합니다.
4. `static void printTryCount(String moveNumber)`: 시도 횟수를 출력합니다.
5. `static void printRaceCar(String playerName, int distance)`: 각 플레이어의 경주 상황을 출력합니다.
6. `static void printFinalWinner(List<String> winners)`: 최종 우승자를 출력합니다.

### 🚨 Class: ExceptionHandler

#### Constants:
- `private static final int maxValidLength`: 플레이어 이름의 최대 길이를 제한하는 상수

#### Static Methods:
1. `public static boolean isValidLength(String playerName)`: 주어진 이름이 유효한 길이인지 확인합니다.
2. `public static boolean isValidPlayerName(String playName)`: 주어진 이름이 허용된 문자만으로 구성되어 있는지 확인합니다.
3. `public static boolean isNameAlreadyExists(List<String> playerArray)`: 주어진 플레이어 리스트에 중복된 이름이 있는지 확인합니다.
4. `public static void raisePlayerInputException(List<String> playerArray)`: 플레이어 이름 입력에 대한 예외를 처리합니다.
5. `public static boolean isValidMoveNumber(String moveNumber)`: 주어진 숫자가 유효한 이동 횟수인지 확인합니다.
6. `public static void rasieMoveNumberInputException(String str)`: 이동 횟수 입력에 대한 예외를 처리합니다.

### 🙋‍♂️ Class: User

#### Methods:
1. `public static List<String> playerNameInput()`: 플레이어 이름을 입력받아 리스트로 반환합니다. 입력된 이름들을 쉼표(,)로 분리하여 리스트로 변환하고, 입력 예외를 처리합니다.
2. `public static String tryNumberInput()`: 시도할 회수를 입력받아 문자열로 반환합니다. 입력된 숫자의 유효성을 확인하고, 입력 예외를 처리합니다.

### 🛠️ Class: Create

#### Methods:
1. `public static int randomNumber()`: 0부터 9 사이의 랜덤 숫자를 반환합니다.
2. `public static List<Player> playerObjectArray(List<String> players)`: 주어진 플레이어 이름들로부터 플레이어 객체 배열을 생성하여 반환합니다.
3. `public static Map<String, Integer> playerDistanceMapping(List<Player> playerObjectArray)`: 플레이어 객체 배열로부터 플레이어 이름과 이동 거리를 매핑한 맵을 생성하여 반환합니다.

### 🤝 Class: JoinComma

#### Methods:
1. `public static String playerInput(List<String> players)`: 주어진 플레이어 리스트를 쉼표(,)로 연결하여 문자열로 반환합니다.
2. `public static String winnerOutput(List<String> winners)`: 주어진 우승자 리스트를 쉼표와 공백으로 연결하여 문자열로 반환합니다.
---
### **🌟 테스트 목록**
1. Application Test
- [x] 이름에 대한 판단
  - [x] 이름은 최소 1자에서 최대 5자 이하 판단
  - [x] `kim, seong, han`: 공백 및  특수문자 불허
  - [x] `kim, kim`: 중복된 이름 불허
- [x] 실행횟수에 대한 판단
  - [x] 실행횟수가 0이외의 숫자인지 판단
- [x] 실행시 출력에 대한 판단
  - [x] `이름 : ---` 구조로 잘 되어있는지 판단
- [x] 실행결과에 대한 판단
  - [x] `최종우승자 : kim` 우승자 1명일 때 최종 출력 판단
  - [x] `최종우승자 : kim, seong` 우승자 2명 이상일 때 최종 출력 판단
2. StringUtils Test
- [x] `,`로 조인할 때 공백 없이 조인되는지 확인
- [x] `, `로 조인할 때 공백 있게 조인되는지 확인