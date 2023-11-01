package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;
    private int beforeMove;
    private int afterMove;

    @BeforeEach
    void setUp() {
        car = new Car("pobi", 0);
        beforeMove = car.getPosition();
    }

    @Test
    void moveForward_메서드에_4_이상의_정수를_넣으면_자동차의_위치값이_1_증가() {
        car.moveForward(4);
        afterMove = car.getPosition();

        assertThat(afterMove).isEqualTo(beforeMove + 1);
    }

    @Test
    void moveForward_메서드에_4_미만의_정수를_넣으면_자동차의_위치값에_변화없음() {
        car.moveForward(3);
        afterMove = car.getPosition();

        assertThat(afterMove).isEqualTo(beforeMove);
    }
}
