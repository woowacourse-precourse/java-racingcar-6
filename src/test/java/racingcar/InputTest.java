package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputTest {
    InputValidator validator = new InputValidator();

    @Test
    void 자동차_이름_정상_입력() {
        assertThatCode(() -> {
            new Cars("pobi,woni,jun");
        }).doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_5자리_이상() {
        assertThatThrownBy(() -> {
            new Cars("pobi,woni,junnnn");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_자동차_이름을_입력하지_않았을_때() {
        assertThatThrownBy(() -> {
            new Cars("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차수_정상_입력() {
        assertThatCode(() -> {
            String input = "5";
            validator.roundNonInputValidate(input);
            validator.roundRegExValidate(input);
        }).doesNotThrowAnyException();
    }

    @Test
    void 차수를_입력하지_않았을_때() {
        assertThatThrownBy(() -> {
            validator.roundNonInputValidate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차수를_입력시_숫자가_아닌_다른_문자를_입력했을_때() {
        assertThatThrownBy(() -> {
            validator.roundRegExValidate("abc");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
