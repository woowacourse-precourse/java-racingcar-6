package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class TotalRoundValidatorTest {
    Validator totalRoundValidator = new TotalRoundValidator();

    @ParameterizedTest
    @DisplayName("부적절한 전체 라운드 입력 시 에러 발생 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n", "다섯", "five", "@"})
    void testCarNameGreaterThanFive(String totalRound) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> totalRoundValidator.validate(totalRound));
    }
}
