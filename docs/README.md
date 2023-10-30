Racing 기능요구사항 분석


기능

컴퓨터가 게임을 시작한다

출력문을 출력하고 

입력문을 입력한다.

자동차 객체 정보를 저장한다.

자동차 경주를 실행한다.










- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 어플리케이션은 종료되어야 한다.
- [ ] 주어진 횟수동안 n대의 자동차는 전진 또는 멈출 수 있다. - n대의 자동차가 출발하며, 행동에는 전진과 멈춤이 있다
- [ ] 자동차 이름은 쉼표, 를 기준으로 구분하며 이름은 5자 이하만 가능하다 - 쉼표기준으로 구분하고 5자 이하로 이름을 적을 것
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. - 몇번 이동할지 입력창 필요
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. - 자동차가 전진 시  자동차 이름 출력
- [ ] 전진하는 조건은 0~9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. - 4이상일 경우 전진가능!
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. -
- [ ] 우승자가 여러 명일 경우 , 를 이용하여 구분한다.




(천천히 코딩하세요!)

알고리즘 분석

1.게임시작!
2.경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) 출력
3.이름 입력
- 이름 갯수만큼 car을 만들어야 할까요? 넵!
- 필드값에는 이름과 숫자를 사용할꺼에요!
- cargenerator에서 split을 사용해야 할까요? 잘 모르겠어요 ㅠㅠ
- Car generator에는 필드에 배열 혹은 리스트가 있어야할 것 같아요!
- Car generator에는 리스트에 Car generator를 리턴하는 메소드가 있어야 할 것 같아요!
- 잘못된 값을 입력하면 IllegalArgumentException선언!

4.시도할 회수는 몇회인가요? 출력

5.횟수입력
- car의 갯수만큼 generator을 사용한다.
- 횟수만큼 반복한다. 만약 4이상일 경우 전진!
- 가장 높은 전진수의 차량이 승리!
- 횟수제한이 없냉?
- 그럼 숫자이외의 값이 들어오면 IllegalArgumentException선언!

6. 승리 차량을 출력한다. 만약 출력차량이 복수라면 ,를 붙여서 출력한다.



RacingGame —

    Input										
    output
    
    Play(){											
    output 시작
    String carNames = input 자동차이름

	cargenerator									
	
	simulator
	
	output 횟수
	int turn = input 횟수												
    }

	announceStart
	
												

	announceSituation (while)						

	announceWin				



CarGenerator —

    String carNames
    
    SplitNames()
    
    generateCars()


Simulator —

    carList
    
    rideRace() {random generator 사용}
    
    checkWinner!


Car —

    Name
    Result?

Gameview —

    announceRacing (){for : name : result}








객체를 어떻게 나눌 것인가? 효율로 생각해보자

게임이 기계 혹은 시스템이라고 생각해보자

게임안에는 game의

		inputview, outputview, gameview

               cargenerator, simulator, Winnerchecker

		domain(car)

               Randomgenerator 의 클래스를 초기 세팅으로 구성한다