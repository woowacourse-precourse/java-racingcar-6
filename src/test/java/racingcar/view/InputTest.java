package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class InputTest extends NsTest {

    @Test
    void 콤마로_구분된_문자열_입력_확인() {
        assertSimpleTest(
                () -> {
                    run("pobi,woni");
                    assertThat(output()).contains("pobi, woni");
                }
        );
    }

    @Test
    void 빈_문자열_입력_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,java"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_문자열_입력_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,java"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        InputView inputView = new InputView();
        List<String> list = inputView.inputStringSplitByComma();
        System.out.println(list);
    }

}
