package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Try 클래스")
class TryTest {

    @Test
    void 자연수로_시도_횟수를_생성(){
        Try tri = new Try(5);
        assertThat(tri.getCount()).isEqualTo(5);
    }
}