package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Car car;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        car = new Car("TestCar");
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void Car_자동차가_움직인경우_필드멤버_갱신을_확인() {
        int initalLocation = car.getLocation();
        car.canForward(Car.MIN_NUMBER_TO_MOVE);
        assertEquals(initalLocation + Car.MOVE_DISTANCE, car.getLocation());
    }

    @Test
    void Car_자동차가_움직이지_않는_경우_멤버변수가_변하지_않는다() {
        int initalLocation = car.getLocation();
        car.canForward(Car.MIN_NUMBER_TO_MOVE - 1);
        assertEquals(initalLocation, car.getLocation());
    }

    @Test
    void Car_현재_위치만큼의_막대바를_출력한다() {
        car.canForward(Car.MIN_NUMBER_TO_MOVE);
        car.canForward(Car.MIN_NUMBER_TO_MOVE);
        car.printLocation(car);
        String expectedOutput = "TestCar : " + "-".repeat(2) + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    
}