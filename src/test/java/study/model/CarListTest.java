package study.model;

import org.junit.jupiter.api.Test;
import racingcar.model.CarList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarListTest {

    @Test
    void test_정상적인경우() {
        // given
        CarList carList = new CarList();
        carList.add("pobi");
        carList.add("woni");
        carList.add("jun");

        // when
        for (int i = 0; i < 5; i++) {
            carList.executeRound();
        }
        List<String> winners = carList.getWinners();

        // then
        System.out.println("winners = " + winners);
        assertThat(winners.size()).isGreaterThan(0);
    }

}
