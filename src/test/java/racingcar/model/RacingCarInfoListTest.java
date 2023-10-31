package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarInfoListTest {
    @Test
    void 중복_이름_예외처리() {
        List<String> list = new ArrayList<>();
        list.add("pobi");
        list.add("woni");
        list.add("pobi");

        assertThatThrownBy(() -> new RacingCarList(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_초과_예외처리() {
        List<String> list = new ArrayList<>();
        list.add("pobipobipobi");

        assertThatThrownBy(() -> new RacingCarList(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}