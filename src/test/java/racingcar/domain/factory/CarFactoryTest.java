package racingcar.domain.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.RandomMoveEngine;
import racingcar.domain.validator.CarNameValidator;

@SuppressWarnings("NonAsciiCharacters")
class CarFactoryTest {
    private static final CarFactory carFactory = new CarFactory(new RandomMoveEngine(), new CarNameValidator());

    @ParameterizedTest
    @CsvSource(textBlock = """
            a,
            12345
            """)
    void 유효한_이름이면_정상_생성(String validName) {
        Car car = carFactory.create(validName);

        assertThat(car.getName()).isEqualTo(validName);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            '',
            ' ',
            '1 ',
            ' 1',
            123456
            """)
    void 이름이_유효하지_않으면_예외가_발생한다(String invalidName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carFactory.create(invalidName));
    }
}
