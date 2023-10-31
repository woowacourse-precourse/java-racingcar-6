package classTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.utils.Validator;


public class ValidatorTest {
    private final Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"1", "hanmin", "ek j", "", "  ", "@"})
    void input_자동차_이름_유효성_검사_예외_처리(String carName) {
        assertThatThrownBy(() -> validator.checkCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"jiyun", "", "0", "-1", "+1"})
    void input_반복_횟수_유효성_검사_예외_처리(String repeatNumber) {
        assertThatThrownBy(() -> validator.checkRepeatNumber(repeatNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("carsNameProvider")
    void 동일_이름_자동차_예외_처리(List<String> carsName) {
        assertThatThrownBy(() -> validator.checkDuplicateName(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> carsNameProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("jiyun", "hoho", "jiyun")),
                Arguments.of(Arrays.asList("a", "hoho", "hoho"))
        );
    }

}
