package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

class CarsTest {
    private static Car testCar1;
    private static Car testCar2;
    private static Car testCar3;
    private static Cars testCars;

    @BeforeEach
    void beforeEach() {
        testCar1 = makeTestCar(4, "test1");
        testCar2 = makeTestCar(6, "test2");
        testCar3 = makeTestCar(1, "test3");

        testCars = new Cars(List.of(testCar1, testCar2, testCar3));
    }


    @Test
    void 자동차_단체로_움직이기_테스트() {
        testCars.moveCars();

        assertEquals(testCar1.getDistance(), 1);
        assertEquals(testCar2.getDistance(), 1);
        assertEquals(testCar3.getDistance(), 0);
    }

    @Test
    void 우승자_찾기_테스트() {
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