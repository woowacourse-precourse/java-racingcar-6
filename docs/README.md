# 구현 기능 목록

## 입력 (InputView)
- [x] carNamesInput();
   - [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- [x] wantTryMove();
  - [x] 몇번의 이동을 할것인지 입력한다.


## 출력 (OutputView)

- [x] printRequestCarNames();
  - [x] 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
- [x] printRequestTryCount(); 
  - [x] 시도할 회수는 몇회인가요?
- [x] printGameResultMessage()
  - [x] 실행결과를 출력하기 전 "실행결과" 메세지 출력
- [x] printCarLocation(); 
  - [x] 각 이동후 자동차 이름과 전진한 현재위치를 출력한다. 
- [x] printWinner(); 
  - [x] 모든 이동후 최종 우승자를 , 를 기준으로 출력한다.


## RacingCar

- [x] RacingCar(String name){}
  - [x] 입력받은 자동차 이름으로 RacingCar 객체를 생성한다.
  - [x] validator 를 통해 이름이 5글자를 초과하는지 검증한다.
- [x] this.location = 0; 
  - [x] RacingCar 에는 현재 위치에 대한 정보가 담겨있다.
- [x] getLocation(); 
  - [x] 현재위치 정보를 알수 있어야한다.
- [x] move(); 
  - [x] 현재 위치에서 전진할수 있어야한다.
- [x] isMove();
    - [x] 전진하는 조건은 0~9 사이의 무작위값을 구한후 무작위값이 4 이상이다.
    - [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

## RacingGameController

- [x] makeCars(String userInput)
  - [x] 경주에 참여할 차 이름을 입력받고 RacingCar 객체를 생성한다.
- [x] inputTryCount();
  - [x] 몇번의 이동시도를 할것인지 입력받는다.
- [x] moveCars()
  - [x] 모든 RacingCar 에게 1회 move 시도를 한다.
- [x] findMaxLocation()
  - [x] 가장 멀리 이동한 RacingCar 의 위치를 찾는다.
- [x] findWinner(int maxLocation);
  - [x] 모든 이동 시도가 완료된후 각 RacingCar 의 위치를 확인하여 우승자를 찾는다.
  
## Validator
- [x] ,를 기준으로 자동차 이름을 입력 받을때 5자 이하인지 검증.
- [x] 사용자가 잘못된 입력을 했을경우 IllegalArgumentException 발생후 종료한다.

## Converter
- [x] 유저에게 입력받은 원하는 전진 횟수를 int 로 바꿔준다.