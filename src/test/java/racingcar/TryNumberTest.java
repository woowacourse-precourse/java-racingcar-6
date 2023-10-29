package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import racingcar.model.TryNumber;

public class TryNumberTest {
    @Test
    void 시도횟수_1보다_작을_때_예외_처리() {
        assertThatThrownBy(() -> {
            TryNumber tryNumber = new TryNumber("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_음수일_때_예외_처리() {
        assertThatThrownBy(() -> {
            TryNumber tryNumber = new TryNumber("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_소수일_때_예외_처리() {
        assertThatThrownBy(() -> {
            TryNumber tryNumber = new TryNumber("1.2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_시도횟수_보다_경주안했을_때_확인() {
        TryNumber tryNumber = new TryNumber("3");
        assertFalse(tryNumber.isOver(1));
    }

    @Test
    void 입력_시도횟수만큼_경주했을_때_확인() {
        TryNumber tryNumber = new TryNumber("3");
        assertTrue(tryNumber.isOver(3));
    }

}
