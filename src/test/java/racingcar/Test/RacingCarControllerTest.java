package racingcar.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.movement.RacingCarController;
import racingcar.service.movement.RacingCarController.MovementStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarControllerTest {

    private RacingCarController racingCarController;

    private MovementStrategy alwaysMoveStrategy = () -> true;
    private MovementStrategy neverMoveStrategy = () -> false;

    @BeforeEach
    void setUp() {
        racingCarController = new RacingCarController(alwaysMoveStrategy);
    }

    @Test
    @DisplayName("랜덤 수가 4이상일 경우, 차들이 움직임")
    void 랜덤수가_4이상일_경우() {
        int[] countsByName = new int[]{0, 0, 0};
        racingCarController.moveCars(countsByName);
        assertThat(countsByName).isEqualTo(new int[]{1, 1, 1});
    }

    @Test
    @DisplayName("랜덤 수가 4미만인 경우, 차들이 멈춤")
    void 랜덤수가_4미만인_경우() {
        int[] countsByName = new int[]{0, 0, 0};
        racingCarController = new RacingCarController(neverMoveStrategy);
        racingCarController.moveCars(countsByName);
        assertThat(countsByName).isEqualTo(new int[]{0, 0, 0});
    }
}
