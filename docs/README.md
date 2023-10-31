# 미션 - 자동차 경주🏁
간단 자동차 경주 게임을 구현한다.

구현할 프로그램의 flowchart를 그려보면 다음과 같다.

<img src="flowchart.png" width="700" height="650"/>


# 기능 목록

---

### 1️⃣ 입력 검증: 경주 참가자 

`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 사용자로부터 경주 참가자를 입력받는다.
참가자들은 쉼표(,)로 구분되며 5자 이하여야 한다.

- 쉼표(,)를 기준으로 입력값을 split한다.  
- 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.


        잘못된 경우를 입력하는 경우는 다음의 경우로 분류했다.
    
        * 쉼표(,)를 포함하지 않는다.
        * 쉼표로 split한 각 요소 중 하나라도 6자 이상인 요소가 있다.

- 사용자가 올바른 값을 입력한 경우 LinkedHashMap을 반환한다. key값은 쉼표를 기준으로 입력받은 자동차의 이름이며, value값은 StringBuilder이다.


- 입력받은 값을 검증하는 부분을 isInputVaild로 분리해주었다. 

<details>
<summary>requestRacers(), isInputVaild </summary>
<div markdown="1">



```java
 public static LinkedHashMap<String, StringBuilder> requestRacers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = readLine().split(",");

        if (!isInputValid(names)) throw new IllegalArgumentException();

        return Stream.of(names).collect(
        Collectors.toMap(name -> name, value -> new StringBuilder(), (e1, e2) -> e1, LinkedHashMap::new));
        }

public static boolean isInputValid(String[] names) {
        return names.length >= 2 && Stream.of(names).allMatch(name -> name.length() <= 5);
        }
```

</div>
</details>

테스트는 기존에 있던 이름에_대한_예외_처리를 이용했다.
6자 이상의 이름을 입력한 경우와 쉼표로 구분하지 않고 입력한 경우의 예외 처리를 따로 검증했다.

<details>
<summary>✅이름에_대한_예외_처리_6자_이상인_경우</summary>
<div markdown="1">

```java
@Test
    void 이름에_대한_예외_처리() {
            assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
            .isInstanceOf(IllegalArgumentException.class));
        }
```

</div>
</details>

<details>
<summary>✅이름에_대한_예외_처리_쉼표가_없는_경우</summary>
<div markdown="1">

```java
@Test
    void 이름에_대한_예외_처리_쉼표가_없는_경우() {
            assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobijavaji", "1"))
            .isInstanceOf(IllegalArgumentException.class));
    }
```

</div>
</details>

---

### 2️⃣ 입력 검증: 경주 횟수 

`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 사용자로부터 경주 횟수를 입력받는다.

-  사용자가 잘못된 값(1 이상의 숫자가 아닌 값)을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.


- 사용자가 올바른 값을 입력한 경우 입력받은 경주 횟수를 int 형식으로 반환한다.

<details>
<summary>requestNum()</summary>
<div markdown="1">

```java
 public static int requestNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();

        if (!input.matches("^[1-9]\\d*$")) throw new IllegalArgumentException();

        return Integer.parseInt(input);
}
```
</div>
</details>

테스트는 경주 횟수로 0을 입력한 경우, 숫자가 아닌 값이 포함된 경우, 숫자가 아닌 값을 입력한 경우의 세 가지로 나눠 검증했다.

<details>
<summary> ✅ 경주횟수에_대한_예외_처리_0인_경우 </summary>
<div markdown="1">

```java
@Test
void 경주횟수에_대한_예외_처리_0인_경우() {
        assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,woni,dori", "0"))
        .isInstanceOf(IllegalArgumentException.class));
    }
```
</div>
</details>

<details>
<summary> ✅ 경주횟수에_대한_예외_처리_숫자_이외의_값이_있는_경우 </summary>
<div markdown="1">

```java
@Test
void 경주횟수에_대한_예외_처리_숫자_이외의_값이_있는_경우() {
        assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,woni,dori", "4번이상"))
        .isInstanceOf(IllegalArgumentException.class));
}
```
</div>
</details>

<details>
<summary> ✅ 경주횟수에_대한_예외_처리_숫자가_아닌_경우 </summary>
<div markdown="1">

```java
@Test
void 경주횟수에_대한_예외_처리_숫자가_아닌_경우() {
        assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,woni,dori", "많이"))
        .isInstanceOf(IllegalArgumentException.class));
}
```
</div>
</details>

---

### 3️⃣ 경주

경주는 2️⃣에서 입력받은 경주 횟수만큼 진행한다.
각 참가자별로 다음의 프로세스를 수행한다.

