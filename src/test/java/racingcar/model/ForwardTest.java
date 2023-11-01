package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ForwardTest {
    @Test
    public void 한칸_전진() {
        Forward forward = new Forward();
        List<Integer> result = forward.moveForward(Arrays.asList(0, 0, 0));

        assertThat(Collections.max(result)).isLessThan(2);
    }
}