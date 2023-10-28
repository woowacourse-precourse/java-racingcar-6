package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarDistanceMessageTest {

    @Test
    void testToString_메시지_생성() {
        CarDistanceMessage carDistanceMessage = new CarDistanceMessage("foo", 5);
        assertEquals(carDistanceMessage.toString(), "foo : -----");
    }

}