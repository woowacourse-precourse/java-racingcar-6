package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

class CarTest {
    private static Car testCar1;
    private static Car testCar2;

    @BeforeEach
    void beforeEach() {
        testCar1 = makeTestCar(4, "test1");
        testCar2 = makeTestCar(3, "test2");
        testCar1.moveOrStay();
        testCar2.moveOrStay();
    }

    @Test
    void 임의의_수가_4_이상일_경우_전진() {
        assertEquals(testCar1.getDistance(), 1L);
    }

    @Test
    void 임의의_수가_3_이하일_경우_정지() {
        Car testCar = makeTestCar(3, "test");
        testCar.moveOrStay();

        assertEquals(testCar2.getDistance(), 0L);
    }

    @Test
    void 거리_비교_테스트() {
        assertThat(testCar1.compareTo(testCar2)).isGreaterThan(0);
    }

    @Test
    void 최대_거리와_비교_테스트() {
        Car testCar3 = makeTestCar(4, "test3");
        testCar3.moveOrStay();

        assertThat(testCar1.isWinner(testCar3)).isEqualTo(true);
        assertThat(testCar2.isWinner(testCar3)).isEqualTo(false);
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