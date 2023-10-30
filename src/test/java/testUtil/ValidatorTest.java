package testUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.Test;

import racingcar.utils.Validator;


class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 차_이름_예외_테스트(){
        String input = "pppppp";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 턴_예외_테스트(){
        String input = "123A";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateTurns(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
