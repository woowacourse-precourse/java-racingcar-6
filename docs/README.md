## **🌟 기능 목록**

1. 📥 **사용자(User) 입력 처리 기능:**
   - [x] 사용자로부터 각 자동차의 이름을 입력받는 기능.
     - [x] `,`을 기준으로 문자열 파싱
     - [x] Players 저장
   - [x] 사용자로부터 이동 횟수를 입력받는 기능.

2. 📊 **사용자(User) 관련 출력 기능:**
   - [x] 사용자(User)로부터 받은 플레이어(Player) 이름 출력 기능
     - [x] `pobi,woni,jun`처럼 `이름,이름,이름`으로 `,` 사이 공백 없음 주의

3. 🦸 **플레이어(Player) 관련 자동차 선택 기능**
    - [x] Game에서 제공한 차 중에서 플레이어가 차를 선택하는 기능
      - [x] 차가 있을 때만 전진하는 기능
      - [x] 차를 이동시키는 기능
      - [x] 차의 이동거리를 출력하는 기능
      
4. 🚗 **자동차(Car) 이동 관련 기능:**
   - [x] 자동차(Car) 클래스 생성
   - [x] 각 자동차에 대해 0 ~ 9 사이의 난수를 생성하는 기능
   - [x] 난수가 4 이상일 경우 전진하도록 하는 기능.

5. 📊 **자동차 관련 출력 기능:**
   - [x] 각 이동마다 자동차의 이름과 현재 위치를 출력하는 기능.
      - [x] `pobi : --`처럼 `이름: 위치`으로 `콜론(:)` 사이의 공백 주의
      - [x] 현재 위치 출력시 - 사용하기
     
6. 🏆 **우승자 결정 기능:**
   - [x] 경주가 끝난 후 가장 멀리 간 자동차(들)를 판별하여 우승자를 결정하는 기능.

7. 🏅 **우승자 출력 기능:**
   - [x] 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력하는 기능.
     - [x] `최종 우승자 : pobi, jun`처럼 `최종우승자 : 이름, 이름`으로 `,`, `콜론(:)` 사이 공백 존재 주의

8. ⚠️ **예외 처리 기능:**
   - [x] 사용자의 잘못된 입력에 대해 적절한 예외를 처리하고 프로그램을 종료하는 기능.(필수기능)
     - [x] 쉼표(,)를 기준으로 입력 확인 → 공백 및  특수문자 불허로 공백 존재시 에러 발생
     - [x] 입력시 공백 확인 → 공백 및  특수문자 불허로 공백 존재시 에러 발생
     - [x] 이름은 최소 1자에서 최대 5자 이하(대문자, 소문자, 숫자 허용 | 특수문자, 공백 불허)
     - [x] 중복된 이름이 있는지 확인
     - [x] 입력된 값이 숫자인지 확인
---
## **🌟 클래스 목록**

## 🧑‍💻 User 클래스

`User` 클래스는 사용자로부터 플레이어 이름과 이동 횟수를 입력받는 역할을 담당하는 클래스.

### 메서드

#### `public static List<String> inputPlayerName()`

- 사용자로부터 플레이어 이름을 입력받아 리스트로 반환하는 메서드. 입력받은 이름은 쉼표로 구분.

#### `public static String inputTryNumber()`

- 사용자로부터 이동 횟수를 입력받아 문자열로 반환하는 메서드.

## 👨‍👨‍👧‍👦 Player 클래스

`Player` 클래스는 유저(User)클래스에 의해 생성된 게임 참여자를 나타내는 클래스로, 플레이어의 이름과 차량을 관리.

### 속성

- `name` : 플레이어의 이름을 나타내는 문자열.
- `car` : 플레이어의 차량을 나타내는 `Car` 클래스의 인스턴스.

### 메서드

#### `public Player(String playerName)`

- 생성자 메서드로, 플레이어의 이름을 인자로 받아 초기화.

#### `public String getPlayerName()`

