package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    public void 이름은_빈_값일_수_없다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(""))
                .withMessage(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
    }

    @Test
    public void 이름은_공백일_수_없다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(" "))
                .withMessage(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
    }
}