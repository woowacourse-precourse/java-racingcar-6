package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private final Car testCar = Car.generateCar("ukeun");

    @Test
    @DisplayName("move 메서드 테스트")
    void move() {
        assertRandomNumberInRangeTest(
                () -> {
                    testCar.move(3);
                    assertEquals(2, testCar.getMoved());
                },
                3, 4, 5
        );
    }

    @Test
    @DisplayName("toString 메서드 테스트")
    void testToString() {
        assertRandomNumberInRangeTest(
                () -> {
                    testCar.move(3);
                    assertEquals("ukeun : ---", testCar.toString());
                },
                4, 4, 4
        );
    }
}