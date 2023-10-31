# 구현 기능 목록

---
## Car class

- Car constructor
  - Car 객체의 맴버 변수인 name, position을 받아 초기화한다.
- getPosition
  - Car 객체의 현재 위치를 반환한다.
- getName
  - Car 객체의 이름을 반환한다.
- goForward
  - Car 객체의 position이 1 만큼 증가한다. (자동차가 전진함)
- toString
  - Car 객체의 현재 상황을 반환한다.
## CarGame class

- CarGame constructor
  - CarGame 객체의 맴버 변수인 Car 객체 리스트 cars 와 시도할 회수 attempts 를 초기화 한다. 
- prompt
  - 자동차 경주 게임의 진행을 위해 맴버 변수 값을 입력하기 위한 입출력을 담당한다.
- play
  - playOneTime 을 이용하여 자동차 경주 게임을 실행한다.
  - printCurrentStatus 를 이용하여 각 시도한 횟수별 경기 상황을 출력한다.
  - printWinner 를 이용하여 최종 우승자를 출력한다. 
- playOneTime
  - 자동차 경주 게임의 한 턴을 수행한다.
  - 0~9의 임의의 숫자를 생성하여 4 이상이면 해당 자동차는 전진한다.
- printCurrentStatus
  - 현재 자동차 경주 게임의 자동차별 상황을 출력한다.
- printWinner
  - 자동차 경주 게임의 최종 우승자를 getWinner 를 이용하여 반환 받은 후 결과를 출력한다. 
- getWinner
  - 자동차 경주게임의 최종 우승자를 리스트 형태의 Car 객체로 반환한다.

## Application class

- main
  - CarGame 객체를 생성하고 자동차 경주 게임을 수행한다.