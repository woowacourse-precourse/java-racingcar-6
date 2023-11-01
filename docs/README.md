# 📝 시나리오 및 구현할 기능 목록

> 시나리오를 설명하고 구현할 기능을 설명하는 페이지입니다.
>

## 📕 시나리오

1. 사용자가 자동차 이름들과 시도할 회수를 입력한다.
2. 입력된 자동차 이름과 시도할 회수에 따라 자동차 경주 게임을 진행한다.
3. 각 차수마다 자동차들이 전진 또는 멈춘 결과를 출력한다.
4. 모든 차수의 경주가 종료되면 우승자를 출력한다.
5. 프로그램을 종료한다.

## ✅ 기능 목록

### 입력

- [x]  사용자 자동차 이름 입력
- [x]  사용자 시도할 횟수 입력

### 자동차 경주

- [x]  자동차 객체 생성
    - [x]  자동차 이동 구현
        - [x]  횟수 입력할 경우 전진 (전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.)
        - [x]  전진 횟수 카운트
- [x] 라운드별 car의 이름과 포지션을 갖는 Cars 객체 생성

### 스코어

- [x]  전진 횟수 가장 큰 우승자 반환

### 출력

- [x]  각 차수별 실행 결과 반환
- [x] 우승자 안내문구
    - [x]  단독 우승자 안내 문구
    - [x]  공동 우승자가 있는 경우 쉼표를 이용하여 구분.

### 검증

- [x]  자동차 이름은 5자 이하만 출력 가능하게 하기
- [x]  자동차 생성 시 2대 이상으로 생성

## 🛠️ 클래스 설명

### **Controller**

`GameController` 클래스

- `runGame()`: 게임을 실행하는 메서드. 게임 초기화, 라운드 진행, 우승자 출력을 담당
- `initializeGame()`: 게임 시작 전, 사용자 입력을 받아 자동차 목록 초기화
- `determineWinners()`: 레이스에서 최종 우승자를 결정하는 메서드. 우승한 차량 이름 목록을 반환
- `getMaxPosition()`: 레이스에서 가장 멀리 이동한 차량의 위치를 반환하는 메서드
- `showWinners()`: 레이스에서 우승한 차량 목록을 출력
- `createCars(List<String> carNames)`: 사용자 입력으로부터 받은 자동차 이름 목록을 `Car` 객체로 생성하여 자동차 목록을 반환

 `Round` 클래스

- `play()`: 라운드를 실행하고 차량의 이동 상황을 출력

### Domain

 `Car` 클래스

- **`Car(String carName)`**: 자동차의 이름을 인자로 받아 초기화하는 생성자
- **`Car(String carName, int position)`**: 자동차의 이름과 초기 위치를 인자로 받아 초기화하는 생성자
- **`moveForward()`**: 자동차를 전진시키는 메서드로, 0부터 9 사이의 랜덤한 값을 추출하고, 추출된 값이 4 이상일 때 위치를 1만큼 증가시킴
- **`getPosition()`**: 현재 자동차의 위치를 반환하는 메서드
- **`getCarName()`**: 자동차의 이름을 반환하는 메서드

 `Cars` 클래스

- `cars`: `Car` 객체들의 목록을 저장하는 리스트
- `public Cars(List<Car> cars)`: `Car` 객체들의 목록을 입력받아 `cars` 리스트를 초기화하는 생성자
- `public List<String> getCarNames()`: 현재 자동차들의 이름 목록을 가져옴
- `public List<Integer> getCarPositions()`: 현재 자동차들의 위치 목록을 가져와 각 자동차의 `getPosition()` 메서드를 호출하여 위치를 추출하고, 추출된 위치들을 리스트에 저장하여 반환
- `public void moveCars()`: 모든 자동차를 전진시킵니다. 각 자동차의 `moveForward()` 메서드를 호출하여 전진시킴

### View

 `Input` 클래스

- `inputCarNames()`: 사용자로부터 자동차 이름을 입력받는 메서드
- `inputTryCount()`: 사용자로부터 시도할 회수를 입력받는 메서드

 `Output` 클래스

- `printCurrentPositions(List<String> carNames, List<Integer> carPositions)`: 현재 자동차들의 위치를 출력하는 메서드
- `printFinalWinners(List<String> winnerNames)`: 최종 우승자를 출력하는 메서드

### utils

 `ValidationUtils` 클래스

- `validateCarNames(String carNames)`: 자동차 이름을 검증하는 메서드, 각 이름의 길이가 5를 초과하는지 확인
- `validateUserInput(String userInput)`: 사용자 입력값을 검증하는 메서드. 입력이 숫자로만 이루어져 있는지 확인