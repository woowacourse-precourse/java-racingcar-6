package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    RacingCars racingCars;

    @BeforeEach
    void before() {
        List<String> names = new ArrayList<>();

        names.add("abc");
        names.add("def");

        racingCars = RacingCars.createRacingCars(names);
    }

    @Test
    @DisplayName("자동차 생성 확인")
    void createRacingCarsTest() {
        assertThat(racingCars.getResults()).containsExactly("abc : ", "def : ");
    }

    @Test
    @DisplayName("자동차 이동 결과 확인")
    void tryMoveCarsTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.tryMoveCars();
                    assertThat(racingCars.getResults()).containsExactly("abc : -", "def : ");
                    assertThat(racingCars.getWinners()).containsOnly("abc");

                    racingCars.tryMoveCars();
                    assertThat(racingCars.getResults()).containsExactly("abc : -", "def : -");
                    assertThat(racingCars.getWinners()).containsExactly("abc", "def");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 이동 결과 확인 2")
    void tryMoveCarsTest2() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingCars.tryMoveCars();
                    assertThat(racingCars.getResults()).containsExactly("abc : -", "def : -");
                    assertThat(racingCars.getWinners()).containsExactly("abc", "def");

                    racingCars.tryMoveCars();
                    assertThat(racingCars.getResults()).containsExactly("abc : -", "def : --");
                    assertThat(racingCars.getWinners()).containsOnly("def");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
    }
}
