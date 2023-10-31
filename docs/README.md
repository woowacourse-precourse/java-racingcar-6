주제: 자동차 경주 게임 구현
---

기능 및 조건:
---
1. , 표로 구분 지어지는 자동차들 이름의 string을 받는다.
    1. 자동차의 수는 제한이 없다.
    2. 이름은 5자 이하만 가능하다
2. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
3. 가장 많이 전진한 자동차 또는 자동차들의 이름을 출력한다.
    1. 0~9까지의 수를 random으로 돌려서 나온 값이 4이상이면 전진
    2. 우승자가 여러 명일 경우 ,를 사용하여 구분한다.
4. 잘못된 값을 사용하였을 경우 IllegalArgumentException error를 발생시키고 종료한다.
5. 외부 라이브러리 사용 금지
    1. java lang, util, io, net package 사용가능
6. depth는 2까지만 허용한다
    1. 메서드를 나누어서 해결 가능하다
    2. 메서드의 역할은 최대한 하나로 설정해라
7. 3항 연산자를 쓰지 않는다.

개인적 욕심:
---
1. 이후 view가 달라질 수도 있음을 생각하여 MVC pattern을 적용해 보고 싶다.
2. test 쪽을 이전에 사용해 본 적이 없었는데 이번 기회에 적용해 보고 싶다.

기획:
---
- 구성:
  - model:
    - car <-(composition)-map
  - view:
    - View interface
    - TextView
  - controller:
    - gameController
- 제안 1. 
  - controller
    - gameController
      - gameController(view, map)
      - view member
      - Map map
      - int attemptNum
      - void setCarString()
      - void setNumOfAttemp()
      - void executeGame()
    - model(car <-(composition)- map <- main)
      - car
          - String name
          - int process
          - String getName()
          - int getProcess()
          - void trial()
          - int compareFunction(car) //return this.process - car.process
      - RacingMap
          - List<car> carList
          - List<String> winner
          - map() // constructor
          - void setCarList(List<Car>)
          - List<Car> getCarList()
          - void trial() // execute one attempt
          - void calWinner()
          - List<String> getWinner()
    - view
      - View Interface
        - void printGetCarString()
        - void printGetNumOfAttempt()
        - void printMapProcess()
        - void printWinner()
      - text View