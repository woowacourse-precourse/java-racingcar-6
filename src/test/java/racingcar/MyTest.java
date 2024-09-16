package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyTest extends NsTest {
    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void parseInt_string으로_입력받은_값_int로_변환() {
        String inputStr = "1";
        int result = Integer.parseInt(inputStr);

        assertEquals(result, 1);
    }

    @Test
    void 이름_글자수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_공백에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_0보다_크지_않을_때에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,test", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_숫자가_아닐_때에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,test", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    public void runMain() {
        Application.main(new String[]{});
    }
}
