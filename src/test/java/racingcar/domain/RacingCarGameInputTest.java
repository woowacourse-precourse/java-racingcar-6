package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.CAR_NAME_HAVE_WHITE_CHAR;
import static racingcar.message.ErrorMessage.CAR_NAME_IS_BIGGER_THAN_5CHAR;
import static racingcar.message.ErrorMessage.CAR_NAME_IS_DUPLICATED;
import static racingcar.message.ErrorMessage.CAR_NAME_IS_EMPTY;
import static racingcar.message.ErrorMessage.MOVE_COUNT_IS_NOT_NUM;
import static racingcar.message.ErrorMessage.MOVE_COUNT_IS_NOT_POSITIVE_NUM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import utils.InputUtil;

public class RacingCarGameInputTest {
    @AfterEach
    private void close() {
        InputUtil.closeConsole();
    }

    @Test
    void 자동차_이름_입력_정상_작동() {
        InputUtil.setInput("yang,min,cheol");

        assertThatCode(() -> RacingCarGameInput.readCarNames())
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름이_5자가_넘어가는_경우_예외_발생() {
        InputUtil.setInput("yang,minjin,cheol");

        assertThatThrownBy(() -> RacingCarGameInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_BIGGER_THAN_5CHAR.getMessage());
    }

    @Test
    void 자동차_이름_입력에_공백이_들어가는_경우_예외_발생() {
        InputUtil.setInput("yang, min");

        assertThatThrownBy(() -> RacingCarGameInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_HAVE_WHITE_CHAR.getMessage());
    }

    @Test
    void 자동차_이름이_중복일_경우_예외_발생() {
        InputUtil.setInput("yang,yang");

        assertThatThrownBy(() -> RacingCarGameInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_DUPLICATED.getMessage());
    }

    @Test
    void 자동차_이름이_비어_있을_경우_예외_발생() {
        InputUtil.setInput("yang,,min");

        assertThatThrownBy(() -> RacingCarGameInput.readCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_EMPTY.getMessage());
    }

    @Test
    void 이동_횟수_입력_정상_작동() {
        InputUtil.setInput("2000");

        assertThatCode(() -> RacingCarGameInput.readMoveCount())
                .doesNotThrowAnyException();
    }

    @Test
    void 이동_횟수가_숫자가_아닌_경우_예외_반환() {
        InputUtil.setInput("12ad");

        assertThatThrownBy(() -> RacingCarGameInput.readMoveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MOVE_COUNT_IS_NOT_NUM.getMessage());
    }

    @Test
    void 이동_횟수가_1이상이_아닌_경우_예외_반환() {
        InputUtil.setInput("0");

        assertThatThrownBy(() -> RacingCarGameInput.readMoveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MOVE_COUNT_IS_NOT_POSITIVE_NUM.getMessage());
    }
}
