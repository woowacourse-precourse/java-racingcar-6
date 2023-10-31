# 🚔자동차 경주 게임

## ⛳구현할 기능 목록

### 입력
* 경주할 자동차 이름 입력 받기 (RacingSetting Class) ✅ [TEST 구현완료]
* 이동을 시도할 횟수 입력 받기 (RacingSetting Class) ✅ [TEST 구현완료]

### 출력
* 이동 후 실행 결과 출력 (Car Class, Information Class) ✅ [TEST 구현완료]
* 최종 우승자 출력 (RacingCar Class) ✅ [TEST 구현완료]
* 입력받을때 안내메시지 출력 (RacingSetting Class) ✅ [TEST 구현완료]
### 구현
* 자동차 전진 기능 구현 (Car Class) ✅ [TEST 구현완료]
* 랜덤한 값(0~9) 구하는 기능 구현 (Car Class) ✅
* 자동차 이름이 유효한지 검사하는 기능 구현 (Information Class) ✅ [TEST 구현완료]
* 자동차 개수가 유효한지 검사하는 기능 구현 (CarNum Class) ✅ [TEST 구현완료]
* 이동을 시도할 횟수가 유효한지 검사하는 기능 구현 (MoveNum Class) ✅ [TEST 구현완료]
* 입력값이 이동을 시도할 횟수를 넘었는지 검사하는 기능 구현 (MoveNum Class) ✅
* 입력받은 자동차 이름 쉼표 기준 파싱 (RacingSetting Class) ✅

## 💻구현할 클래스 목록

### RacingGame
클래스 변수 : List<Car<Car>> car
* 전체적인 실행 ✅ [TEST 구현완료]
* 최종 우승자 출력하기 ✅ [TEST 구현완료]

### RacingSetting
클래스 변수 : MoveNum moveNum, CarNum carNum
* 경주할 자동차 입력받기 ✅ [TEST 구현완료]
* 이동을 시도할 횟수 입력받기 ✅ [TEST 구현완료]
* 입력받을때 안내메시지 출력 ✅ [TEST 구현완료]

### Car
클래스 변수 : Information information
* 자동차 전진 기능 구현 ✅ [TEST 구현완료]
* 랜덤한 숫자 생성 기능 구현 ✅
* 이동 후 실행 결과 출력 ✅ [TEST 구현완료]
* 생성자로 Information class name 초기화 ✅

### Information
클래스 변수 : String name, int destination
* 자동차 이름이 유효한지 검사하는 기능 구현 ✅ [TEST 구현완료]
* 현재 자동차 이름과 위치를 출력 ✅ [TEST 구현완료]
* 위치 업데이트(증가) 기능 구현 ✅ [TEST 구현완료]
* 생성자로 name 및 destination 초기화 ✅

### MoveNum
클래스 변수 : int num
* 이동을 시도할 횟수가 유효한지 검사하는 기능 구현 ✅ [TEST 구현완료]
* 입력값이 이동을 시도할 횟수를 넘었는지 검사하는 기능 구현 ✅
* 생성자로 num 초기화 ✅ [TEST 구현완료]

### CarNum
클래스 변수 : int num
* 자동차 개수가 유효한지 검사하는 기능 구현 ✅ [TEST 구현완료]
* 생성자로 num 초기화 ✅