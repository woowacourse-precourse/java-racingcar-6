package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarDistanceMessageTest {

    @Test
    void toString_메시지_생성() {
        CarDistanceMessage carDistanceMessage = new CarDistanceMessage("foo", 5);
        assertEquals(carDistanceMessage.toString(), "foo : -----");
    }

}