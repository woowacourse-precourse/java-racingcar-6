package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MonitorTest extends NsTest {
    private Monitor monitor;
    private List<Car> cars;
    private Car car1, car2, car3;

    @BeforeEach
    protected void setUp() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        car1.move(1, car1);
        car2.move(4, car2);
        car3.move(6, car3);

        monitor = new Monitor(cars);

        monitor.printCars(cars);
    }

    @Test
    void printCars() {
        assertThat(output()).contains("car1 : ", "car2 : -", "car3 : -");
    }

    @Override
    protected void runMain() {
    }
}