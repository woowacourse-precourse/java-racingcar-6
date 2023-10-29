# 미션 - 자동차 경주🏁
간단 자동차 경주 게임을 구현한다.

구현할 프로그램의 flowchart를 그려보면 다음과 같다.

<img src="flowchart.png" width="700" height="650"/>


# 기능 목록

---

### 1️⃣ 입력 검증: 경주 참가자 

`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 사용자로부터 경주 참가자를 입력받는다.
참가자들은 쉼표(,)로 구분되며 5자 이하여야 한다.

-  사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.


        잘못된 경우를 입력하는 경우는 다음의 경우로 분류했다.
    
        * 쉼표(,)를 포함하지 않는다.
        * 쉼표로 split한 각 요소 중 하나라도 6자 이상인 요소가 있다.

- 사용자가 올바른 값을 입력한 경우 LinkedHashMap을 반환한다. key값은 자동차의 이름이며, value값은 ""의 StringBuilder이다.

---

### 2️⃣ 입력 검증: 경주 횟수 

`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 사용자로부터 경주 횟수를 입력받는다.

-  사용자가 잘못된 값(1 이상의 숫자가 아닌 값)을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.


- 사용자가 올바른 값을 입력한 경우 입력받은 경주 횟수를 int 형식으로 반환한다.

---

### 3️⃣ 경주

경주는 2️⃣에서 입력받은 경주 횟수만큼 진행한다.
각 참가자별로 다음의 프로세스를 수행한다.

1. `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 **0~9 사이의 수 1개를 선택** 한다.
2. 값이 **4 이상** 이면 value에 **"-"를 추가** 한다.
3. key와 value를 **출력** 한다.


---

### 4️⃣ 결과 판정

value의 길이가 가장 긴 참가자를 출력한다. 
동점자가 있는 경우 쉼표로 구분해 출력한다.