package racingcar.domain.wrapper;

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
import static racingcar.handler.ConstantsHandler.SPLIT_DELIMITER;

public class CarNamesTest {

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of(CarNames.create(List.of("pobi", "woni", "jun")), List.of("pobi", "woni", "jun")),
                Arguments.of(CarNames.create(List.of("현대", "BMW", "테슬라")), List.of("현대", "BMW", "테슬라"))
        );
    }

    @DisplayName("자동차 이름이 중복된 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @ValueSource(strings = {"pobi,pobi,woni", "pobi,현대,woni,현대"})
    void createCarNamesWithDuplicate(String inputString) {
        assertThatThrownBy(() -> CarNames.create(List.of(inputString.split(SPLIT_DELIMITER))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.DUPLICATE_NUMBER.getException().getMessage());
    }

    @DisplayName("자동차 이름이 정상적으로 반환된다")
    @ParameterizedTest(name = "[{index}] input : {0} ")
    @MethodSource("generateCarNames")
    void createCarNames(CarNames cars, List<String> carNames) {
        assertThat(cars.getCarNames()).isEqualTo(carNames);
    }
}
