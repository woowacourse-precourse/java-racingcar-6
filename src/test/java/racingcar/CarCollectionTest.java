package racingcar;

import car.Car;
import car.CarCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarCollectionTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString();
    }

    @Test
    void addCar_자동차_추가() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        CarCollection carCollection = createCarCollection(car1, car2);

        List<Car> cars = carCollection.getCars();

        assertThat(cars).contains(car1);
        assertThat(cars).contains(car2);
    }

    @Test
    void moveCarsForward_모든_자동차_앞으로_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("car1");
                    Car car2 = new Car("car2");
                    Car car3 = new Car("car3");

                    CarCollection carCollection = createCarCollection(car1, car2, car3);

                    carCollection.moveCarsForward();

                    List<Car> cars = carCollection.getCars();
                    for(Car car : cars) {
                        assertThat(car.getDistance()).isEqualTo(1);
                    }
                },
                4, 4, 4
        );
    }

    @Test
    void printCarsDistance_자동차가_전진한_거리를_각_자동차별로_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("car1");
                    Car car2 = new Car("car2");

                    CarCollection carCollection = createCarCollection(car1, car2);

                    carCollection.moveCarsForward();
                    carCollection.printCarsDistance();

                    assertThat(output()).contains("car1 : -", "car2 :");
                },
                4, 3
        );
    }

    @Test
    void getMaxDistance_자동차들_중_가장_많이_이동한_자동차의_거리를_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("car1");
                    Car car2 = new Car("car2");
                    Car car3 = new Car("car3");

                    CarCollection carCollection = createCarCollection(car1, car2, car3);

                    carCollection.moveCarsForward();
                    int maxDistance = carCollection.getMaxDistance();

                    assertThat(maxDistance).isEqualTo(1);
                },
                4, 3, 4
        );
    }

    @Test
    void getWinners_자동차들_중_가장_많이_이동한_자동차들을_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("car1");
                    Car car2 = new Car("car2");
                    Car car3 = new Car("car3");

                    CarCollection carCollection = createCarCollection(car1, car2, car3);

                    carCollection.moveCarsForward();

                    List<String> winners = carCollection.getWinners();

                    assertThat(winners).contains("car1", "car3");
                },
                4, 3, 4
        );
    }

    private CarCollection createCarCollection(Car... cars) {
        CarCollection carCollection = new CarCollection();

        for (Car car : cars) {
            carCollection.addCar(car);
        }
        return carCollection;
    }

}
