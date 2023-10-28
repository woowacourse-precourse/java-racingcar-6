package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void init() {
        racingService = new RacingService();
    }

    @Test
    void 이름_입력_검증_성공() {
        List<String> successTarget = List.of("join", "beomb");
        assertDoesNotThrow(() -> racingService.validationCarNames(successTarget));
    }

    @Test
    void 이름_입력_검증_실패_길이_초과() {
        List<String> overLengthTarget = List.of("123456");
        assertThrows(IllegalArgumentException.class, () -> racingService.validationCarNames(overLengthTarget));
    }

    @Test
    void 이름_입력_검증_실패_중복() {
        List<String> duplicationTarget = List.of("jon", "jon", "piter");
        assertThrows(IllegalArgumentException.class, () -> racingService.validationCarNames(duplicationTarget));
    }

    @Test
    void 회수_입력_검증_성공() {
        String input = "5";
        int expected = 5;

        assertThat(racingService.convertToAttemptsCount(input)).isEqualTo(expected);
    }

    @Test
    void 회수_입력_검증_실패() {
        String case1 = "  ";
        String case2 = "abc";
        String case3 = "0";
        String case4 = "-1";

        assertThrows(IllegalArgumentException.class, () -> {
            racingService.convertToAttemptsCount(case1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            racingService.convertToAttemptsCount(case2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            racingService.convertToAttemptsCount(case3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            racingService.convertToAttemptsCount(case4);
        });
    }
}
