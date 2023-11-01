# 자동차 경주 게임 (Racing Car Game)

## 코드 구조

```
.
├── README.md
├── build
├── build.gradle
├── docs
│ └── README.md
├── gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
├── main
│ └── java
│   └── racingcar
│       ├── Application.java
│       ├── Car.java
│       └── Race.java
└── test
└── java
├── racingcar
│ └── ApplicationTest.java
└── study
└── StringTest.java
```

- `Application.java`: 사용자 입력을 처리하고 게임을 시작하는 엔트리 포인트입니다.
- `Car.java`: 자동차의 상태와 움직임을 나타내는 클래스입니다.
- `Race.java`: 자동차 경주를 관리하고 경주 결과를 표시하는 클래스입니다.

## 주요 함수

### `Application.java`

- `main(String[] args)`: 애플리케이션의 진입점입니다. 사용자 입력을 받고 경주 게임을 시작합니다.

### `Car.java`

- `Car(String name)`: 자동차의 이름을 인수로 받아 초기화하는 생성자입니다.
- `getName()`: 자동차의 이름을 반환합니다.
- `move()`: 무작위로 생성된 숫자에 따라 자동차를 전진시킵니다.
- `getPosition()`: 현재 자동차의 위치를 반환합니다.

### `Race.java`

- `Race(String[] carNames, int count)`: 자동차의 이름 배열과 시도할 회수를 인수로 받아 초기화하는 생성자입니다.
- `startRace()`: 경주를 시작하고, 각 이동의 결과를 표시합니다.
- `printStatus(Car car)`: 자동차의 이름과 위치를 표시하는 메서드입니다.
- `getWinners()`: 경주가 종료된 후, 우승한 자동차(들)의 이름을 반환합니다.
