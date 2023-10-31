package service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars cars;

    @BeforeEach
    public void setUp(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("car1"));
        carList.add(new Car("car2"));
        carList.add(new Car("car3"));
        cars = new Cars(carList);
    }
    @Test
    void determineWinner_중복_우승자() {
        cars.car().get(0).go(4);
        cars.car().get(1).go(4);
        List<String> result = cars.determineWinner();
        assertThat(result).contains("car1","car2");
    }

    @Test
    void determineWinner_단독_우승자() {
        cars.car().get(1).go(4);
        List<String> result = cars.determineWinner();

        assertThat(result).contains("car2");
    }

}