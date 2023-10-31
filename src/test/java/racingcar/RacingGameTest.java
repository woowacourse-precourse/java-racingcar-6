package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
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
                    assertThatThrownBy(() ->runException("car1, ,car2", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                );
    }

    @Test
    void 이름이_공백인_자동차가_있을_때_예외_처리2() {
        assertSimpleTest(() ->
                    assertThatThrownBy(() ->runException("car1,,car2", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                );
    }

    protected final void runException(final String... args) {
        try {
            run(args);
        } catch (final NoSuchElementException ignore){

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

    public void runMain(){
        Application.main(new String[]{});
    }
}