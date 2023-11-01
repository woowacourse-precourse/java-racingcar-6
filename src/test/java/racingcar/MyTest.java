package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest extends NsTest{
    @Test
    void 두가지_이상의_승리자_출력(){/*
        assertRandomNumberInRangeTest(
                ()->{
                    run()

                },
                1,
        );*/
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
