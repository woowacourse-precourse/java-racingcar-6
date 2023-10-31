package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarValidatorTest {
    Validator validator = new CarValidator();

    @ParameterizedTest
    @DisplayName("부적절한 자동차 이름 입력 시 에러 발생 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n", "leopard"})
    void testCarNameGreaterThanFive(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(name));
    }
}
