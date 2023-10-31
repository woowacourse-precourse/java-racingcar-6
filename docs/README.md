# 🚀 구현 기능 목록

- **참가 자동차 설정**
    - 사용자로부터 참가할 자동차 이름 입력 받기
      - 자동차 이름이 5자를 넘어가면 예외 처리
      - 자동차 개수 범위 : 1~10 를 벗어나면 예외 처리

- **레이스 라운드 설정**
    - 사용자로부터 레이스 라운드(시도할 횟수) 입력 받기
      - 레이스 라운드가 숫자가 아니면 예외 처리
      - 레이스 개수 범위 : 1~100 를 벗어나면 에외 처리

- **랜덤 숫자 생성**
    - 0-9 사이의 랜덤한 숫자 생성

- **레이스 실행**
    - 생성된 랜덤 숫자가 4 이상이면 자동차 전진
    - 각 라운드별 참가자 자동차의 위치 정보 업데이트 및 출력
      - 자동차의 위치정보는 ("-")로 출력

- **우승자 결정**
    - 가장 멀리 이동한 자동차를 찾아 우승자로 선정
    - 우승자 이름 출력
      - 우승자가 여러 명이면 쉼표를 구분자로 해 모두 출력


## 📂 패키지 구조

```
racingcar
├── constants
│   └── Delimiters.java
│   └── ViewMessages.java
│   └── RacingcarConstants.java
│   └── ErrorMessage.java
├── controller
│   └── RaceController.java
├── exception
│   └── RacingCarException.java
├── model
│   └── Car.java
│   └── Race.java
├── service
│   └── CarFactoryService.java
│   └── RaceService.java
│   └── RandomNumberService.java
│   └── ValidationService.java
├── view
│   ├── InputView.java
│   └── ResultView.java
└── Application.java

```   


### constants
- `Delimiters` : 구분자를 정의한다.
- `RacingCarConstants`: 게임과 관련된 상수 값들을 정의한다.
- `ErrorMessages`: 예외 처리와 관련된 에러 메시지를 정의한다.
- `ViewMessages` : 출력 메시지를 정의한다.  



### controller
- `RaceController`
    - `startGame()`: 게임을 시작한다.
    - `getRaceInput()`: 사용자로부터 게임에 필요한 입력을 받는다.
    - `playRace()`: 레이스를 실행한다.
    - `endRace()`: 레이스 결과를 출력하고 게임을 종료한다.


### exception
- `RacingCarException`: `IllegalException`을 상속받으며 ErrorMessages 를 매개변수로 받아 에러 메시지를 출력

### model
- `Car`: 자동차의 이름과 위치를 저장한다.

- `Race`: 매 라운드에서 자동차의 움직임(전진)을 관리한다.


### service
- `RaceService`:
    - `executeRace(race: Race)`: 레이스를 실행합니다. 이 메서드에서 각 라운드별로 자동차의 이동을 관리
    - `findWinners(race: Race)`: 레이스의 우승자를 찾는다.


- `RandomNumberService`
    - `generateRandomNumber()`: 주어진 범위 내에서 랜덤한 숫자를 생성한다.


- `ValidationService`
    - `validateCarNames(names: List<String>)`: 입력 받은 자동차 이름의 유효성을 검사한다.
    - `validateCarsRange(cars: String)`: 입력 받은 자동차의 범위의 유효성을 검사한다.
    - `validateRoundType(round: String)`: 입력 받은 라운드 수가 int가 맞는지 검사한다.
    - `validateRoundRange(round: Int)`: 입력 받은 라운드 수의 범위의 유효성을 검사한다.

    
- `CarFactoryService` : List<String>을 List<Car>로 변환한다.


### view

- `InputView`
    - `getCarNames()`: 사용자로부터 자동차 이름을 입력 받는다.
    - `getRounds()`: 사용자로부터 라운드 수를 입력 받는다.


- `ResultView`
    - `printRoundResult(cars: List<Car>)`: 각 라운드별 레이스 결과를 출력한다.
    - `printWinners(winners: List<Car>)`: 레이스의 우승자를 출력한다.



# 🎯 프로그래밍 요구 사항
- **indent**
    - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.


- **3항 연산자**
    - 3항 연산자를 쓰지 않는다.


- **메서드 분리**
    - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.


- **테스트 코드**
    - JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.


# 🔍 피드백 반영
- git을 통해 관리할 자원에 대해서도 고려한다
    - `.class` 파일이나 `.idea`파일은 git에 올리지 않는다.


- 공백도 의미있게 작성한다.
    - 공백 라인을 의미 있게 사용하고, 문맥을 분리하는 부분에 사용한다.
    - Idea의 코드 자동 정렬 기능을 사용해 공백 컨벤션을 지키도록 한다.


- Java에서 제공하는 API를 적극 활용한다.
    -  직접 구현하는 것보다는 Java에서 제공해주는 것을 활용한다.


- 배열 대신 Java Collection을 사용한다
    - Java Collection 자료구조(List, Set, Map 등)를 사용하면 데이터를 조작할 때 직접 구현하기보다는 이 API를 활용한다.


- 커밋 메시지를 의미있게 하고, 커밋 메시지 컨벤션을 지킨다.