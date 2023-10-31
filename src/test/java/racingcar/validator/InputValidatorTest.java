package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.fixture.CarsFixture.CAR_NAMES_LIST;
import static racingcar.fixture.CarsFixture.DUPLICATED_CAR_NAMES_LIST;
import static racingcar.fixture.NameFixture.VALID_CAR_NAMES_INPUT;

@DisplayName("[InputValidator Test] - Domain Layer")
class InputValidatorTest {
    private static final String DELIMITER = ",";

    @Nested
    @DisplayName("[validateEndsWithComma] 쉼표(,)로 끝나는 입력값에 대해 예외를 던진다.")
    class validateEndsWithCommaTest {

        @Test
        @DisplayName("[Success] 정상적인 조건의 이름으로, 아무런 행동도 하지 않는다.")
        void Given_ValidNames_When_validateEndsWithComma_Then_DoNothing() {
            // given
            final String VALID_NAMES = VALID_CAR_NAMES_INPUT.getName();

            // when &&then
            assertDoesNotThrow(() -> InputValidator.validateEndsWithComma(VALID_NAMES));
        }

        @Test
        @DisplayName("[Exception] 구분자로 끝나는 이름 요청으로 예외를 던진다.")
        void Given_EndWithCommaRequest_When_validateEndsWithComma_Then_ThrowException() {
            // given
            final String ENDS_WITH_DELIMITER = VALID_CAR_NAMES_INPUT.getName() + DELIMITER;

            // when &&then
            assertThatThrownBy(() -> InputValidator.validateEndsWithComma(ENDS_WITH_DELIMITER))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessageContaining(ErrorMessage.ENDS_WITH_DELIMITER.getMessage());
        }
    }

    @Nested
    @DisplayName("[validateDuplicated] 리스트 내부 중복된 값이 있다면 예외를 던진다.")
    class validateDuplicatedTest {
        @Test
        @DisplayName("[Success] 정상적인 조건의 이름으로, 아무런 행동도 하지 않는다.")
        void Given_ValidNames_When_ValidateDuplicated_Then_DoNothing() {
            // given
            List<String> validCarNames = CAR_NAMES_LIST.getCarNamesList();

            //when &&then
            assertDoesNotThrow(() -> InputValidator.validateDuplicated(validCarNames));
        }

        @Test
        @DisplayName("[Exception] 중복된 이름이 리스트에 포함되어, 예외를 던진다.")
        void Given_Duplicated_When_ValidateDuplicated_Then_ThrowException() {
            // given
            List<String> duplicatedCarNames = DUPLICATED_CAR_NAMES_LIST.getCarNamesList();

            // when &&then
            assertThatThrownBy(() -> InputValidator.validateDuplicated(duplicatedCarNames))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessageContaining(ErrorMessage.DUPLICATED.getMessage());
        }
    }

    @Nested
    @DisplayName("[validateRoundCount] 최소 수행 횟수 미만의 시도 횟수에 대해  예외를 던진다.")
    class validateRoundCount {

        @Test
        @DisplayName("[Success] 정상적인 조건의 시도 횟수로, 아무런 행동도 하지 않는다.")
        void Given_ValidNames_When_ValidateDuplicated_Then_DoNothing() {
            // given
            final int validRoundCountA = 1;
            final int validRoundCountB = 20;
            final int validRoundCountC = 300;

            //when &&then
            Assertions.assertAll(
                    () -> assertDoesNotThrow(() -> InputValidator.validateRoundCount(validRoundCountA)),
                    () -> assertDoesNotThrow(() -> InputValidator.validateRoundCount(validRoundCountB)),
                    () -> assertDoesNotThrow(() -> InputValidator.validateRoundCount(validRoundCountC))
            );

        }

        @Test
        @DisplayName("[Exception] 중복 이름 입력으로 예외를 던진다.")
        void Given_Duplicated_When_ValidateDuplicated_Then_ThrowException() {
            // given
            List<String> duplicatedCarNames = DUPLICATED_CAR_NAMES_LIST.getCarNamesList();

            // when &&then
            assertThatThrownBy(() -> InputValidator.validateDuplicated(duplicatedCarNames))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessageContaining(ErrorMessage.DUPLICATED.getMessage());
        }
    }
}
