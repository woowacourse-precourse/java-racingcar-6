package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RaceTest {

    private Race race;
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        race = new Race();
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        race.cars.add(car1);
        race.cars.add(car2);
        race.cars.add(car3);
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    private void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private void setupTestData() {
        Car car1 = race.cars.get(0);
        Car car2 = race.cars.get(1);
        Car car3 = race.cars.get(2);

        car1.setPosition(3);
        car2.setPosition(1);
        car3.setPosition(3);
    }

    @Test
    void createCarObjectsTest() {
        race.cars.clear();

        String[] carNames = {"Car1", "Car2", "Car3"};
        race.createCarObjects(carNames);
        List<Car> cars = race.cars;
        assertEquals(carNames.length, cars.size());
        for (int i = 0; i < carNames.length; i++) {
            assertEquals(carNames[i], cars.get(i).getName());
        }
    }

    @Test
    void updateCarsPositionTest() {
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.createRandomNumber()).thenReturn(1, 4, 5);
        race.numberGenerator = numberGenerator;

        race.updateCarsPosition();

        List<Car> cars = race.cars;
        assertEquals(0, cars.get(0).getPosition());
        assertEquals(1, cars.get(1).getPosition());
        assertEquals(1, cars.get(2).getPosition());
    }

    @Test
    void displayCarMoving() {
        setUpStreams();

        setupTestData();

        race.displayCarMoving();

        assertThat(outputStream.toString()).contains("Car1 : ---");
        assertThat(outputStream.toString()).contains("Car2 : -");
        assertThat(outputStream.toString()).contains("Car3 : --");
    }

    @Test
    void findMaxPositionTest() {
        setupTestData();

        int maxPosition = race.findMaxPosition();
        assertEquals(3, maxPosition);
    }

    @Test
    void findWinnersTest() {
        setupTestData();

        List<String> winners = race.findWinners();
        List<String> expectedWinners = Arrays.asList("Car1", "Car3");
        assertThat(winners).isEqualTo(expectedWinners);
    }

    @Test
    void displayWinner() {
        setUpStreams();

        setupTestData();

        race.displayWinner();

        String expectedOutput = "최종 우승자 : Car1, Car3";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);
    }
}