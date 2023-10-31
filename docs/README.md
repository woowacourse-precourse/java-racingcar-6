## 기능 목록

- [x] 한 줄로 입력된 자동차 이름들을 분리한다. : NamesManager # separateNamesString()

- [x] 자동차 이름이 조건에 맞는지 확인한다. : NamesManager # checkNamesException()
  - [x] 자동차 이름이 5자 이하인지 확인한다. : NamesManager # wrongNameLength()
  - [x] 자동차 이름이 모두 unique한지 확인한다 : NamesManager # duplicateName()

- [x] 시도할 횟수가 조건에 맞는지 확인한다 : RoundNumberManager # checkRoundNumberExceptions()
  - [x] 시도할 횟수가 숫자가 맞는지 확인한다. : RoundNumberManager # notNumber()
  - [x] 시도할 횟수가 음수인지 확인한다. : RoundNumberManager # negativeNumber()

- [x] 라운드를 진행한다. : Leaderboard # round()
  - [x] 전진할지 멈출지 결정한다. : car # engine()
    - [x] 랜덤숫자(0~9)를 뽑는다.
    - [x] 4이상인 경우 전진한다.
    - [x] 그 외에는 멈춘다.
    
- [x] 모든 자동차의 현재 상황을 출력한다. : Leaderboard # status()
  - [x] 자동차가 얼마나 이동했는지 -로 출력한다. : Leaderboard # distance()

- [x] 우승자를 출력한다. : Leaderboard # winner()
  - [x] 우승자 안내 문구를 만든다. LeaderBoard # winnerFormat