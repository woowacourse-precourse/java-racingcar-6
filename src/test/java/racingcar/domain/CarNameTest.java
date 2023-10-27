package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameTest {

    @Nested
    @DisplayName("자동차 이름 검증 테스트")
    class ValidationTest {
        @ParameterizedTest(name = "input : [{0}]")
        @CsvSource({"''", "' '", "steven", "CA Lee"})
        @DisplayName("자동차 이름의 형식이 올바르지 않으면, 예외를 던진다")
        void creationTest_whenFormatIsNotMatch(String name) {

            assertThatThrownBy(() -> CarName.from(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 빈칸이 아니어야 하고 5글자 이하이어야 합니다");
        }

        @Test
        @DisplayName("자동자 이름에 null이 들어갈 경우 예외를 던진다")
        void creationTest_whenFormatIsNotMatch() {

            assertThatThrownBy(() -> CarName.from(null)).isInstanceOf(NullPointerException.class);
        }

        @ParameterizedTest(name = "input : [{0}], expect name : [{1}]")
        @CsvSource({"' steve','steve'", "'po bi ','po bi'", "' jun ','jun'"})
        @DisplayName("자동차 이름 앞뒤의 빈칸이 있다면, 해당 빈칸을 잘라낸다")
        void creationTest_whenNameHasFrontBehindBlank(String inputName, String expected) {
            CarName carName = CarName.from(inputName);

            String actual = carName.getName();

            assertThat(actual).isEqualTo(expected);
        }
    }
}
