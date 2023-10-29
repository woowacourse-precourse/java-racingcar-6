# 기능 분석

## 제한 사항 분석

- 자동차는 전진할 수 있다.
    - 전진 조건은 0에서 9사이의 무작위 값이 4이상인 경우다.
- 자동차는 멈출 수 있다.
    - 멈춤 조건은 0에서 9사이의 무작위 값이 3이하인 경우다.
- 자동차의 이름은 5자 이하이다.
- 자동차의 이름은 쉼표(,)를 기준으로 구분한다.
- **자동차 이름은 중복되지 않는다. (추가 제한 사항)**
- **자동차 이름은 영문이다. (추가 제한 사항)**
- **차수별 자동차 움직임 순서는 입력한 자동차 이름 순서대로 진행한다. (추가 제한 사항)**
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 몇 번을 이동할 것인지 지정한다.
- **이동 횟수는 숫자로 입력한다. (추가 제한 사항)**
- **최소 이동 횟수는 1번이다. (추가 제한 사항)**
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료된다.

## 핵심 기능 분석

- 움직인다.

## 핵심 객체 분석

```markdown
- Car [ x ]
    - move
```

## 핵심 도메인, 역할 분석

- (자동차가) 전진한다. : move
- (자동차가) 멈춘다. : move

### 구현 중 추가된 사항 

처음 Car 도메인을 생각했을 때 Car만 필요할 것이라 생각하였지만

Car이 생성되는 시점과 Car이 움직이는 시점이 다른 문젝가 있어 OnRaceCar 추가

OnRaceCar의 경우 불변 객체로 위치가 변경되면 새로운 객체를 생성하여 관리하도록 설계


## 시스템 기능 분석

- 시작한다.
- 진행한다.
- 신호를 준다.
- 출력한다.
- 입력한다.
- 저장한다.
- 조회한다.

## 시스템 도메인 객체 분석

```markdown
- Game [ ]
    - start

- Round [ x ]
    - play

- Host [ x ]
    - signal

- Reader [ ]
    - read
    
- Viewer [ x ]
    - print

- Manager [ ]
    - save
    - find
```

## 시스템 도메인, 역할 분석

- (게임을) 시작한다. : start
- (라운드를) 진행한다. : play
- (호스트가) 자동차에게 시그럴을 준다. : signal
- (리더가) 이동 횟수를 입력받는다. : read
- (리더가) 자동차 이름을 입력받는다. : read
- (뷰어가) 게임 진행 가이드를 출력한다. : print
- (뷰어가) 차수 진행 결과를 출력한다. : print
- (뷰어가) 최종 우승자를 출력한다. : print
- (메니저가) 자동차를 저장한다. : save
- (메니저가) 자동차를 조회한다. : find
- (메니저가) 자동차 위치를 저장한다. : save
- (메니저가) 자동차 위치를 조회한다. : find

## 객체 결합 관계

```markdown
- Game
    - CarNameReader : Reader
    - TryCountReader : Reader
    - ConsoleViewer : Viewer
    - CarManager : Manager
    - CarPositionManager : Manager
    - Round
        - Host
        - Car
```

## 시나리오 분석

1. 게임을 시작한다.
2. 경주할 자동차 이름을 입력한다.
    - 자동차 이름을 저장한다.
3. 시도할 회수를 입력한다.
4. 차수를 진행한다.
    - 차수별 차 위치를 저장한다.
5. 차수별 결과를 출력한다.
6. 최종 우승자를 출력한다.
    - 가장 최신의 차 위치를 조회한다.

## 예외 분석

- IllegalArgumentException : 잘못된 값을 입력할 경우
    - 자동차 이름이 5자 이상인 경우 : `OverCarNameLengthLimitException`
    - 자동차 이름에 영문이 아닌 경우 : `InvalidCarNameTypeException`
    - 시도할 횟수가 1보다 작은 경우 : `LessThanTryCountMinException`
- RuntimeException : 시스템 동작중 예외
    - 자동차 이름 중복되는 경우 : `DuplicatedCarNameException`
    - 메니저에서 원하는 값을 찾지 못하는 경우 : `NotFoundSourceException`
    - 문자를 숫자로 변환하지 못하는 경우 : `InvalidNumberSourceException`

## 패키지 구조

```markdown
├── domain
│ // 도메인 패키지
│ ├── core
│ │ // 핵심 패키지 : 핵심 도메인을 위한 패키지
│ ├── system
│ │ // 시스템 패키지 : 시스템 도메인을 위한 패키지
│── exceptions
│ // 예외 패키지 : 예외 처리를 위한 패키지
├── initializer
│ // 초기화 패키지 : 게임 초기화를 위한 패키지
│── support
│ // 지원 패키지 : 도메인과 관련된 지원성 처리를 위한 패키지
│── utils
│ // 유틸 패키지 : 도메인과 관련 없는 유틸리티성 처리를 위한 패키지
└── Application.java
```
