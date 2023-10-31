# 구현 기능 목록


## 🚗 Car Class
*차와 관련된 변수*

---

- String name;   이름
- int distance = 0;   이동 거리(디폴트 0으로)
- Car() 생성자 : 객체 생성시 car 이름 받아서 저장


## 💁🏻‍♀️️ Get Class
*입력과 관련된 함수*

---

- void carName() : 차 이름 받아오기
- int playCount() : 실행 횟수 받아오기


## 🖥️ Print Class
*출력과 관련된 변수와 함수*

---

- void message() : 안내 문구 출력하는 함수
- void result() : 실행 결과 출력 함수(하나의 실행 당 한 번 수행)
- void winner() : 우승자 출력 함수 (공동 우승자는 ,로 구분해서 출력)
- private static final String MSG : 출력 메시지 변수


## 🗂️ Main()

---

### ➡️ static int forward()
*전진하는 함수*

1. Randoms.pickNumberInRange(0,9) 이용해서 0~9사이 무작위 값 구하기
2. 구한 값이 4이상이면 true 반환, 아니면 false 반환

### ➡️ static List<Car> sortCarDistance()
*car 객체 리스트를 distance 값으로 내림차순 정렬하기*

### ➡️ static List<String> winnerListGenerator()
*우승자 리스트 생성하기*

- 가장 큰 distance와 distance의 값이 같으면 우승자

### 🚫 IllegalArgumentException
*사용자 입력 값 체크*

- 자동차 이름이 5자 이하인가


