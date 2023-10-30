### 주어진 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException을` 발생시킨 후 애플리케이션은 종료되어야 한다.


<br/>
<br/>

### 구현 해야 할 요소들

- 이름을 입력받기 [o] - input.createNames()
  - (추가) 입력받은 이름 쉼표 기준으로 나누고 예외처리 [o] - input.getNames()
  - 5자 넘을경우 오류 발생 [o] - exception.checkNameOver5()
  - 중복된 이름이 있을경우 오류 발생 [o] - exception.checkDuplicatedName()
  
    
- 몇번의 이동을 할건지 입력받기 [o] - input.moveCount()
  - (추가) 입력 값 예외 처리 후 int형으로 변환 [o] - input.getMoveCount()
  - 숫자를 입력받지 않을경우 오류 발생 [o] - exception.checkNumber()
  

- 각 이름 인덱스에 매칭되게끔 이동 횟수 리스트 만들기 [o] - movement.createMovement()
  
  
- (추가) 각각 랜덤값 생성후 움직일지 멈출지 확인하고 한 사이클 프린트 하기 [o] - movement.eachRace()
  - 움직이면 이동 횟수 리스트 값 += 1 해주기 [o] - movement.raceMoveOrStop() 
  - 랜덤 값을 이용해서 전진할지 멈출지 계산 [o] - movement.isMove()
  - 현재까지의 이동 현황 프린트하기 [o] - movement.printRace()
  

- 우승자가 여러명일경우 쉼표(,)를 이용하여 구분하여 우승자 프린트하기 [o] - race.printWinner()
  - 우승자 여러명일때 여러 우승자들 추출하기 [o] - race.extractWinner
