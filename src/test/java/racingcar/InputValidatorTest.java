package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 유효한_자동차_이름() {
        assertThatCode(() -> inputValidator.validCarNameLength("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    void 차_이름_빈_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validCarNameLength(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이_초과한_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validCarNameLength("pobipobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_정상_입력() {
        assertThatCode(() -> inputValidator.validCarNameLength("6"))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자_외_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validTrialNumber("5a1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_빈_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validTrialNumber(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
