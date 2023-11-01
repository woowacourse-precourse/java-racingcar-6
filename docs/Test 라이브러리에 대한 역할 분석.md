## 테스트 라이브러리에 대한 역할 분석
### NsTest 테스트
콘솔에서의 입력과 출력 그리고 에러 처리에 대한 메소드를 제공하고 있습니다.  
System 라이브러리에서는 `setIn`을 통해 입력을 설정하고,   
`setOut`을 통해 출력을 세팅합니다.  

- **System.setIn()**
```java
    public static void setIn(InputStream in) {
        checkIO();
        setIn0(in);
    }
```

- **System.setOut()**
```java
    public static void setOut(PrintStream out) {
        checkIO();
        setOut0(out);
    }
```

NsTest 라이브러리를 살펴보겠습니다.
- **run()**  
`command(args)`를 통해 콘솔의 입력을 세팅하고 실행하고 싶은 메소드를 `runMain()`에 담아서 실행합니다.

```java
    protected final void run(final String... args) {
        try {
            command(args);
            runMain();
        } finally {
            Console.close();
        }
    }
```

- **command()**  
String[] 문자열 배열을 `/n` 요소로 이어 붙여 byte[] 배열 형태로 반환합니다.  
`InputSteam` 가운데 `ByteArrayInputStream` 으로 입력을 세팅합니다.
```java
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
```

- **runMain()**  
`runMain()`은 바로 사용을 하지는 못하고 실제 사용하는 곳에서 오버라이딩 재정의하여 사용해야 합니다.  
```java
    protected abstract void runMain();
```

### Assertions 테스트
`camp.nextstep.edu.missionutils.test.Assertions`
### assertSimpleTest
해당 executable 람다식이 1초(`SIMPLE_TEST_TIMEOUT`) 만에 실행이 되는지 확인
```java
    public static void assertSimpleTest(final Executable executable) {
        assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, executable);
    }
```

- 코드 예시
```java
    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
```

### assertRandomNumberInRangeTest
`assertRandomNumberInListTest`,`assertRandomNumberInRangeTest`,`assertRandomUniqueNumbersInRangeTest`는
`assertRandomTest`를 기반으로 작성되고 있습니다.
`assertRandomTest` 메소드만 살펴보도록 하겠습니다.  

```java
    public static void assertRandomNumberInListTest(
        final Executable executable,
        final Integer value,
        final Integer... values
    ) {
        assertRandomTest(
            () -> Randoms.pickNumberInList(anyList()),
            executable,
            value,
            values
        );
    }
```

### assertRandomTest
mockStatic을 사용하여 전역으로 Radndom클래스를 mock으로 관리하고,
executable 테스트 실행합니다. 입력 받은 값을 배열로 만들어서 random 값을 제공합니다.  

```java
    private static <T> void assertRandomTest(
        final Verification verification,
        final Executable executable,
        final T value,
        final T... values
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                executable.execute();
            }
        });
    }
```

- 코드 예시
```java
    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }
```