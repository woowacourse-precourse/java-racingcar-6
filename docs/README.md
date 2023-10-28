### ⚙️ 구현할 기능 목록

#### Application
- [x] 자동차 경주 게임 시작 - main()

#### Game
- [ ] 문구 출력 - printMessage()
  - [x] 경주할 자동차 입력 요청하는 문구 출력
  - [ ] 우승자 출력
    - [ ] 우승자가 한 명 이상인 경우 쉼표(,)를 이용하여 구분
- [x] 자동차 이름 입력 받기 - setCarNames()
- [x] 시도할 횟수 입력 받기 - setTrialNumber()

#### GameManager
- [ ] 0에서 9 사이의 무작위 값을 구하기
  - [ ] 무작위 값이 4 이상인 경우, 전진
  - [ ] 무작위 값이 4 미만인 경우, 멈춤
- [ ] 자동차 경주 게임 완료 판단

#### InputValidator
- [x] 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`
    - [x] 자동차 이름이 1자 미만, 5자 초과하는 경우 - validCarNameLength()
    - [x] 시도할 횟수 입력 받을 때, 숫자 외 다른 문자 입력한 경우 - validTrialNumber()