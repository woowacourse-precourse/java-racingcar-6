package study.model;

import org.junit.jupiter.api.Test;
import racingcar.model.CarMap;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarMapTest {

    @Test
    void test_정상적인경우() {
        // given
        CarMap carMap = new CarMap();
        carMap.add("pobi");
        carMap.add("woni");
        carMap.add("jun");

        // when
        for (int i = 0; i < 5; i++) {
            carMap.excuteRound();
        }
        List<String> winners = carMap.getWinners();

        // then
        System.out.println("winners = " + winners);
        assertThat(winners.size()).isGreaterThan(0);
    }

}