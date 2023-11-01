
## 기능 목록

- ### Game
  - [X] 게임을 시작하는 메서드 를 가진다.
    
    - run() 
    
  - [X] 자동차 이름을 입력받아 List 로 저장할 수 있어야 한다.
    
    - getCars()
  
  - [X] 시도할 횟수를 입력받아야 한다.

    - getTotalMove()
  
  - [X] 결과를 출력할 수 있어야 한다.

    - getResult()
  
  - [X] 모든 자동차를 움직여야 한다. (한 라운드 진행)

    - moveAllCar()
      
  - [X] 단계별 진행상황을 출력할 수 있어야 한다.

    - printRoundProgress()

  - [X] 우승자를 구할 수 있어야 한다.

    - getWinner()

  - [X] 우승자를 출력할 수 있어야 한다.

    - printWinner()


- ### Car
  - [X] 전진을 시도할 수 있어야 한다.

    - tryMove()

  - [X] 차의 이름과 현재 위치를 출력할 수 있어야 한다.

    - printProgress()



- ### Validation
  - [X] 자동차 이름의 글자수가 1 이상 5 이하인지 검증할 수 있어야 한다.

    - validateCarName()

  - [X] 자동차 이름에 중복이 존재하는지 검증할 수 있어야 한다.

    - validateDuplicateCar()

  - [X] 입력받은 시도할 회수가 정수인지, 1 이상인지 검증할 수 있어야 한다.

    - validateTotalMove()


- ### JUnit 5와 AssertJ를 이용하여 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

