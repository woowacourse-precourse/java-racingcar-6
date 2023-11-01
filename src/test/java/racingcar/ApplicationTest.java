package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void split_메서드_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        String[] result = input.split(",");

        assertThat(result).contains("jun", "woni", "pobi");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "pobi";
        String[] result = input.split(",");

        assertThat(result).contains("pobi");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "pobi,jun";
        String result = input.substring(0, 8);
        String resultTwo = input.substring(0, 4);
        String resultThree = input.substring(5,8);

        assertThat(result).isEqualTo("pobi,jun");
        assertThat(resultTwo).isEqualTo("pobi");
        assertThat(resultThree).isEqualTo("jun");

    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "pobi";
        char charAtElement = input.charAt(2);
        assertThat(charAtElement).isEqualTo('b');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "pobi";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
