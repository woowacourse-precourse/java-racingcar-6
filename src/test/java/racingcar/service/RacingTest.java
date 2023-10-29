package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Driver;
import racingcar.domain.TestDriver;
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

        Racing racing = new Racing();
        racing.setRacingCars(carList);

        // When
        for(int i = 0; i<3; i++){
            racing.race();
        }

        // Then
        assertThat(car1.getPosition()).isEqualTo(3);
        assertThat(car2.getPosition()).isEqualTo(0);
        assertThat(car3.getPosition()).isEqualTo(3);
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

        Racing racing = new Racing();
        racing.setRacingCars(carList);

        // When
        for(int i = 0; i<3; i++){
            racing.race();
        }

        // Then
        List<String> winners = racing.getWinner();
        assertThat(winners).contains("test1", "test3");
    }

    @Test
    public void setRacingCarTest(){
        Driver driver1 = new TestDriver(4);
        Car car1 = new Car("test1", driver1);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);

        Racing racing = new Racing();

        // When
        racing.setRacingCars(carList);


        // Then
        List<Car> cars = racing.getRacingCars();
        assertThat(cars.get(0).getName()).isEqualTo("test1");
    }
}
