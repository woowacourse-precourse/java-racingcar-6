## 🚗자동차 경주게임🚗 기능리스트

---

### 1. 사용자 입력 받기
- [x] 자동차 이름 받기 - Input #getCarNames()
- [x] 자동차 이동횟수 받기 - Input #getMoveCount()
- [x] 입력값 검증하기
  - 자동차 이름은 쉼표 기준 구분, 5자 이하 - InputValidator #validateCarNames() 
  - 이동횟수는 자연수 - InputValidator #validateMoveCount()

### 2. 자동차 경주 게임 진행
- [ ] 각 자동차의 전진유무를 결정하는 메서드 구현 - Car #determineMove()
- [ ] 각 자동차의 현재까지 이동상태를 알아내는 메서드 구현 - Car #getPath() 
- [ ] 이동횟수만큼 다음을 반복
  - 각 자동차 전진/멈추기 수행 - Car #moveOrStop()
  - 각 자동차의 현재까지 이동상태 출력 - Output #printCarsState()

### 3. 최종 우승자 출력
- [ ] 게임이 끝나고 최종 우승자 알아내기 - Referee #getWinner()
- [ ] 최종 우승자 출력하기 - Output #printWinner()