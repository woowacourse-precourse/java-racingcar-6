package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest extends NsTest {

    @Test
    void 입력한_자동차_이름에_스페이스가_존재할때_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,j un", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
