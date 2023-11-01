package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.helper.TestNumberGenerator;
import racingcar.util.NumberGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.createWith("TEST");
    }

    @CsvSource({"3, 0", "6, 1", "9, 1"})
    @ParameterizedTest
    void 자동차가_전진을_할_수_있는_경우_현재_위치를_증가시킨다(int testNumber, int expected) {
        // given
        NumberGenerator numberGenerator = new TestNumberGenerator(testNumber);

        // when
        car.move(numberGenerator);
        int position = car.getPosition();

        // then
        assertThat(position).isEqualTo(expected);
    }

    @Test
    void 자동차의_이름을_반환한다() {
        // when
        String name = car.getName();

        // then
        assertThat(name).isEqualTo("TEST");
    }

    @Test
    void 자동차의_현재_위치를_반환한다() {
        // when
        int position = car.getPosition();

        // then
        assertThat(position).isZero();
    }
}
