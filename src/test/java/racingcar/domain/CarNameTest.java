package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNameTest {

    @Test
    void getNameTest() {
        CarName carName = new CarName("Car");

        assertEquals("Car", carName.getName());
    }
}