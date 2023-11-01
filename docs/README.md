# 자동차 경주

## 과제 정보
- 구현 언어: Java 17
- 라이브러리: camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- indent depth를 2까지만 허용
- 3항 연산자를 쓰지 않는다
- 함수가 한 가지 일만 하도록 최대한 작게 만든다

## 기능 목록
- Controller.addCarName: 자동차의 이름을 입력받고, 올바르게 입력되었는지 검증합니다.
  - Controller.carNameConfirm: 자동차의 이름이 5자가 넘을시 IllegalArgumentException()을 발생시킵니다.
- Controller.startCarRace: 시도할 횟수를 입력받고, 각 차수별 경기 결과를 출력합니다.
- Controller.resultCarRace: 최종 우승자의 수에 따라 다르게 결과를 출력합니다.

- Service.addCar: 입력 받은 자동차명을 저장하고, 결과 리스트를 초기화 해줍니다.
- Service.getCar: 자동차의 이름 리스트를 가져옵니다. 
- Service.racing: 각 차수별 경기 결과를 구하고, 저장합니다.
- Service.getMaxSize: 경기가 끝난 후 가장 많이 전진한 값을 반환합니다.
- Service.findWinner: 우승자를 결과 리스트에 저장하여 반환합니다.

