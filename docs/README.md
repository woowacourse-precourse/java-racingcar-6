# 자동차 경주

## 💡 기능 목록
- [x] 자동자 이름 입력 받기 - **InputManager / inputCarNames()**
    - [x] 쉼표를 이용하여 구분하기 - **CarFactory / generateCars()**
- [x] 시도 횟수 입력 받기 - **InputManager / inputTryCount()**
- [x] 자동자 경주를 시작한다 - **RaceManager / start()**
  - [x] 각 자동차 별로 0~9 사이 랜덤 숫자 생성 - **Car / generateRandomNumber()**
  - [x] 4이상의 값인 경우 한칸 전진 - **CarService / ForwardOrStop()**
- [x] 모든 시도가 끝난 후 가장 많이 이동한 자동차를 우승자로 선정 - **Referee / selectWinner()**
  - [x] 한 명인 경우 단독으로 출력 - **OutputManager / printWinner()**
  - [x] 공동 우승자의 경우 쉼표로 구분해서 동시에 출력 - **OutputManager / printWinner()**

## ❌ 예외 처리
### 사용자 입력에서 예외가 발생한 경우 `IllegalArgumentException` 로 처리한다.
  - [x] 자동차 이름 글자수가 1~5자가 아닌 경우 - **CarValidator / validateCarName()**
  - [x] 자동차 이름 중복 예외 처리 - **CarValidator / validateDuplicatedCarName()**
  - [x] 레이스의 참여한 자동차가 1대 이하인 경우 - **CarValidator / validateNumberOfCar()**
  - [x] 시도 횟수를 숫자가 아닌 값 또는 0을 넣은 경우 - **TryCountValidator / validateTryCountIsInteger()**

## 📜 테스트 작성 계획
- [x] 자동차 생성 테스트
- [x] 자동차 이름 중복 입력 테스트
- [x] 중복 우승자 선정 태스트
- [x] Validator 검증 테스트