- 플레이어의 이름 반환하는 메서드.

#### `public int getDistance()`

- 플레이어의 차량이 이동한 거리를 반환하는 메서드.

#### `public void selectNewCar()`

- 새로운 차량을 선택하여 현재 차량을 업데이트하는 메서드.
- 단발성 게임이 아니라 반복 게임일 경우 새로운 게임이 시작될 때마다 새로운 차량을 선택할 수 있도록 하기 위해서 도입

#### `public void play()`

- 현재 차량이 존재하는 경우 차량을 이동시키는 `tryMove()` 메서드를 호출하여 플레이어가 플레이를 진행.

## 🚗 Car 클래스

`Car` 클래스는 주어진 조건에 따라 움직이는 자동차를 나타내는 클래스.

### 속성

- `distance` : 자동차가 이동한 거리를 나타내는 정수 값.
- `threshold` : 자동차가 이동할지 여부를 결정하는 임계값으로, 4로 설정.

### 메서드

#### `Car()`

- 생성자 메서드로, `Car` 클래스의 새 인스턴스를 초기화.

#### `int getDistance()`

- 현재까지 이동한 거리를 반환하는 메서드.

#### `void tryMove()`

- 자동차를 움직이게 하는 메서드로, `Factory.createRandomDigit()`을 이용하여 생성된 임의의 숫자가 `threshold`보다 크거나 같으면 `distance`를 1 증가.


## 🏎️ Game 클래스

`Game` 클래스는 레이싱 게임을 관리하는 클래스로, 플레이어들을 초기화하고 게임을 진행하며 결과를 출력.

### 속성

- `players` : 게임에 참여하는 플레이어들의 목록을 나타내는 `List<Player>`.

### 메서드

#### `public Game()`

- 생성자 메서드로, 새로운 `Game` 인스턴스를 초기화.

#### `public void start()`

- 게임을 시작하는 메서드로, 게임을 초기화하고 플레이어들의 이름을 입력하고 차량을 할당.

#### `public void play()`

- 게임을 플레이하는 메서드로, 게임 라운드의 수를 입력하고 라운드를 실행.

#### `public void end()`

- 게임이 종료될 때 호출되는 메서드로, 최종 승자를 찾아 출력.

#### `private void assignNewCarToEachPlayer()`

- 각 플레이어에게 새로운 차량을 할당하는 메서드.

#### `private void playRounds(int tryNumber)`

- 주어진 횟수만큼 라운드를 실행하는 메서드.

#### `private void playRound()`

- 각 플레이어의 라운드를 실행하는 메서드.

#### `private List<String> findFinalWinner()`

- 최종 승자를 찾는 메서드로, 플레이어들 중 가장 멀리 간 플레이어를 반환.

### 📜 GameMessage 열거형

`GameMessage` 열거형은 레이싱 게임에서 사용되는 메시지.

### 속성

- `message` : 각 게임 메시지에 대한 설명을 포함하는 문자열입니다.

### 상수

#### `GAME_START`

- 게임 시작 시 플레이어들의 이름을 입력하라는 메시지를 의미.

#### `TRY_NUMBER`

- 시도할 회수를 입력하라는 메시지를 의미.

#### `FINAL_WINNER`

- 최종 우승자를 알리는 메시지를 의미.

### 생성자

#### `GameMessage(final String message)`

- 각 게임 메시지에 대한 설명을 초기화하는 생성자.

## 🖨️ Output 클래스

`Output` 클래스는 레이싱 게임에서의 출력을 관리하는 유틸리티 클래스

### 메서드

#### `static void printGameStartMessage()`

- 게임 시작 메시지를 출력하는 메서드.

#### `static void printPlayersName(List<String> players)`

- 플레이어들의 이름을 출력하는 메서드.

#### `static void printTryNumberMessage()`

- 시도할 회수를 입력하라는 메시지를 출력하는 메서드.

#### `static void printTryCount(String moveNumber)`

