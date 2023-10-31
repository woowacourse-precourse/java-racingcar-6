package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameValidationTest {

    @Test
    void validateGap() {
        CarNameValidation carNameValidation = new CarNameValidation();
        String input = " car";

        assertThatThrownBy(() -> carNameValidation.validateGap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백 없이 입력해주세요.");
    }

    @Test
    void validateLeastName() {
        CarNameValidation carNameValidation = new CarNameValidation();
        String input = "car1";

        assertThatThrownBy(() -> carNameValidation.validateLeastName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 두 개 이상의 자동차 이름을 입력해주세요.");
    }

    @Test
    void validateCommaDivision() {
        CarNameValidation carNameValidation = new CarNameValidation();
        String input = "car1 car2";

        assertThatThrownBy(() -> carNameValidation.validateCommaDivision(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분해주세요.");
    }

    @Test
    void validateNameLengthLimit() {
        CarNameValidation carNameValidation = new CarNameValidation();
        String input = "car1,car2,car345";

        assertThatThrownBy(() -> carNameValidation.validateNameLengthLimit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요.");
    }
}