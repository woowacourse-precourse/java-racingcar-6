목표 메소드 분리, 메소드 이름 잘 짓기  
메소도를 분리하는 이유는 생산성에 있다 생각, 생산성의 큰 요소 중 하나는 중복된 코드를 반복하지 않기  
코드가 중복될 수 있는 부분을 최대한 고려해서 작성해보자.  
코딩의 큰 매력은 같은 요구사항이라도 구현에는 여러 방법이 있는 것. 

클래스 Car, CarFactory, GamePlayer

### Car 클래스  
- 역할 : 게임의 참여자   
- constructor  
Car(String name)
- field  
name 자동차의 이름  
location 자동차의 위치  
- method 
public String getName() 자동차 이름 반환  
void advanceOnceRandomly(GameService gameService) 자동차 전진  
void getLocation() 자동차의 위치 출력 

### CarFactory 클래스 
- 역할 : 입력받은 문자로, 여러 Car 객체를 생성  
- method  
List\<Car> creatCars(List\<String> carNames)입력받은 문자열들을 토대로 여러 Car 객체 생성후 반환  

### GameService 클래스  
- 역할 : 게임 진행에 필요한 기능 담당  
- method
int randomNumber() 무작위의 수 반환
List\<Car> selectWinners(List\<Car> cars) 승리자들 결정  
List<String> inputToCarNames(String input) 입력을 차들의 이름으로 나눈 후 리스트 반환.

### IoValidation 클래스
-역할: 입출력 오류 검사  
- method  
void validateInputCarName(List\<Car> carNames) 차의 입력이 옳바른지 검사  
void validateTurnNumber(String string)  

### IoService 클래스  
- 역할 : 게임의 입출력 담당  
- method  
String inputCarNames() 경주할 차 이름들 입력  
int inputTurnNumber() 몇번의 게임을 진행할지 입력
printOneTurnResult(List\<Car> cars) 한 턴의 결과를 출력  
printWinners(List\<Car> winners) 승리자들 출력

### GamePlayer 클래스
- 역할 : 게임의 진행을 총괄  
- method  
void oneTurn(List\<Car> cars) 한 차수 진행  
void randomAdvanceAll(List\<Car> cars) 모든 차 랜덤하게 전진  
playGame(int round,List\<Cars>) 게임 진행
startGame() 게임 시작 


