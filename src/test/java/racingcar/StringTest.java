package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest extends ApplicationTest {

    @Test
    void testExceptionOverNameLength() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobiaa,woni,pobi"))
              .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test // 테스트 코드에서는 빈 문자열을 "\n" 으로 표현함.
    void testExceptionEmpty() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("\n"))
                  .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testExceptionSpace() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(" "))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testExceptionOnlyComma() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(","))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testExcetionStartAndEndWithComma() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",pobi,"))
               .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testExceptionConsecutiveCommas() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,woni"))
              .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testExcetionSpaceInNames() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, woni ,"))
             .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
