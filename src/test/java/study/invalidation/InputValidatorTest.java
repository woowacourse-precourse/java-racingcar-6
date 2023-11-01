package study.invalidation;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validation.InputValidator;

class InputValidatorTest {

    private InputValidator inputValidator;
    private final Integer NAME_LIMIT_LENGTH = 5;

    @BeforeEach
    void setUp(){
        inputValidator = new InputValidator();
    }

    @Test
    void 입력_예외_처리_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateNumber("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_예외_처리_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateNumber("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_예외_처리_자동차_이름_중복(){
        List<String> carNames = Arrays.asList("song", "song", "bana");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateDuplicate(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_예외_처리_자동차_이름_빈칸(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateBlank(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_예외_처리_자동차_이름_5자이상(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.validateLength("abcdef",NAME_LIMIT_LENGTH))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}