package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TryNumberTest {

    @Test
    void 유효하지않은_TryNumber생성시_오류() {
        assertThatThrownBy(() -> new TryNumber(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값객체는_동등성을_지님() {
        TryNumber tryNumber = new TryNumber(1);
        assertThat(tryNumber).isEqualTo(new TryNumber(1));
    }
}