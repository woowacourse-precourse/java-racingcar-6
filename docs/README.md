# 초간단 자동차 경주 게임
***
### 프로젝트 구조
```
tree

Application - main 클래스, 프로그램 진입점
RacingGame - 자동차 경주 게임 클래스, 입력, 출력 담당
ValidInput - 입력값 유효한 지 판단하는 클래스 (정적 함수)
SimpleCar - 자동차 클래스
RandomNumberGenerator - 랜덤 숫자 제공하는 클래스 (정적 함수)
Constants - 스트링 상수들 저장된 클래스
```
***
### 기능 목록 정리
``` Java
초간단 자동차 경주 게임 구현                            RacingGame#startGame()

자동차 이름 입력 받기                                  RacingGame#promptForPlayerNames()
    입력받은 문자열에 대해 유효한 지 판단                 ValidInput#isValidString()
        쉼표가 있는 지                                ValidInput#hasComma()
        입력 문자열이 쉼표로 시작하거나 끝나는 지         ValidInput#startsOrEndsWithComma()   
        쉼표가 두번 연속 나오는 지                      ValidInput#hasDoubleComma()
    자동차 이름들을 쉼표(,)를 기준으로 나누어 리스트 생성  
    리스트에 저장된 이름들이 유효한 지 판단              ValidInput#isValidNames()
        각 이름들이 5자 이하인지                       ValidInput#isNameLengthLessThanOrEqual5()  
        이름들에 중복이 있는 지                        ValidInput#hasDuplicateNames()
        
이름 개수 만큼 자동차 생성                              SimpleCar#createCar()
    각 자동차에 이름 부여                              SimpleCar#SimpleCar()
    
사용자는 몇 번의 이동을 할 것인지 입력                   RacingGame#promptNumberOfMoves()

주어진 횟수 동안 n대의 자동차는 전진 또는 정지            SimpleCar#goForward()
    전진 여부를 결정하는 0~9 사이 무작위 값 설정         
    무작위 값이 4 이상일 경우 전진 
    
각 회차에 따른 자동차 이동 여부 출력                     RacingGame#printCarMovement()

자동차 경주 게임 완료 후 우승자 출력                     RacingGame#printWinner()
    우승자는 한 명 이상일 수 있음
    우승자가 여러 명인 경우 쉼표(,)로 구분하여 출력        
    
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생 후 애플리케이션 종료 ValidInput#isInputValid()
```




