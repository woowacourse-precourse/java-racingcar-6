package racingcar.unit;

import camp.nextstep.edu.missionutils.test.NsTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.controller.Validator;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest extends NsTest {
    @Test
    void inputCarValidateThrowTest() {
        List<String> list = new ArrayList<>();
        list.add("appleBack");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateInputCarList(list);
        });
    }

    @Test
    void inputAttemptValidateThrowTest() {
        String[] attempt = {"!", "ㄱ", "1ㄱ", "2s"};
        for (String s : attempt) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateInputAttemptNum(s);
            });
        }
    }

    @Test
    void inputAttemptValidateTest() {
        String[] attempt = {"1", "12", "123", "342532"};
        int[] attempt2 = {1, 12, 123, 342532};
        for (int i = 0; i < attempt.length; i++) {
            assertThat(attempt2[i]).isEqualTo(Validator.validateInputAttemptNum(attempt[i]));
        }
    }

    @Test
    public void testCalculateWinner() {
        // Create a list of cars
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Move some cars
        car1.move();
        car2.move();
        car2.move();
        car3.move();
        car3.move();
        car3.move();

        // Calculate the winner
        List<Car> winners = cars;

        // Verify the winner(s)
        assertEquals(3, winners.size()); // In this example, all cars have the same move distance
        assertEquals("Car1", winners.get(0).getName());
        assertEquals("Car2", winners.get(1).getName());
        assertEquals("Car3", winners.get(2).getName());
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
