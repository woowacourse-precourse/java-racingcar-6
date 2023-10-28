## ✏️ 기능 구현 목록 정리하기

### Model
#### 기본구조 : Constructor, Getter, Setter, toString()
`사용자는 컴퓨터의 번호를 알 수 없으므로 사용자의 번호를 기준으로 컴퓨터와 비교합니다.`
- RacingCup Model
    - [x] 모델 기본구조 생성
        - `경기 총 횟수`
        - `경기 현재 진행 횟수`
        - `경기를 진행하는 자동차들`
        - `최종 우승자`
- Player Model
    - [x] 모델 기본구조 생성
        - `자동차 이름`
        - `현재 이동 거리`
---

### View
- GameView
    - [x] 경주할 자동차의 이름 입력받는 기능
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
        - 입력에 대한 검증
          1. 이름이 5글자 이하인가?
          2. `의문점 : 이름에 공백을 포함하는가?`
          3. `의문점 : 공백을 포함한다면 공백을 제외한 5글자인가?`
    - [x] 시도할 횟수를 입력받는 기능
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
        - 입력에 문제가 없는지 검증
            - 경주를 진행하려면 최소 1회 이상 입력
            - `의문점 : 0회 입력시 경기를 하지 않으면 우승자를 emptyList or exception?`
    - [ ] 매 경기 당 자동차 경주의 결과를 출력하는 기능
    - [ ] 최종 우승자를 출력하는 기능
---

### Controller
- RacingCup Controller
  - [ ] 입력받은 자동차들을 추가한다.
  - [ ] 입력받은 경기횟수를 추가한다.
  - [ ] 다음 경기를 진행한다.
  - [ ] 최종 우승자를 정한다.
- Player Controller
  - [ ] 자동차 이름을 설정한다.
  - [ ] 자동차가 경기를 완주했는지 확인한다.
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
    - 매 Round마다 자동차는 경주하고 완주 결과를 발표한다.
    - 최종 결승자에 대한 평가를 진행한다.
    - 최종 결승자를 발표한다.
---