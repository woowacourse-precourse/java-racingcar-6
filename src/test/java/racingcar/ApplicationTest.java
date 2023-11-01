package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void testUserEnterCarName() {
        // Arrange
        String input = "Car1,Car2,Car3";

        // Act
        Application.Car[] cars = Application.UserEnterCarName();

        // Assert
        assertEquals(3, cars.length);
        for (Application.Car car : cars) {
            assertNotNull(car);
            assertNotNull(car.name);
            assertEquals(0, car.meter);
        }
    }

    @Test
    public void testUserEnterCarName_WithInvalidInput() {
        // Arrange
        String input = "Car1,Car2, Car3, Car4, Car5";  // Contains a car name with a space

        // Act and Assert
        assertThrows(IllegalArgumentException.class, Application::UserEnterCarName);
    }

    @Test
    public void testUserEnterRepeatNumber() {
        // Arrange
        String input = "5";

        // Act
        int repeatNumber = Application.UserEnterRepeatNumber();

        // Assert
        assertEquals(5, repeatNumber);
    }

    @Test
    public void testCalculateGoOrStop() {
        // Arrange
        Application.Car[] cars = new Application.Car[]{new Application.Car("Car1"), new Application.Car("Car2"), new Application.Car("Car3")};

        // Act
        Application.CalculateGoOrStop(cars);

        // Assert
        for (Application.Car car : cars) {
            assertTrue(car.meter >= 0 && car.meter <= 1);
        }
    }

    @Test
    public void testWhoIsWinner() {
        // Arrange
        Application.Car car1 = new Application.Car("Car1");
        Application.Car car2 = new Application.Car("Car2");
        Application.Car car3 = new Application.Car("Car3");
        car1.meter = 5;
        car2.meter = 3;
        car3.meter = 5;
        Application.Car[] cars = new Application.Car[]{car1, car2, car3};

        // Act
        String winner = Application.WhoIsWinner(cars);

        // Assert
        assertEquals("Car1, Car3", winner);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
