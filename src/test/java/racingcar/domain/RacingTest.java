package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.service.Racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    public void raceTest(){
        // Given
        Driver driver1 = new TestDriver(4);
        Car car1 = new Car("test1", driver1);

        Driver driver2 = new TestDriver(3);
        Car car2 = new Car("test2", driver2);

        Driver driver3 = new TestDriver(5);
        Car car3 = new Car("test3", driver3);

        List<Car> carList = new ArrayList<>();
        Car[] cars = {car1, car2, car3};
        carList.addAll(Arrays.asList(cars));

        Racing racing = new Racing(carList);

        // When
        for(int i = 0; i<3; i++){
            racing.race();
        }

        // Then
        assertThat(car1.getPosition()).isEqualTo(4);
        assertThat(car2.getPosition()).isEqualTo(1);
        assertThat(car3.getPosition()).isEqualTo(4);
    }

    @Test
    public void getWinnerTest(){
        Driver driver1 = new TestDriver(4);
        Car car1 = new Car("test1", driver1);

        Driver driver2 = new TestDriver(3);
        Car car2 = new Car("test2", driver2);

        Driver driver3 = new TestDriver(5);
        Car car3 = new Car("test3", driver3);

        List<Car> carList = new ArrayList<>();
        Car[] cars = {car1, car2, car3};
        carList.addAll(Arrays.asList(cars));

        Racing racing = new Racing(carList);

        // When
        for(int i = 0; i<3; i++){
            racing.race();
        }

        // Then
        List<String> winners = racing.getWinner();
        assertThat(winners).contains("test1", "test3");
    }
}