1. `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 **0~9 사이의 수 1개를 선택** 한다.
2. 값이 **4 이상** 이면 value에 **"-"를 추가** 한다.
3. key와 value를 **출력** 한다.

<details>
<summary>race()</summary>
<div markdown="1">

```java
public static void race(LinkedHashMap<String, StringBuilder> racers) {
    for (String racer : racers.keySet()) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            racers.get(racer).append("-");
        }
        System.out.println(racer + " : " + racers.get(racer));
    }
    System.out.println("");
}
```
</div>
</details>


<details>
<summary> ✅숫자가_4이상이면_전진하고_3이하면_정지</summary>
<div markdown="1">

```java
private static int[] MOVING_FORWARD_NUMS = {4,5,6,7,8,9};
private static int[] STOP_NUMS = {0,1,2,3};

@Test
void 숫자가_4이상이면_전진하고_3이하면_정지() {
        assertRandomNumberInRangeTest(
        () -> {run("dori,woni", "6");
        assertThat(output()).contains("dori : ------", "woni : ");},
        MOVING_FORWARD_NUMS[0], STOP_NUMS[0],
        MOVING_FORWARD_NUMS[1], STOP_NUMS[1],
        MOVING_FORWARD_NUMS[2], STOP_NUMS[2],
        MOVING_FORWARD_NUMS[3], STOP_NUMS[3],
        MOVING_FORWARD_NUMS[4], STOP_NUMS[3],
        MOVING_FORWARD_NUMS[5], STOP_NUMS[3]
        );
    }
```
</div>
</details>

---

### 4️⃣ 결과 판정

value의 길이가 가장 긴 참가자를 출력한다. 

- 동점자가 있는 경우 쉼표로 구분해 출력한다.

- 문제 요구사항에서 `우승자는 한 명 이상일 수 있다` 고 했으나 우승자가 없는 경우도 존재할 수 있다고 생각한다.
우승자가 없는 경우는 `우승자가 없습니다.` 는 문구가 출력되도록 했다.

<details>
<summary>judge()</summary>
<div markdown="1">

```java
public static void judge(LinkedHashMap<String, StringBuilder> racers) {
        int maxLength = racers.values()
                        .stream()
                        .mapToInt(StringBuilder::length)
                        .max()
                        .orElse(0);

        String winners = racers.entrySet()
                        .stream()
                        .filter(racer -> racer.getValue().length() == maxLength)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.joining(", "));

        if (maxLength > 0) System.out.println("최종 우승자 : " + winners.toString());
        else System.out.println("우승자가 없습니다.");
}
```
</div>
</details>

테스트 코드의 경우 우승자가 한명인 경우는 기존에 있던 테스트 전진_정지를 통해 검증했고(우승자가_1명인_경우),
우승자가 2명인 경우와 우승자가 없는 경우는 아래와 같이 테스트를 작성했다.


<details>
<summary> ✅우승자가_1명인_경우</summary>
<div markdown="1">

```java
@Test
void 우승자가_1명인_경우() {
        assertRandomNumberInRangeTest(() -> {run("pobi,woni", "1");
        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");},
        MOVING_FORWARD, STOP);
}
```
</div>
</details>
<details>
<summary> ✅우승자가_2명인_경우</summary>
<div markdown="1">

```java
@Test
void 우승자가_2명인_경우() {
        assertRandomNumberInRangeTest(() -> {run("pobi,woni,dori", "1");
        assertThat(output()).contains("pobi : -", "woni : -", "dori : " , "최종 우승자 : pobi, woni");},
        MOVING_FORWARD, MOVING_FORWARD, STOP);
}
```
</div>
</details>

<details>
<summary> ✅우승자가_없는_경우</summary>
<div markdown="1">

```java
@Test
void 우승자가_없는_경우() {
        assertRandomNumberInRangeTest(() -> {run("pobi,woni,dori", "1");
        assertThat(output()).contains("pobi : ", "woni : ", "dori : " , "우승자가 없습니다.");},
            STOP, STOP, STOP);
}
```
</div>
</details>

---

# 주요 고려사항
1. **자동차의 이름과 전진/후진을 어떤 자료 구조를 이용할 것인가** 
   
   전진할 때마다 "-"가 추가되므로 String 대신 변경이 가능한 StringBuilder를 선택했다. 자동차의 이름과 경주 상태를 매핑하기 위해 HashMap을 사용하려고 했으나, 값이 랜덤으로 저장된다는 문제가 있어 LinkedHashMap으로 변경해주었다. 


2. **테스트 코드 작성**
    
    지난번 과제와의 차별점이 있다면 구현한 기능에 대한 테스트 코드를 작성하는 요구사항이 추가된 것이다. 테스트 코드를 작성하는 것 자체가 생소했으나 기존에 있던 예제를 참고해 테스트 코드를 작성할 수 있었고, 기능 단위로 테스트를 작성해 검증하니 별도의 프로그램을 실행하는 과정 없이 간단하게 코드를 검증해 작주 과제보다 수월하게 프로그램을 구헌할 수 있었다!