package racingcar.unit;

import camp.nextstep.edu.missionutils.test.NsTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.controller.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest extends NsTest {
    @Test
    void inputCarValidateThrowTest() {
        List<String> list = new ArrayList<>();
        list.add("appleBack");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateInputCarList(list);
        });
    }

    @Test
    void inputAttemptValidateThrowTest() {
        String[] attempt = {"!", "ㄱ", "1ㄱ", "2s"};
        for (String s : attempt) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateInputAttemptNum(s);
            });
        }
    }

    @Test
    void inputAttemptValidateTest() {
        String[] attempt = {"1", "12", "123", "342532"};
        int[] attempt2 = {1, 12, 123, 342532};
        for (int i = 0; i < attempt.length; i++) {
            assertThat(attempt2[i]).isEqualTo(Validator.validateInputAttemptNum(attempt[i]));
        }
    }

    @Test
    void canMoveTest() {
        String[] attempt = {"!", "ㄱ", "1ㄱ", "2s"};
        for (String s : attempt) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateInputAttemptNum(s);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
