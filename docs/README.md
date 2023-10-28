:white_check_mark: 기능 목록

- [x] 랜덤 정수 중 한개의 정수를 생성해주는 클래스. // NumbersGenerate
  - [x] 0에서 9까지의 정수 중 한 개의 정수 반환. // NumbersGenerate#createRandomNum();



- [x] 경주를 하는 자동차 생성하는 클래스. // RaceCar
  - [x] 자동차의 생성자 (입력 받는다.) // RaceCar#RaceCar();
    - [x] 이름은 5자 이하만 가능하다.
    - [x] 생성자를 통해서 입력을 받는다.
    
  - [x] 자동차의 이동을 제어해준다. // RaceCar#movementControlCar
    
    전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    
    - [x] 자동차가 전진을 한다. // RaceCar#moveForward
      
      자동차의 전진 카운터 증가.
    - [ ] ~~자동차 멈춤(정지). //  RaceCar#pauseTemp~~
      
      - [ ] ~~멈춤은 아무런 출력을 하지 않는다.~~
      - [ ] ~~전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 미만일 경우이다.~~



- [x] 게임을 진행하는 게임 진행자를 생성하는 클래스. // GameHost
  - [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.  // GameHost#winRaceCar
    - [x] 우승자는 한 명 이상일 수 있다.
    - [x] "-" 가 시도할 횟수만큼 있으면 우승



- [x] 게임 판단 기준 JudgeStandard
  - [x] 자동차중에 전진을 한 숫작 5개이면 승리를 한것이다. // JudgeStandard#isVictoryCondition



- [ ] 레이싱 게임의 진행을 도와주는 게임진행 상항 클래스를 만든다. // GameProcess

  - [x] 경주할 자동차 이름을 입력하는 메서드 // GameProcess#inputNameOfRaceCar
    - [x] 입력받은 자동차의 이름으로 레이싱 자동차를 만든다.
    - [x] 차동차 각각의 이름은 5자 이하 검사
    - [x] 한글 포함 검사
    - [x] 자동차 하나만 입력되면 안된다.
    
  - [x] 입력받은 이름 문자열로 자동차를 만들어준다. // GameProcess#createRaceCars()
    
    - [x] 문자열 공백 검사
    
  - [x] 게임을 시도할 회수를 입력하는 메서드 // GameProcess#inputNumberGameAttempts

  - [x] 레이싱게임의 최종 승자를 알려준다. // GameProcess#knowFinalWinner

    gameHost의 메서드로 해결

    레이싱게임의 최종 승자를 문자열로 반환하는 메서드.

  

- [x] 모든 클래스에서 사용할 수 있는 메서드의 모음인 Utill 클래스 작성. // Utill
  - [x] 문자열 입력 :  이름은 5자 이하만 가능하다. // Utill#inputString
    - [x] 숫자을 포함하는가 검사 
    
    - [x] 공백입력 검사
    
    - [x] 공백 포함 검사.
    
    - [x] 특수기호 포함 검사
    
  - [x] 숫자 입력 : 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. // Utill#inputNum
    - [x] 공백 입력 검사
    - [x] 공백 포함 검사.
    - [x] 양수 입력 검사
    - [x] 문자열 포함 검사
    - [x] 특수문자 포함 검사
    - [x] 숫자 "0"인지 검사.



- [ ] 사용자 화면을 보여주는 클래스. // GameStart

  - [x] 경주할 자동차 이름을 입력하는 출력을 보여주는 기능  // GameStart#printInputNameOfRaceCar

  - [ ] 전진하는 모든 차들의 자동차를 출력할 (자동차 이름을 같이 출력한다.) // GameStart#printSituationOfCarCurrent

    - [ ] 전진은 "-"을 출력 ( pobi : - )

      ```
      pobi : ----
      woni : ---
      jun : ----
      ```
  
  - [ ] 우승자가 누구인지 출력을 해준다. // GameStart#printWinnerOfRaceGame
  
    - [ ] 우승자는 한명이상이다.
  
    - [ ] 우승자가 여러명일경우 쉼표(,)를 이용하여 구분한다. 
  
      ```
      최종 우승자 : pobi, jun
      ```
  
  - [ ] 게임 진행 상황을 보여준다. // GameStart#showProcessOfRaceGame
  
    - [ ] 시도할 회수만큼 게임 진행 상황을 출력한다.
  
  - [ ] 게임 시작. // GameStart#run
  
    - [ ] 게임 시작을 한다.
  
  




- [ ] 올바른 값을 확인하기 위한 검증 클래스를 만든다. ValidException
  - [x] 이름은 5자 이하 검사. // ValidException#isValidFIveLessString
  - [x] 한글 포함 검사. //  ValidException#isValidIncludeKorean
  - [x] 숫자을 포함하는가 검사  // ValidException#isValidIncludeNum
  - [x] 공백 입력 검사 // ValidException#isValidBlankCheck
  - [x] 양수 입력 검사 // ValidException#isValidPositiveCheck
  - [x] 문자열 포함 검사  // ValidException#isValidIncludeString
  - [x] 특수문자 포함 검사 // ValidException#isValidIncludeSpecialString
  - [x] 문자열 포함 검사 (한글, 영어) // ValidException#isValidIncludeString
  - [x] 문자열 이름 , 다음에는 문자가 나와야한다. ( "sue,woo," )(금지) // ValidException#isValidCommaNextBlankCheck
  - [x] 공백 포함 검사. // ValidException#isValidIncludeBlank
  - [x] 0 입력 검사. // ValidException#isValidZeroCheck
  - [x] 운전하는 자동차 하나만 입력되면 안된다.
  - [x] 자동차의 각각의 이름이 5자이하인지 확인.





### 🚀 기능 요구 사항

초간단 자동차 경주 게임                                                                                                                                                                                                                                                                  을 구현한다.

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### :white_check_mark: 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.