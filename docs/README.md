# 미션 - 자동차 경주

## 🚀 기능 요구 사항

- [x] 각 자동차에 이름을 부여할 수 있다.   CarManager#giveName
    - [x] 자동차의 이름이 5자 이하인지 검증할 수 있다.   Verification#isFiveOrLess
    - [x] 입력한 자동차 이름에 중복값이 있는지 확인할 수 있다.   Verification#duplicate
- [x] 사용자가 몇 번의 이동을 할 건지 입력할 수 있다.   #askMoveTime
    - [x] 입력한 이동횟수가 양수인지 확인할 수 있다.   Verification#inPositive

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.   
- [x] 1회의 n대의 자동차들의 레이싱 결과(전진 또는 정지)를 확인할 수 있다.   Racing#play
- [x] 한 자동차에 대해 전진 또는 정지를 결정할 수 있다.   Selector#whetherToGo
    - [x] 0에서 9 사이의 무작위 값을 구해 4 미만일 경우 정지한다.
    - [x] 0에서 9 사이의 무작위 값을 구해 4 이상일 경우 전진한다.
- [x] 레이싱 실행 결과를 출력할 수 있다.   Progress#onAir
- [x] 모든 자동차들의 전진 횟수를 비교할 수 있다.   Referee#compare
    - [x] 전진 횟수가 가장 많은 자동차가 최종우승자이다. 