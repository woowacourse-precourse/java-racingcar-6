package racingcar;

import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckTest {

    @Test
    void 자동차_이름_글자수_예외_테스트() {
        final String input = "mist, perfume";
        final Check testCheck = new Check();

        assertThatThrownBy(() -> testCheck.checkNameSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하만 가능합니다.");
    }

    @Test
    void 입력_숫자_확인_예외_테스트() {
        final String input = "five";
        final Check testCheck = new Check();

        assertThatThrownBy(() -> testCheck.checkNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해야 합니다.");
    }

}
