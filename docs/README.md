
### 🎠 1번말, 2번말,.. 아니, 자동차 경주였지...

# 🏎️ 웰컴 우테코 그랑프리~ 🏁🏁🏁
## 기능 목록 📝

### 레이싱 시작 전 🔴 
- [ ]  경주에 참여하는 자동차 이름을 사용자로부터 등록 - Application#registCarName
   - [ ]  등록하는 자동차 이름은 5자 이하, 쉼표를 기준으로 구분


- [ ]  자동차의 이동 횟수 입력 - Application#registCarMoveNum
   - [ ] 이동 횟수의 입력값은 숫자이어야 할 것


- [ ] ⚠️ 위 양식에 따르지 않으면 참여 자격 박탈! (`IllegalArgumentException`) - Application#incorrectFormat

### 레이싱 시작! 🟢

- 주어진 이동 횟수만큼 다음 로직 반복


- [ ]  각 자동차에 대해서 0~9 사이의 랜덤 값 생성 - Car#generateRandomValue
  - [ ]  랜덤 값 4 이상인 경우 해당 자동차 전진 - Car#move
- [ ]  각 차수별 실행 결과 출력 - Race#showCurrentMove


### 레이싱 종료~ 🏆

- [ ]  제일 많이 전진한 자동차 이름 출력 - Race#printWinner