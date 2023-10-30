package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputTest extends NsTest {
    @Test
    void 이름_길이에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_문자형에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,car11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_쉼표_구분자에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi/java/sujin"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_중복되는_경우_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java,java,sujin"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 참가자가_한명인_경기에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sujin"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가_0인_경우_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sujin,java,pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수에_숫자로_입력하지않은_경우_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sujin,java,pobi", "two"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
