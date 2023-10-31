# Model
### Game : 한판 한판을 하나의 게임 객체로 다루는 클래스
- int gameTry : 게임 횟수
- Cars cars : Car 객체들을 모아놓은 VO
- List<Car> winners : 경주에서 승리한 Car 객체(들)을 저장
- proceed() : 게임 횟수만큼 경주
### Cars
- List<Car> cars
- compete() : cars 를 돌며 각 Car 객체들이 move() 를 호출
### Car
- CarName carName
- CarPosition carPosition
- move() : 만약 무작위 수가 4 이상이라면 Car.position 1 증가시키는 메서드
- canMove() : 무작위 수가 4 이상인지 판단하는 메서드
### CarName
- String value
### CarPosition
- int value


# View
### InputView
- inputCars() : 경주할 자동차 이름을 입력받는 메서드
- inputGameTry() : 경주를 시도할 횟수를 입력받는 메서드
### OutputView
- outputCarNameMessage() : "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
- outputGameTryMessage() : "시도할 회수는 몇회인가요?" 출력
- outputGameStartMessage() : "실행 결과" 출력
- outputEachStage() : "pobi : --", 각 게임의 결과를 출력
- outputGameResultMessage() : "최종 우승자 : ?,?,?" 출력



# Controller
### GameController : 게임을 진행하는 클래스
- beforeStartGame() : 사용자로부터 자동차 이름들, 게임 시도 횟수를 입력받고 게임 시작
- gameStart() : 게임 시작 메시지 출력
- gameProceed() : 자동차 경주 로직 실행
- gameOver() : 자동차 경주 결과 출력



# Validation
### 자동차 이름
- CarNameDuplicationException : 경주할 자동차 이름이 중복된 경우의 예외 클래스
- CarNameMaxLengthException : 경주할 자동차 이름이 문자열(한글 또는 영어)이 아닌 경우의 예외 클래스
- CarNameMinLengthException : 경주할 자동차 이름이 쉼표로 구분되지 않을 경우의 예외 클래스
- CarNameSpecialCharacterException : 경주할 자동차 이름의 크기가 5 초과할 경우의 예외 클래스
### 자동차 위치
- CarPositionRangeException : 자동차의 위치가 0 - 2,147,483,647 사이의 범위에서 벗어나는 경우의 예외 클래스
### 경주 횟수
- GameTryRangeException : 경주를 시도할 횟수가 0 - 2,147,483,647 사이의 범위에서 벗어나는 경우의 예외 클래스
### 무작위 수
- RandomNumberRangeException : 최소값(0) - 최대값(9)의 범위를 설정하고 그 범위 내의 무작위 수가 만들어지지 않을 경우의 예외 클래스



## Utils
### RandomNumberGenerator
- generateRandomNumber() : 최소값(0) - 최대값(9)의 범위를 설정하면 그 범위 내의 무작위 수를 만들어내는 유틸 클래스

