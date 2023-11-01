## Domain: 자동차 객체

| 접근 제어자 | 타입    | 이름      | 기타                |
| ----------- | ------- | --------- | ------------------- |
| private     | String  | name     | 자동차 이름 (5자 이하) |
| private     | boolean | runnable | 전진하고 있냐 멈췄냐   |
|            |         |          | 전진 조건: 0-9 사이의 무작위 값 중 4 이상 |
| private     | String  | distance | 한 번 전진할 때마다 -가 늘음.  |

- 밖에서 알 수 없게 private로 지정했다.

## Factory: Car 객체를 생성하는 팩토리

자동차 객체를 생성하는 클래스이다.

- 디자인 패턴 중, 간단한 팩토리 메서드 패턴을 이용해서 만들었다.

### 기능

**생성자**에서 쉼표로 구분한 자동차들의 이름을 가지고 객체를 생성한다.

## Service: 자동차 경주 게임 서비스

`RacingGameService`

- 자동차 객체를 생성해서 경주 게임을 실행시키는 서비스이다.
- Start() 함수에서 모든 것이 진행되게 만들었다.
- 사용자의 입력 후,
    
    createRacingCar();
    racingStart();
    

  함수를 실행시켜서 클라이언트는 Start() 함수만 실행시키면 경기가 진행된다.


### 기능

1. 사용자에게 자동차의 이름과 실행 횟수를 입력받는다.
    - `start()` 함수 사용
    - **잘못 입력할 경우**: `IllegalArgumentException` 발생
        - 자동차 이름을 쉼표로 구별하지 않은 경우
        - 자동차 이름 크기가 5가 넘은 경우→ `checkError()` 함수
2. 입력받은 이름을 가지고 RacingCarfactory의 createCar 함수를 이용해 객체를 생성한다.
    - `createRacingCar()` 함수
3. 객체마다 랜덤 넘버를 생성한 뒤, 5 이상의 객체만 달릴 수 있게 boolean type을 지정한다.
    - `runnableCheck()` 함수
4. 각 레이싱 카의 boolean runnable에 맞춰 true인 것만 전진시킨다. 이때, 처음에 입력받았던 전진 횟수에 맞춰 반복한다.
    - `racingStart()` 함수
5. 각 객체의 전진 길이 중 가장 큰 것을 골라 우승자를 가린다.
    - `caculateScore()` 함수
    - 출력 함수: `printGame()`함수

## Application


RacingCarService racingCarService = new RacingCarService();
racingCarService.start();


### 사용자 입력

1. 자동차 이름
2. 시도할 횟수

---

## 😭아쉬운점

- Service 에서 `Start()` 함수가 좀 지저분한 것 같다.
- `caculateScore()` 함수를 구현할 때 알고리즘을 한 번에 생각하지 못한 점….
- 함수에 한 기능을 넣으려고 노력헀지만 그러지 못한 거 같다.
- 뭔가 쓸데없는 List 가 너무 많다 → 메모리 낭비??

## 😯하면서 알아갔던 것

- String.join, replace 사용하는 것
- git commit 메세지 쓰는 법 (아직 서툴다)
- 메서드 하나에 기능을 하나만 넣도록 노력하는 법