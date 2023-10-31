미션 - 자동차 경주
---

### 게임 흐름

게임 흐름은 다음과 같이 요약됩니다:

1. 사용자는 자동차 이름(쉼표로 구분) 및 시도 횟수를 입력하도록 안내됩니다.
2. 게임이 진행되며 자동차는 임계값을 기반으로 무작위로 이동합니다.
3. 게임은 가장 먼 위치에 있는 우승자(들)를 발표합니다.

주요 상호작용은 `Application`, `GameController`, `GameService` 및 `Game` 클래스 간에 발생하며 메시지 처리는 `MessageFactory` 및 `MessageProcessor` 클래스에 의해 제공됩니다.

이 프로그램은 입력과 출력을 위한 간단한 콘솔 인터페이스를 사용하며, 레이스 자체에 대한 시각적인 요소는 포함하지 않습니다. 그 대신 자동차 레이스의 로직을 시뮬레이션하는 데 중점을 둡니다.

### 구현할 기능 목록

1. **Car 클래스**
    - 자동차의 이름을 유효성 검사하고, 이름은 1자 이상, 5자 이하로 제한한다.
    - 자동차의 이름을 반환하는 `getName()` 메서드를 구현한다.
    - 자동차의 현재 위치를 반환하는 `getPosition()` 메서드를 구현한다.
    - 자동차의 현재 위치를 표현하는 문자열을 반환하는 `getMoveResult()` 메서드를 구현한다.
    - 자동차를 전진시키는 `move(int move)` 메서드를 구현한다. `move` 값이 임계값 이상일 경우에만 전진한다.

2. **Game 클래스**
    - 게임을 진행하기 위해 자동차 목록, 시도 횟수, 메시지 프로세서, 랜덤 넘버 생성기를 초기화한다.
    - 시도 횟수가 0 이하인 경우 예외를 발생시킨다.
    - 게임을 진행하는 `play()` 메서드를 구현한다.
    - 한 라운드를 진행하는 `playOneRound(StringBuilder result)` 메서드를 구현한다.
    - 우승자를 찾는 `getWinners()` 메서드를 구현한다.
    - 최대 위치를 반환하는 `getMaxPosition()` 메서드를 구현한다.
    - 우승자를 찾아 리스트로 반환하는 `findWinners(int maxPosition)` 메서드를 구현한다.
    - 특정 자동차가 우승자인지 확인하는 `isWinner(Car car, int maxPosition)` 메서드를 구현한다.

3. **GameService 클래스**
    - 메시지 프로세서와 랜덤 넘버 생성기를 초기화한다.
    - 사용자로부터 입력받은 문자열을 받아 자동차 목록을 생성하는 `createCars(String input)` 메서드를 구현한다.
    - 자동차 목록과 시도 횟수를 받아 게임을 진행하는 `playGame(List<Car> cars, int tryCount)` 메서드를 구현한다.

4. **GameController 클래스**
    - 메시지 프로세서와 게임 서비스를 초기화한다.
    - 게임을 실행하는 `runGame()` 메서드를 구현한다.
    - 사용자로부터 자동차 이름과 시도 횟수를 입력받고, 게임을 실행한다.
    - 자동차 이름을 받아 자동차 목록을 생성하는 `createCars(String input)` 메서트를 구현한다.
    - 자동차 목록과 시도 횟수를 받아 게임을 진행하는 `playGame(List<Car> cars, int tryCount)` 메서드를 구현한다.

5. **RandomsWrapper 클래스**
    - `RandomNumberGenerator` 인터페이스를 구현하며, `GameRange`에서 정의한 범위를 이용하여 난수를 발생시킨다.

6. **MessageFactory 클래스**
    - 게임 메시지와 예외 메시지를 관리한다.

7. **MessageProcessor 클래스**
    - 콘솔 출력과 입력을 처리하는 메서드를 제공한다.

8. **CarNameLength, GameRange, MoveThreshold 열거형**
    - 각각 자동차 이름 길이, 게임 범위, 이동 임계값을 관리한다.

9. **Application 클래스**
    - 프로그램의 진입점인 `main` 메서드가 있다. 게임 컨트롤러를 생성하고 게임을 실행하는 역할을 한다.

---