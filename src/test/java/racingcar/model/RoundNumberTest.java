package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;

class RoundNumberTest {

    @Test
    public void RoundNumber는_숫자여야_한다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundNumber("a"))
                .withMessage(ExceptionMessage.ROUND_NUMBER_MUST_BE_NUMBER);
    }

    @Test
    public void RoundNumber는_음수일_수_없다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundNumber("-1"))
                .withMessage(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
    }

    @Test
    public void RoundNumber는_0일_수_없다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundNumber("0"))
                .withMessage(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
    }
}