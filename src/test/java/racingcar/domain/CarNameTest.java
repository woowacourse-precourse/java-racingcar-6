package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.DomainExceptionCode;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("[도메인] 자동차 이름")
class CarNameTest {

    @Nested
    @DisplayName("을 생성할 때")
    class CreateTest {

        @ParameterizedTest
        @NullAndEmptySource
        void _이름은_없을_수_없다(String input) {

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new CarName(input))
                    .withMessageContaining(DomainExceptionCode.CAR_NAME_CAN_NOT_BE_EMPTY.getMessage());

        }

        @ParameterizedTest
        @ValueSource(ints = {6, 7, 8, 9})
        void _글자를_넘길_수없다(int size) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new CarName("-".repeat(size)))
                    .withMessageContaining(DomainExceptionCode.CAR_NAME_SIZE_MUST_BE_LESS_THAN_EQUAL.getMessage());
        }
    }

}