package racingcar.utils;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ValidationTest {
    Validation validation = new Validation();
    @Test
    void 예외_nameValidation_글자수_6자_이상() {
        List<String> racers = Arrays.asList("pobi", "javaji");
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validation.carNameInputValidation(racers));
    }
    @Test
    void 예외_nameValidation_자동차_1대_입력() {
        List<String> racers = Arrays.asList("pobi");
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validation.carNameInputValidation(racers));
    }
}