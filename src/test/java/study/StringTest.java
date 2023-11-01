package study;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class StringTest extends NsTest {
    private static final String USER_A = "pobi";
    private static final String USER_B = "hun";

    @Test
    void split_자동차_이름_입력받기_null_값_예외확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void split_자동차_이름_입력받기_공백값_예외확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void split_주행_횟수_문자입력_예외확인(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun","열번시도"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
