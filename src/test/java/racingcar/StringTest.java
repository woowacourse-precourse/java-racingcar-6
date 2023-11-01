package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest extends ApplicationTest {

    @Test
    void TestExceptionOverNameLength() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobiaa,woni,pobi"))
              .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test // 테스트 코드에서는 빈 문자열을 "\n" 으로 표현함.
    void TestExceptionEmpty() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("\n"))
                  .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExceptionOnlySpace() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(" "))
                 .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExceptionOnlyComma() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(","))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExcetionStartAndEndWithComma() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",pobi,"))
               .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExceptionConsecutiveCommas() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,woni"))
              .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void TestExcetionNameStartAndEndWithSpace() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, woni ,"))
             .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
