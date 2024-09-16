package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class racingcarTest extends NsTest {
    private final racingcarGame racingcarGame = new racingcarGame();

    @Test
    void 숫자입력예외처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soft,hard", "e"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수예외처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soft,hard", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름나누기() {
        String input = "1,2";
        List<String> result = racingcarGame.splitNames(input);

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
