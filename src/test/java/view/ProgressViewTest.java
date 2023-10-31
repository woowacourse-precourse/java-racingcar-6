package view;

import model.Car;
import model.Cars;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import util.RandomNumber;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class ProgressViewTest {
    private static MockedStatic<RandomNumber> randoms;

    private Cars cars;

    @BeforeEach
    public void setUp() {
        List<Car> carsAslist = new ArrayList<>();
        carsAslist.add(new Car("Car1"));
        carsAslist.add(new Car("Car2"));
        carsAslist.add(new Car("Car3"));

        cars = new Cars(carsAslist);
    }

    @BeforeAll
    public static void beforeClass() {
        randoms = mockStatic(RandomNumber.class);
    }

    @AfterAll
    public static void afterAll() {
        randoms.close();
    }

    @Test
    public void 모든자동차_이동_안함_진행결과_출력_검증() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProgressView.printProgress(cars);

        System.setOut(System.out);

        String expectedOutput = "Car1 : \r\nCar2 : \r\nCar3 : \r\n\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void 모든자동차_1칸이동_진행결과_출력_검증() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        when(RandomNumber.generateRandomNumber()).thenReturn(4);

        cars.moveAll();

        ProgressView.printProgress(cars);

        System.setOut(System.out);

        String expectedOutput = "Car1 : -\r\nCar2 : -\r\nCar3 : -\r\n\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void 모든자동차_2칸이동_진행결과_출력_검증() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        when(RandomNumber.generateRandomNumber()).thenReturn(4);

        cars.moveAll();
        cars.moveAll();

        ProgressView.printProgress(cars);

        System.setOut(System.out);

        String expectedOutput = "Car1 : --\r\nCar2 : --\r\nCar3 : --\r\n\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}