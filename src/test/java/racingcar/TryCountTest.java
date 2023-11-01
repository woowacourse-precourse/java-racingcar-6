package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class TryCountTest extends NsTest {

        @Test
        void 시도횟수가_숫자가_아닌_경우_예외_처리() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("pobi,woni", "a"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
        }
        @Override
        public void runMain() {
                Application.main(new String[]{});
        }
}
