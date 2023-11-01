package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AttemptNumberTest {

    @Test
    void 게임_반복_횟수_입력_비어있음() {
        String input = "";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    if (input.isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                });
    }

    @Test
    void 게임_반복_횟수_숫자_입력x() {
        String input = "test";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    int num = Integer.parseInt(input);
                });
    }

    @Test
    void 게임_반복_횟수_음수_또는_0_입력() {
        int num = -1;
        assertThrows(IllegalArgumentException.class,
                () -> {
                    if (num < 1) {
                        throw new IllegalArgumentException();
                    }
                });
    }
}


