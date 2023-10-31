package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {
    private static final int MOVE = 1;
    private static final int STOP = 0;

    @Test
    void 자동차_이름_5자_초과_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("abcdef"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void _4_이상이면_전진(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("car");
                    MoveStrategy moveStrategy = new RandomMoveStrategy();

                    car.move(moveStrategy);

                    assertThat(car.getPosition()).isEqualTo(MOVE);
                },
                randomNumber
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void _4_미만이면_멈춤(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("car");
                    MoveStrategy moveStrategy = new RandomMoveStrategy();

                    car.move(moveStrategy);

                    assertThat(car.getPosition()).isEqualTo(STOP);
                },
                randomNumber
        );
    }
}
