package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    public void 자동차_이름_분할_테스트() {
        // given
        Player player = new Player("pobi,woni,jun");

        // when
        List<String> strings = player.splitNamesOfCars();

        // then
        assertThat(strings).contains("pobi", "woni", "jun");
    }

    @Test
    public void 자동차_이름_분할_테스트2() {
        // given
        Player player = new Player("pobi");

        // when
        List<String> strings = player.splitNamesOfCars();

        // then
        assertThat(strings).contains("pobi");
    }
}