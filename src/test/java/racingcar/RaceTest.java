package racingcar;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class RaceTest extends NsTest{

    @Test
    void 이름에_대한_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,bear", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
