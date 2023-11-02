package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CommonValidatorTest {
    @ParameterizedTest
    @CsvSource(value = {"''", "NULL"}, nullValues = {"NULL"})
    void 문자열_null(String name) {
        String domainName = "테스트";

        assertThatThrownBy(() -> CommonValidator.validateBlankCheck(name, domainName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(domainName + "의문자열 값이 없습니다.");
    }
}
