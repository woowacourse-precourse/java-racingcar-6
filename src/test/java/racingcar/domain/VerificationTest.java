package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class VerificationTest {

    private Verification verification;

    @BeforeEach
    void setUp() {
        verification = new Verification();
    }

    @Test
    void isFiveOrLess_입력값이_5자를_이하이면_true_반환() {
        String input = "less";
        boolean result = verification.isFiveOrLess(input);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void isFiveOrLess_입력값이_5자를_초과하면_false_반환() {
        String input = "overFive";
        boolean result = verification.isFiveOrLess(input);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void isPositive_입력값이_음수이면_예외_발생() {
        int input = -1;
        assertThatThrownBy(() -> verification.isPositive(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isPositive_입력값이_0이면_예외_발생() {
        int input = 0;
        assertThatThrownBy(() -> verification.isPositive(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void duplicate_중복되는_이름이_있으면_예외_발생() {
        List<String> cars = Arrays.asList("andy", "pobi", "woni", "hoya", "pobi");
        assertThatThrownBy(() -> verification.duplicate(cars))
                .isInstanceOf(IllegalArgumentException.class);

    }

}