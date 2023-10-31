package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.validation.CarNameValidator;

class CarListTest {

    @Test
    void of() {
        CarList carList = CarList.from("sk,fk");
        System.out.println(carList);
    }
}