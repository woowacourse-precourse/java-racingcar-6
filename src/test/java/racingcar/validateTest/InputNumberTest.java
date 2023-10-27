package racingcar.validateTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.service.UserService;

public class InputNumberTest {
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void 시도_횟수_입력() {
        String input = "7";

        int test = userService.inputTryNumber(input);

        assertThat(Integer.parseInt(input)).isEqualTo(test);
    }

    @Test
    void 유효_입력_검증_테스트() {
        String input = "q";

        assertThatThrownBy(() -> {
            int test = userService.inputTryNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
