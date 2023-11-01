package testUtil;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.utils.Validator;


class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 차_이름_예외_테스트_NULL(){
        String input = "";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 차_이름_예외_테스트_정상과비정상(){
        String input = "ppp,dddddd";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 차_이름_예외_테스트_6글자(){
        String input = "pppppp";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 차_이름_예외_테스트_정상(){
        String input = "qqq,www";

        assertSimpleTest(() ->
                assertThatCode(() -> validator.validateCarNames(input)).doesNotThrowAnyException()
        );
    }
    @Test
    void 턴_예외_테스트_숫자와문자(){
        String input = "123A";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateTurns(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 턴_예외_테스트_문자만(){
        String input = "ABC";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.validateTurns(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
