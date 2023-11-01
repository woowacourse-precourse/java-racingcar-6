package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import racingcar.model.Car;

class CarMovementControllerTest {

    Car[] cars = { new Car("car1"), new Car("car2"), new Car("car3") };
    
    // Mocking을 위한 CarMovementController 객체 생성
    CarMovementController carController = Mockito.spy(CarMovementController.class);

	@Test
	void testForward_메서드_4이상의_난수_발생_시_전진() {

        // generatedRandomNumberZerotoNine 메서드가 항상 4를 반환하도록 설정
        when(carController.generatedRandomNumberZerotoNine()).thenReturn(4);

        cars = carController.forward(cars);

        for (Car car : cars) {
            assertEquals(1, car.getForwardCount());
        }
	}
	
	@Test
	void testForward_메서드_3이하의_난수_발생_시_정지() {
		// generatedRandomNumberZerotoNine 메서드가 항상 3를 반환하도록 설정
        when(carController.generatedRandomNumberZerotoNine()).thenReturn(3);

        cars = carController.forward(cars);

        for (Car car : cars) {
            assertEquals(0, car.getForwardCount());
        }
	}

}
