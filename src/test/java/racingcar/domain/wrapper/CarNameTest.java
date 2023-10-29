package racingcar.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.handler.ErrorHandler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarNameTest {

    @DisplayName("자동차 이름이 영어와 한글이 아닌 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @ValueSource(strings = {"poB1", "pobi ", "won^"})
    void createCarNamesWithInvalidWord(String inputString) {
        assertThatThrownBy(() -> CarName.create(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_ENGLISH_KOREAN.getException().getMessage());
    }

    @DisplayName("자동차 이름이 5글자가 넘어가는 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @ValueSource(strings = {"pobiii", "BUGATTI", "기아제네시스"})
    void createCarNamesWithInvalidLength(String inputString) {
        assertThatThrownBy(() -> CarName.create(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_LENGTH.getException().getMessage());
    }
}
