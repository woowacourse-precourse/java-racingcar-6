
# 레이싱 게임

## 객체 설계 (기능 목록)

### domain

#### RacingGame
1. 게임을 생성한다(Cars, ProgressCount) [x]
2. 게임을 시작한다. [x]
   3. 현재 진행 카운트를 늘리고 [x]
   4. Cars에게 움직이라고 요청한다. [x]
3. 게임의 우승자를 알려준다. [x]
   4. Cars에게 위임한다. [x]
    

#### Cars
1. Cars를 생성한다(carNames, NumberGenerator) [x]
   2. carNames는 2개이상이어야한다. [x]
   3. carNames는 중복되면 안된다. [x]
1. 차들을 움직인다. [x]
   2. 움직일때 NumberGenerator를 통해 얻어온값이 4이상이라면 움직이게 한다.[x]
2. Cars 중에 MaxPosition이 같은것들을 리턴해준다.
   1. Car의 MaxPosition을 찾고 [x]
   2. MaxPosition의 차들을 뽑아 리턴해준다. [x]

#### Car
1. 차를 생성한다(Name,position) [x]
2. 차를 움직인다. [x]
3. 최대 포지션의 차를 찾는 기능 (다른 Car 객체와 compare (Comparable 상속)) [x]
4. 포지션이 같은지 확인하는 기능 [x]

#### CarName
1. 이름을 생성한다. [x]
    1. 이름은 5글자 이하여야한다. [x]

#### ProgressCount
1. 진행 횟수 객체를 생성한다.(현재,최대) [x]
   2. 최대는 1이상이어야합니다.[x]

#### NumberGenerator(인터페이스)
1. 범위에 맞는 랜덤한 값을 생성해준다 [x] 


### View

#### 출력
1. 실행 결과 출력(List<Car> cars) [x]
2. 게임 우승자 출력(List<Car> cars) [x]

#### 입력
1. 차 이름 입력 기능 [x]
2. 시도할 횟 수 입력 기능 [x]


## 요구 사항 외 예외 체크
1. 레이싱 게임은 차가 2대 이상이 되어야 진행된다 -> Controller 정규식, Cars에 구현 [x]
2. 차의 이름은 중복되면 안된다. -> Cars에 구현 [x]
3. 시도 횟수는 1이상이어야 한다. -> ProgressCount 객체 추출 [x]
