## 자동차 경주 게임

### 기능 목록
- [x] 자동차의 이름들을 입력받는다. Input # carNames()
- [x] 각 자동차는 이름을 부여받을 수 있다. Car # name
- [x] 쉼표(,)로 구분된 이름만큼의 자동차 인스턴스를 생성한다.

- [x] 사용자에게 몇 번의 이동을 할 것인지 입력받는다. Input # round()
- [x] 입력된 횟수만큼 0부터 9 사이의 난수를 생성한다. Move # getRandomNum()
    - [x] 난수가 0 ~ 3일 경우 정지, 4 ~ 9일 경우 전진 Move # race(), Car # setDistance()
- [x] 각 자동차는 본인이 이동한 거리를 저장한다. Car # distance
- [x] 모든 이동이 끝난 후 우승자를 출력한다.
  - [x] 우승자는 이동한 거리가 가장 많은 자동차이다. PickWinner # compareDistance()
  - [x] 만약, 우승자가 여러 명일 겅우 쉼표(,)를 이용하여 구분한다. Output # winnerMessage()


### 주어진 예외 처리
- [x] 자동차의 이름은 5자 이하여야 한다.
  - [x] 5자 이상의 이름을 입력 받은 경우 IllegalArgumentException을 발생시킨 후 프로그램은 종료된다. InputCarException # nameLengthException()

### 개인적인 예외 처리
* 주어진 예외처리나 프로그램 동작에 장애가 있는 예외의 경우에는 IllegalArgumentException을 발생시키나 그 이외의 경우에는 최대한 Exception을 발생시키지 않도록 함
- [x] 입력한 자동차 이름이 1개 이하일 경우? IllegalArgumentException을 발생시킨 후 프로그램은 종료된다. InputCarException # numberOfCarException()
- [x] round의 값이 정수가 아닐 경우? IllegalArgumentException을 발생시킨 후 프로그램은 종료된다. InputRoundException # notIntegerException()
- [x] 자동차 이름이 중복된 경우? 하나의 자동차로 취급 Input # carNames()
- [x] 자동차 이름에 띄어쓰기가 들어갈 경우? 공백을 모두 제외하고 이름으로 설정된다.InputCarException # removeWhitespace()
- [x] 자동차 이름이 0자일 경우? 프로그램 동작에 장애가 없으므로 가능하도록 한다.

### 테스트 코드 작성
- [ ] 주어진 난수가 설정된 기준에 따라 정지하는지, 전진하는지 검사한다. MoveTest # 정지_혹은_전진()
- [ ] 중복된 이름이 있을 때, 하나의 자동차로 취급하는지 검사한다. InputTest # 중복된_이름_통합()
- [ ] 여러 자동차의 거리를 비교하여 우승자를 기준에 맞게 리스트에 넣어 반환하는지 검사한다. PickWinnerTest # 우승자_비교()
- [ ] 자동차의 이름이 5자 이하인지 검사한다. InputCarException # 자동차_이름_5자_이하()
- [ ] 입력한 자동차의 개수가 2개 이상인지 검사한다. InputCarException # 입력한_자동차의_개수가_2개_이상()
- [ ] 자동차 이름에 공백이 있으면 제거하는지 검사한다. InputCarException # 자동차_이름_공백_제거()
- [ ] 입력한 횟수가 정수인지 검사한다. InputRoundException # 입력된_횟수가_정수()
    
### 기능 요구 사항
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

각 자동차에 이름을 부여할 수 있다. 
전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
