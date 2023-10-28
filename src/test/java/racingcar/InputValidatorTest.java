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
    void 빈_이름_예외_처리() {
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
}
