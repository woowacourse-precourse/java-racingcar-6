package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingCountTest {
    private MovingCount movingCount;

    @BeforeEach
    void setUp() {
        movingCount = new MovingCount();
        movingCount.initMovingCount(3);
    }

    @Test
    void 움직임_횟수_리스트_전체_리턴() {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 0));

        assertThat(list).isEqualTo(movingCount.getMovingCount());
    }

    @Test
    void 움직임_횟수_리스트의_특정_인덱스값_1만큼_증가() {
        List<Integer> list = movingCount.getMovingCount();

        assertThat(list.get(0) + 1).isEqualTo(movingCount.addCount(0));
    }
}
