package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.Name;

class OutputTest {
    @Test
    void 최종_우승자_출력() {
        // Given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<Car> cars = new ArrayList<>();
        cars.add(Car.from(Name.from("Car1")));
        cars.add(Car.from(Name.from("Car2")));

        // When
        Output.printWinnersName(cars);

        // Then
        assertEquals("최종 우승자 : Car1, Car2", outContent.toString().trim());
    }

    @Test
    void 자동차_상태_출력() {
        // Given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Cars cars = CarFactory.createCars(List.of("Car1", "Car2"));
        cars.iterator().next().moveForward();

        // When
        Output.printCarStatus(cars);

        // Then
        String expectedOutput = "Car1 : -\nCar2 : \n\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
