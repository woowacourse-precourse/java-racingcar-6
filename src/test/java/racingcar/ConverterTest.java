package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.converter.NumToDash.createDashString;

public class ConverterTest {
    @Test
    void testcreateDashString(){
        int size=3;
        String t=createDashString(size);
        assertEquals(t.length(),3);
    }
}
