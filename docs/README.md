# 구현할 기능 목록 정리

## Controller
### 자동차 이름 입력 받기
- Controller#enterCarName() 
- 사용자에게 경주 할 자동차 이름을 입력 받는 기능.
- 한 줄로 입력 받으면 쉼표를 기준으로 자동차 이름 구분한다.

### 자동차 생성하기 
- Controller#addCar()
- 자동차 이름을 기준으로 자동차를 생성한다.

### 시도할 회수 입력 받기
- Controller#enterTry()
- 사용자에게 몇 번의 이동을 할 것인지 시도할 횟수를 입력 받는다.

### 실행 결과를 보여주기 위한 플로우 코드
- Controller#raceStart()
- 자동차를 이동 시키기 위해 Car의 forward() 메서드를 호출한다.
- 실행 결과를 보여주기 위해 Mc의 showResult() 메서드를 호출한다.


## Car (Model)
### 랜덤값 생성하기
- Car#calRandomNum()
- 랜덤값을 생성한다.

### 자동차 이동하기 
- Car#forward()
- 랜덤 값이 4 이상이면 자동차를 이동한다.

## Mc (View)
### 실행 결과 출력하기
- Mc#showResult
- 각 횟수당 실행 결과를 출력한다.

### 우승자 출력
- Mc#showWinner
- 우승자를 출력하는데, 우승자가 1명이면 oneWinner(), 우승자가 여러면이면 coWinner()를 호출한다.


## Validator (유효성 검사)

### 자동차 이름 글자수 검사 
- Validator#checkStringLength()
- 사용자한테 입력 받은 자동차 이름이 5자를 초과하면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

### 자동차 이름 중복 검사
- Validator#checkStringDuplicate()
- 사용자한테 입력 받은 자동차 이름에 중복이 있으면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

### 자동차 이름 최소 개수
- Validator#checkStringSize()
- 사용자한테 입력 받은 자동차 이름이 오직 하나라면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
