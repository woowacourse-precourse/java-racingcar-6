package racingcar.service.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.CarExceptionMessage;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "    ", "     "})
    void blankTest(String name) {
        Assertions.assertThatThrownBy(() -> new CarName(name))
                .hasMessage(CarExceptionMessage.ONLY_BLANK_NAME.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {",준기", "포,비", "준기,", "  ,", "@,@"})
    void commaTest(String name) {
        Assertions.assertThatThrownBy(() -> new CarName(name))
                .hasMessage(CarExceptionMessage.COMMA_EXISTS.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"내이름은준기", "내이름은김준기", "     *_*"})
    void lengthTest(String name) {
        Assertions.assertThatThrownBy(() -> new CarName(name))
                .hasMessage(CarExceptionMessage.OUT_OF_NAME_LENGTH.getError());
    }
}