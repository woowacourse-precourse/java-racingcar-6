# 자동차 경주

## 기능 목록 V


## 기능 목록 V3
- [x] 게임에 참여하는 자동차를 생성한다. CreateCar
  - [x] 사용자로부터 자동차의 이름을 입력 받는다. CreateCar#input()
  - [ ] 사용자로 부터 입력 받은 값을 쉼표(,)를 기준으로 구분하여 값을 저장한다. CreateCar#splite()
      - [x] 자동차 이름, 수 예외 처리
        - [x] 자동차 이름은 5자 이하만 가능하다. CreateCar#validateCarNameLength()
        - [x] 자동차 생성 가능 수는 최소 2대, 최대 10대로 한다. (게임 진행 필수 2대, 2023 F1 출전 팀을 기준 10팀) CreateCar#validateCarCount()
  - [x] 자동차의 이름과 전진 상태을 담을 Map을 만든다. CreateCar#stateMap()

- [x] 자동차가 앞으로 이동한다. Forward 
  - [x] 0에서 9 사이에서 무작위 값을 구한다. Forward#randomNums()
  - [x] Forward#randomNums()가 4 이상일 때 전진한다. Forward#canForward()
  - [x] canForward()에 따른 변경사항을 반영한다. Forward#updatePosition
  
- [x] 진행할 경주 라운드를 입력 받고 라운드 마다의 상태를 나타낸다 그리고 경주의 최종 결과를 나타낸다. Racing
  - [x] 경주를 진행할 라운드를 입력 받는다. Racing#Round()
    - [x] 입력 예외 처리 : 시도 횟수 예외 처리. 숫자가 아닌 값, 음수 값, 0 값, 제한 횟수 초과.
      - [x] 숫자 예외 처리 Racing#parseRound() 
  - [x] 전진하는 자동차를 출력할 때 이름을 같이 출력한다. Racing#state()
  - [x] 경주의 최종 결과를 나타낸다. Racing#Winner()
    - [x] 경주가 끝났을 때 가장 앞서 있는 자동차를 찾는다. Racing#findWinner()
  -[x] 경주의 상태를 나타낸다. Racing#printState()
  
- [x] 게임을 주관한다. RacingGame
    - [x] 게임을 시작한다. RacingGame#start()
 
  

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

e.g. <br/><br/>
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) <br/>
pobi,woni,jun <br/>
시도할 회수는 몇회인가요? <br/>
5 <br/>

실행 결과 <br/>
pobi : - <br/>
woni : <br/>
jun : - <br/>

pobi : -- <br/>
woni : - <br/>
jun : -- <br/>

pobi : --- <br/>
woni : -- <br/>
jun : --- <br/>

pobi : ---- <br/>
woni : --- <br/>
jun : ---- <br/>

pobi : ----- <br/>
woni : ---- <br/>
jun : ----- <br/>

최종 우승자 : pobi, jun
