# 자동차 경주

## 기능 목록 V2
-[x] 게임에 참여하는 자동차를 생성한다. CreateCar
  - [x] 사용자로부터 자동차의 이름을 입력받는다. CreateCar#input()
    - [x] 자동차의 이름과 진행 상태을 담을 Map을 만든다. CreateCar#stateMap()
      - [x] 자동차 이름 예외 처리
        - [x] 자동차 이름은 5자 이하만 가능하다. CreateCar#checkNameLength()
    - [x] stateMap의 사이즈를 통해 입력 받은 자동차의 수를 결정한다. CreateCar#getNumberOfCars()
      - [x] 자동차 수 예외 처리
        - [x] 자동차 생성 가능 최대 수는 10대로 한다. (2023 F1 출전 팀을 기준 10팀) CreateCar#checkCarCount()
        - [x] 자동차 생성 가능 최소 수는 2대로 한다. (경주 게임을 진행하기 위한 최소 인원) CreateCar#checkCarCount()
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
[x] 게임을 주관한다. RacingGame
    - [x] 게임을 시작한다. RacingGame#start()
 

## 기능 목록 V1

-[ ] 자동차를 생성한다. CreateCar
  - [ ] 게임에 참여하는 자동차의 수를 정한다. (자동차의 수는 부여된 이름의 수로 결정됨.) 
      - [x] 사용자로 부터 입력을 받는다. CreateCar#input()
      - [x] 입력 받은 값으로 부터 생성된 자동차 수를 결정한다.(자동차 이름은 쉼표(,)를 기준으로 구분한다.) CreateCar#carName(), CreateCar#carCount()
      - [ ] 자동차 이름은 5자 이하만 가능하다. CreateCar#checkNameLength()
      - [ ] 자동차 생성 가능 최대 수는 10대로 한다. (2023 F1 출전 팀을 기준 10팀)  
      - [ ] 자동차 생성 가능 최소 수는 2대로 한다. (경주 게임을 진행하기 위한 최소 인원)
      - [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

- [ ] 자동차가 전진 한다.Forward
  - [ ] 자동차가 멈춘다. Forward#stop()
    - [ ] 전진하는 자동차를 출력할 때 이름을 같이 출력한다. Forward#result() 
    - [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
        - [ ] 0에서 9 사이에서 무작위 값을 구한다. Forward#randomNums()
        - [ ] 조건 4이상일 경우다. Forward#canForward()
      
- [ ] 경주 게임의 최종 결과를 알려준다. RacingChampion
    - [ ] 경주 게임을 완료한 후 누가 우승했는지를 알려준다. RacingChampion#winner()
      - [ ] 우승자는 한 명 이상일 수 있다. 
      - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.


-[ ] 주어진 횟수 동안 경주를 진행한다. RacingRound
  - [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. RacingRound#attemptCount()
    - [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    
- [ ] 경주 진행상황을 나타낸다. RacingState#racingState

- [ ] 경주 게임의 최종 결과를 알려준다. Racing 
    - [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
    - [ ] 경주 상태를 나타내는다 Racing#state()
      - [ ] 레이싱에 필요한 요소를 불러온다. (자동차 이름, 수) Racing#input()
      - [ ] 레이싱의 과정을 보여준다. Racing#racing()
      - [ ] 레이싱의 우승자를 알려준다. Racing#winner()
    - [ ] 우승자는 한 명 이상일 수 있다.



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
