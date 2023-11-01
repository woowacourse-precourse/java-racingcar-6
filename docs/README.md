## 기능 목록
- [X] 무작위 값 랜덤 뽑기 (전진 조건) domain.NumberGenerator # createRandomNumber()
- [X] 랜덤 값 판단하기 domain.Judgement # goStop()
  - [X] 무작위 값 4 이상: 전진
  - [X] 무작위 값 4 미만: 멈춤 
- [X] 입력하기 view.Input
  - [X] 자동차에 이름 부여하기 view.Input # getCarName()
    - [X] 이름은 쉼표 기준으로 나눈다
    - [X] 5자 이하만 가능 -> 예외 처리
    - [X] 부여한 이름 갯수에 따라 자동차 갯수가 결정된다  
  - [X] 시도할 횟수 입력하기 view.Input # getTrialNumber()
- [X] 출력하기 view.Printer
  - [X] 자동차 이름 출력 (단, 전진하는 자동차 출력할 때 같이) view.Printer # displayResult()
  - [X] 우승한 자동차 출력 (우승자는 1명 이상일 수 있다) view.Printer # displayWinners()
    - [X] 우승자 여러명일 경우, 쉼표를 사용해서 구분한다 
- [X] 우승자 판단하기 domain.Judgement # getWinners()
- [X] 예외 입력 값 처리하기 view.Input # checkWordsLimit()







## 기능 요구 사항
- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [X] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [X] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [X] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [X] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [X] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
