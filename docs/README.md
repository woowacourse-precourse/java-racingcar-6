## 기능 목록

- 자동차의 이름과 전진 횟수를 저장할 객체를 생성한다 : Car
- 자동차 list를 관리하고, 입력 횟수만큼 주행을 반복하고, 우승자를 표시하는 객체를 생성한다. Referee

- 경기에 참여할 자동차의 List를 생성한다. Referee#setCarList
  - 입력을 받아, 쉽표를 구분해서, 자동차 이름 List를 생성한다. Referee#setCarNameList 
  - 자동차 이름의 길이가 5자를 초과하면 에러를 발생시키고 프로그램을 종료한다. Referee#carNameError
- 입력된 횟수만큼 주행을 반복하며 결과를 표시한다. Referee#loopCarRacing
    - 주행 횟수를 입력받는다. Referee#setRacingCnt
    - 각 자동차의 순서마다 랜덤으로 0~9 중 숫자 하나를 생성한다. Referee#startCarRacing
      -  자동차의 전진 횟수를 추가한다. Car#addMoveCount
      -  자동차의 전진 횟수를 불러온다. Car#getMoveCount
- 우승한 자동차의 목록을 표시한다. Referee#showWinner

- 자동차의 이름이 입력대로 이뤄졌는지 확인한다. ApplicationTest#자동차_이름_일치
  - 자동차의 이름을 불러온다. Car#carGetName
- 주행횟수가 제대로 입력됐는지 확인한다. ApplicationTest#주행_횟수_일치
  - 주행횟수를 불러온다. Referee#getRacingCount