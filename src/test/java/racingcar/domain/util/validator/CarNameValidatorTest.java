package racingcar.domain.util.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.config.GameConfig;
import racingcar.domain.entity.Car;
import racingcar.domain.util.validator.CarNameValidator;

class CarNameValidatorTest {
    @Nested
    class 정상 {
        @Test
        public void validate_maximumName_정상적인_입력() {
            int MAXIMUM_NAME = GameConfig.MAXIMUM_NAME;
            StringBuffer nameBuffer = new StringBuffer("a");
            for (int i = 0; i < MAXIMUM_NAME - 1; i++) {
                nameBuffer.append("a");
            }
            String name = nameBuffer.toString();

            assertDoesNotThrow(() -> CarNameValidator.validate(name));
        }

        @Test
        public void checkDuplication_정상적인_입력() {
            Car car1 = new Car("car1");
            Car car2 = new Car("car2");
            List<Car> cars = List.of(car1, car2);

            assertDoesNotThrow(() -> CarNameValidator.checkDuplication(cars));
        }
    }

    @Nested
    class 예외_발생 {
        @Test
        public void validate_maximumName_MAXIMUM_NAME_보다_크면_예외_발생() {
            int MAXIMUM_NAME = GameConfig.MAXIMUM_NAME;
            StringBuffer nameBuffer = new StringBuffer("a");
            for (int i = 0; i < MAXIMUM_NAME; i++) {
                nameBuffer.append("a");
            }
            String name = nameBuffer.toString();

            assertThatThrownBy(() -> CarNameValidator.validate(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("The name must be less than " + (MAXIMUM_NAME + 1) + " characters.");
        }

        @Test
        public void checkDuplication_중복이면_예외_발생() {
            Car car1 = new Car("car");
            Car car2 = new Car("car");
            List<Car> cars = List.of(car1, car2);

            assertThatThrownBy(() -> CarNameValidator.checkDuplication(cars))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Car name duplicate");
        }
    }
}