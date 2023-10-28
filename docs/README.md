## 기능 목록

- [] 한 줄로 입력된 자동차 이름들을 분리한다. : namesManager # separateNamesString()

- [] 자동차 이름이 조건에 맞는지 확인한다. : namesManager # checkNamesException
  - [] 자동차 이름이 5자 이하인지 확인한다. : namesManager # wrongNameLength()

- [] 전진할지 멈출지 결정한다. : car # engine()
  - [] 랜덤숫자(0~9)를 뽑는다.
  - [] 4이상인 경우 전진한다.
  - [] 그 외에는 멈춘다.

- [] 모든 자동차의 현재 상황을 출력한다. : Leaderboard # status()
  - [] 자동차가 얼마나 이동했는지 -로 출력한다. : Leaderboard # distance()

- [] 우승자를 출력한다. : Leaderboard # winner()
  - [] 여러 명일 때는 ,로 구별되게 출력한다.
  
- [] 라운드를 진행한다. : round()