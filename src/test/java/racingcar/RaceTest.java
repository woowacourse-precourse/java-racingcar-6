package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RaceTest {
    @Test
    void createCarObjectsTest() {
        // Given
        Race race = new Race();
        String[] carNames = {"Car1", "Car2", "Car3"};

        // When
        race.createCarObjects(carNames);

        // Then
        List<Car> cars = race.cars;
        assertEquals(carNames.length, cars.size());
        for (int i = 0; i < carNames.length; i++) {
            assertEquals(carNames[i], cars.get(i).getName());
        }
    }

    @Test
    void updateCarsPositionTest() {
        // Given
        Race race = new Race();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        race.cars.add(car1);
        race.cars.add(car2);
        race.cars.add(car3);

        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.createRandomNumber()).thenReturn(1, 4, 5);
        race.numberGenerator = numberGenerator;

        // When
        race.updateCarsPosition();

        // Then
        assertEquals(0, car1.getPosition());
        assertEquals(1, car2.getPosition());
        assertEquals(1, car3.getPosition());
    }

    @Test
    void displayCarMoving() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Race race = new Race();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        race.cars.add(car1);
        race.cars.add(car2);
        race.cars.add(car3);

        car1.setPosition(3);
        car2.setPosition(1);
        car3.setPosition(2);

        race.displayCarMoving();

        System.setOut(System.out);

        assertThat(outputStream.toString()).contains("Car1 : ---");
        assertThat(outputStream.toString()).contains("Car2 : -");
        assertThat(outputStream.toString()).contains("Car3 : --");
    }

    @Test
    void findMaxPositionTest() {
        Race race = new Race();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        race.cars.add(car1);
        race.cars.add(car2);
        race.cars.add(car3);

        car1.setPosition(3);
        car2.setPosition(4);
        car3.setPosition(2);

        int maxPosition = race.findMaxPosition();
        assertEquals(4, maxPosition);
    }

    @Test
    void findWinnersTest() {
        Race race = new Race();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        race.cars.add(car1);
        race.cars.add(car2);
        race.cars.add(car3);

        car1.setPosition(3);
        car2.setPosition(1);
        car3.setPosition(3);

        List<String> winners = race.findWinners();
        List<String> expectedWinners = Arrays.asList("Car1", "Car3");
        assertEquals(expectedWinners, winners);
    }

    @Test
    void displayWinner() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Race race = new Race();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        race.cars.add(car1);
        race.cars.add(car2);
        race.cars.add(car3);

        car1.setPosition(3);
        car2.setPosition(3);
        car3.setPosition(2);

        race.displayWinner();

        System.setOut(System.out);

        String expectedOutput = "최종 우승자 : Car1, Car2";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);
    }
}