package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoundManagerTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RoundManager roundManager;
    private static final List<String> carNames = Arrays.asList("pobi", "woni", "jun");


    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();
        for(String name:carNames){
            cars.add(new Car(name));
        }
        roundManager = new RoundManager(cars);
    }

    @Test
    void 자동차_전진_결과_생성() {
        assertRandomNumberInRangeTest(
                () -> {
                    roundManager.roundPlay();
                    assertThat(roundManager.getRacingCars().get(0).getState()).isEqualTo("pobi : -");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_정지_결과_생성() {
        assertRandomNumberInRangeTest(
                () -> {
                    roundManager.roundPlay();
                    assertThat(roundManager.getRacingCars().get(2).getState()).isEqualTo("jun : ");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}