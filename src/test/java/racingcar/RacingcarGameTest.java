package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingcarGame;

public class RacingcarGameTest {

    @DisplayName("무작위 값이 4이상일 때 이동 횟수가 1 증가한다.")
    @Test
    void 이동_횟수_증가_테스트() {
        // given
        final int MOVE_FORWARD_COUNT_ZERO = 0;
        final int MOVE_FORWARD_COUNT_ONE = 1;
        final int RANDOM_NUMBER_THREE = 3;
        final int RANDOM_NUMBER_FOUR = 4;

        int case1 = RANDOM_NUMBER_THREE;
        int case2 = RANDOM_NUMBER_FOUR;
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        RacingcarGame racingcarGame = new RacingcarGame();

        // when
        racingcarGame.increaseMoveForwardCount(testCar1, case1);
        racingcarGame.increaseMoveForwardCount(testCar2, case2);

        // then
        assertThat(testCar1.getMoveForwardCount()).isEqualTo(MOVE_FORWARD_COUNT_ZERO);
        assertThat(testCar2.getMoveForwardCount()).isEqualTo(MOVE_FORWARD_COUNT_ONE);
    }
}
