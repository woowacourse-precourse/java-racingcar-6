package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void 이름예외처리_TEST() throws Exception{
        Validator validator = new Validator();
        String input = "pobii,dddd";
        assertThatThrownBy(()->validator.checkCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR");
    }
}
