# 자동차 경주

## ✍️ 기능 목록
 ### 입력 
  - [X] 경주 할 자동차 이름 입력
  - [X] 자동차 이름에 공백이 들어갈 경우 공백 제거 기능 ( 공백 제거시, 동일한 이름의 자동차일 경우 발생할 문제에 대한 고려 )
  - [X] 시도할 횟수 입력
  - [X] 게임 진행 횟수 입력 시 공백 제거 기능
 ### 출력
  - [X] 각 차수별 실행 결과 출력
  - [X] 우승자 결과 출력
 ### 기능 
  - [X] 자동차마다 0~9 사이의 무작위 값을 받는 기능
  - [X] 전진해야 하는 자동차일 경우 전진하는 기능
  - [X] 전진한 자동차를 조회하는 기능
  - [X] 게임 종료를 알리는 기능
  - [X] 게임 종료 시 , 각 자동차가 얼마나 이동했는지 비교하는 기능
  - [X] 가장 멀리 간 자동차들을 판단하는 기능
  - [X] 우승자에 해당하는 자동차를 조회하는 기능 
 ### 예외처리
  - 자동차 이름 입력 시 
    - [X] 입력받은 자동차 이름이 중복될 경우 
    - [X] 입력 받은 자동차 이름이 5글자를 초과할 경우 
    - [X] 이름에 공백만 입력한 경우
  - 게임 진행 횟수 입력 시
    - [X] 시도 횟수를 너무 크게 입력한 경우 ( 최대를 10만 범위 내로 제한 )
    - [X] 숫자가 아닌 문자를 입력한 경우 ( 연산자, 문자, ...  ) 
    - [X] 0을 입력한 경우
  - 게임 종료 시 
    - [X] 모든 자동차가 1칸도 움직이지 않은 경우

## 🗂️️ 프로젝트 구조
    📦src
    ┣ 📂main
    ┃ ┗ 📂java
    ┃ ┃ ┗ 📂racingcar
    ┃ ┃ ┃ ┣ 📂constant
    ┃ ┃ ┃ ┃ ┣ 📜Constant.java
    ┃ ┃ ┃ ┃ ┗ 📜ExceptionMessage.java
    ┃ ┃ ┃ ┣ 📂controller
    ┃ ┃ ┃ ┃ ┗ 📜RaceController.java
    ┃ ┃ ┃ ┣ 📂domain
    ┃ ┃ ┃ ┃ ┣ 📜Car.java
    ┃ ┃ ┃ ┃ ┣ 📜Race.java
    ┃ ┃ ┃ ┃ ┣ 📜RaceCarGarage.java
    ┃ ┃ ┃ ┃ ┗ 📜RacingGame.java
    ┃ ┃ ┃ ┣ 📂validator
    ┃ ┃ ┃ ┃ ┗ 📜InputValidator.java
    ┃ ┃ ┃ ┣ 📂view
    ┃ ┃ ┃ ┃ ┣ 📜Input.java
    ┃ ┃ ┃ ┃ ┗ 📜Output.java
    ┃ ┃ ┃ ┗ 📜Application.java
    ┗ 📂test
    ┃ ┗ 📂java
    ┃ ┃ ┣ 📂racingcar
    ┃ ┃ ┃ ┣ 📂validator
    ┃ ┃ ┃ ┃ ┗ 📜InputValidatorTest.java
    ┃ ┃ ┃ ┗ 📜ApplicationTest.java
    ┃ ┃ ┗ 📂study
    ┃ ┃ ┃ ┗ 📜StringTest.java

## 🤓 클래스를 나눈 기준
 - 객체 지향적으로 설계하고 싶어 기준을 갖고 분리했습니다. 더 나은 설계를 위해 생각을 공유 해주세요 !  
 - RacingGame ( 게임 시작을 담당 )
 - RaceController ( RacingGame 이 너무 많은 책임을 담당하는 것을 분리 해주기 위해 생성 )
    - RaceCarGarage, Race, Output 를 조율해주는 역할  
 - Input ( 입력을 담당 ) 
 - InputValidator ( 입력에 대한 검증을 담당 )
 - Output ( 출력을 담당 )
 - RaceCarGarage ( 자동차 객체를 생성해주는 역할 )
 - Race ( 게임 진행을 담당 )