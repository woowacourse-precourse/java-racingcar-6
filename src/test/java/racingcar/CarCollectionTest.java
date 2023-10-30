package racingcar;

import car.Car;
import car.CarCollection;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCarTestConstants.MOVING_FORWARD;
import static racingcar.RacingCarTestConstants.STOP;

public class CarCollectionTest {
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
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void printCarsDistance_자동차가_전진한_거리를_각_자동차별로_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("car1");
                    Car car2 = new Car("car2");

                    CarCollection carCollection = createCarCollection(car1, car2);

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outputStream));

                    carCollection.moveCarsForward();
                    carCollection.printCarsDistance();

                    String captured = outputStream.toString().trim();
                    assertThat(captured).contains("car1 : -", "car2 :");
                },
                MOVING_FORWARD, STOP
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
                MOVING_FORWARD, STOP, MOVING_FORWARD
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
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void printWinners_자동차들_중_가장_많이_이동한_자동차들을_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("car1");
                    Car car2 = new Car("car2");
                    Car car3 = new Car("car3");

                    CarCollection carCollection = createCarCollection(car1, car2, car3);

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(outputStream));

                    carCollection.moveCarsForward();
                    List<String> winners = carCollection.getWinners();
                    carCollection.printWinners(winners);

                    String captured = outputStream.toString().trim();
                    assertThat(captured).contains("최종 우승자 : car1, car3");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
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
