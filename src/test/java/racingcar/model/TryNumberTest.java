package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TryNumberTest {

    @Test
    public void 입력_받은_시도_횟수가_숫자가_아닌_경우_예외() {
        String input = "a";
        assertThrows(IllegalArgumentException.class, () -> {
            new TryNumber(input);
        });
    }

    @Test
    public void 입력_받은_시도_횟수가_1이하_경우_예외() {
        String input = "0";
        assertThrows(IllegalArgumentException.class, () -> {
            new TryNumber(input);
        });

    }

    @Test
    public void 시도_횟수에_1이상의_숫자를_입력한_경우() {
        String input = "2";

        TryNumber result = new TryNumber(input);

        assertThat(result.getTryNumber()).isEqualTo(2);
    }
}