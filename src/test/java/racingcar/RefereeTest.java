package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private Referee referee;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        CarGenerator generator = new CarGenerator();
        referee = new Referee();

        String names = "apple,pear,melon";
        List<String> nameList = generator.splitNames(names);
        carList = generator.createCars(nameList);

        carList.get(0).move(true);
        carList.get(0).move(true);
        carList.get(0).move(true);

        carList.get(1).move(true);
        carList.get(1).move(true);
        carList.get(1).move(true);

        carList.get(2).move(true);
    }

    @Test
    void findMaxDistance_메소드로_주어진_객체_중_가장_큰_거리값_반환() {
        int max = referee.findMaxDistance(carList);
        assertThat(max).isEqualTo(3);
    }

    @Test
    void findWinner_메소드로_주어진_객체_중_최대_거리만큼_이동한_객체_반환() {
        int max = 3;
        List<Car> winnerList = referee.findWinner(carList, max);

        assertThat(winnerList.get(0).getName()).isEqualTo(carList.get(0).getName());
        assertThat(winnerList.get(1).getName()).isEqualTo(carList.get(1).getName());
    }
}