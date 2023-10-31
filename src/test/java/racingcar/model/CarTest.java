package racingcar.model;

import static racingcar.constant.Constant.RULE_CAR_MOVE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final int RANDOM_UNDER = 4;
    private static final int RANDOM_OVER = 6;

    @ParameterizedTest
    @ValueSource(ints = {RANDOM_UNDER, RANDOM_OVER})
    @DisplayName("position_증가_테스트")
    void move(int intArg) {
        Car car = new Car("pobi");
        int result = 0;

        car.move(intArg);
        if (intArg >= RULE_CAR_MOVE) {
            result = 1;
        }

        Assertions.assertThat(car.getPosition()).isEqualTo(result);
    }
}