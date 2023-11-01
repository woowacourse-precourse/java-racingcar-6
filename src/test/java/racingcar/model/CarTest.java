package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private final Car testCar1 = (Car) Model.generateCar("ukeun", 0);
    private final Car testCar2 = (Car) Model.generateCar("nueku",1);

    @Test
    @DisplayName("moveOrStop 메서드 테스트")
    void testMove() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar1.moveOrStop();
                    }
                    assertEquals(3, testCar1.getMoved());
                },
                9, 9, 9
        );
    }

    @Test
    @DisplayName("isDraw 메서드 테스트 1 : 비긴 경우")
    void testIsDraw1() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar1.moveOrStop();
                        testCar2.moveOrStop();
                    }
                    assertTrue(testCar1.isDraw(testCar2));
                },
                3, 3, 4, 4, 5, 5
        );
    }

    @Test
    @DisplayName("isDraw 메서드 테스트 2 : 비기지 않은 경우")
    void testIsDraw2() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar1.moveOrStop();
                        testCar2.moveOrStop();
                    }
                    assertFalse(testCar1.isDraw(testCar2));
                },
                3, 4, 3, 4, 3, 3
        );
    }

    @Test
    @DisplayName("toString 메서드 테스트")
    void testToString() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar1.moveOrStop();
                    }
                    assertEquals("ukeun : ---", testCar1.toString());
                },
                4, 4, 4
        );
    }

    @Test
    @DisplayName("compareTo 메서드 테스트 1 : 이동 거리 비교")
    void testCompreTo1() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar1.moveOrStop();
                        testCar2.moveOrStop();
                    }
                    assertEquals(3, testCar1.compareTo(testCar2));
                },
                1,7,2,4,3,6
        );
    }

    @Test
    @DisplayName("compareTo 메서드 테스트 2 : 이동 거리가 같은 경우 인덱스 비교")
    void testCompareTo2() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar1.moveOrStop();
                        testCar2.moveOrStop();
                    }
                    assertEquals(-1, testCar1.compareTo(testCar2));
                },
                4,4,3,3,4,4
        );
    }
}