package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    Cars cars;
    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.add("pobi");
        cars.add("woni");
    }

    @Test
    void 랜덤_값에_따른_레이싱_결과_전진_멈춤() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    cars.printRoundRacingResult();
                    assertThat(output()).contains("pobi : -\nwoni :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 레이싱_최종_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    ArrayList<String> result = cars.getFinalWinners();
                    assertThat(result).containsOnly("pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 레이싱_최종_우승자_중복() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    ArrayList<String> result = cars.getFinalWinners();
                    assertThat(result).contains("pobi","woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        cars.racing();
    }

}
