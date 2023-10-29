package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CarListTest {

    @Test
    public void 자동차_이름에_중복이_있으면_예외() {
        String input = "a,a,a";

        assertThrows(IllegalArgumentException.class, () -> {
            new CarList(input);
        });
    }


}