package racingcar.common;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("자동차 이름 검증")
    @Nested
    class carNameTest {
        @DisplayName("빈 문자열 입력 시 예외 발생")
        @ParameterizedTest(name = "carName=\"{0}\"" )
        @ValueSource(strings = {" ", " ,", "pobi, ,jun"})
        public void empty(String carNames) {
            StringToListConverter converter = new StringToListConverter();
            List<String> carNameList = converter.convert(carNames);

            //then
            Assertions.assertThatThrownBy(() -> Validator.validateCarNames(carNameList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessageConstants.CAR_NAME_BLANK_MESSAGE);
        }

        @DisplayName("이름 입력 안할 시 예외 발생")
        @ParameterizedTest(name = "carName=\"{0}\"" )
        @ValueSource(strings = {"", ","})
        public void nullTest(String carNames) {
            StringToListConverter converter = new StringToListConverter();
            List<String> carNameList = converter.convert(carNames);

            Assertions.assertThatThrownBy(() -> Validator.validateCarNames(carNameList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessageConstants.CAR_NAMES_NULL_MESSAGE);
        }

        @DisplayName("중복된 이름 입력 시 예외 발생")
        @Test
        public void duplicated() {
            //given
            String carNames = "pobi, pobi";
            StringToListConverter converter = new StringToListConverter();
            List<String> carNameList = converter.convert(carNames);

            //then
            Assertions.assertThatThrownBy(() -> Validator.validateCarNames(carNameList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessageConstants.CAR_NAME_DUPLICATED_MESSAGE);
        }

        @DisplayName("길이가 6이상일 경우 예외 발생")
        @Test
        public void overLength() {
            //given
            String carNames = "longlongname";
            StringToListConverter converter = new StringToListConverter();
            List<String> carNameList = converter.convert(carNames);

            //then
            Assertions.assertThatThrownBy(() -> Validator.validateCarNames(carNameList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessageConstants.CAR_NAME_WRONG_LENGTH_MESSAGE);
        }
    }

    @DisplayName("이동 횟수 검증")
    @Nested
    class RoundNumberTest {

        @DisplayName("문자 입력 시 예외 발생")
        @Test
        public void notInteger() {
            //given
            String roundNumber="aaa";

            //then
            Assertions.assertThatThrownBy(() -> Validator.validateRoundNumber(roundNumber))
                            .isInstanceOf(IllegalArgumentException.class)
                                    .hasMessage(ErrorMessageConstants.ROUND_NUMBER_WRONG_TYPE_MESSAGE);
        }

        @DisplayName("양의 정수가 아닌 숫자 입력 시 예외 발생")
        @ParameterizedTest(name ="횟수={0}")
        @ValueSource(strings = {"-1", "0"})
        public void notPositiveInteger(String roundNumber) {
            Assertions.assertThatThrownBy(() -> Validator.validateRoundNumber(roundNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessageConstants.ROUND_NUMBER_WRONG_RANGE_MESSAGE);
        }
    }
}
