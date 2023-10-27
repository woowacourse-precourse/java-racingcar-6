# class Car
- 변수
	- String name : 입력받은 자동차 이름으로 초기화된다.
    - int step : 현재 전진한 횟수를 저장한다.
    - String show : 현재 전진한 상태를 출력할 형태로 저장한다.
- 메서드  
    - go : 1-9 사이의 난수를 생성해 4이상이면 step을 +1하고 show에 "-"를 추가한다.
    - print : 현재 전진한 횟수를 "{name} : --(step만큼)" 형태로 출력한다.

# 기능
1. 입력 받기 <br/>
	자동차 이름과 시도할 회수를 입력받는다. 자동차 이름은 ArrayList에 저장한다. Car 객체 배열을 생성하고 자동차 개수만큼 Car 인스턴스를 만들며 저장된 자동차 이름으로 초기화한다. <br/><br/>
	
2. 실행 결과 출력하기 <br/>
	Application 내부의 result 함수로 구현.<br/>
	시도할 횟수만큼 Car 객체 배열에서 각 Car마다 go() print()를 실행한다. 각 시도마다 줄바꿈을 출력한다. <br/><br/>

3. 최종 우승자 출력하기 <br/>
	Application 내부의 winner 함수로 구현.<br/>
	Car 객체 배열을 돌며 가장 큰 step 값을 찾고, 한번 더 돌며 maxStep을 가진 Car의 name을 출력한다. <br/><br/>