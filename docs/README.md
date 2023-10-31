### 구현 기능 목록

- 사용자 입력
    - 경주할 자동차 이름 `Map<String, Integer> cars[car]`
      - ```text
        경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
        pobi,woni,jun
        ```
      - car은 쉼표로 구분, 5자 이하만 가능
      - 문자열 입력 받아 split하여 validate한 후 cars로 할당
    - 이동할 횟수 `int count`
      - ```text
        시도할 회수는 몇회인가요?
        5
        ```
    - [예외] 잘못된 값 입력 -> `IllegalArgumentException` -> 애플리케이션 종료
      - 경주할 자동차 이름: 각각의 이름이 1-5 사이 길이인지 `Validator.validateCar()` 
      - 이동 횟수: 입력값이 integer인지 `Validator.validateCount()`


- 프로그램 내부
  - `Map<String, Integer> status` : 현재 상태 저장하는 map
  - `play()`: 주어진 횟수(`count`) 동안 n대의 자동차는 전진 or 멈춤 `Progress.takeProgress()`
    - 전진하는 조건: 0-9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상인 경우 `Random.getRandom()`
  - 주어진 횟수를 모두 완료한 후 가장 많이 전진한 자동차가 우승


- 프로그램 출력
  - 각 차수마다 실행 결과 출력 `Result.showMiddle()`
  - ```text
    pobi : --
    woni : ----
    jun : ---
    ```
  - 우승자 결정될 시 결과 출력 `Result.showFinal()`
    - 단독 우승자 안내 문구
    - ```text
      최종 우승자 : pobi
      ```
    - 공동 우승자 안내 문구(쉼표로 구분)
    - ```text
      최종 우승자 : pobi, jun
      ```

<!--
### 예상 flow
1. INPUT
   1) 경주할 자동차 이름 문자열 -> `splitCarsInput()` -> `ArrayList cars`
   2) `validateCarName()`
   3) 이동할 횟수 문자열
   4) `validateMoveValue()` -> parseInt(moveCount)
2. INTERNAL
   1) for(int i=0; i<moveCount; i++) [a]
   2) for(String car: cars)[b]
   3) `carMove(car)` [b]
         1) `randomDraw()` -> `isForward(car)`
         2) if `isForward(car) == TRUE`
         3) currentStatus[car] += 1
   4) `printCurrentStatus()` [a]
   5) `findWinner() -> winner`
   6) `printFinalResult()`
-->