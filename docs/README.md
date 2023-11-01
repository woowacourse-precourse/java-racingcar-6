# 기능 명세 (최종)
- 완료한 기능은 기능 옆에 ✅ 이모지를 통해 반영한다.
- 기능 명세는 구현 중에 언제든 추가될 수 있다.
- 각 기능 별 구현 중에 해당 기능을 어떤 객체의 어떤 메서드에서 구현했는지 작성한다.

## 게임 시작
1. 프로그램은 게임의 첫 시작 시 다음과 같은 문구를 출력한다. inputView#readUserInput() ✅

   ```
   경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
   ```
2.  사용자는 아래와 같이 전진할 자동차의 개수만큼 이름을 입력할 수 있다. 이때 이름은 `,`로 구분한다.   inputView#readUserInput() ✅
     ```
     pobi,woni,jun
     ```
    >   ⚠ 이름은 5자 이하만 가능하다.

3. 프로그램은 아래와 같은 출력을 통해 사용자에게 시도 회수를 물어본다.  inputView#readUserInput() ✅
   ```
   시도할 회수는 몇회인가요?
   ```

3. 사용자는 자동차들이 몇 번의 이동을 할 건지 입력한다.  inputView#readUserInput() ✅
   ```
   5
   ```
   > ⚠ 정수가 아닌 입력에 대해서는 IllegalArgumentException을 발생 시킨다.

## 게임 실행
1. 프로그램은 사용자의 시도 횟수를 입력받은 후에 아래 문장을 출력한다. outputView#printAllRoundsResults() ✅
   ```
   실행 결과
   ```
2. 각 자동차는 한 차수마다 0~9사이의 무작위 값을 전달받는다. 랜덤 값을 사용할 땐 아래 메서드를 사용한다. #NsRandomGeneraotr#generate() ✅
   ```
   Randoms.pickNumberInRange(0,9);
   ```
3. 각 자동차는 전달받은 `무작위 숫자가 4 이상인 경우`에만 전진한다. RandomMoveStrategy#isMovable() ✅
4. 현재 차수에서 자동차가 만약 이동했다면, 그 자동차의 이동 횟수를 1증가시킨다. Car#move() ✅
5. 프로그램은 각 차수의 실행 결과를 아래와 같이 출력한다. outputView#printAllRoundsResults() ✅
   ```
   pobi : -
   woni : 
   jun : -
   ```
   > ⚠매 차수의 출력 결과를 공백 라인으로 구분한다.

## 게임 결과
1. 모든 차수가 다 진행되면, 자동차들 중에 가장 이동 횟수가 많은 자동차를 구한다. Result#announce() ✅
   >⚠가장 많은 이동 횟수를 가진 차량이 여러 대인 경우도 존재한다. 
2. 가장 이동 횟수가 많은 자동차를 아래와 같이 출력한다. OutputView#printWinner() ✅
   ```
   최종 우승자 : pobi, jun
   ```
3. 이떄 이름은 `,`로 구분한다.

## 예외처리
1. 이름이 아예 없는 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `적어도 하나 이상의 이름을 입력해야 합니다.`

2. 이름에 중복이 있는 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `중복된 이름이 있습니다.`  


3. 참가자 수가 2명 미만인 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `적어도 두 명 이상의 참가자가 있어야 합니다.`  


4. `pobi`와 `javaji`가 동시에 등록된 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `pobi와 javaji는 동일 인물입니다.`

5. 이름이 `null`이거나 길이가 1자 미만, 20자 초과인 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `이름은 1자 이상, 20자 이하이어야 합니다.`

6. 이름이 알파벳, 한글, 언더바 외의 문자를 포함하는 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `이름은 알파벳, 한글, 언더바만 포함할 수 있으며, 특수문자나 숫자, 공백은 포함할 수 없습니다.`

7. 시도 횟수가 1 미만인 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `시도 횟수는 1 이상이어야 합니다.`

8. 시도 횟수가 `Integer.MAX_VALUE`인 경우에는 `IllegalArgumentException`을 발생시킨다. ✅
   > ⚠ `시도 횟수가 너무 큽니다. Integer.MAX_VALUE보다 작은 값을 입력해주세요.`  

## 출력 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```
## 클래스 다이어그램
![img.png](img.png)
