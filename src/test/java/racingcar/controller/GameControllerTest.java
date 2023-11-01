package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.CarNames;

public class GameControllerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 입력받은_값만큼_이동을_수행한다() {
        //given
        String moveCountInput = "3";
        CarNames carNames = CarNames.fromInput("name1,name2,name3");
        //when
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    run("name1,name2,name3", moveCountInput);
                    assertThat(output()).contains("name1 : ---");
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
