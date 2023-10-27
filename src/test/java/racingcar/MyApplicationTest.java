package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyApplicationTest {

    @Test
    void testListConversion() {
        String racingCar = "pobi,man";

        List<String> expected = new ArrayList<>();
        expected.add("pobi");
        expected.add("man");

        List<String> result = Application.listConversion(racingCar);

        assertIterableEquals(expected, result);
    }
}
