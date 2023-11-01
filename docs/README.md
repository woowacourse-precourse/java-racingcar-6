<h1>프리코스2: 자동자 경주 게임</h1>


### 사용자 자동차 이름 입력
- n대의 자동차 이름을 입력한다: InputView
  - 쉼표(,)로 구분한다: inputView `validateCarInput()`
  - 자동차 이름은 5자 이하만 가능하다: domain `validateCarName()`

### 사용자 시도(이동) 횟수 입력  
- 시도 횟수를 입력한다: InputView  
  - 입력은 숫자여야 한다: inputView `validateAttempNum()`

### 전진 조건 계산
- 전진 조건을 계산한다: CarRace
  - 각 자동차마다 0~9 사이 랜덤 값 생성
  - 랜덤 값 4 이상일 시 전진 

### 차수별 실행 결과 출력
- 차수별 실행 결과를 출력한다: OutputView
  - 시도 횟수가 끝날 때까지 반복한다.

### 우승 후보 계산
- 우승 후보를 계산한다: Result
  - 전진 횟수가 가장 많은 자동차가 우승한다.

### 우승 후보 출력
- 우승 후보를 출력한다: OutputView
  - 우승자가 여러 명일 경우 쉼표(,)를 사용해 구분한다.

<hr/>

    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    시도할 회수는 몇회인가요?
    5  

    실행 결과
    pobi : -
    woni :
    jun : -
    
    pobi : --
    woni : -
    jun : --
    
    pobi : ---
    woni : --
    jun : ---
    
    pobi : ----
    woni : ---
    jun : ----
    
    pobi : -----
    woni : ----
    jun : -----
    
    최종 우승자 : pobi, jun