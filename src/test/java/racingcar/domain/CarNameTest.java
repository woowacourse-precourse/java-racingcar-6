package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    void 유효하지않은_CarName생성시_오류() {
        assertThatThrownBy(() -> new CarName("pobibi")).isInstanceOf(IllegalArgumentException.class);
    }

}