package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.handler.ErrorHandler;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarsTest {

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of(new RacingCars(List.of("pobi", "woni", "jun")), List.of("pobi", "woni", "jun")),
                Arguments.of(new RacingCars(List.of("현대", "BMW", "테슬라")), List.of("현대", "BMW", "테슬라"))
        );
    }

    @DisplayName("자동차 이름이 영어와 한글이 아닌 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @ValueSource(strings = {"poB1,현대,woni", "pobi,현대 ,woni"})
    void createCarNamesWithInvalidWord(String inputString) {
        assertThatThrownBy(() -> new RacingCars(List.of(inputString.split(","))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_ENGLISH_KOREAN.getException().getMessage());
    }

    @DisplayName("자동차 이름이 중복된 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @ValueSource(strings = {"pobi,pobi,woni", "pobi,현대,woni,현대"})
    void createCarNamesWithDuplicate(String inputString) {
        assertThatThrownBy(() -> new RacingCars(List.of(inputString.split(","))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.DUPLICATE_NUMBER.getException().getMessage());
    }

    @DisplayName("자동차 이름이 5글자가 넘어가는 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @ValueSource(strings = {"pobiii,pobi,woni", "pobi,BUGATTI,woni,현대"})
    void createCarNamesWithInvalidLength(String inputString) {
        assertThatThrownBy(() -> new RacingCars(List.of(inputString.split(","))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_LENGTH.getException().getMessage());
    }

    @DisplayName("자동차 이름이 정상적으로 반환된다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @MethodSource("generateCarNames")
    void createCarNames(RacingCars racingCars, List<String> carNames) {
        assertThat(racingCars.getCarNames()).isEqualTo(carNames);
    }
}
