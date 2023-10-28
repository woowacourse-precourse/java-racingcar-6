## 구현할 게임의 로직
----

```
1. 게임 시작 시 '경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)' [출력]

2. 사용자로부터 자동차 이름들 입력받기 [입력]
    2-1. 입력값이 ','로 구분되어있는지 검증
    2-2. 구분자로 자른 후 빈 배열이 있는지 검증
    
3. '시도할 회수는 몇회인가요?' 문구 출력[출력]
    3-1. 입력값이 숫자로만 이루어져 있는지 검증
    
4. 횟수만큼 게임 진행
    4-1. 각각 자동차는 랜덤 주사위를 굴린다.
    4-2. 결과값이 4 이상이라면 전진한다.
    4-3. 전진했다면 점수를 부여받는다.
    4-4. 1회의 결과값을 출력한다 [출력]

5. 최종 우승자를 출력한다. [출력]
```

## 진행 과정

```
1. 사전값을 세팅
    - 자동차 이름 넣어달라는 메시지 출력
    - 값을 입력 받는다
    - 입력받은 값 검증 진행
    - 횟수를 정해달라는 메시지 출력
    - 값을 입력 받는다
    - 입력받은 값 검증 진행
    >> List<String>, int로 이 세팅값을 반환한다 -> 어케하누

2. 게임 진행
    - 자동차들의 이름을 가지고 점수판(Map<String, StringBuilder>)을 만든다
    - 1에서 입력받은 횟수만큼 라운드를 진행한다 
    - 각자 주사위를 굴린 후, 4 이상인지 확인한다.
    - 각자의 점수판에 기록한다
    - 점수판을 출력한다
  
3. 게임 종료 후 우승자 계산
    - 완성된 점수판을 순회하며 가장 긴 길이를 계산한다
    - 가장 긴 길이와 일치하는 자동차 명단을 작성한다
    - 우승자 명단을 출력한다
```

## 구현 기능 목록

### 게임 진행 기능

- RaceGame 클래스

- 게임 진행 기능
    - void gameStart()
- 점수판을 세팅하는 기능 v
    - Map<String, StringBuilder> makeScoreBoard(List<String> carName)
- 지정된 횟수만큼 게임을 진행하는 기능
    - 미완..
- 한 판의 게임을 진행하는 기능 v
    - void playOneRound(Map<String, StringBuilder> scoreBoard)
- 게임 종료 후 점수판을 계산하는 기능 v
    - int calculateForwardPoint(Map<String, StringBuilder> scoreBoard)
- 우승자 명단을 반환하는 기능 v경
    - List<String> findWinners(int maxPoint, Map<String, StringBuilder> scoreBoard)

### 입력 기능

- UserInput 클래스

- 유저로부터 입력받는 기능 v
    - String getUserInput()
- 자동차 이름을 입력받아 검증 후 필요 타입으로 반환하는 기능 v
    - List<String> getCarNames() v
- 게임 진행 횟수를 입력받아 검증 후 필요 타입으로 반환하는 기능
    - int getGameRound

### 검증 기능

- Validation 클래스

- 자동차 이름, 입력받은 횟수에 대한 검증

- 자동차 이름에 대한 통합 검증 v
    - List<String> validateCarNames(String input)
    - 자동차 이름에 공백이 포함된 경우 v
        - void validateWhiteSpace(String[] carNames)
    - 자동차들의 구분자가 지정된 구분자(',')가 아닐 경우 v
        - void validateDelimiterType(String[] carNames)
    - 자동차의 이름이 1 ~ 5자 사이가 아닐 경우 v
        - void validateNameLength(String[] carNames)
    - 중복된 자동차 이름이 있을 경우 v
        - void validateDuplicateName(int carNameCount, String[] carNames) {
- 입력받은 횟수에 대한 검증 v
    - 입력받은 횟수가 숫자가 아닐 경우 v
        - public int validateGameRound(String input) {

### 출력 기능

- Printer 클래스

- 자동차 이름 요구 메시지 출력 v
    - void printStartMessage()
- 시도 횟수 요청 메시지 출력 v
    - void printRequestRoundMessage()
- 실행 결과 메시지 출력 v
    - void printResultMessage()
- 하나의 라운드 결과값 출력 v
    - void printRoundResult(Map.Entry<String, StringBuilder> scoreBoard)
- 최종 우승자 출력 v
    - void printWinnersNames(List<String> winnerNames)

### 자동차 전진 관련 기능

- Engine 클래스

- 0 ~ 9 사이를 반환하는 기능 v
    - int makeRandomNumber(int min, int max)
- 굴린 주사위가 4 이상인지 판별하는 기능 v
    - boolean isMovable()
- 전진하는 기능 v
    - StringBuilder moveForward(StringBuilder beforeScore)