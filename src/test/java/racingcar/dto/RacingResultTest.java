package racingcar.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;

class RacingResultTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 전진횟수만큼_position_길이가_증가한다(int movedCount) {
        // given
        Car car = new Car("test");
        IntStream.range(0, movedCount)
                .forEach(i -> car.move());
        RacingResult racingResult = RacingResult.from(car);

        // when
        int actual = racingResult.position().length();

        // then
        assertThat(actual).isEqualTo(movedCount);
    }
}