package racingcar.dto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 전진횟수만큼_position_길이가_증가한다(int movedCount) {
        // given
        Car car = new Car("test");
        IntStream.range(0, movedCount)
                .forEach(i -> car.move());

        // when
        RacingResult racingResult = RacingResult.from(car);

        // then
        int actual = racingResult.position().length();
        assertThat(actual).isEqualTo(movedCount);
    }
}