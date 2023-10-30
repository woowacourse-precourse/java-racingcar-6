package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.NumberGenerator;
import racingcar.utils.StubNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {

    private RacingController controller;
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        controller = new RacingController();
        cars = Arrays.asList(new Car("car1", new StubNumberGenerator(5)),
                new Car("car2", new StubNumberGenerator(1)),
                new Car("car3", new StubNumberGenerator(2)));

        cars.forEach(Car::move);
    }

    @Test
    public void 단독_우승자_찾기_테스트() throws Exception {
        //given
        String expectedWinner = "car1";

        //when
        String actualWinner = controller.findWinner(cars);

        //then
        assertEquals(expectedWinner, actualWinner);
    }


    @Test
    public void 공동_우승자_찾기_테스트() throws Exception {
        controller = new RacingController();
        cars = Arrays.asList(new Car("car1", new StubNumberGenerator(5)),
                new Car("car2", new StubNumberGenerator(5)),
                new Car("car3", new StubNumberGenerator(2)));

        cars.forEach(Car::move);

        //given
        String expectedWinner = "car1, car2";

        //when
        String actualWinner = controller.findWinner(cars);

        //then
        assertEquals(expectedWinner, actualWinner);
    }



}