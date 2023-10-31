package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TryNumberTest {
    private final Integer number = 1;
    private TryNumber tryNumber = new TryNumber(number);

    @Test
    public void getNumber_test(){
        assertEquals(number, tryNumber.getTryNumber());
    }
}
