package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesToArrayTest {
    @Test
    void 입력받은_차량이름들_배열로_반환() {
        String[] carNames = CarNamesToArray.convert("a,b,c");
        assertThat(carNames).containsExactly("a", "b", "c");
    }
}
