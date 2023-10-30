package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RefereeTest {
    List<Car> carsAslist = new ArrayList<>();
    Car car1 = new Car("car1");
    Car car2 = new Car("car2");
    Car car3 = new Car("car3");
    private Referee referee;


    @BeforeEach
    public void setUp() {
        referee = new Referee();
    }

    @Test
    public void 우승자_1명_찾아내기() {
        car1.moveForward();
        carsAslist.add(car1);
        carsAslist.add(car2);
        carsAslist.add(car3);

        Cars cars = new Cars(carsAslist);

        referee.competeCars(cars);

        assertThat(referee.getWinner()).isEqualTo(List.of("car1"));
    }

    @Test
    public void 우승자_2명_찾아내기() {
        car1.moveForward();
        car2.moveForward();
        carsAslist.add(car1);
        carsAslist.add(car2);
        carsAslist.add(car3);

        Cars cars = new Cars(carsAslist);

        referee.competeCars(cars);

        assertThat(referee.getWinner()).isEqualTo(List.of("car1", "car2"));
    }
}