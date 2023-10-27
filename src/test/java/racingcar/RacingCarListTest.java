package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarListTest {

    List<Car> cars  = new ArrayList<>();
    TestUser user = new TestUser();
    Car car = new Car();

    class TestUser extends User{
        @Override
        public String inputCarCount() {
            return "3";
        }

    }
    @Test
    void getRacingCarList() {
       int carCount = Integer.parseInt(user.inputCarCount());
       for (int i = 0; i < carCount; i++) {
           cars.add(car.createNewCar());
       }
       assertEquals(3, cars.size());
    }
}