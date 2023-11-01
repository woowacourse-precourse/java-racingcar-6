package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumTest {
    @Test
    public void randomNum() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(RandomNum.getrandomNum());
        }
        assertThat(list).contains(0,1,2,3,4,5,6,7,8,9);
    }
}