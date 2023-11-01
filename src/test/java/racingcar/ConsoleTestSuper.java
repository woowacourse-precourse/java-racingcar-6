package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class ConsoleTestSuper {

    protected final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    protected final PrintStream originalOut = System.out;
    protected final PrintStream customOut = new PrintStream(outputStream);

    protected InputStream customInput;

    /*
    콘솔입력 기능을 테스트 할 시, @BeforeEach 역할을 하는 메서드(직접 호출 필요)
    input을 결정한 뒤에는 setIn(input)과 같은 식으로 호출해주어야 입력테스트가 정상 수행된다.

    아래와 같이 사용하면 된다.
    ```java
    @Test
    void readLine_테스트() {
        String input = "Hello, World!";
        setIn(input);

        String userInput = Input.readLine();

        assertEquals("Hello, World!2", userInput);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello World!", "한글도 넣어볼게요"})
    void readLine_테스트(String expectedInput) {
        setIn(expectedInput);

        String actualInput = Input.readLine();

        Assertions.assertThat(actualInput).isEqualTo(expectedInput);
    }
    ```
     */
    protected void setIn(String input) {
        input += "\n"; // 줄바꿈 단위로 읽기 때문에 줄바꿈문자 추가
        customInput = new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
    }

    @BeforeEach
    void setOut() {
        System.setOut(customOut);
    }

    /*
    Console 내부에서 scanner 인스턴스(이하 'scanner')를 관리하기 때문에, 바깥에서 임의로 scanner 인스턴스를 제어할 수 없다.
    scanner가 가지는 stream을 customStream으로 바꾸든지 말든지,
    여러번 테스트를 반복하면 scanner에 buffer가 계속 누적되어 있다(이전 buffer를 클리어하지 못하고 말이다).

    Console에서 scanner 객체를 생성하는 부분을 보면, scanner가 null이면 새 scanner를 만들어 반환하고 있다.
    그래서 scanner 객체를 새로 만들어주면 해결될 거라고 생각했다(현재로선 더 좋은 방법은 모르겠다).

    그래서 reflection을 활용하여, 테스트를 마칠 때마다(@AfterEach) scanner를 null로 만들어줬더니 실제로 해결되었다.

    만약 이 방법이 싫다면, 기본 제공되는 NsTest를 사용하면 된다.
    */
    @AfterEach
    void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field field = Console.class.getDeclaredField("scanner");
        field.setAccessible(true);
        field.set(Scanner.class, null);
        System.setOut(originalOut);
    }

    protected String enterInput(String testString) {
        return testString + "\n";
    }

}
