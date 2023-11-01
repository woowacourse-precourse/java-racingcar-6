package service;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class InteractServiceTest extends NsTest {

    @DisplayName("중복된 이름이 들어올 경우")
    @Test
    public void Name_Dup() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이름에 공백이 들어올 경우")
    @Test
    public void Name_Blank() {
        // when & given
        List<String> inputs = List.of(
                " pobi", " ", "\n"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input, "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("시도할 회수에 양의 정수가 아닌 다른 값이 들어오는 경우")
    @Test
    public void Invalid_TryNum() {
        // when & given
        List<String> inputs = List.of(
                "0", "-4", "-1", "문자", "@@", " ", "\n"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,wooni,kim", input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
