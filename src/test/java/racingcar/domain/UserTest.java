package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.User.ATTEMPTS_INT_ERROR_MESSAGE;
import static racingcar.domain.User.ATTEMPTS_NEGATIVE_ERROR_MESSAGE;
import static racingcar.domain.User.CAR_NAME_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {
    private User user;
    private InputStream originalSystemIn;
    @BeforeEach
    void setUp() {
        user = new User();
    }

    @AfterEach
    void restoreSystemIn() {
        Console.close();
    }

    void setInInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void 자동차_이름_입력() {
        final String input = "pobi,woni,jun";
        setInInputStream(input);

        String actual = user.inputCarsName();

        assertThat(actual).isEqualTo(input);
    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        final String input = "pobi,woni,jun";

        user.splitCarsName(input);

        assertThat(user.getCarsNameArray()).contains("pobi", "woni", "jun");
    }

    @Test
    void 예외_자동차_이름_글자수_초과() {
        final String input = "pobi,woni,goodjun";

        user.splitCarsName(input);

        assertThatThrownBy(() -> user.checkCarNameUnderFive())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    void 시행_횟수_입력() {
        final String input = "4";
        setInInputStream(input);

        assertThat(user.inputAttempts()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "abc", "김상혁", "0.1", "123+"})
    void 예외_시행_횟수_정수가_아닌_경우(String input) {
        assertThatThrownBy(() -> user.checkAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPTS_INT_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", "-39"})
    void 예외_시행_횟수_음수인_경우(String input) {
        assertThatThrownBy(() -> user.checkAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPTS_NEGATIVE_ERROR_MESSAGE);
    }
}