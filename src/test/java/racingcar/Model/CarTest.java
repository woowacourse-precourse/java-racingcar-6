package racingcar.Model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.Application;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    public void 자동차_이동_테스트()  {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("test", "1");
                    assertThat(output()).contains("test : -");
                },
                MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}