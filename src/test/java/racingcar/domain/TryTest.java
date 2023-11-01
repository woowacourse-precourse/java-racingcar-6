package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Try 클래스")
class TryTest {

    private Try tryCount;

    @BeforeEach
    void setup() {
        tryCount = new Try(5);
    }

    @Test
    void 자연수로_시도_횟수를_생성() {
        assertThat(tryCount.getCount()).isEqualTo(5);
    }

    @Test
    void 레이스_진행_시_시도_횟수가_1_감소() {
        tryCount.tryRace();
        assertThat(tryCount.getCount()).isEqualTo(4);
    }

    @Test
    void 시도_횟수가_0이면_레이스_종료() {
        Try tryCount = new Try(1);
        tryCount.tryRace();
        assertThat(tryCount.isRaceOver()).isEqualTo(true);
    }

    @Test
    void 처음_시도_횟수가_1_미만이면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Try(0));
    }
}