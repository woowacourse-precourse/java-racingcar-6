# 레이스 경주 게임

## 게임 진행 방식
1. 경주할 자동차의 이름을 사용자로부터 입력받는다. (예, "pobi,woni,hello")
2. 경기를 진행할 횟수를 사용자로부터 입력받는다 (예, "5");
3. 전진과 멈춤이 있는데 0-9의 숫자중 4 이상이면 전진하고 4 미만이면 멈춘다.
4. 모든 경기가 종료되면 우승자를 출력한다.

## Class

### RaceController
- getRace() : 사용자로부터 입력받은 자동차의 이름들을 Race 객체로 반환한다.
- getRaceCount() : 사용자로부터 경기를 진행할 횟수를 int로 반환한다.
- game() : 경기횟수만큼 게임을 진행한다.
- getResult() : String[] 타입의 우승자 목록을 하나의 문자열로 출력한다.

### RaceService
- getCarName() : 사용자가 입력한 String 값의 자동차 이름들을 Race 객체에 담아서 반환한다.
- getRaceCount() : 사용자가 입력한 String 값의 경기진행횟수를 int로 반환한다.

### RaceRepository
- getCarName() : 메세지를 출력하고 자동차이름들에 대한 검증이 완료된 String 값을 반환한다.
- getRaceCount() : 메세지를 출력하고 경기진행횟수 대한 검증이 완료된 String 값을 반환한다.

### Valid
- validCarName() : 요구사항에 만족하는 자동차이름들에 대한 검증로직
- validCount() : 요구사항에 만족하는 경기진행횟수에 대한 검증로직

### InputTemplate
- execute() 
  - 메세지를 출력
  - (요구사항)Console.readLine() 으로 사용자로부터 값을 입력받음
  - Valid를 이용한 검증
  - 검증이 완료된 값을 String으로 반환
  - 입력된 값이 없는경우 NoSuchElementException -> IllegalArgumentException 으로 throw

### Domain - Race
- 생성자 : 사용자가 입력한 자동차목록을 Map 형식으로 매칭시킨다.
- play() : (요구사항)Randoms.pickNumberInRange(0,9)을 사용해 4 이상일경우 해당 자동차의 값을 +1 시킨다.
- printPlay() : 한 경기를 진행할때마다 그 결과를 출력한다.
- getMaxNum() : 모든 경기가 종료되고 가장 많이 전진한 횟수를 int로 반환한다.
- getWinner() : 가장 많이 전진한 횟수로 우승자를 String[] 로 반환한다.


## 요구사항
1. [] 자동차 이름은 쉼표(,) 구분
2. [] 자동차 이름은 5자 이하만 가능
3. [] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
4. [] Randoms.pickNumberInRange(0,9)에서 4 이상일 경우 전진
5. [] 우승자는 1명 이상일 수 있다. 여러명일경우 쉼표(,)로 구분
6. [] 입력값이 잘못된경우 IllegalArgumentException 예외 발생

#### 추가 요구사항
1. 들여쓰기는 2까지 허용
2. 삼항연산자 불가능
3. camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 사용
4. camp.nextstep.edu.missionutils.Console의 readLine() 사용


