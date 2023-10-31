package racingcar.unitTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.vo.CarName;
import racingcar.validation.NameValidator;

public class CarNameValidationTest {

    private NameValidator nameValidator;
    @BeforeEach
    void setUp() {
        nameValidator = new NameValidator();
    }

    @Test
    void should_throwException_when_hasNotComma() {
        // given
        String carName = "park;kim";
        // when & then
        Assertions.assertThatThrownBy(() -> nameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_throwException_when_LessThan5() {
        // given
        CarName carName = new CarName("sanghyeok");
        // when & then
        Assertions.assertThatThrownBy(() -> nameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_throwException_when_isBlank() {
        // given
        CarName carName = new CarName("");
        // when & then
        Assertions.assertThatThrownBy(() -> nameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
