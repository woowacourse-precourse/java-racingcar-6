# [ 구현 기능 목록 ]
- [X] 자동차 이름을 입력받는다. 
  - InputView#readFromUser() -> GameController#getCarNames()
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 예외 처리 Validator#validateCarNames()
    - 쉼표로 구분하기 전 
      - 쉼표(,)만 입력한 경우
      - 공백을 입력한 경우
    - 쉼표로 구분한 후
      - 이름이 없거나 공백
      - 이름 하나가 6자 이상
      - 같은 이름이 있는 경우
      - 하나만 입력한 경우...? 예외 처리 (게임이니까 최소 두개 이상 입력해야 함)


- [X] 몇 번의 이동을 할 것인지 입력받는다.(게임 총 라운드 수)
  - totalRound : 게임 총 라운드 수 
  - InputView#readFromUser() -> GameController#getTotalRound()
  - 예외 처리 Validator#validateTotalRound()
    - 0
    - 숫자가 아닌 값


- [X] 자동차는 전진하거나 멈춘다. 
  - Car#move() -> Car#play() -> GameController#playRound()
  - 0 ~ 9 의 랜덤 숫자를 뽑는다.
  - 뽑은 숫자가 4 이상이면 전진한다. (4 미만이면 멈춘다.)
    

- [X] 라운드 결과를 출력한다. 
  - GameController#processResult() -> OutputView#printRoundResult()


- [X] 게임을 완료한 후 최종 우승자를 출력한다.
  - GameController#processResult() -> OutputView##printWinner()
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

---
# [ 플로우 ]
1. 자동차 이름을 입력받는다. + validation 진행
   - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
   

2. 입력받은 이름을 가진 자동차 객체를 생성한다.

   
3. 시도할 횟수 (게임 라운드 수)를 입력받는다. + validation 진행
   - "시도할 회수는 몇회인가요?"


4. 라운드를 반복한다. 
   - 자동차 객체들이 0 ~ 9 의 랜덤 숫자를 뽑고
   - 그 값에 따라 전진 or 멈춘다
   

5. 실행 결과를 출력한다.
   

6. 최종 우승자를 출력한다.
   - "최종 우승자 : pobi, jun"