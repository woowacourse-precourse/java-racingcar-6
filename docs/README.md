# Racing Car - 구현할 기능 목록

### **사용자로부터 이동횟수를 입력 받는 기능**

- [x] 사용자로부터 이동 횟수를 입력 받는다. - **UserInputHandler**#getUserInputForMoves
  
  ```
  5
  ```
  - [x] 잘못된 입력(숫자가 아님)이면 `IllegalArgumentException`을 발생 후 종료한다. - **InputValidator**#validateNumberFormat

### **자동차에게 이름을 부여하는 기능**

- [x] 자동차에게 이름을 부여할 수 있다. **RacingCarGame**#initCar
  
  - [x] 사용자로부터 이름(들)을 입력 받는다. - **UserInputHandler**#getUserInputForNames
    
    ```
    pobi,woni,jun
    ```
    
    - [x]  입력 데이터를 쉼표를 기준으로 분리할 수 있다. - **StringOperator**#seperate
    
    - [x] 잘못된 입력 (5자 초과, null)이면 `IllegalArgumentException`을 발생 후 종료한다. - **InputValidator**#
  
  - [x] 자동차를 이름과 함께 생성한다. **CarController**#createCar

### **Racing Car 게임을 진행하는 기능**

- [x] 이동횟수만큼 게임을 진행한다. - **RacingCarGame**#game
  
  - [x] 게임 안내 메시지를 출력한다. **GameConfig**
    
    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    시도할 회수는 몇회인가요?
    ```
  
  - [x] 자동차가 전진할 기회를 준다 **CarController**#grantChaceForForward
    
    - [x] 무작위 수(0~9)를 구한다. -**NumberGenerator**#createRandomNumber
    
    - [x] 4이상이면 전진 한다. - **Car**#forward 
  
  - [x] 차수마다 자동차들의 전진 결과를 출력한다. **CarController**#printRoundRestult
    
    - [x] 자동차의 이름과 전진 상황을 출력한다(전진 여부 상관X) - **Car**#printForward
      
      ```
      pobi : --
      woni : ----
      jun : ---
      ```

### **우승자를 알려주는 기능**

- [x] 우승자를 가린다.- **RacingCarGame**#announceWinners
  
  - [x] 자동차 중 가장 많이 전진한 차(단수, 복수)를 알아낸다.**CarController**#determineWinner
    
    - [x] 우승자가 몇 명인지 알아낸다.[단수, 복수] **Judge**#getNumberOfWinners
    
    - [x] 우승자의 이름(자동차)을 알아낸다. **Judge**#getNameOfWinners
    
    - [x] 우승자를 출력한다. 여러 명이면 쉼표로 구분한다.**CarController**#printWinners
    
    ```
    최종 우승자 : pobi
    ```
    
    ```
    최종 우승자 : pobi, jun
    ```