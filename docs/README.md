# 구성 요소 분석
## 1. 자동차 클래스
자동차 리스트를 구성하기 위한 클래스이다. 자동차의 이름과 이동한 경로를 저장한다.
### 기능1) 자동차 설정 `public void createCar(String carName)`
매개변수로 지정할 자동차의 이름 문자열을 넘겨 받는다.
### 기능2) 자동차 이동 `public void carInfoUpdate()`
자동차가 이동한 이후의 경로를 갱신한다. 동시에 이동 횟수를 기록한다.
> **자동차의 이동 횟수와 경로를 함께 저장하는 이유는?**<br>
> 자동차는 이동할 때마다 이동 횟수만큼의 `-`를 출력하게 된다.<br>
> 이동 횟수만 기록할 경우 출력시에 이동 횟수를 카운트하는 연산을 추가해야하고, 경로만 기록할 시에 우승자를 기록할 때 경로를 역산하여 이동 횟수를 구해야한다.<br>
> 이때 이동 경로 문자열과 이동 횟수를 미리 저장해두면 필요할 때마다 연산하지 않아도 된다.
### 기능3) 이름 반환 `public String getCarName()`
출력에 필요한 이름을 반환한다.
### 기능4) 경로 반환 `public String getCarPath()`
출력에 필요한 경로를 반환한다.

## 2. 컴퓨터 데이터 I/O 클래스
데이터의 입/출력과 이동 관련한 랜덤 숫자를 만들기 위한 클래스이다.
### 기능1) 차 정보 입력 `public void userInputCarsInfo()`
사용자는 자동차의 이름을 `,`로 구분한 문자열을 입력받는다. <br>
구분된 문자열을 이용해 자동차의 개수만큼 자동차 설정 메소드를 호출한다. <br>
입력과 동시에 문자열의 길이와 문자열이 공백으로만 이루어져 있는지 검증한다. <br>
입력 문자열 검증 이후 자동차 이름간의 중복을 검증한다.
### 기능2) 이동 횟수 입력 `public void userInputMovingInfo()`
사용자는 자동차의 이동 횟수를 입력한다.
### 기능3) 시스템 메세지 출력 `public void printSystemMessage()`
상수로 구성한 프로그램의 시작, 입력을 받기 위한 메세지, 최종 우승자 메세지를 출력한다.
### 기능4) 이동 결과 출력 `public void printMovingResult()`
자동차를 이동할 때마다 갱신된 경로를 출력한다.
### 기능5) 우승자 출력 `public void printWinner(List<String> winnerList)`
매개변수로 우승자 리스트를 받는다. 형식에 따라 우승자를 출력한다.
### 기능6) 랜덤 숫자 생성 `public boolean makeRandomNumber()`
이동 여부를 위한 랜덤 숫자를 생성한다. 4 이상의 숫자가 생성된 경우 `true`를 반환한다.
### 기능7) 이동 횟수 Setter `public void setNumtotalMoving(int numberToChange)`
이동 횟수를 수정한다.
### 기능8) 이동 횟수 Getter `public int getNumTotalMoving()`
이동 횟수를 받아온다.

## 3. 검증 클래스
사용자의 입력을 검증하는 클래스이다.
### 기능1) 길이 검증 `public boolean validateLength(String checkStr, int lengthLimit)`
자동차 이름의 길이를 검증한다. <br>
매개변수로 입력된 `lengthLimit`보다 길이가 클 경우 `IllegalArgumentException` 예외를 발생시킨다.
### 기능2) 중복 검증 `public boolean validateDuplicate(List<String> nameSets)`
자동차 이름 간의 중복 여부를 검증한다. 매개변수로 자동차 이름의 리스트를 넘겨 받는다. <br>
중복이 존재하는 경우 `IllegalArgumentException` 예외를 발생시킨다.
### 기능3) 자동차 이름 공백 검증 `public void validateEmptySpace()`
자동차 이름이 공백만으로 이루어져 있는지 확인한다. <br>
공백만으로 이루어진 경우 `IllegalArgumentException` 예외를 발생시킨다.
### 기능4) 자료형 검증 `int validateDataType(String toCheck)`
사용자가 입력한 이동 횟수의 자료형을 검증한다. 유효한 값이면 문자열을 정수형으로 반환한다.

## 4. 레이싱 클래스
### 기능1) 레이싱 데이터 초기화 `public void initializeRacing()`
레이싱을 위한 데이터를 초기화한다. 이때 사용자의 입력도 받아온다.
### 기능2) 레이싱하기 `public void doRacing()`
사용자의 입력 데이터를 기반으로 레이싱을 한다.
### 기능3) 자동차 이동하기 `public void moveCar(List<Car> carList)`
생성한 랜덤 숫자를 기반으로 자동차의 이동을 결정한다.<br>
4 이상의 숫자일 경우 자동차는 이동하고 4 미만의 숫자일 경우 이동하지 않는다.
### 기능4) 우승자 선별 `public void getWinner()`
레이싱 결과로 우승자를 선별하고 관련 데이터를 출력한다.<br>
우승자가 2명 이상일 경우 형식에 맞게 출력한다.