package racingcar.util.io;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputUtilsTest {

    @Test
    void 차_이름_null_입력_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputUtils.validateCarNameInput(null);
        });
    }

    @Test
    void 차_이름_5자_초과_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputUtils.validateCarNameInput("pobi,wooony");
        });
    }
}
