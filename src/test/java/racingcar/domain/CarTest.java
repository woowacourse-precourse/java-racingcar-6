package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", "123456", "중간   공백", "   다섯글자초과", "다섯글자초과   ", "  다섯글자초과  "})
    @DisplayName("자동차 이름 5글자 초과 예외 테스트")
    void carNameMaxLengthFailTest(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @ParameterizedTest
    @CsvSource(value =
            {
                    "좌공백,   좌공백",
                    "우공백,우공백   ",
                    "양쪽공백,  양쪽공백  "
            }, ignoreLeadingAndTrailingWhitespace = false)
    @DisplayName("자동차 이름 공백 제거 테스트")
    void carNameTrimTest(String trimName, String name) {
        Car car = assertDoesNotThrow(() -> new Car(name));
        String carName = car.getStatus()
                .getName();
        assertThat(carName).isEqualTo(trimName);
    }
}