
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

**class CarGameManager**
- function : play, else ...
- car names string 입력받기
- carListGenerator 로 cars 생성

**class Car**   
- String name   
- int point
- function : addPoint
- function : toString() // 결과출력
- valid logic : 이름 길이, 빈 문자열

**class CarList**
- List<Car> list; 
- function : toString() // 결과출력
- function : 모든 차 전진 여부 반영하기 (1바퀴) // Round 에 의해 제어
   
**class CarListFactory**
   function : create(String input)   

---
###객체의 변동성이 계속 존재   
**!!!! 클래스 내의 하나의 함수로만 객체를 변동할 수 있도록 제한해보자!!!!**

---
###refactor

1. **class Round**
- int round 
- function : isLeft() : round 클래스의 숫자에 따라서 차 전진 루틴 실행할지 말지 판단하기
- 외부에서 숫자 접근 및 수정 불가하게 하기 (getter, setter 사용 X)

2. **class RoundFactory**
- create : round 객체 생성
- validate : 음수, 숫자 변환 불가 등

3. **class Car**
- 실제 전진하는 객체는 car
- car 내부에 전진하는 서비스 로직 넣기

4. **class CarList**
- 람다 활용해보기

