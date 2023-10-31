package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    private final int MOVING_DISTANCE = 1;

    private MovePolicy movePolicy;

    @ParameterizedTest
    @CsvSource(value = {"true,1","false,0"})
    void 자동차는_정해진_정책에_부합해야_움직인다(boolean returnIsMoveable,int result) {
        movePolicy = () -> returnIsMoveable;
        Car car = new Car("테스트");
        int currentPosition = car.getPosition();

        car.move(MOVING_DISTANCE, movePolicy);

        assertThat(car.getPosition() - currentPosition).isEqualTo(result);
    }
}