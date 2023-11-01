package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.NumberGenerator;
import racingcar.util.SubNumberGenerator;

class CarTest {
    private NumberGenerator numberGenerator;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("name");
    }

    @ParameterizedTest()
    @CsvSource({"4,1", "9,1", "1,0", "0,0"})
    void 랜덤_숫자에_따른_전진_혹은_멈춤(int number1, int expectedNum) {
        // given
        NumberGenerator numberGenerator = new SubNumberGenerator(number1);

        // when
        car.move(numberGenerator);

        // then
        assertThat(car.getForwardDistance()).isEqualTo(expectedNum);
    }

}