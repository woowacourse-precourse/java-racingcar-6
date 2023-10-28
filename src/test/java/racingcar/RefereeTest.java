package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private CarGenerator generator;
    private Referee referee;

    private String names;
    List<String> nameList;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        generator = new CarGenerator();
        referee = new Referee();
        names = "apple,pear,melon";
        nameList = generator.splitNames(names);
        carList = generator.createCars(nameList);

        carList.get(0).move();
        carList.get(0).move();
        carList.get(0).move();

        carList.get(1).move();
        carList.get(1).move();
        carList.get(1).move();

        carList.get(2).move();
    }

    @Test
    void findMaxDistance_메소드로_주어진_객체_중_가장_큰_거리값_반환() {
        int max = referee.findMaxDistance(carList);
        assertThat(max).isEqualTo(3);
    }

    @Test
    void findWinner() {
        int max = 3;
        List<Car> winnerList = referee.findWinner(carList, max);

        assertThat(winnerList.get(0).getName()).isEqualTo(carList.get(0).getName());
        assertThat(winnerList.get(1).getName()).isEqualTo(carList.get(1).getName());
    }
}