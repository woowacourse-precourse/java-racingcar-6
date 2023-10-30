package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCar;
import racingcar.utils.RacingCarGameInput;

public class RacingCarGameInputTest {
    @AfterEach
    private void closeConsole() {
        Console.close();
    }

    private void setInputStream(String input) {
        System.setIn(convertToInputStream(input));
    }

    private ByteArrayInputStream convertToInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 자동차_이름이_5자가_넘어가는_경우_예외_발생() {
        setInputStream("yang,minjin,cheol");
        assertThatThrownBy(() -> RacingCarGameInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_BIGGER_THAN_5CHAR);
    }

    @Test
    void 자동차_이름_입력에_공백이_들어가는_경우_예외_발생() {
        setInputStream("yang, min");
        assertThatThrownBy(() -> RacingCarGameInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_EMPTY);
    }


    @Test
    void 시도_횟수가_숫자가_아닌_경우_예외_반환() {
        setInputStream("12ad");
        assertThatThrownBy(() -> RacingCarGameInput.readMoveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_NOT_NUMBER);
    }

    @Test
    void 시도_횟수가_1이상이_아닌_경우_예외_반환() {
        setInputStream("0");
        assertThatThrownBy(() -> RacingCarGameInput.readMoveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_NOT_POSITIVE);
    }
}
