package study.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.CarList;
import racingcar.model.RacingCar;

class CarListTest {

    @Test
    void test_리스트_사이즈_테스트() {
        // given
        CarList carList = new CarList();
        carList.add("pobi");
        carList.add("woni");
        carList.add("jun");

        // when
        int listSize = 0;
        Iterator<RacingCar> carIterator = carList.getIterator();
        while (carIterator.hasNext()) {
            carIterator.next();
            listSize++;
        }

        // then
        assertThat(listSize).isEqualTo(3);
    }

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
