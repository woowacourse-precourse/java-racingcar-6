package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.InputValidator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    private static final int MAX_CAR_NAME_SIZE = 5;
    private static final int MIN_ATTEMPTS_COUNT = 1;

    private InputValidator inputValidator;

    @BeforeEach
    void init() {
        inputValidator = new InputValidator();
    }

    @Test
    void 이름_입력_검증_성공() {
        List<String> successTarget = List.of("join", "beomb");
        assertDoesNotThrow(() -> inputValidator.validateNameLength(successTarget, MAX_CAR_NAME_SIZE));
    }

    @Test
    void 이름_입력_검증_실패_길이_초과() {
        List<String> overLengthTarget = List.of("123456");
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateNameLength(overLengthTarget, MAX_CAR_NAME_SIZE));
    }

    @Test
    void 이름_입력_검증_실패_중복() {
        List<String> duplicationTarget = List.of("jon", "jon", "piter");
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateNoDuplicates(duplicationTarget));
    }

    @Test
    void 회수_입력_검증_성공() {
        String input = "5";
        int expected = 5;

        assertThat(inputValidator.parseInputToInt(input)).isEqualTo(expected);
    }

    @Test
    void 회수_입력_검증_실패_잘못된_형색() {
        String case1 = "  ";
        String case2 = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.parseInputToInt(case1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.parseInputToInt(case2);
        });
    }

    @Test
    void 회수_입력_검증_실패_최소값_미만() {
        int case1 = 0;
        int case2 = -1;

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateMinCount(case1, MIN_ATTEMPTS_COUNT);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateMinCount(case2, MIN_ATTEMPTS_COUNT);
        });
    }
}
