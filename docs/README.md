# 구현할 기능 목록
<hr/>

### Car 클래스
> 각 자동차를 생성하는 클래스
> > 필드:
> > + String carName: 자동차의 이름 저장
> > + int movement: 자동차가 움직인 횟수 저장, 초깃값은 0

##### Car(name) 생성자
+ 자동차의 이름을 입력받아 저장함

##### void move()
+ isMovable() 함수를 호출함
+ isMovable() 함수의 반환값을 movement에 더해줌
+ printCurrentState() 함수를 호출함

##### void printCurrentState()
+ 자동차의 현재 상태를 출력함

##### int isMovable()
+ 0에서 9사이의 무작위 값을 구한 후 값이 4 이상일 경우 1 반환, 아닐 경우 0 반환

<br/>

### RaceStarter 클래스
> 경주를 시작하고 관리하는 클래스
> > 필드: 
> > + ArrayList cars: Car 클래스를 저장
> > + int moveNum: 사용자가 입력한 이동 횟수 저장
> > + int carNum: 자동차의 개수 저장

##### RaceStarter(str, moveNum) 생성자
+ getCars(str) 함수를 호출하고 반환값을 carNum에 할당함
+ moveNum에 사용자가 입력한 횟수인 moveNum을 할당함

##### int getCars(str)
+ 사용자가 입력한 문자열을 ','를 기준으로 나눔
+ checkInputValidity 함수를 통해 입력값 유효성 체크
+ 각각의 자동차 이름으로 Car 클래스를 만들고 cars 리스트에 추가함
+ 자동차의 개수를 반환함

##### void start()
+ cars 리스트 내부의 자동차들에 대해 move()를 moveNum번 반복
+ printWinner 함수를 호출

##### void printWinner()
+ 각 자동차의 movement를 비교하고 우승자를 출력함

##### void checkInputValidity(name)
+ 각 자동차의 이름의 5자 이하인지 확인 후 조건에 맞지 않으면 IllegalArgumentException 발생

<br/>

### Application 클래스
> 프로그램을 시작시키는 클래스

##### main 메소드
+ 사용자 입력값을 받음
+ raceStarter 클래스의 인스턴스를 생성하고 start를 호출함