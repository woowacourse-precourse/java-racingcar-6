package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    void 이름() {
        Cars car = new Cars();
        List name = car.parsingCarName("pobi,juni,jun");
        assertThat(name).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
        System.out.println(name);
    }
}