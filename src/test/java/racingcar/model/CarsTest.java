package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

class CarsTest {

    @Test
    void 우승자_찾기_테스트() {
        Car testCar1 = makeTestCar(4, "test1");
        Car testCar2 = makeTestCar(6, "test2");
        Car testCar3 = makeTestCar(1, "test3");

        Cars testCars = new Cars(List.of(testCar1, testCar2, testCar3));
        testCars.moveCars();

        List<String> result = List.of("test1", "test2");

        assertEquals(testCars.findWinners(), result);
    }

    private Car makeTestCar(int number, String name) {
        NumberGenerator testNumberGenerator = new NumberGenerator() {
            @Override
            public int generateNumber() {
                return number;
            }
        };

        return new Car(name, testNumberGenerator);
    }
}