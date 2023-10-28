package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Racer;
import racingcar.model.Round;
import racingcar.model.car.Car;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorFactoryTest {

    @DisplayName("클래스에 맞는 검증기 가져오는지 테스트")
    @ParameterizedTest(name = "{index} {0}, {1}")
    @MethodSource("checkValidatorParametersProvider")
    void checkValidatorFactory(Class<?> clazz, Validator validator) {
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        assertThat(validatorFactory.getValidator(clazz)).isInstanceOf(validator.getClass());
    }

    static Stream<Arguments> checkValidatorParametersProvider() {
        return Stream.of(
                Arguments.arguments(Car.class, new CarValidator()),
                Arguments.arguments(Racer.class, new RacerValidator()),
                Arguments.arguments(Round.class, new RoundValidator())
        );
    }
}