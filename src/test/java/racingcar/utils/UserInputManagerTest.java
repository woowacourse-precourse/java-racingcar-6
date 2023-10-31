package racingcar.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserInputManagerTest extends NsTest {
    private UserInputManager userInputManager;

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        String[] result = input.split(",");

        assertThat(result).contains("woni", "pobi", "jun");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "pobi";
        String[] result = input.split(",");

        assertThat(result).contains("pobi");
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름이_5자를_초과할떄_Throw_IllegalArgumentException() {
        String input = "pobiiii, wooooni";
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(input)).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    protected void runMain() {
        userInputManager = new UserInputManager();
    }
}