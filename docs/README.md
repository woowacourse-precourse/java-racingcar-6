## 구현 기능 목록

### ✅ 레이싱 자동차 이름 입력
- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
- [x] 자동차 이름 입력 받기

### ✅ 레이스 시도 회수 입력
- [x] "시도할 회수는 몇회인가요?" 출력
- [x] 횟수 입력 받기

### ✅ 레이싱 자동차 생성
- [x] 자동차 이름 생성하기
- [x] [예외] 입력이 없는 경우
- [x] [예외] 입력에 영어문자,',' 외에 다른 것이 들어온 경우
- [x] [예외] 자동차 이름 길이가 0인 경우
- [x] [예외] 자동차 이름 길이가 5자를 넘는 경우
- [x] [예외] 중복된 이름이 있는 경우
- [x] 자동차 전진 함수 생성하기
- [x] 무작위 값이 4 이상일 경우 이동거리 + 1
- [x] 자동차 전진 결과 생성하기

### ✅ 레이싱 게임 생성
- [x] 자동차 목록 생성하기
- [x] [예외] 자동차 목록에 공백이 존재하는 경우
- [x] [예외] 중복된 자동차 이름이 존재하는 경우
- [x] 자동차 목록으로 자동차 생성하기
- [x] 레이싱 게임 횟수 생성하기
- [x] [예외] 입력이 없는 경우
- [x] [예외] 입력에 숫자 외에 다른 것이 들어온 경우
- [x] [예외] 입력이 0인 경우
- [x] 레이스 시도 횟수 입력을 정수로 저장
- [x] 0에서 9 사이에서 무작위 값을 구하기
- [x] 레이스 실행하기
- [x] 모든 레이스 실행하기
- [x] 모든 자동차 라운드 결과 알려주는 함수 생성하기
- [x] 우승자 목록 알려주는 함수 생성하기

### ✅ 레이싱 게임 실행
#### 1. 레이스 준비
- [x] 자동차 목록 생성
- [x] 자동차 생성
- [x] 레이스 라운드 생성

#### 2. 레이스 진행
- [x] 레이스 라운드 반복 진행
- [x] 자동차 전진시키기
- [x] 각 레이스의 자동차 결과 저장
- [x] 모든 레이싱 결과 출력

#### 3. 레이스 결과
- [x] 우승자 목록 생성
- [x] 우승자 목록 출력
- [x] 우승자가 한명일 경우 그대로 출력
- [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분해 출력

## MVC의 class 및 세부 method

### 1. Controller
1) RacingGameController
- void readeToPlay() : 레이스 시작 전 플레이어의 입력을 받아, 게임 사전 준비하는 메서드
- void play() : 입력받은 레이스 횟수 만큼, 레이스를 실행하고 그 결과를 출력하고, 우승자를 출력

### 2.Model
#### 1) RacingCar
- RacingCar() : 자동차 이름을 받아, 차를 생성하고, 이동 횟수를 0으로 초기화 하는 생성자
- void move() : 파리미터의 숫자가 이동 범위 이상일 경우, 이동 횟수를 증가시킴
- String getRacingCarName() : 맴버 변수로 가지고 있는 자동차 이름을 반환
- int getMoveCount() : 맴버 변수로 가지고 있는 이동 횟수를 반환
- void validateNotContainCarName() : 자동차 이름 목록에 자동차 이름이 없거나, 구분자만 존재있는지에 대한 검수 [예외처리]
- void validateAlphaCarName() : 자동차 이름 목록이 영어로만 구성되어있는지에 대한 검수 [예외처리]
- void validateCarNameLength() : 자동차 이름 목록의 개별 이름 길이에 대한 검수 [예외처리]

