package model;

import static org.assertj.core.api.Assertions.assertThat;

import helper.TestNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.util.NumberGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.createWith(new CarName("TEST"));
    }

    @CsvSource({"3, false", "6, true", "9, true"})
    @ParameterizedTest
    void 전진을_할_수_있으면_true_없으면_false를_반환한다(int testNumber, boolean expected) {
        // given
        NumberGenerator numberGenerator = new TestNumberGenerator(testNumber);

        // when
        boolean result = car.canMove(numberGenerator);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
