package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest extends NsTest {
    @Test
    void 회수가_숫자_아님_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,lkh,be", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_공백_예외처리() {
        List<String> names = Arrays.asList(" ", "happy", "123");
        List<String> emptyName = Arrays.asList(" ");

        assertThat(!Application.isNotEmpty(names));
        assertThat(!Application.isNotEmpty(emptyName));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
