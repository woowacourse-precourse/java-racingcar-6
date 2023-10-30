package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("[도메인] 자동차 이름")
class CarNameTest {

    @Nested
    @DisplayName("을 생성할 때")
    class CreateTest {
        @Test
        void _이름은_없을_수_없다() {
            assertAll(
                    () -> assertThatIllegalArgumentException()
                            .isThrownBy(() -> new CarName(null)),
                    () -> assertThatIllegalArgumentException()
                            .isThrownBy(() -> new CarName(""))
            );

        }

        @ParameterizedTest
        @ValueSource(ints = {6, 7, 8, 9})
        void _글자를_넘길_수없다(int size) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new CarName("-".repeat(size)));
        }
    }

}