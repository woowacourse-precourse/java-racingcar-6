
# 흐름에 따른 기능 수행

- [ ] 자동차 이름을 받기 - Car
  - [ ] 이름 리스트 - Car.getNames
  - [ ] 쉼표로 이름 구분 - Car.splitInputNames
  - [ ] 예외 처리 - Car.validateInputNames
    - [ ] 빈 값 x - Car.checkEmpty
    - [ ] 자동차 이름에 중복 값 X - Car.checkDuplicate
    - [ ] 이름의 길이가 5자 이하 - Car.checkLength

- [ ] 몇 번의 시도를 할지 회수를 받기 - Attempt
  - [ ] 입력 받기 - Attempt.getCount
  - [ ] 예외 처리 - Attempt.validateAttemptCount
    - [ ] 숫자인지 - Attempt.checkInt
    - [ ] 1이상의 자연수 - Attempt.checkNatural

- [ ] 전진 조건 확인 - MovingCondition
  - [ ] 0에서 9 사이에서 무작위 값을 구한 후 4이상 시, 전진 - MovingCondition.isMoveForward
  - [ ] 4미만 시, 멈춤 - MovingCondition.isMoveForward

- [ ] 실행 과정 - RacingGame
  - [ ] 자동차별 현재 진행 사항 확인 - RacingGame.race
  - [ ] 실행 과정 결과 출력 - RacingGame.printProgressResult

- [ ] 최종 우승자 - Winner
  - [ ] 최종 우승자 확인 - Winner.findWinners
  - [ ] 최대 전진 길이 확인 - Winner.findMaxProgress
  - [ ] 우승자의 자동차 이름 출력 (1명 이상일 수 있음.) - Winner.printResult



# Test Code

### Car 클래스
- [ ] getNames
- [ ] splitInputNames
- [ ] validateInputNames
  - [ ] checkEmpty
  - [ ] checkDuplicate
  - [ ] checkLength

### Attempt 클래스
- [ ] getCount
- [ ] validateAttemptCount
  - [ ] checkInt
  - [ ] checkNatural

### MovingCondition 클래스
- [ ] isMoveForward

### RacingGame 클래스
- [ ] race
- [ ] printProgressResult

### Winner 클래스
- [ ] findWinners
- [ ] findMaxProgress
- [ ] printResult
