
## 자동차 경주 게임
### 구현 사항
주어진 횟수동안, n대의 자동차는 전진 or 멈출 수 있다
자동차에 이름을 부여. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
자동차 이름은 , 를 기준으로 구분, 이름은 5자리 이하만 가능
사용자가 몇번의 이동을 할 것인지 입력할 수 있어야 함.
전진하는 조건 : 0~ 9 무작위 숫자를 구한 후, 그 값이 4이상일 경우
게임 완료 후 누가 우승했는지를 알려준다. 우승자는 1명이상일 수 있음
우승자가 여러명일 경우 : , 를 이용해 구분
사용자가 잘못된 값을 입력할 경우, IllegalArgumentException 을 발생 후 종료

### input & output
input
pobi,woni,jun(경주할 자동차 이름)
5(시도할 횟수)

output
각 차수 별 실행 결과
pobi : --
woni : ----
jun : ---
최종 우승자 : pobi

---

## 기능 구현 목록

### Controller

- controllerValidation
  - input이 맞는 형태인지 확인
- controllerParsing
  - 자동차 이름을 , 기준으로 파싱
- controllerSimulation
  - 자동차 경주 시뮬레이션

### Service

- serviceSimulation
  - 숫자를 랜덤하게 골라서, 전진인지, 그대로인지 체크
  - input : x
  - output : 전진하는 차의 넘버
- serviceCheckGoal
  - 하나라도 골인지점에 도착했는지 체크 
  - input : 차의 위치
  - output : 1(도착 o), 0(도착 x)
### constant

- errorMessage

### View

- viewInputCar
  - 자동차 이름 입력
- viewInputNumber
  - 횟수 입력
- outputMessage(ENUM)
  - 출력할 메세지 관련 ENUM
- viewOutputMessage
  - '실행 결과' 출력
- viewOutputState
  - 차 별 현재 전진한 칸
- viewOutputSuccess
  - 우승자 출력
### utils

- getRandom
  - 수를 임의로 뽑아주기