package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ExceptionMessage;

class CarNameTest {

    @Test
    public void 이름은_최대_5글자() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("123456"))
                .withMessage(ExceptionMessage.CAR_NAME_IS_TOO_LONG);
    }

    @Test
    public void 이름은_널_값일_수_없다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(null))
                .withMessage(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 이름은_공백일_수_없다(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
    }
}