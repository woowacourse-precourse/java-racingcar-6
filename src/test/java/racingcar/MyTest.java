package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest extends NsTest {
    @Test
    @DisplayName("라운드가 0이하의 입력일때의 예외처리 테스트")
    public void 라운드_음수입력_예외확인_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "-10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("라운드 문자 입력 예외 처리 테스트")
    public void 라운드_문자입력_예외확인_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "4applemango"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,Judy,Popo", "3test!!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
