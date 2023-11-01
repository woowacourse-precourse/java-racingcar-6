package racingcar.util;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 자동차이름_1글자_미만_입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.carNamesInput("a,b, ,c"))
                        .isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.carNamesInput("a,b,,c"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_5글자_초과_입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.carNamesInput("abcdef,g"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
    
    @Test
    void 자동차이름_중복_입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.carNamesInput("a,a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이동횟수_0_입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.tryCountInput("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