- 시도한 횟수를 출력하는 메서드.

#### `static void printPlayerStatus(String playerName, int distance)`

- 플레이어의 상태를 출력하는 메서드.

#### `static void printPlayersStatus(List<Player> players)`

- 플레이어들의 상태를 출력하는 메서드.

#### `static void printFinalWinner(List<String> winners)`

- 최종 승자를 출력하는 메서드.

## ⚠️ ExceptionHandler 클래스

`ExceptionHandler` 클래스는 플레이어 이름과 이동 횟수에 대한 유효성을 확인하는 유틸리티 메서드를 제공하는 클래스

### 상수

- `maxValidLength` : 플레이어 이름의 최대 길이를 나타내는 정수 상수.

### 메서드

#### `public static boolean isValidLength(String playerName)`

- 주어진 플레이어 이름이 유효한 길이인지 확인하는 메서드.

#### `public static boolean isValidPlayerName(String playName)`

- 주어진 문자열이 유효한 플레이어 이름인지 확인하는 메서드.

#### `public static boolean isNameAlreadyExists(List<String> playerArray)`

- 주어진 플레이어 이름 목록에서 중복된 이름이 있는지 확인하는 메서드.

#### `public static void raisePlayerInputException(List<String> playerArray)`

- 플레이어 이름에 대한 예외를 처리하는 메서드.

#### `public static boolean isValidMoveNumber(String moveNumber)`

- 주어진 문자열이 유효한 이동 횟수인지 확인하는 메서드.

#### `public static void rasieMoveNumberInputException(String str)`

- 이동 횟수에 대한 예외를 처리하는 메서드.

## 🛠️ Factory 클래스

`Factory` 클래스는 유틸리티 메서드를 제공하여 객체 및 데이터 구조를 생성하는데 사용.

### 메서드

#### `public static int createRandomDigit()`

- 0부터 9 사이의 임의의 숫자를 생성하여 반환하는 메서드.

#### `public static List<Player> createPlayersArray(List<String> playersName)`

- 주어진 플레이어 이름 목록을 기반으로 플레이어 객체의 리스트를 생성하여 반환하는 메서드.

#### `public static Map<String, Integer> createPlayerDistanceMap(List<Player> playersArray)`

- 주어진 플레이어 리스트를 기반으로 플레이어의 이름과 이동 거리를 매핑한 맵을 생성하여 반환하는 메서드.

## 🛠️ StringUtils 클래스

`StringUtils` 클래스는 문자열과 관련된 유틸리티 메서드를 제공하는 클래스.

### 메서드

#### `public static String joinWithoutBlank(List<String> stringList)`

- 주어진 문자열 리스트를 쉼표로 구분하여 하나의 문자열로 결합하는 메서드(공백은 제외).

#### `public static String joinWithBlank(List<String> stringList)`

- 주어진 문자열 리스트를 쉼표와 공백으로 구분하여 하나의 문자열로 결합하는 메서드.

## 🛠️ MapUtils 클래스

`MapUtils` 클래스는 맵과 관련된 유틸리티 메서드를 제공하는 클래스.

### 메서드

#### `public static <K, V extends Comparable<? super V>> V getMaxValue(Map<K, V> map)`

- 주어진 맵에서 값이 가장 큰 요소의 값을 반환하는 메서드.

#### `public static <K, V> List<K> getKeysForValue(Map<K, V> map, V value)`

- 주어진 맵에서 특정 값에 대한 모든 키를 반환하는 메서드.
---
## **🌟 테스트 목록**
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
3. MapUtils Test
- [x] 주어진 Map의 최대 value추출하는지 확인
- [x] 최대 value를 가진 key를 추출하는지 확인 
4. Factory Test
- [x] 생성된 RandomDigit의 값이 0~9 확인 
- [x] List<String>playersName -> List<Player>player 변경 확인
- [x] LinkedHashMap이 입력순서를 보장했는지 확인
- [x] player와 distance가 잘 맵핑되었는지 확인