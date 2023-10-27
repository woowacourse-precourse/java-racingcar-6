package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    private final String name = "벤츠";

    @Test
    void moveSuccess() {
        final int moveNumber = 5;
        final int notMoveNumber = 2;

        final Car benz = Car.from(name);
        final Car movedBenz = benz.move(moveNumber);
        final Car notMovedBenz = benz.move(notMoveNumber);

        final int movedBenzProgress = 1;
        final int notMovedBenzProgress = 0;

        assertAll(
            () -> assertThat(movedBenz.getProgress()).isEqualTo(movedBenzProgress),
            () -> assertThat(benz.getProgress()).isEqualTo(notMovedBenzProgress),
            () -> assertThat(notMovedBenz.getProgress()).isEqualTo(notMovedBenzProgress),
            () -> assertThat(benz).isNotSameAs(movedBenz),
            () -> assertThat(benz).isNotSameAs(notMovedBenz)
        );


    }
    @Test
    void moveFail() {
        Car benz = Car.from(name);

        final int negativeNumber = -1;
        final int overRangeNumber = 10;

        assertAll(
            () -> assertThatIllegalArgumentException().isThrownBy(() -> benz.move(negativeNumber)),
            () -> assertThatIllegalArgumentException().isThrownBy(() -> benz.move(overRangeNumber))
        );
    }
}