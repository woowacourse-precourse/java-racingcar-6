package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 클래스")
class CarsTest {

    @Test
    void 이름_리스트로_Cars_생성() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"));
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차가_두대_미만이면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Cars(Arrays.asList("pobi")));
    }

}