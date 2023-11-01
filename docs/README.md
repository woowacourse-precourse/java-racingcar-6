# 구현할 기능 목록

## 1. 입력한 n대의 자동차를 (,)쉼표기준으로 split하여 Map에 넣기
#### List splitCars(String input) : 입력받은 String을 filter사용하여 빈문자열 제거한 List생성
#### Map carsToMap(List cars) : List를 Map으로 변환



## 2. 예외 처리 사항
#### 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고 해당 에러메세지를 출력한다
#### 1) void inputValidation(String input) : trim()을 이용하여 앞,뒤 공백을 제거한 문자열이 5자를 넘어가면 예외발생
#### ++ 자동차 이름에 공백이 포함되어 있으면 예외발생
#### ++ ,,, 쉼표만 입력한경우 예외발생
#### ++ 자동차 이름이 중복인 경우 Map자료구조를 사용하므로 결과에 영향을 주지않음
#### 2) void trynumberValidation(String trynumber) : 숫자가 아닌 문자를 입력한 경우 예외발생
#### ++ 0이나 음수를 입력한 경우 예외발생



## 3. 매 회차마다 전진 or 멈추는 메서드
#### 1) Integer generateNumber() : 랜덤숫자 생성
#### 2) Map racingCar(Map map) : 랜덤숫자에 따라 각 key에 따른 value에 +1(전진) or not(정지)
#### 3) void resultEachOrder(Map map) : iterator로 각 key, value에 따른 진행도 출력
#### 4) String printBar(char ch, int value) : value에 따른 -개수 추가



## 4. 우승자 출력
#### String winners(Map map) : 단독우승자를 출력후, 공동우승자 있을때 쉼표로 구분하여 추가
