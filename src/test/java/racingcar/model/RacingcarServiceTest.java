package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.Application;

import java.util.ArrayList;
import java.util.List;

class RacingcarServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void getAdvance_test() {
        RacingcarService racingcarService = new RacingcarService();

        Advance advance = racingcarService.getAdvance();
        boolean isAdvance = advance.getIsAdvance();
        int advanceCount = advance.getAdvanceCount();

        if (advanceCount < 4) {
            assertFalse(isAdvance);
        } else {
            assertTrue(isAdvance);
        }
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}