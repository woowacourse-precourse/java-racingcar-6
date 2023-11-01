# 자동차 경주 🚘
> **n 대의 자동차가 m 번의 횟수 만큼 이동하여 우승자를 가리는 게임**
<br/>

## 🎮 게임 진행

1. 게임 시작  
    - 경주할 자동차 이름 입력  
    `경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)`  
    - 시도할 횟수 입력  
   `시도할 회수는 몇회인가요?`  
   <br/><br/>
2. m 회 동안 경주 시행 
    - ( 0 - 9 사이 무작위 값 ) >= 4 → 전진  
    - ( 0 - 9 사이 무작위 값 ) <= 3 → 멈춤  
   <br/>
    - 실행 결과 출력  
      `실행 결과` 아래로 매 회 결과를 출력  
      ex) 1 회 결과 출력
      ```text
      pobi : -
      woni : 
      jun : -
      ```
    <br/><br/>
3. 최종 우승자 출력  
   - 단독 우승자  
   ex) `최종 우승자 : pobi`  
   - 공동 우승자  
   ex) `최종 우승자 : pobi, jun`
   <br/><br/>
   <br/>

## 🕹 기능 목록

### 1. _domain_ 패키지

**(1) CarRacing 클래스**

- <code>**race(int turn)**</code>
  - **레이스 게임 진행**
  - _turn_ 만큼 경주 한 턴을 진행하는 메소드 호출
    - 한 턴 결과 출력 메소드 호출
  - 최종 결과 메소드 호출
    <br/><br/>

- <code>**oneTurnRace()**</code>
  - **한 턴의 경주 시행**
  - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` API 사용하여 랜덤 수 r 생성  
    - r 의 값에 따라 전진 or 멈춤 시행
      <br/><br/>

- <code>**getRaceResult()**</code>
  - _Referee_ 클래스와 협력하여 최종 우승자 선발 후 출력
    <br/><br/>

**(2) Referee 클래스**

- <code>**findWinner(List\<String> cars, List\<Integer> carPos)**</code>
  - **최종 우승자**인 _가장 멀리 간 차 List_ 구한 뒤 반환
    <br/><br/>

### 2. _validation_ 패키지

**(1) InputValidator 클래스**

- <code>**validateCarsInput()**</code>
    - 쉼표로 구분된 **자동차 이름이 5자 이하**인지 검증
    - 입력이 잘못되었을 시 `IllegalArgumentException` 발생 후 어플리케이션 종료
      <br/><br/>

- <code>**validateTurnInput()**</code>
    - **시도할 횟수**로 **0 이상의 정수**가 입력되었는지 검증
    - 입력이 잘못되었을 시 `IllegalArgumentException` 발생 후 어플리케이션 종료
      <br/><br/>

### 3. _view_ 패키지

**(1) InputView 클래스**

- <code>**inputCars()**</code>
  - 쉼표 기준으로 구분하여 **경주할 자동차 이름**을 입력 받은 후 List로 반환
    <br/><br/>

- <code>**inputTurn()**</code>
  - **몇 회 경기를 시행할 지** 입력 받아 int 반환
    <br/><br/>

**(1) OutputView 클래스**

- <code>**printProgressStmt()**</code>
  - 실행 결과 안내문 출력
    <br/><br/>

- <code>**printOneTurnResult(List\<String> cars, List\<Integer> carPos)**</code>
    - 한 턴 경주 시행 결과 출력
      <br/><br/>

- <code>**printWinnerResult(List\<String> winner)**</code>
    - _winner List_ 를 받아 최종 우승자 출력
      <br/><br/>
