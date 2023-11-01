package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private final Validator validator = new Validator();
    private List<String> input;
    private String number;

    @Test
    void validator_이름이_5글자_이상일_시_예외_처리() {
        input = new ArrayList<>();
        input.add("aaaaaa");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validator_이름이_1글자_미만일_시_예외_처리() {
        input = new ArrayList<>();
        input.add("");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validator_이름_입력값에_공백이_포함될_시_예외_처리() {
        input = new ArrayList<>();
        input.add(" one");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validator_이름이_중복으로_입력될_시_예외_처리() {
        input = new ArrayList<>();
        input.add("one");
        input.add("one");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkCarName(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validator_시행_횟수_입력값이_정수형이_아닐_경우_예외_처리() {
        number = "abc";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkVaildNum(number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validator_시행_횟수_입력값이_0일_경우_예외_처리() {
        number = "0";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkVaildNum(number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validator_시행_횟수_입력값이_음수일_경우_예외_처리() {
        number = "-1";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkVaildNum(number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
