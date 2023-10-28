package racingcar.Utils;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 자동차_이름이_5자를_넘어가면_예외가_발생한다() {
        String input = "test1,test2,exceedName";
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputException.WRONG_CAR_NAME_PATTERN.getMessage());
    }
    @Test
    void 자동차_이름이_1자_미만이면_예외가_발생한다() {
        String input = "test1,test2, ";
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputException.WRONG_CAR_NAME_PATTERN.getMessage());
    }

    @Test
    void 자동차_이름은_영어소문자_숫자_조합만_가능하다() {
        String input = "test1,test2,car_1";
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputException.WRONG_CAR_NAME_PATTERN.getMessage());
    }

    @Test
    void 자동차_이름은_중복이_불가능_하다() {
        String input = "test1,dup,dup";
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputException.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    void 자동차_대수는_최대_10대_가능하다() {
        String input = "t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11";
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputException.EXCEED_CAR_NUM.getMessage());
    }
}