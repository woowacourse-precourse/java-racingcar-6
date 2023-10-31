# 우테코 2주차 과제 - 자동차 경주 게임 만들기

## 요구된 기능 목록 

### 1. 공통

    1. 유저의 입력값이 요구값과 다를 경우 IllegalArgumentException 발생

### 2. Game 클래스

    1. 게임 시작

    2. 게임 유지동안 사용될 Dice 인스턴스 생성

    3. 유저의 입력값에 따라 상응하는 수의 Car 인스턴스 생성

    4. 사용자로부터 이동할 횟수 받아오기

    5. 각 턴별 자동차의 위치 출력

    6. 게임 종료(이동횟수 소진)시 우승한 1명 이상의 Player 표시, 여러명일 경우 쉼표로 구분

### 3. Car 클래스

    1. 자동차는 전진 혹은 정지(이동하지 않음) 가능
 
    2. 각 자동차는 5자 이하의 이름을 가지고 있으며, 
       이 이름은 유저의 입력값에 따르며 각 이름은 쉼표로 구분됨

    3. 각 턴에서 Dice 에서 생성된값이 4 이상일 때 한 칸 이동

### 4. Dice 클래스

    1. 0부터 9 사이 (0, 9 포함) 무작위의 값 생성


## 구현할 클래스와 메서드 목록

### 1. Game 클래스

#### 필드 : Car 객체 리스트, int 턴 횟수, Dice 객체

    1. run() - 사용자의 인풋을 받아 인스턴스 생성 후 게임 진행

~~2. printResults() - 각 턴별 결과 출력~~ < 삭제, Car 클래스의 printResult()로 대신함

    3. printWinners() - 게임 종료 후 우승자 출력


---- 추가 -----

~~4. getCarInput() - 자동차 이름 입력~~ < 수정, assignCars()로 변경

    4. assignCars() - 자동차 이름 입력받아 리스트 생성후 RacingCars로 넘겨줌

    5. getTurnsInput() - 게임 진행 횟수 입력

### 2. Car 클래스

#### 필드: int 현재위치, String 이름 

~~1. move() - 한 칸 이동~~ < 변경
    
    1. move(Dice dice) - 주사위를 굴려 나온 숫자에 따라 이동 여부 결정
  
~~2. stay() - 위치 유지~~ < 삭제, move() 메소드와 통합

    3. getPosition() - 현재 위치 반환 

    4. getName() - 이름 반환

    5. printResult() - 주사위 굴린 후 위치 출력

### 3. Dice 클래스

#### 필드: int 최솟값, int 최댓값

    1. roll() - 주사위를 굴려 최솟값 ~ 최댓값 사이 랜덤한 값 생성 후 반환 

--------추가---------

### 4. RacingCars 클래스 : Car 클래스의 일급컬렉션

#### 필드: LinkedList&lt;Car&gt; cars

    1. validateCarNames(LinkedList<Car> cars) - 각 차의 이름이 5자 이하인지 확인

    2. moveCars(Dice dice) - 컬렉션 안의 Car 객체들 턴마다 이동 혹은 정지

    3. getWinners() - Car 객체들중 가장 이동거리가 긴 객체들의 이름을 리스트로 반환

------- 추가 -------
    
    4. checkDuplicateNames(LinkedList<Car> cars) - 중복되는 이름이 있는지 확인