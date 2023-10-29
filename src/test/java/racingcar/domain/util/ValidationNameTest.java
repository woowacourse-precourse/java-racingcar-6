package racingcar.domain.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름이 유효한 길이인지 테스트한다.")
    @ValueSource(strings = {"audi, abced, ", " , doekrneor, ", "seron, eoinel, seorlsn"})
    void validateLength(String names) {
        IllegalArgumentException lengthException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationName.validateLength(names);
        });
        assertThat(lengthException.getMessage()).isEqualTo(ExceptionMessages.LENGTH.getExceptionMessage());
    }
}