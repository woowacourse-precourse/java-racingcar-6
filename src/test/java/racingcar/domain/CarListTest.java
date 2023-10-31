package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.validation.CarNameValidator;

class CarListTest {

    @Test
    void of() {
        CarList carList = CarList.of("sk,fk");
        System.out.println(carList);
    }
}