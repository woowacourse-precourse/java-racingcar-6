package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    RacingCars racingCars1 = new RacingCars(new String[]{"pobi","woni"});
    RacingCars racingCars2 = new RacingCars(new String[]{"pobi","woni"});
    MoveNumGenerator cannotMoveNumGenerator = new MoveNumGenerator(0, 3);
    MoveNumGenerator canMoveNumGenerator = new MoveNumGenerator(4, 9);

    @Test
    void 자동차_이동_테스트() {
        List<Result> results1 = racingCars1.moveCars(canMoveNumGenerator);
        Assertions.assertThat(results1.size()).isEqualTo(2);
        Assertions.assertThat(results1.get(0).getAdvance()).isEqualTo(1);
        Assertions.assertThat(results1.get(1).getAdvance()).isEqualTo(1);

        List<Result> results2 = racingCars2.moveCars(cannotMoveNumGenerator);
        Assertions.assertThat(results2.size()).isEqualTo(2);
        Assertions.assertThat(results2.get(0).getAdvance()).isEqualTo(0);
        Assertions.assertThat(results2.get(1).getAdvance()).isEqualTo(0);
    }

    @Test
    void 우승자_수_테스트() {
        racingCars1.moveCars(canMoveNumGenerator);
        List<Result> winners1 = racingCars1.findWinners();
        Assertions.assertThat(winners1.size()).isEqualTo(2);

        // 아무도 움직이지 못하면 모두 우승자
        racingCars2.moveCars(cannotMoveNumGenerator);
        List<Result> winners2 = racingCars2.findWinners();
        Assertions.assertThat(winners2.size()).isEqualTo(2);
    }
}