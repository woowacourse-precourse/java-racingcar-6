package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.fixture.CarFixture;
import racingcar.helper.StubNumberGenerator;
import racingcar.util.NumberGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = CarFixture.createCar("suv");
    }

    @CsvSource({"4, 1", "5, 1", "9, 1"})
    @ParameterizedTest
    void 랜덤값으로_생성된_값이_4이상이면_위치가_변한다(int number, int expectedPosition) {
        // given
        NumberGenerator numberGenerator = new StubNumberGenerator(number);

        // when
        car.move(numberGenerator);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @CsvSource({"0, 0", "3, 0", "1, 0"})
    @ParameterizedTest
    void 랜덤값으로_생성된_값이_4미만이면_위치가_그대로이다(int number, int expectedPosition) {
        // given
        NumberGenerator numberGenerator = new StubNumberGenerator(number);

        // when
        car.move(numberGenerator);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
