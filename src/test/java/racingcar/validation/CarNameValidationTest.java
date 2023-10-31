package racingcar.validation;

import static racingcar.constant.IllegalArgumentMessage.NAME_DUPLICATE;
import static racingcar.constant.IllegalArgumentMessage.NAME_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차_이름")
class CarNameValidationTest {

    @Test
    @DisplayName("중복_예외")
    void validate_duplicate() {
        List<String> carNameList = new ArrayList<>(Arrays.asList("pobi", "pobi", "jun"));

        Assertions.assertThatThrownBy(() -> CarNameValidation.validate(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("길이_예외")
    void validate_wrong_size() {
        List<String> carNameList = new ArrayList<>(Arrays.asList("pobiLover", "GwanSeok", "jun"));

        Assertions.assertThatThrownBy(() -> CarNameValidation.validate(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_OUT_OF_RANGE.getMessage());
    }
}