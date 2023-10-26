# 구현 기능 목록

## 입력 (InputView)
- carNamesInput();
  - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  - ,를 기준으로 자동차 이름을 부여한다.
  - 5자 이하만 가능하다.
- wantTryMove();
  - 몇번의 이동을 할것인지 입력한다.
- 사용자가 잘못된 입력을 했을경우 IllegalArgumentException 발생후 종료한다.

## 출력 (OutputView)

- printRequestCarNames();
  - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
- printRequestWantTryMove(); 
  - 시도할 회수는 몇회인가요?
- printCarLocation(); 
  - 각 이동후 자동차 이름과 전진한 현재위치를 출력한다.
- printWinner(); 
  - 모든 이동후 최종 우승자를 , 를 기준으로 출력한다.

## RacingCar

- RacingCar(String carName){}
  - 입력받은 자동차 이름으로 RacingCar 객체를 생성한다.
- this.location = 0; 
  - RacingCar 에는 현재 위치에 대한 정보가 담겨있다.
- getLocation(); 
  - 현재위치 정보를 알수 있어야한다.
- move(); 
  - 현재 위치에서 전진할수 있어야한다.
    - 전진하는 조건은 0~9 사이의 무작위값을 구한후 무작위값이 4 이상이다.
      - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

## RacingGameController

- makeCars()
  - 경주에 참여할 차 이름을 입력받고 RacingCar 객체를 생성한다.
- requestWantToMove();
  - 몇번의 이동시도를 할것인지 입력받는다.
- play()
  - 유저가 원하는 이동시도 만큼 각 RacingCar 를 이동시킨다.
- findWinner();
  - 모든 이동 시도가 완료된후 각 RacingCar 의 위치를 확인하여 우승자를 뽑는다.
- printResult();
  - 우승자를 출력한다.
  
## Validator
- ,를 기준으로 자동차 이름을 입력 받을때 5자 이하인지 검증.

## Converter
- 유저에게 입력받은 자동차 이름들을 List<RacingCar> 로 바꿔준다.