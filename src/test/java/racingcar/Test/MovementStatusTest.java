package racingcar.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.movement.MovementStatus;
import racingcar.service.movement.RacingCarController.MovementStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementStatusTest {

    private MovementStatus movementStatus;

    private MovementStrategy alwaysMoveStrategy = () -> true;
    private MovementStrategy neverMoveStrategy = () -> false;

    @BeforeEach
    void setUp() {
        // 초기 설정은 항상 움직임
        movementStatus = new MovementStatus(alwaysMoveStrategy);
    }

    @Test
    @DisplayName("차들이 주어진 횟수 모두 4이상의 수가 나왔을 때(=alwaysMoveStrategy) 움직인다.")
    void 차들이_주어진_횟수만큼_움직일_때() {
        String[] names = {"car1", "car2", "car3"};
        int count = 2;
        int[] result = movementStatus.race(names, count);
        assertThat(result).isEqualTo(new int[]{2, 2, 2});
    }

    @Test
    @DisplayName("차들이 주어진 횟수 모두 4미만 수가 나왔을 때(=neverMoveStrategy) 움직이지 않는다.")
    void 차들이_주어진_횟수만큼_움직이지_않을_때() {
        movementStatus = new MovementStatus(neverMoveStrategy);
        String[] names = {"car1", "car2", "car3"};
        int count = 2;
        int[] result = movementStatus.race(names, count);
        assertThat(result).isEqualTo(new int[]{0, 0, 0});
    }
}
