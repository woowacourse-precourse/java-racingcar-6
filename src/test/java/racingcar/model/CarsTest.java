package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarsTest extends NsTest {
    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 라운드_결과_출력_형식_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars("A,B,C");
                    cars.decideToMove();
                    assertThat(cars.generateRoundResultString()).contains("A : -", "B : ", "C : -");
                },
                MOVE_FORWARD, STOP, MOVE_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
