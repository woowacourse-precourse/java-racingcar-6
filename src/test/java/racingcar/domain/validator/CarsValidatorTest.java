package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

@SuppressWarnings("NonAsciiCharacters")
class CarsValidatorTest {
    private static final String DUPLICATED_NAME = "경주에 참가하는 자동차 이름은 중복될 수 없습니다";
    private static final String MIN_PARTICIPANTS = "경주에 참가하는 자동차는 최소 두 대 이상이어야 합니다";

    public static Stream<Arguments> 검증이_실패하면_예외가_발생한다() {
        return Stream.of(
                Arguments.of(List.of(new Car("1", 0, null), new Car("1", 0, null)), DUPLICATED_NAME),
                Arguments.of(List.of(new Car("1", 0, null)), MIN_PARTICIPANTS),
                Arguments.of(List.of(), MIN_PARTICIPANTS)
        );
    }

    @ParameterizedTest
    @MethodSource
    void 검증이_실패하면_예외가_발생한다(List<Car> cars, String message) {
        CarsValidator carsValidator = new CarsValidator();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> carsValidator.accept(cars))
                .withMessage(message);
    }
}
