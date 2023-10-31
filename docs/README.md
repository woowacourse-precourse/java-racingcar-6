## 🔍 concept
#### 자동차 경주 시합
#### 자동차 경주는 총 n라운드로 진행됨.
#### n라운드 중 제일 많이 완주한 플레이어가 우승

---

## ✏️ 기능 구현 목록 정리하기

### Model
#### 기본구조 : Constructor, Getter, Setter, toString()
`사용자는 컴퓨터의 번호를 알 수 없으므로 사용자의 번호를 기준으로 컴퓨터와 비교합니다.`
- RacingCup Model
    - [x] 모델 기본구조 생성
        - `경기 전체 라운드`
        - `경기 현재 라운드`
        - `1등 플레이어의 완주 라운드`
        - `최종 우승자`
- Player Model
    - [x] 모델 기본구조 생성
        - `자동차 이름`
        - `완주 라운드`

---

### View
- GameView
    - [x] 경주할 자동차의 이름 입력받는 기능
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
        - 입력에 대한 검증
          1. 이름이 5글자 이하인가?
          2. `의문점 : 이름에 공백을 포함하는가?` - Test 코드에서 trim()을 출력에 사용. 양끝 공백만 불허
          3. `의문점 : 공백을 포함한다면 공백을 제외한 5글자인가?` - 양끝 공백이 아니면 Yes
    - [x] 자동차 경주를 진행할 총 횟수를 입력받는 기능 (시도 횟수)
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
        - 입력에 문제가 없는지 검증
          - 경주를 진행하려면 최소 1회 이상 입력
          - `의문점 : 0회 입력시 경기를 하지 않으면 우승자를 emptyList or exception?` 
          - 자동차 경주를 완료하는 경우만 체크하므로 exception이 옳다.
    - [x] 자동차 경주의 현재 라운드 결과를 출력하는 기능
    - [x] 최종 우승자를 출력하는 기능
---

### Controller
- RacingCup Controller
  - [x] 입력받은 경기횟수를 추가한다. 
  - [x] 자동차가 경기를 진행할 수 있으면 진행한다.
  - [x] 경기를 진행한다.
    - `camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용`
    - Random 값이 4이상일 경우만 완주를 할 수 있다.
    - 모두 다 멈춤만 발생할 경우 누가 우승인가??
      - `우승자는 없다.`
      - `모두 우승이다.`
      - 우승자가 없을 경우에 대한 설명이 없으므로 모두 우승 처리를 선택
  - [x] 현재까지의 최고기록을 측정한다.
    - 현재 경기진행과 더불어 최고기록을 측정하면서 한 번에 두가지 기능을 수행 중.
  - [x] 최종 우승자를 정한다.
- Player Controller
  - [x] 자동차 이름을 설정한다.
---

### Utility
- InputDataExceptionHandler
    - [x] 입력받은 자동차 이름을 검증하는 기능
    - [x] 입력받은 시도할 횟수를 검증하는 기능
---

### Main
- Application
    - <b>MVC 패턴</b>을 활용해서 프로그램을 구현
    - 우테코배 RacingCup을 시작한다.
    - 경주할 Player들을 등록한다.
    - 레이싱 경기의 총 Round를 설정한다.
    - 매 Round마다 자동차는 경주를 진행한다.
    - 매 Round에 대한 완주 결과를 발표한다.
    - 마지막 라운드가 끝나면 최종 결승자에 대한 평가를 진행한다.
    - 최종 결승자를 발표한다.
---