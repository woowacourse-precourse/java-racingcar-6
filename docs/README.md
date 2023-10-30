# 자동차 경주 게임

## 기능 목록

- [x] 사용자 이름을 `,`로 구분하여 입력받는다. - `InputView.requestCarNames()`
  - [x] 이름이 5자리 이상인 경우 예외 발생 - `CarNameRequest.validateNameSize()`
- [x] 게임 진행 횟수를 입력받는다. - `InputView.requestTotalRoundCount()`
  - [x] 입력값이 숫자가 아닌 경우 예외 발생 - `InputView.validateNumeric()`
  - [x] 자연수가 아닌 경우 예외 발생 - `TotalRoundNumberRequest.validateRoundCount()`
- [x] 1부터 9까지의 수를 생성 후 4 이상이면 자동차를 전진시킨다. - `Car.move()`
- [x] 라운드마다 모든 자동차들의 움직인 거리를 출력한다. - `OutputView.printCurrentProgress()`
- [x] 입력받은 수만큼 게임을 진행 후 최종 우승 결과를 출력한다.
  - [x] 공동 우승 시 입력순으로 `,`로 구분하여 자동차 이름을 출력한다.

## 기능 요구 사항

자동차들은 매 시행마다 1부터 9까지 랜덤한 수를 통해 4 이상이면 전진하여 가장 많은 거리를 이동하면 우승하는 게임이다.

자동차마다 독립적으로 1부터 9까지 수를 생성하며, 4 이상인 경우 1칸 전진하고 그외엔 움직이지 않는다.
매 시행마다 모든 자동차의 움직인 거리가 출력되어 게임 진행상황을 파악할 수 있다.

게임이 끝난 후 이동한 거리가 같으면 공동 우승으로 간주한다.

e.g. 자동차 이름이 `kim,lee`이고 진행 횟수가 3인 경우
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
kim,lee
시도할 횟수는 몇회인가요?
3

실행 결과
kim : -
lee : 

kim : -
lee : -

kim : -
lee : -

최종 우승자 : kim, lee
```

## 패키지 구조
```
├── config
│   └── GameConfig.java
├── controller
│   └── GameManagerController.java
├── domain
│   ├── Car.java
│   └── Cars.java
├── dto
│   └── request
│       ├── CarNameRequest.java
│       └── TotalRoundNumberRequest.java
├── exception
│   ├── UserInputException.java
│   └── errorcode
│       └── UserInputErrorCode.java
└── view
    ├── InputView.java
    ├── OutputView.java
    └── message
        └── GameMessage.java
```

__config__
- `GameConfig.java` : 게임 관련 설정 값들을 상수로 가지고 있는 클래스

__controller__
- `GameManagerController.java` : 요청에 따라 적절한 입/출력, 비지니스 로직을 호출하는 클래스

__domain__
- `Car.java`
  - 자동차 이름/거리를 저장하고 1부터 9사이 랜덤 수를 발생시켜 자동차 전진을 수행
- `Cars.java`
  - `List<Car>`필드를 가지는 일급 컬렉션
  - 리스트의 불변성을 보장하고 중복 검증, 우승자 이름, `Car` 객체 필드(이름, 거리)에 대한 Getter 메소드를 제공한다.

__dto__
- `CarNameRequest.java` 
  - 입력받은 자동차 이름을 저장하는 DTO 클래스
  - 입력받은 이름의 길이를 검증
- `TotalRoundNumberRequest.java`
  - 입력받은 게임 진행 횟수를 저장하는 DTO 클래스 
  - 라운드 수가 1 이상인지 검증

__exception__
- `UserInputException.java`
  - 입력값이 잘못된 경우 발생하는 예외 클래스
  - `IllegalArgumentException.java` 을 상속
  - `UserInputErrorCode.java` 열거체를 필드로 가진다.
- `UserInputErrorCode.java`
  - 예외 메시지를 담는 열거체

__view__
- `InputView.java`
  - 자동차 이름, 진행 횟수를 입력받는 클래스
  - 입력값이 공백인지 여부를 검증
  - 진행 횟수를 입력받을 때 숫자 여부를 검증
- `OutputView.java`
  - 입력 전 질문 내용, 게임 진행 결과를 출력하는 클래스 