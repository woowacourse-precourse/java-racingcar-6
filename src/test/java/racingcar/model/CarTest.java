package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.helper.OutputTest;
import racingcar.helper.SubNumberGenerator;
import racingcar.util.NumberGenerator;

class CarTest extends OutputTest {
    private NumberGenerator numberGenerator;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("name");
    }

    @ParameterizedTest()
    @CsvSource({"4,1,name : -", "1,0,name : "})
    void 랜덤_숫자에_따른_전진_혹은_멈춤(int number1, int expectedNum, String expectedString) {
        // given
        NumberGenerator numberGenerator = new SubNumberGenerator(number1);

        // when
        car.move(numberGenerator);
        car.displayProgress();

        // then
        assertThat(car.getForwardDistance()).isEqualTo(expectedNum);
        assertThat(output()).contains(expectedString);
    }

}