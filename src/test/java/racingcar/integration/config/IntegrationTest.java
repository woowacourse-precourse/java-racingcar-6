package racingcar.integration.config;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;

public abstract class IntegrationTest extends NsTest {
    protected static final int MOVING_FORWARD = 4;
    protected static final int STOP = 3;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
