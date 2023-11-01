package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest extends NsTest {

        @Test
        void carName이_문자인경우() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("pobi,won!", "1"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
        }
        @Test
        void carName에_공백이_포함된경우() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("po b,woni", "1"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
        }
        @Test
        void carName이_없는경우() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("pobi","", "1"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
        }

        @Override
        public void runMain() {
                Application.main(new String[]{});
        }
}
