## 기능 목록

###  UserInput Class 
1. 자동차 이름 입력 기능 `Map<String, Integer> inputCarNames()`
   - 쉼표(,)로 구분하여 다수의 자동차 이름 입력 가능
   - 입력값 검증
     1. 각 이름의 길이는 1 ~ 5자리 만 가능
     2. 중복 불가능


2. 시도 횟수 입력 기능 `int inputNumberOfRounds()`
    - 입력값 검증
      1. 숫자만 입력 가능
      2. 1 ~ 2147483647(MAX_INTEGER 값) 값만 가능

###  RacingCarGame Class
3. 자동차 전진 기능 `Map<String, Integer> executeAllRounds(Map<String, Integer> carNameAndMovementCountMap, int numberOfRounds)`
   - 각 자동차는 매 라운드 당 랜덤으로 0 ~ 9 사이의 수 중 하나를 뽑아 4 이상이면 앞으로 전진
   - 라운드 별 누적된 전진 결과 출력


4. 게임 완료 후 우승자 선출 기능 `List<String> selectFinalWinner(Map<String, Integer> carNameAndMovementCountMap)`
   - 가장 많이 전징한 우승자 이름 출력
   - 우승자 중복 가능
