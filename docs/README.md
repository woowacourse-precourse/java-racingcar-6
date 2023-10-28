## 📙 미션 - 숫자 야구

### 💡 기능 구현

<br>

### 📃 Car
1. 입력한 차 이름과 전진한 차의 위치 값이 있어야 함.
2. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상. 즉 0~9까지 랜덤으로 숫자 값을 구했을 때 값이 4 이상이어야 한칸 이동 가능.
<br>

***

### 📃 Racing
1. 실제 경주에 들어갈 Car 데이터들

😱 생각하지 못한 것


***

### 📃 입력할 View와 출력할 View를 만들어줌.

### input
1. 차 이름과 숫자를 입력 받을 메서드
<br>

### output
1. "경주할 자동차 이름을 입력하세요", "시도할 회수는 몇회인가요?" 출력
2. 실행 결과 출력. 각 차마다 움직인 수만큼 - 출력
3. 최종 우승자 출력.

<br>

### 📃 RacingCarController
1. 경주 시작하는 run()
2. getCarNames()로 차 이름을 입력할 메서드 <br>
(추가로 입력한 차 이름은 반드시 String이어야 함.)
3. getTrialCount()로 시도할 횟수 입력할 메서드 <br>
(시도 횟수는 반드시 Integer여야 함.)
4. 

<br>

***

### 📃 Validator
1. 자동자 이름이 String인지
2. 시도할 횟수 Integer 사용했는지
3. 랜덤 숫자 1~9인지
4. 자동차 이름을 쉼표 기준으로 구분했을 때 이름이 5자 이하인지

(마지막에 구현하는게 편한 듯)
<br>

***

<br>
<br>

### < 폴더 구조 >

```
├─main
│  └─java
│      └─baseball
│          │--Application.java (경주 시작)
│          │
│          ├─controller
│          │  -  RacingcarController.java (실행 동작 구조)
│          │
│          ├─model
│          │  -  Car.java (차에 대한 정보)
│          │  -  Racing.java (경주에 대한 졍보)
│          │
|          |
│          ├─validator
│          │  -  Validator.java
│          │  -  (차 입력했을 때 String인지, 입력 길이, 차수를 숫자로 입력하는지, 차 현재 위치는 최대 입력한 회차 수까지만 가능.)
│          ├
│          ├
│          │
│          └─view
│             -  Input.java (입력)
│             -  Output.java (출력할 모든 메세지)
│
└─test
    └─java
        ├─ racingcar
        │   -   ApplicationTest.java
```
