# 자동차 경주

## 💡 기능 목록
- [x] 자동자 이름 입력 받기 - **InputManager / inputCarNames()**
    - [x] 쉼표를 이용하여 구분하기 - **CarFactory / generateCars()**
- [x] 시도 횟수 입력 받기 - **InputManager / inputTryCount()**
- [x] 자동자 경주를 시작한다 - **RaceManager / startRace()**
  - [x] 각 자동차 별로 0~9 사이 랜덤 숫자 생성 - **Car / generateRandomNumber()**
  - [x] 4이상의 값인 경우 한칸 전진 - **CarService / ForwardOrStop()**
- [x] 모든 시도가 끝난 후 가장 많이 이동한 자동차를 우승자로 선정 - **Referee / selectWinner()**
  - [x] 한 명인 경우 단독으로 출력 - **RaceManager / printWinner()**
  - [x] 공동 우승자의 경우 쉼표로 구분해서 동시에 출력 - **RaceManager / printWinner()**

## ❌ 예외 처리
### 사용자 입력에서 예외가 발생한 경우 `IllegalArgumentException` 로 처리한다.
  - [ ] 자동차 입력에서 글자수가 5자가 넘는 경우 - **Validator / validateCarName()**
  - [ ] 시도 횟수를 숫자가 아닌 값을 넣은 경우 - **Validator / validateTryCount()**