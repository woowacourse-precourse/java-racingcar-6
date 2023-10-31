package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racingcar.CheckException.checkPositiveNumberOfMove;
import static racingcar.CheckException.checkRightNumberOfMove;

public class ExceptionTest {
    @Test
    void 시도_횟수에_대한_예외_처리() {
        int input1 = -2;
        String input2 = "SAE";
        assertAll(
                () -> assertThatThrownBy(() -> checkPositiveNumberOfMove(input1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("Input should be a positive number"),
                () -> assertThatThrownBy(() -> checkRightNumberOfMove(input2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("Input should be convert to number")
        );
    }
}
