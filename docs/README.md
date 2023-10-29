# 구성 요소 분석
## 1. 자동차 클래스
자동차 리스트를 구성하기 위한 클래스이다. 자동차의 이름과 이동한 경로를 저장한다.
### 기능1) 자동차 설정 `public void createCar(String carName)`
매개변수로 지정할 자동차의 이름 문자열을 넘겨 받는다.
### 기능2) 자동차 이동 `public void movingCar()`
자동차가 이동된 뒤의 경로를 기록한다. 경로 기록과 동시에 이동 횟수를 기록한다.
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
구분된 문자열을 이용해 자동차의 개수만큼 자동차 설정 메소드를 호출한다.<br>
### 기능2) 이동 횟수 입력 `public void userInputMovingInfo()`
사용자는 자동차의 이동 횟수를 입력한다.
### 기능3) 시스템 메세지 출력 `public void printSystemMessage()`
프로그램의 시작, 입력을 받기 위한 메세지, 우승자를 출력한다.
### 기능4) 이동 결과 출력 `public void printMovingResult()`
자동차를 이동할 때마다 바뀐 경로를 출력한다.
### 기능5) 랜덤 숫자 생성 `public boolean makeRandomNumber()`
이동 여부를 위한 랜덤 숫자를 생성한다. 4 이상의 숫자가 생성된 경우 `true`를 반환한다.
### 기능6) 이동 횟수 Setter `public void setNumtotalMoving(int numberToChange)`
이동 횟수를 수정한다.
### 기능7) 이동 횟수 Getter `public int getNumTotalMoving()`
이동 횟수를 받아온다.

## 3. 검증 클래스
사용자의 입력을 검증하는 클래스이다.
### 기능1) 길이 검증 `public boolean validateLength()`
자동차 이름의 길이를 검증한다.
### 기능2) 중복 검증 `public boolean validateDuplicate(List<String> nameSets)`
자동차 이름 간의 중복 여부를 검증한다. 매개변수로 자동차 이름의 리스트를 넘겨 받는다.
### 기능3) 자동차 이름 공백 검증 `public void validateEmptySpace()`
자동차 이름이 공백으로 입력되었는지 확인한다.
### 기능4) 자료형 검증 `public void validateDataType()`
사용자가 입력한 이동 횟수의 자료형을 검증한다.
### 기능5) 범위 검증 `public void validateDomain()`
사용자가 입력한 이동 횟수의 범위 값을 검증한다.

## 4. 레이싱 클래스
### 기능1) 레이싱 데이터 초기화 `public void initializeRacing()`
레이싱을 위한 데이터를 초기화한다. 이때 사용자의 입력도 받아온다.
### 기능2) 레이싱하기 `public void doRacing()`
사용자의 입력 데이터를 기반으로 레이싱을 한다.
### 기능3) 우승자 선별 `public void getWinner()`
레이싱 결과로 우승자를 선별하고 관련 데이터를 출력한다.