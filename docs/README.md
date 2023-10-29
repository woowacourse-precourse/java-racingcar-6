## 구현할 게임의 로직

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

## 세부 진행 과정

```
1. 사전값을 세팅
    - 자동차 이름 넣어달라는 메시지 출력
    - 값을 입력 받는다
    - 입력받은 값 검증 진행
    - 횟수를 정해달라는 메시지 출력
    - 값을 입력 받는다
    - 입력받은 값 검증 진행
    - 자동차들의 이름을 가지고 점수판(Map<String, StringBuilder>)을 만든다

2. 게임 진행
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

----

### 게임 진행 관련 기능

- RaceInfo 클래스
    - 사전값 세팅
        - [x] 점수판을 만드는 기능
            - Map<String, StringBuilder> makeScoreBoard(List<String> carNames)

- RaceProcess 클래스
    - 게임 진행 과정
        - [x] 한 판의 게임을 진행하는 기능
            - void oneRound(Map<String, StringBuilder> scoreBoard)
        - [x] 전진 가능한지 판별하는 기능
            - int isMovable()

- RaceResult 클래스
    - 게임 종료 후 우승자 선발
        - [x] 가장 많은 전진 포인트를 계산하는 기능
            - int calculateForwardPoint(Map<String, StringBuilder> scoreResult)
        - [x] 우승자를 발표하는 기능
            - List<String> findWinners(int maxPoint, Map<String, StringBuilder> scoreResult)

### 입력 기능

- UserInput 클래스

- [x] 유저로부터 입력받는 기능
    - String getUserInput()
- [x] 자동차 이름을 입력받아 검증 후 필요 타입으로 반환하는 기능 v
    - List<String> getCarNames()
- [x] 게임 진행 횟수를 입력받아 검증 후 필요 타입으로 반환하는 기능
    - int getGameRound

### 검증 기능

- Validation 클래스

- 자동차 이름, 입력받은 횟수에 대한 검증

- 자동차 이름에 대한 통합 검증
    - List<String> validateCarNames(String input)
    - [x] 자동차 이름에 공백이 포함된 경우
        - void validateWhiteSpace(String[] carNames)
    - [x] 자동차들의 구분자가 지정된 구분자(',')가 아닐 경우
        - void validateDelimiterType(String[] carNames)
    - [x] 자동차의 이름이 1 ~ 5자 사이가 아닐 경우
        - void validateNameLength(String[] carNames)
    - [x] 중복된 자동차 이름이 있을 경우
        - void validateDuplicateName(int carNameCount, String[] carNames) {
- 입력받은 횟수에 대한 검증
    - [x] 입력받은 횟수가 숫자가 아닐 경우
        - int validateGameRound(String input)
    - [ ] 라운드 횟수를 입력하지 않았을 경우
        - void validateBlankRound(String input)

### 출력 기능

- Printer 클래스

- [x] 자동차 이름 요구 메시지 출력
    - void printStartMessage()
- [x] 시도 횟수 요청 메시지 출력
    - void printRequestRoundMessage()
- [x] 실행 결과 메시지 출력
    - void printResultMessage()
- [x] 하나의 라운드 결과값 출력
    - void printRoundResult(Map.Entry<String, StringBuilder> scoreBoard)
- [x] 최종 우승자 출력
    - void printWinnersNames(List<String> winnerNames)