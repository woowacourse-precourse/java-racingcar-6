
# 기능 목록 


## 입력
- 사용자는 쉼표(,)기준으로 자동차의 이름을 정할 수 있다
  - 자동차 이름은 5자 이하까지만 가능
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해야 한다.
  - ```text
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    ```
  - **[에러]** 자동차의 이름이 6자 이상이면 'IllegalArgumentException'가 발생한 후 Applicaition이 종료된다.
  - **[에러]** 자동차의 이름이 중복이라면 'IllegalArgumentException'가 발생
  - **[에러]** 자동차의 이름이 공백이라면 'IllegalArgumentException'가 발생
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - ```text
    시도할 회수는 몇회인가요?
    5
    ```
  - **[에러]** 입력값이 숫자인지 확인 후, 아니라면 'IllegalArgumentException'가 발생
  - **[에러]** 입력값이 양수인지 확인 후, 아니라면 'IllegalArgumentException'가 발생

## 경주 진행

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  -  전진 조건 : 0에서 9 사이에서 랜덤 값 생성 후, 해당 랜덤 값이 4 이상일 경우이다.
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용해야 한다.


## 출력
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - ```text
    pobi : --
    woni : ----
    jun : ---
    ```
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
  - 단독일 경우 / 공동일 경우
  - 공동일 경우 쉼표(,)를 이용하여 구분한다.
  - ```
    최종 우승자 : pobi
    ```
  - ```
    최종 우승자 : pobi, jun
    ```