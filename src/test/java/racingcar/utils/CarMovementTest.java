package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMovementTest {

    @Test
    void canMove_메서드는_4를_기준으로_대소_관계를_판별한다() {
        CarMovement carMovement = new CarMovement();
        boolean canMove = carMovement.canMove();
        assertThat(canMove).isIn(true, false);
    }
}
