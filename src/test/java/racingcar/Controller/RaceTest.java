package racingcar.Controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.Model.RandomModel.checkRandomNumber;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void runTest(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    Assertions.assertThat(output()).contains("pobi : -", "woni : ");
                },
                    MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain(){
        new Race();
    }
}