#### 2) RacingGame
- void readyToCars() : 자동차 이름 목록을 받아, 유효성 검사와 자동차를 생성
- void readyToRace() : 레이스 실행할 횟수를 받아, 유효성 검사와 맴버 변수로 저장
- void round() : 이동 숫자를 생성하고, 이동하는 레이스 한 라운드를 실행
- void race() : 레이스 실행 횟수 만큼, round() 함수 실행하고, 라운드 마다의 결과를 저장하여 총 레이스 결과를 반환
- List<String> findWinners() : 자동자 목록에서 각각 이동 횟수를 구하고, 최대값 비교를 통해 우승자를 찾아 반환
- int generateMovableNumber() : 지정한 범위에서 랜덤한 숫자를 반환
- String getWinner() : 우승자 목록을 출력 형식에 맞추어 반환
- List<RacingCar> getRacingCars() : 맴버 변수인 자동차 목록을 반환
- void validateContainSpace() : 자동차 이름 목록에 공백이 포함되어 있는지에 대한 검수 [예외처리]
- void validateDuplicateCarNames() : 자동차 이름 목록의 중복된 이름이 있는지에 대한 검수 [예외처리]
- void validateDigitRaceCount() : 레이스 실행 횟수가 숫자로만 구성되어있는지에 대한 검수 [예외처리]
- void validateEmptyRaceCount() : 레이스 실행 횟수를 입력하지 않았는지에 대한 검수 [예외처리]
- int convertStringToIntRaceCount() : 레이스 실행 횟수가 0일 경우 [예외처리], 인트형으로 변경 후 반환
- List<String> convertStringToListCarNames() : 유효성 검사가 완료된 자동차 이름 목록을 리스트로 변경 후 반환

### 3.View
#### 1) RacingGameView
- void raceStartMessage() : 레이싱 게임 시작에 필요한 입력값을 요구하는 문구 출력
- void raceCountMessage() : 레이스 횟수 입력값을 요구하는 문구 출력
- void raceResults() : 레이스 결과를 출력
- void gameWinners() : 레이스 우승자를 출력
- void raceResults() : 레이스의 결과를 출력
- String convertScoreToString() : 스코어를 알맞은 형식으로 변환
- String convertMoverCountToString() : 자동차 움직인 횟수를 알맞은 형식으로 변환

### 4.utils
#### 1) RacingGameMessage : Enum class
- 레이싱 게임에 관련된 문구를 enum으로 선언
    
      START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

      REQUEST_TRY_MESSAGE("시도할 회수는 몇회인가요?"),

      GAME_RESULT_MESSAGE("실행 결과"),

      WINNER_MESSAGE("최종 우승자 : "),

      NEWLINE("\n"),

      MOVE("-");

- String getStartMessage() : 게임 시작 문구 반환
- String getRequestRaceCountMessage() : 레이스 실행 횟수 문구 반환
- String getGameResultMessage(String raceResult) : 게임 결과를 출력 형식에 맞게 설정 후 반환
- String getWinnerMessage(String winners) : 우승자 목록을 출력 형식에 맞춰 반환
- String getNewLine() : 개행 반환
- String getMoveMessage() : 이동에 관한 문구 반환

#### 2) ErrorMessage : enum class
- 에러 메시지에 관한 문구를 enum으로 선언

      SPACE_ERROR("자동차 이름 구분은 ','로 하셔야합니다"),
    
      NO_NAME_ERROR("레이싱 자동차 이름이 없습니다"),
    
      ALPHA_NAME_ERROR("레이싱 자동차 이름은 영어만 허용됩니다"),
    
      NAME_LENGTH_ERROR("자동차 이름 길이는 5이하 입니다"),
    
      DUPLICATED_NAME_ERROR("중복된 자동차 이름이 있습니다"),
    
      DIGIT_RACE_COUNT_ERROR("숫자만 입력해주시길 바랍니다"),
    
      EMPTY_RACE_COUNT_ERROR("레이스 횟수를 입력하시길 바랍니다"),
    
      ZERO_RACE_COUNT_ERROR("레이스 시도 횟수는 1 이상입니다");

- String getDelimiterError() : 공백 포함 오류 대한 문구 반환
- String getNoCarsNameError() : 자동차 이름이 없는 오류에 대한 문구 반환
- String getAlphaCarNameError() : 자동차 이름이 영어가 아닌 오류에 대한 문구 반환
- String getCarNameLengthError() : 자동차 이름 길이 오류에 대한 문구 반환
- String getDuplicatedCarNamesError() : 자동차 이름 중복 오류에 대한 문구 반환
- String getDigitRaceCountError() : 레이스 실행 횟수가 숫자로만 구성되지 않은 오류에 대한 문구 반환
- String getEmptyRaceCountError() : 레이스 실행 횟수가 없는 오류에 대한 문구 반환