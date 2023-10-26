
### 기능구현 목록   
- 자동차 이름 입력받기
  - 입력받은 이름을 객체로 전환 (list로 관리)
- 몇 번의 이동을 할 것인지 입력 받기
  - 차량 개수만큼, 각 차량의 전진 여부 결정 (0~3은 그대로, 4~9는 전진)
  - 출력
  - 이를 입력 받은만큼 반복
- 우승자 출력

---
### 설계해보기


**interface GameManager**   
- function : play   

**class CarGameManager**
- function : play, else ...
- car names string 입력받기
- carListGenerator 로 cars 생성

**class Car**   
- String name   
- int count
- function : addCount

**class CarList**
- List<Car> list; 
- function : toString() // 결과출력
- function : 모든 차 전진 여부 반영하기 (1바퀴) // 외부에서 입력받은 만큼 시키기
   
**class CarListGenerator**
   function : createCarList(String input)   

---
### 객체의 변동성이 계속 존재   
**!!!! 클래스 내의 하나의 함수로만 객체를 변동할 수 있도록 제한해보자!!!!**
