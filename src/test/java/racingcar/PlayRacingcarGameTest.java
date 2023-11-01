package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayRacingcarGameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void movingforward_or_stop() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -- ", "woni : - ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
        );
    }

    /* 자동차 이름 입력 테스트 */
    @Test
    void namingTest_fail_less_than_5_length_limit_of_characters() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, javaji", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void namingTest_fail_no_name() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void namingTest_fail_empty_name() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   ", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /* 시도 횟수 입력 테스트 */
    @Test
    void inputnumberTest_fail_no_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, java", "  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputnumberTest_fail_wrong_number() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, java", "!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, java", "5회"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }







    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
