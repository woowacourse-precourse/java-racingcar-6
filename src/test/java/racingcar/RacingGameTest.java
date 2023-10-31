package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    @Test
    void 자동차가_0대일_때_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차가_0대일_때_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_공백인_자동차가_있을_때_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, ,car2", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_공백인_자동차가_있을_때_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,,car2", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수가_숫자일_때_정상_출력() {
        assertSimpleTest(() ->{
                    run("car1, car2", "5");
                    assertThat(output()).contains("최종 우승자");
                }
        );
    }

    @Test
    void 시도할_횟수가_숫자가_아닐_때_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, car2", "123가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수가_숫자가_아닐_때_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, car2", "car3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final void runException(final String... args) {
        try {
            run(args);
        } catch (final NoSuchElementException ignore) {

        }
    }

    protected final void run(final String... args) {
        try {
            command(args);
            runMain();
        } finally {
            Console.close();
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}