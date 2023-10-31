# 초간단 자동차 경주 게임

***

### 프로젝트 구조

```
src
├─main
│  └─java
│      └─racingcar
│               ├─Application.java  
│               ├─Constants.java      
│               ├─RacingGame.java      
│               ├─SimpleCar.java      
│               └─ValidInput.java      
└─test
    └─java
        ├─racingcar
        │        ├─ApplicationTest.java   
        │        └─ValidInputTest.java          
        └─study
             └─StringTest.java       

Application - main 클래스, 프로그램 진입점
Constants - 스트링 상수들 저장된 클래스
RacingGame - 자동차 경주 게임 클래스, 입력, 출력 담당
SimpleCar - 자동차 클래스
ValidInput - 입력값 유효한 지 판단하는 클래스
```

***

### 기능 목록 정리

``` Java
[v] 초간단 자동차 경주 게임 구현                               RacingGame#startGame()
    [v] 자동차 이름 입력 받기                                 RacingGame#promptForPlayerNames()
        [v] 입력받은 문자열에 대해 유효한 지 판단               ValidInput#isValidString()
            [v] 쉼표가 있는 지                                ValidInput#hasComma()
            [v] 쉼표가 두 번 연속 나오는 지                    ValidInput#hasDoubleComma()        
            [v] 입력 문자열이 쉼표로 시작하거나 끝나는 지        ValidInput#startsOrEndsWithComma()   
        [v] 자동차 이름들을 쉼표(,)를 기준으로 나누어 리스트 생성  
        [v] 리스트에 저장된 이름들이 유효한 지 판단              ValidInput#isValidNames()
            [v] 각 이름들이 5자 이하인지                       ValidInput#isNameLengthLessThanOrEqual5()  
            [v] 이름들에 중복이 있는 지                        ValidInput#hasDuplicateNames()
        
    [v] 이름 개수 만큼 자동차 생성                             SimpleCar#createCar()
        [v] 각 자동차에 이름 부여                             SimpleCar#SimpleCar()
    
    [v] 사용자는 몇 번의 이동을 할 것인지 입력                   RacingGame#promptNumberOfMoves()

    [v] 주어진 횟수 동안 n대의 자동차는 전진 또는 정지            SimpleCar#goForward()
        [v] 전진 여부를 결정하는 0~9 사이 무작위 값 설정         
        [v] 무작위 값이 4 이상일 경우 전진    
    [v] 각 회차에 따른 자동차 이동 여부 출력                     RacingGame#printCarMovement()

    [v] 자동차 경주 게임 완료 후 우승자 출력                     RacingGame#printWinner()
        [v] 우승자는 한 명 이상일 수 있음
        [v] 우승자가 여러 명인 경우 쉼표(,)로 구분하여 출력        
    
[v] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생 후 애플리케이션 종료
```




