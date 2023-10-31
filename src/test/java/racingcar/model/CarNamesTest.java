package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNamesTest {

    @ParameterizedTest
    @MethodSource("validCarNamesProvider")
    public void 유효한_차_이름_목록(String validCarNamesString, List<String> validCarNamesList) {
        //when
        CarNames carNames = CarNames.create(validCarNamesString);

        //then
        assertThat(carNames.getCarNames()).isEqualTo(validCarNamesList);
    }

    static Stream<Arguments> validCarNamesProvider() {
        return Stream.of(
                Arguments.arguments("a", List.of("a")),
                Arguments.arguments("pobi", List.of("pobi")),
                Arguments.arguments("pobi,wonni,jun", List.of("pobi", "wonni", "jun"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi,gyuwon,jun", "pobbii,gyuwon,jun", "pobi,wonni,pobi"})
    public void 유효하지_않은_차_이름_목록(String invalidCarNamesString) {
        //then
        assertThatThrownBy(() -> CarNames.create(invalidCarNamesString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
