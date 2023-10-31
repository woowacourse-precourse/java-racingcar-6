# 기능 목록
필요한 기능 리스트와 설명
양식 : [구현여부] (기능 설명)_ (클래스 이름)#(메서드 이름)
---
- [] 게임을 시작한다. Race#run, Race#gameStart
- [] 자동차 이름을 입력받는다. OutputView#inputCarNameView, InputView#inputCarName
  - [] ","를 기준으로 구분한다.  
    - [] 이름으로 차를 생성한다. Car#Car
  - [] (검사) 5자 이하만 가능하다. Validation#carNameSizeCheck, SizeNotMatchException
- [] 시도할 횟수를 입력받는다. OutPurView#inputTryNumberView, InputView#inputTryNumber
  - [] (검사) 자연수만 가능하다. Validation#checkNatureNumber, NotNatureNumberException
- [] 자동차는 랜덤한 값을 보고 전진 및 정지를 한다. Car#handle
  - [] 랜덤값 생성기 Random
    - [] 0 - 9 사이의 정수를 생성한다. Random#pickNumberInRange
  - [] 생성된 값이 4이상일 경우 전진한다. Car#move
- [] 경주는 한번의 라운드가 끝날 때마다 진행상황을 저장한다. Race#playRound
  - [] 자동차는 자기의 이름과 상태를 경주에게 제공한다. Car#resultOutput
  - [] 경주는 자동차 상태 목록을 저장한다. Result#saveRound
- [] 경주는 모든 라운드가 끝나면 진행결과를 출력한다. Race#gameSet
  - [] 경주는 진행상황을 출력기에 전송한다. OutputView#outputRounds
  - [] 경주는 가장 멀리 간 자동차(들)을 우승자로 지정한다. Result#returnWinner
  - [] 우승자를 출력한다. OutputView#outputResult
  - [] 공동 우승자인 경우 ", "를 구분자로 사용하여 출력한다. OutputView#outputResults




# 🚀 기능 요구 사항

---
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
