# ⚙️ 기능 목록 

### Application.java
📌 자동차 경주를 시작
```
[자동차 경주를 시작]
RacingCarController.start()
```
****
## [controller] 패키지
### RacingCarController.java
📌 자동차 경주의 흐름을 관리
```
[자동차 이름 입력 메세지 문구 출력]
outputController.printCarNameInputMessage();
```
```
[자동차 리스트 생성]
CarListMaker carListMaker = new CarListMaker();
List<Car> carList = carListMaker.makeCarList();
```
```
[시도 횟수 입력 메세지 문구 출력]
outputController.printTryingCountsInputMessage();
```
```
[시도 횟수 입력 받기]
TryingCounts tryingCounts = new TryingCounts();
Integer tryingCountsNumber = tryingCounts.getTryingCounts();
```
```
[자동차 움직이기]
CarMovementController carMovementController = new CarMovementController();
String racingCarResult = carMovementController.moveCars(carList, tryingCountsNumber);
```
```
[자동차 경주 결과 출력]
outputController.printResult(racingCarResult);
```

****
## [car] 패키지
### Car.java
📌 자동차의 정보를 저장
```
[자동차 이름, 이동 거리 저장]
String name;
Integer steps;

public Car(String name, Integer steps) {
    this.name = name;
    this.steps = steps;
}
```
<br/>

### CarListMaker.java
📌 자동차의 리스트를 생성
```
[자동차 리스트를 문자열로 입력받고 유효성을 검사 후 리스트 생성]
public List<Car> makeCarList();
```
<br/>

### CarMovementController.java
📌 자동차들의 움직임에 따른 흐름을 관리 
```
[자동차들을 움직이고 그에 따른 기록을 저장]
public String moveCars(List<Car> carList, Integer tryingCountsNumber)
```
<br/>

### CarMovementResultLogStorage.java
📌 자동차들의 움직임의 기록을 저장하고 그 저장값을 반환
```
[자동차들의 움직임을 기록]
public void addLog(String logs)
```
```
[자동차들의 움직임 기록을 반환]
public String getResultStringOfCarMovements()
```
<br/>

### CarMovementWinnerWriter.java
📌 우승한 자동차를 기록
```
[제일 멀리간 자동차들을 받아와서 기록]
public void writeCarMovementWinner(List<Car> carList, CarMovementResultLogStorage carMovementResultLogStorage)
```
<br/>


### CarMovementWriter.java
📌 자동차들의 이동을 기록
```
[자동차들의 이동 거리를 확인하고 이름과 이동 거리를 기록]
public void writeMovementOfCars(List<Car> carList, Integer index, CarMovementResultLogStorage carMovementResultLogStorage)
```
```
[자동차의 이동 거리 확인]
private String checkMovedStepsOfCar(Car car)
```
<br/>

### CarMover.java
📌 자동차들을 이동시킴
```
[자동차의 랜덤 값에 따른 이동 여부를 받아와서 기록]
public void moveCars(List<Car> carList, Integer tryingCountsNumber, CarMovementResultLogStorage carMovementResultLogStorage)
```

```
[자동차의 이동 여부를 랜덤 값에 따라 판단]
private void updateCarMovements(List<Car> carList, Integer index)
```

### RacingCarWinnerFinder.java
📌 자동차 경주에 우승한 자동차들 찾기
```
[자동차의 이동거리를 최대값 변수에 갱신하면서 최대로 멀리 간 자동차들을 저장 후 반환]
public List<String> getRacingCarWinner(List<Car> carList, Integer index)
```

****
## [tryingcounts] 패키지
### TryingCounts.java
📌 자동차 이름 유효성 확인
```
[시도 횟수를 입력 받고 유효성 검사하기]
public Integer getTryingCounts() 
```

****
## [validation] 패키지
### [carname] 내부 패키지
### CarNamesValidationChecker.java
📌 자동차 이름 유효성 확인
```
[자동차 이름 유효성 확인하면서 유효하지 않을 경우 IllegalArguemntException 발생]
public void checkCarNamesValidation(String carNamesString)
```
<br/>

### CarNamesStringEndIllegalQuoteChecker.java
📌 자동차들 이름 문자열 마지막 구분자 확인
```
[마지막에 구분자가 있으면 잘못된 입력으로 간주하고 IllegalArguemntException 발생]
public void checkCarNamesStringEndIllegalQuote(String carNamesString)
```
<br/>

### CarNamesStringSpaceChecker.java
📌 자동차들 이름에 공백이 포함되어 있는지 확인
```
[자동차들 이름에 공백이 포함되어 있으면 IllegalArguemntException 발생]
public void checkCarNamesWithSpaceChecker(String carNamesString)
```
<br/>

### CarNamesLengthValidationChecker.java
📌 자동차들의 이름 길이가 유효한지 확인
```
[자동차들의 이름 중 길이가 맞지 않는 것이 있다면 IllegalArguemntException 발생]
public void checkCarNamesLengthValidation(List<String> carNamesList)
```
<br/>

### CarNamesDuplicationChecker.java
📌 자동차들 이름 중 중복이 없는지 확인
```
[자동차들의 이름 중 중복되는 것이 있다면 IllegalArguemntException 발생]
public void checkCarNamesDuplicationChecker(List<String> carNamesList)
```
<br/>
<br/>

### [trycounts] 내부 패키지
### TryingCountsNumberValidationChecker.java
📌 시도 횟수가 숫자로만 이루어져 있는지 확인
```
[시도 횟수가 숫자가 아닌 문자로 이루어져 있으면 IllegalArguemntException 발생]
public Integer checkTryingCountsNumberValidation(String tryingCounts)
```
<br/>

****
## [input] 패키지
### InputController.java
📌 입력에 대한 관리
```
[자동차 이름들 입력 받기]
public String scanCarNames()
```
```
[시도 횟수 입력 받기]
public String scanTryingCountsNumber()
```

****
## [output] 패키지
### OutputController.java
📌 출력에 대한 관리
```
[자동차 이름 입력에 대한 메세지 출력]
public void printCarNameInputMessage()
```
```
[시도 횟수 입력에 대한 메세지 출력]
public void printTryingCountsInputMessage()
```
```
[자동차 경주 결과에 대한 출력]
public void printResult(String racingCarResult)
```