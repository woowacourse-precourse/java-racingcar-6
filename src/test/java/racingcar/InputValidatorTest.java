package racingcar;

import java.util.List;
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
        assertThatCode(() -> inputValidator.validCarNames(List.of("pobi")))
                .doesNotThrowAnyException();
    }

    @Test
    void 차_이름_빈_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validCarNames(List.of("")))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이_초과한_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validCarNames(List.of("pobipobi")))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validCarNames(List.of("ppaa", "papa", "ppaa")))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_정상_입력() {
        assertThatCode(() -> inputValidator.validTrialNumber("6"))
                .doesNotThrowAnyException();
    }

    @Test
    void 음수_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputValidator.validTrialNumber("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
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
