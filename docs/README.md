

## 기능목록

- [X] 게임을 시작한다
- [X] 입력을 받는다
  - [X] 자동차 이름을 받기 전에 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"를 출력한다.
  - [X] 자동차 이름을 입력 받는다
  - [X] 시도할 횟수를 입력하기 전에 "시도할 회수는 몇회인가요?"를 출력한다.
  - [X] 시도할 횟수를 입력 받는다 
- [X] 입력이 유효한지 검증한다
  - [X] 자동차 이름이 빈 공백이면 IllegalArgumentException을 발생시키고 종료한다
  - [X] 자동차 이름이 6자 이상이면 IllegalArgumentException을 발생시키고 종료한다
  - [X] 시도할 횟수가 0 이하의 값이라면 IllegalArgumentException을 발생시키고 종료한다 
  - [X] 기타 입력이 유효하지 않는 경우에 IllegalArgumentException을 발생시키고 종료한다
- [X] 게임을 진행한다
  - [X] 게임을 진행하기 전 "실행 결과"를 출력한다
  - [X] 중간 결과를 계산하기
  - [X] 중간 결과를 출력한다
      - [X] 각 자동차별 실행 결과를 출력하기
- [X] 결과를 출력한다
  - [X] 최종우승자를 산정한다
  - [X] 최종우승자를 출력한다
  


## 설계

### 초기 도메인 모델
![Domain Model Graph](./image/Domain1.png)

* Game Executor  : 게임을 실행
* Racing Car Game : 레이싱 카 게임의 로직을 수행 
* Racing car : 레이싱 카의 로직을 수행
* Game Output View : 게임의 아웃풋 뷰
* Game Input View : 게임의 인풋 뷰 

## 초기 도메인 상태 모델
![Domain State Graph](./image/State1.png)

1. 상태
   * Wait For Input(car name) : 레이싱 카의 이름들을 입력으로 받는다
   * Wait For Input(trial) : 시도할 횟수를 입력으로 받는다
   * Stage : 각 게임의 찻수를 실행한다
   * Game Over : 최종 결과를 출력한다

2. 트리거
   * Invalid Input : 유효하지 않은 입력을 받는다
   * Valid Input : 유효한 입력을 받는다
   * Iterate : 찻수를 반복한다
   * End : 게임을 종료한다

## 결과물

## 의존성 그래프

![DependencyGrpah](./image/DepencyGraph.png)

### 각 함수의 기능목록
| 클래스                   | 접근자     | 함수                        | 책임                                                                                        |
|-----------------------|---------|---------------------------|-------------------------------------------------------------------------------------------|
 | Game                  | public  | isFinished                | 게임이 종료되었는지 여부를 출력한다                                                                       |
| Game                  | public  | isFinished                | 게임이 종료되었는지 여부를 출력한다                                                                       |
| Game                  | public  | runStage                  | 각 자동차Random.randomNumberRange() 값을 이용하여서  각 Racingcar의 tryForward()를 호출한다                 |
| Game                  | public  | printStage                | OutputInterface의 printStage()를 호출한다                                                       |
| Game                  | public  | render                    | Renderer.renderCars()를 호출한다                                                               |
| GameExecutor          | public  | run                       | game의 주요 API들을 로직대로 호출한다                                                                  |
| GameRandom            | public  | randomNumberRange         | start 이상 end 미만의 값중에서 Random하게 출력시킨다                                                      |
| RacingCarGame         | private | getWinners                | 자동차들 중에서  가장 높은 Poisiton을 갖는 자동차의 이름들을 출력한다                                               |
| RacingCarGame         | private | getCarWithHighestPosition | 자동차들 중에서 가장 높은 Position을 갖는 값(p)을 찾는다                                                     |
| RacingCarGame         | private | createCars                | 자동차의 이름들을 받아서 자동차 객체의 목록으로 변환한다 <br/> 이때 이름이 중복되는 자동차가 있으면 IllegarArgumentException을 반환한다 |
| RacingCarGame         | private | checkTrial                | trial 횟수가 1 이상의 값이 아니라면 IllegalArgumentException을 발생시킨다                                   |
| RacingCarGame         | private | checkNames                | 자동차의 이름이 중복되면 IllegalArgumentException을 발생시킨다                                             |
 | RacingCar             | public  | tryForward                | number값을 받아서 number값이 4이상이면 전진시킨다                                                         |
 | RacingCar             | public  | isSamePositionWith        | 입력받은 다른 RacinCar와 같은 Position인지 출력한다                                                      |
 | RacingCar             | public  | getName                   | 자신의 이름을 출력한다                                                                              |
 | RacingCar             | public  | render                    | Renderer.renderCar()에 자신의 이름과 Position을 넘긴다                                               |
 | RacingCar             | private | checkName                 | 이름의길이가 0이상 5이하인지 확인한다                                                                     |
| Position              | public  | of                        | 새로운 Position 객체를 생성한다                                                                     |
| Position              | public  | forward                   | 입력받은 만큼 수만큼 전진한 새로운 Position 객체를 생성한다                                                     |
| Position              | public  | compareTo                 | 다른 Position 객체와 x좌표를 비교를 한다                                                               |
| Position              | public  | equals                    | 다른 Position 객체와 x좌표가 같은지 비교를 한다                                                           |
| Position              | public  | hashCode                  | hashCode를 반환한다                                                                            |
| Position              | public  | getX                      | x좌표 값을 반환한다                                                                               |
| RacingCarGameRenderer | public  | renderCars                | 입력받은 모든 차 리스트를 render()를 호출한다                                                             |
| RacingCarGameRenderer | public  | renderCar                 | 입력 받은 차 이름과 좌표로 포매팅을한다                                                                    |
 | InputInterface        | public  | getNames                  | 유저한테서 name들을 Input 받는다                                                                    |
 | InputInterface        | public  | getTrial                  | 유저한테서 시도 횟수들을 Input 받는다                                                                   |
 | OutputInterface       | public  | println                   | 입력받은 문자열을 출력한다                                                                            |
 | OutputInterface       | public  | printStage                | 입력받은 Game의 toString()을 출력한다                                                               |
 | OutputInterface       | public  | printWinner               | 입력받은 winner목록을 출력한다                                                                       |
 | View                  | public  | render                    | 입력받은 String을 원하는 포맷대로 출력한다                                                                |


