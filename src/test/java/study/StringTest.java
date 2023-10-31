package study;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class StringTest extends NsTest {

    @Test
    void split_자동차_이름_입력받기_null_값_예외확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
