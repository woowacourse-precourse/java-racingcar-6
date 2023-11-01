
### 🎠 1번말, 2번말,.. 아니, 자동차 경주였지...

# 🏎️ 웰컴 우테코 그랑프리~ 🏁🏁🏁
## 기능 목록 📝

### 레이싱 시작 전 🔴 
- [ ]  경주에 참여하는 자동차 이름을 사용자로부터 등록 - InputView#registCarName
   - [ ]  등록하는 자동차 이름은 5자 이하, 쉼표를 기준으로 구분 - InputValidate#validateCarName


- [ ]  자동차의 이동 횟수 입력 - InputView#registCarMoveNum
   - [ ] 이동 횟수의 입력값은 숫자이어야 할 것 - InputValidate#validateCarMoveNum


- [ ] ⚠️ 위 양식에 따르지 않으면 참여 자격 박탈! (`IllegalArgumentException`) - InputValidate#incorrectFormat

### 레이싱 시작! 🟢

- 주어진 이동 횟수만큼 다음 로직 반복


- [ ]  각 자동차에 대해서 0~9 사이의 랜덤 값 생성 - RandomUtils#generateRandomValue
  - [ ]  랜덤 값 4 이상인 경우 해당 자동차 전진 - RaceService#moveCarByLogic
- [ ]  각 차수별 실행 결과 출력 - OutputView#showCurrentMove


### 레이싱 종료~ 🏆

- [ ]  제일 많이 전진한 자동차 이름 출력 - OutputView#printWinner

---

# MVC - 기능 목록 

## Model

- Race - 레이스에 필요한 모든 정보를 담고 있는 객체
  
  -  사용자로부터 입력받은 값들을 저장

  -  Car[]와 라운드 횟수 저장 


- Car - 레이스에 참가하는 자동차 객체

   - 자동차의 이름을 저장
   - 로직에 의한 전진 횟수 저장

## View

- InputView - 사용자 입력 처리 객체

   - 사용자로부터 입력 값 입력
   - 입력받는 차 이름의 형식이 올바른지 검증
   - 입력받는 라운드 횟수 형식이 올바른지 검증


- OutputView - 레이싱 게임 상황 출력 객체

   - 각 차수별 실행 결과 출력
   - 우승자 안내 문구 출력 - 단독 우승자
   - 우승자 안내 문구 출력 - 공통 우승자

## Controller

- RaceController - 레이스의 전반적인 진행을 맡은 객체

  - 레이스 개최
  - 사전 등록
  - 레이스 시작
  - 레이스 우승자 발표 

## Service

- RaceService - 차를 움직이는 로직 담당

  - 랜덤 값이 4이상이면 차를 전진시키는 기능

## Utils
- RandomUtils - 랜덤 수 생성 유틸 객체

   - 0~9범위의 랜덤 수 생성


## Validator 

- InputValidate - 입력값 검증 객체

   - 자동차 이름 형식 검증
   - 이동 횟수 형식 검증 
   - 예외 발생시 exception 던지기 