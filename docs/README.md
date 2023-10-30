# 미션 - 자동차 경주

## 🚀 기능 요구 사항

- [ ] 사용자가 자동차의 이름을 입력할 수 있다.   #askNames
- [ ] 각 자동차에 이름을 부여할 수 있다.   CarManager#giveName
    - [ ] 자동차의 이름이 5자 이하인지 검증할 수 있다.   Verification#isLessThanFive
- [ ] 사용자가 몇 번의 이동을 할 건지 입력할 수 있다.   #askMoveTime

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.   Racing#progress
- [ ] 한 자동차에 대해 전진 또는 정지를 결정할 수 있다.   Selector#whetherToGo
    - [ ] 0에서 9 사이의 무작위 값을 구해 4 미만일 경우 정지한다.
    - [ ] 0에서 9 사이의 무작위 값을 구해 4 이상일 경우 전진한다.
- [ ] 모든 자동차들의 전진 횟수를 비교할 수 있다.   Referee#compare