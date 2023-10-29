# 구현할 기능 목록

## 1. 입력한 n대의 자동차를 (,)쉼표기준으로 split하여 Map에 넣기
#### Map splitCars(String input)



## 2. 유효성검증
#### 1) void inputValidation(String input)
#### 2) void trynumberValidation(String trynumber)



## 3. 매 회차마다 전진 or 멈추는 메서드
#### 1) Integer generateNumber() : 랜덤숫자 생성
#### 2) Map racingCar(Map map) : 랜덤숫자에 따라 각 key에 따른 value에 +1 or not
#### 3) void resultEachOrder(Map map) : iterator로 각 key, value에 따른 진행도 출력
#### 4) String printBar(char ch, int value) : value에 따른 -개수 추가



## 4. 우승자 출력
#### 1) Comparator<Entry<String, Integer>> comparator : value기준 최댓값을 가지는 key, value
#### 2) String winners(Map map) : 단독우승자를 출력후, 공동우승자 있을때 추가
