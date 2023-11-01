package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

class CarsTest {

    @ParameterizedTest
    @MethodSource("provideForCarNamesIsDuplicate")
    @DisplayName("자동차 이름 중복일 경우 예외 처리 테스트")
    void carNamesIsDuplicatedErrorTest(final List<String> names) {
        final String message = ErrorMessages.CAR_NAME_IS_DUPLICATED.getMessage();
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(InvalidArgumentException.class)
                .hasMessageContaining(message);
    }

    static Stream<Arguments> provideForCarNamesIsDuplicate() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun", "pobi")),
                Arguments.of(Arrays.asList("pobi", "woni", "jun", "woni")),
                Arguments.of(Arrays.asList("pobi", "woni", "jun", "jun")),
                Arguments.of(Arrays.asList("pobi", "woni", "jun", "jun", "jun", "jun"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForCarsObjectCreationTest")
    @DisplayName("자동차 리스트 객체 생성 테스트")
    void carsObjectCreationTest(final List<String> names) {
        assertDoesNotThrow(() -> new Cars(names));
    }

    static Stream<Arguments> provideForCarsObjectCreationTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun")),
                Arguments.of(Arrays.asList("pobi", "i", "j n")),
                Arguments.of(Arrays.asList("pob+i", "woni1", "jun", "hugh")),
                Arguments.of(Arrays.asList("po-bi", "won!i", "1234", "j2un"))
        );
    }
}
