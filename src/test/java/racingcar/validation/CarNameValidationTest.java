package racingcar.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidationTest {

    @Test
    @DisplayName("자동차_이름_중복_오류")
    void validate_duplicate() {
        List<String> carNameList = new ArrayList<>(Arrays.asList("pobi", "pobi", "jun"));

        Assertions.assertThatThrownBy(() -> CarNameValidation.validate(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_이름_길이_오류")
    void validate_wrong_size() {
        List<String> carNameList = new ArrayList<>(Arrays.asList("pobiLover", "GwanSeok", "jun"));

        Assertions.assertThatThrownBy(() -> CarNameValidation.validate(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}