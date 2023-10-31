
## 기능 목록

- ### Game
  - [X] 게임을 시작하는 메서드 를 가진다.
    
    - run() 
    
  - [X] 자동차 이름을 입력받아 List 로 저장할 수 있어야 한다.
    
    - getCars()
  
  - [X] 시도할 회수를 입력받아야 한다.

    - getTotalMove()
    
  - [ ] 결과를 출력할 수 있어야 한다.

    - printResult()
      
  - [ ] 단계별 진행상황을 출력할 수 있어야 한다.

    - printRoundProgress()

  - [ ] 우승자를 출력할 수 있어야 한다.

    - printWinner()
  

- ### Car
  - [ ] 전진을 시도할 수 있어야 한다.

    - tryMove()

  - [ ] 차의 이름과 현재 위치를 출력할 수 있어야 한다.

    - printProgress()
  
  - [ ] 우승자 여부를 판단할 수 있어야 한다. 
  
    - isWinner()


- ### Validation
  - [ ] 자동차 이름의 글자수가 1 이상 5 이하인지 검증할 수 있어야 한다.

    - validateCarName()

  - [ ] 자동차 이름에 중복이 존재하는지 검증할 수 있어야 한다.

    - validateDuplicateCar()

  - [ ] 시도할 회수가 1 이상인지 검증할 수 있어야 한다.

    - validateTotalMove()


- ### JUnit 5와 AssertJ를 이용하여 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

