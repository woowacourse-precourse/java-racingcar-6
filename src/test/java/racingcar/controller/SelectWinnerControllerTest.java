package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;

class SelectWinnerControllerTest {

	@Test
	void testResultCars_매서드_단독_우승자_테스트() {
		Car[] cars = { new Car("car1"), new Car("car2"), new Car("car3") };

        cars[0].forward();

        SelectWinnerController controller = new SelectWinnerController();

        List<Car> winnerCars = controller.resultCars(cars);

        assertEquals(1, winnerCars.size());
        assertEquals("car1", winnerCars.get(0).getName());
	}
	
	@Test
	void testResultCars_매서드_공동_우승자_테스트() {
        
        Car[] cars = { new Car("car1"), new Car("car2"), new Car("car3") };
        cars[0].forward();
        cars[1].forward();

        SelectWinnerController controller = new SelectWinnerController();

        List<Car> winnerCars = controller.resultCars(cars);

        assertEquals(2, winnerCars.size());
        assertEquals("car1", winnerCars.get(0).getName());
        assertEquals("car2", winnerCars.get(1).getName());
	}

}
