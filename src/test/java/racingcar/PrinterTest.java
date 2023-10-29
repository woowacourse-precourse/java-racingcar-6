package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PrinterTest {
    @Test
    void Printer_cars_메소드_출력_테스트() {
        List<Car> cars = Arrays.asList(new Car("car1", 1),
                new Car("car2", 2), new Car("car3", 3));

        Printer.cars(cars);
    }
}
