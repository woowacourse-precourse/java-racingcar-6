# [ 구현 기능 목록 ]
- [ ] 자동차 이름을 입력받는다. 
  - InputView#readFromUser() -> GameController#getCarNames()
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 예외 처리 
    - 쉼표로 구분했을 때 
      - 쉼표(,)만 입력한 경우
      - 이름이 없거나 공백
      - 6자 이상
      - 같은 이름이 있는 경우
      - 하나만 입력한 경우...?


- [ ] 몇 번의 이동을 할 것인지 입력받는다.(게임 총 라운드 수)
  - gameRounds : 게임 총 라운드 수 
  - InputView#readFromUser() -> GameController#getTotalRound()
  - 예외 처리
    - 0
    - 숫자가 아닌 값


- [ ] 자동차는 전진하거나 멈춘다. 
  - Car#move() -> GameController#playRound()
  - 0 ~ 9 의 랜덤 숫자를 뽑는다.
  - 뽑은 숫자가 4 이상이면 전진한다. (4 미만이면 멈춘다.)
    

- [ ] 라운드 결과를 출력한다. 
  - GameController#createResult() -> OutputView#printRoundResult()


- [ ] 게임을 완료한 후 최종 우승자를 출력한다.
  - GameController#createResult() -> OutputView##printWinner()
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.