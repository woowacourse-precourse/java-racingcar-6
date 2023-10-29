## 📙 미션 - 숫자 야구

### 💡 기능 구현

<br>

### 📃 Car
1. 입력한 자동차 이름과 전진한 차의 위치 값이 있어야 함.
2. 차가 움직이는지 안 움직이는지 여부(랜덤으로 뽑아낸 숫자가 4이상이면 움직임)에 대한 메서드 필요.
<br>

***

### 📃 Cars
1. 실제 경주에 들어갈 Car 데이터들
2. 입력한 자동차들을 ',' 로 구분해서 리스트에 삽입
3. 랜덤으로 자동차들이 0~9 까지 랜덤으로 뽑아냄.
4. 자동차들 이동.
5. Cars에서 우승자를 뽑아냄. (추가해줌)
<br>

***

<br>

### 📃 Name
1. 자동차들 이름에 대한 변수 생성. (바뀌지 않으므로 상수)
2. Car에서 객체 타입으로 변수 생성했으니까 String으로 변환.

<br>

***

<br>

### 📃 Position
1. 현재 자동차들의 위치 변수 (시도 횟수마다 바뀌므로 final x)
2. 차가 움직이는 메서드 생성. (차가 1씩 움직여야 함.)
3. Car에서 객체 타입으로 변수 생성했으니까 Integer로 변환.
<br>

***

<br>

### 📃 TryCount
1. 입력한 숫자에서 바뀌지 않기 때문에 final로 생성.
2. 입력한 시도 횟수랑 현재 진행 중인 시도 횟수가 같으면 반복문 빠져나오기 위한 메서드 필요.
3. 입력할 때 readLine()으로 String 입력이니까 다시 Integer로 변환.

<br>

***

<br>

### 📃 Winners
1. 우승한 자동차들을 넣을 리스트 생성. 우승한 자동차들의 최대 현재 위치 변수 생성.
2. 우승한 자동차들 이름을 넣은 리스트를 반환해야 함.
3. maxPosition을 뽑아내기 위한 메서드 생성.
4. maxPosition과 우승한 자동차 List를 가지는 메서드 생성. (Cars에서 반환할 것임.)
<br>

***

<br>

### 📃 입력할 View와 출력할 View를 만들어줌.

### input
1. 자동차 이름과 숫자를 입력 받을 메서드
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

😱 생각하지 못한 것 <br>
아직까지 model에 어떤 정보를 넣어야 할지 감이 잘 잡히지 않는 점이 너무 아쉽다.

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
│          │  -  Car.java (자동자에 대한 정보 -> 이름, 위치, goOrStop)
│          │  -  Cars.java (List에 입력한 자동차 추가, 우승자, 랜덤으로 자동차들 움직임.)
│          │  -  Name.java (자동차 이름 변수)
│          │  -  Position.java (자동차들의 현재 위치 변수, 위치)
│          │  -  TryCount.java (시도 횟수 변수, 입력을 String으로 하므로 Integer로 변환.)
│          │  -  Winners.java ()
│          │
│          ├
│          ├
│          ├─model
│          ├    - StringUtils (입력한 차 문자열에서 ',' 구분)
│          ├
|          |~~~~
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
