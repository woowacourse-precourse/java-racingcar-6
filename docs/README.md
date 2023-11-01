## 레이싱 게임 기능 명세서
**클래스 - 메서드 순서로 기능 명세서를 작성했습니다.**

## Application
### main
- [x] InputView, RacingService, OutputView를 인스턴스화 한 뒤, RacingController에게 인자로 전달한다.
- [x] racingController의 객체를 이용해 run 메서드를 실행시킨다.

## RacingController
### RacingController(생성자)
- [x] InputView, RacingService, OutputView의 인스턴스를 받은 뒤, 객체 의존성을 주입한다.

### run
- [x] racingGameStart 메서드 호출한다.

### racingGameStart
- [x] getCarNames로부터 문자열 리스트를 받는다.
- [x] Cars 클래스의 생성자를 통해 문자열 리스트를 전달한다.
- [x] getTries로부터 정수 형태로 게임 실행 횟수를 받는다.
- [x] racingGame 메서드에 인자로 cars, tries를 전달한다.

### getCarNames
- [x] ConsoleOutput의 displayGetCarNameMessage 정적 메서드를 활용해 문자열 출력
- [x] inputView 클래스의 getCarNames 메서드를 통해 문자열을 받는다.
- [x] racingService의 stringToList 메서드에 인자로 문자열을 전달하고 문자열 리스트를 받는다.
- [x] InputValidator의 isLengthGreaterThanFive 정적 메서드에 문자열 리스트를 보내 검증 받는다.
- [x] 문자열을 반환한다.

### getTriew
- [x] ConsoleOutput의 displayTryMessage 정적 메서드를 활용해 문자열 출력
- [x] inputView 클래스의 getTries 메서드를 통해 정수를 받는다.
- [x] InputValidator의 isGreaterThanZero 정적 메서드에 정수를 보내 검증 받는다.
- [x] ConsoleOutput의 printNewLine 정적 메서드를 활용해 줄바꿈 한다.

### racingGame
- [x] 매개변수로 Cars의 객체와 실행 횟수를 정수로 받는다.
- [x] ConsoleOutput의 displayRaceResultMessage 정적 메서드를 활용해 문자열 출력
- [x] 실행 횟수 만큼 IntStream.range의 foreach를 활용해 cars의 playGame 메서드 실행을 반복한다.
- [x] outputView에게 cars의 getWinner를 통해 받은 GameResultDto를 전달한다.

## Car
### Car(생성자)
- [x] 이름을 받아서 Car 객체를 생성하고, 이름을 멤버 변수에 할당한다.

### moveCar
- [x] 자동차를 한 칸 앞으로 이동시킨다.

### nameAndLocation
- [x] 자동차의 이름과 현재 위치를 포함하는 RoundResultDto 객체를 반환한다.

### isSameLocation
- [x] 다른 위치와 현재 위치를 비교하여 같으면 true, 다르면 false를 반환한다.

### name
- [x] 자동차의 이름을 반환한다.

### location
- [x] 자동차의 현재 위치를 반환한다.

## Cars
### Cars(생성자)
- [x] 문자열 리스트를 받은 뒤, 각 문자열을 Car 객체로 변환하여 리스트로 저장한다.

### playGame
- [x] for 반복문을 사용해 Car 객체마다 checkNumberAndMoveCar, printCarInfo 메서드를 실행시킨다.
- [x] ConsoleOutput의 printNewLine 정적 메서드를 활용해 줄바꿈 한다.

### checkNumberAndMoveCar
- [x] Computer 클래스의 createRandomNumber 정적 메소드를 호출해 정수를 반환 받는다.
- [x] if 문과 checkNumberOverThree 메서드를 통해 정수를 검증하고, 특정한 상황에 car 클래스의 moveCar 메서드를 호출한다.

### checkNumberOverThree
- [x] 주어진 숫자가 3보다 큰지 검사하고, boolean 자료형으로 반환한다.

### printCarInfo
- [x] OutputView 클래스를 필드 주입으로 초기화 한다.
- [x] outputView 클래스의 printRoundResult 메서드를 호출하고 car 클래스의 nameAndLocation 메서드의 실행 값을 인자로 보낸다.

### getWinner
- [x] 이 게임의 우승자를 결정하고, 이들의 이름을 가진 GameResultDto를 반환한다.

### getMaxLocation
- [x] 자동차들 중 최대 위치를 찾아 반환한다.

### getWinners
- [x] 최대 위치와 같은 위치에 있는 자동차들의 이름을 찾아 리스트로 반환한다.

## Computer
### createRandomNumber
- [x] 0부터 9 사이의 무작위 정수를 생성하고 반환한다.

## RacingService
### stringToList
- [x] 쉼표로 구분된 문자열을 받아서 문자열 리스트로 변환한다.

## ExceptionHandler
### throwIfStringLengthOverFive
- [x] 예외를 발생시키며, 메시지 "자동차 이름의 길이는 5를 넘어가면 안됩니다."를 포함한 IllegalArgumentException을 던진다.

### throwIfNumberIsZeroOrNegative
- [x] 예외를 발생시키며, 메시지 "횟수는 0보다 커야합니다."를 포함한 IllegalArgumentException을 던진다.

### throwIfCarNotFound
- [x] IllegalArgumentException을 생성하여 반환하며, 메시지 "자동차가 존재하지 않습니다."를 포함한다.

## InputValidator
### isLengthGreaterThanFive
- [x] 문자열 리스트를 받아, 리스트 내의 문자열 중 하나라도 길이가 5보다 크면, ExceptionHandler를 사용하여 예외를 발생시킨다.

### isGreaterThanZero
- [x] 정수를 받아, 정수가 0보다 작거나 같으면, ExceptionHandler를 사용하여 예외를 발생시킨다.

## ConsoleOutput
### displayGetCarNameMessage
- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 메시지를 출력한다.

### displayTryMessage
- [x] "시도할 회수는 몇회인가요?" 메시지를 출력한다.

### displayRaceResultMessage
- [x] "실행 결과" 메시지를 출력한다.

### printNewLine
- [x] 빈 줄을 출력하여 화면에 줄바꿈을 추가한다.

## InputView
### getCarNames
- [x] 사용자로부터 자동차 이름을 입력받아 문자열로 반환한다.

### getTries
- [x] 사용자로부터 시도할 횟수를 입력받아 정수로 반환한다.

## OutputView
### printRoundResult
- [x] 라운드 결과 정보인 RoundResultDto를 받아서 화면에 출력한다.
- [x] 출력 형식은 "자동차 이름 : 위치(이동 횟수만큼 '-' 표시)"이다.

### printGameResult
- [x] 게임 결과 정보인 GameResultDto를 받아서 화면에 출력한다.
- [x] 출력 형식은 "최종 우승자 : 우승자 이름 목록"이다.
- [x] 우승자 이름 목록은 쉼표로 구분하여 표시한다.

### printOneStepPosition
- [x] 주어진 위치에 해당하는 이동 횟수만큼 '-' 문자열을 생성하고 반환한다.

### joinNames
- [x] 문자열 리스트를 받아 쉼표와 공백으로 구분된 문자열로 반환한다.

