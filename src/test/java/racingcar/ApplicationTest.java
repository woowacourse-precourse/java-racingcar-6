package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCars;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("Car1", "Car2", "Car3");
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 점수_4이상일때_자동차이동() {
        RacingCars mockRacingCars = mock(RacingCars.class);
        when(mockRacingCars.CreateRandomNum()).thenReturn(RacingCars.PICK_NUMBER_CONDITIONS - 1);

        mockRacingCars.MoveCars();

        for (Car car : mockRacingCars.GetRacingCars()) {
            assertEquals(0, car.GetPosition());
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
