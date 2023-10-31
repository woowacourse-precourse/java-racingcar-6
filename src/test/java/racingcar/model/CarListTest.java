package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarList;

import static org.junit.jupiter.api.Assertions.*;

public class CarListTest {

    private CarList carList;

    @BeforeEach
    public void setUp() {
        carList = new CarList("test1,test2");
    }

    @Test
    public void 중복없는이름() {
        Car car = new Car("test3");
        assertDoesNotThrow(() -> carList.isNameDupe(car));
    }

}
