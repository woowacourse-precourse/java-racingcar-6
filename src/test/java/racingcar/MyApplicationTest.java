package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    void testIsValidNum_ValidInput() {
        String validInput = "10";

        boolean isValid = Application.isValidNum(validInput);

        assertTrue(isValid);
    }

    @Test
    void testForward() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");

        int gameNum = 5;

        List<String>[] forwardResults = Application.forward(carNames, gameNum);

        assertNotNull(forwardResults);
        assertEquals(carNames.size(), forwardResults.length);

        for (int i = 0; i < forwardResults.length; i++) {
            List<String> forwardList = forwardResults[i];
            assertNotNull(forwardList);
            assertEquals(gameNum, forwardList.size());

            for (String forward : forwardList) {
                assertTrue(forward.matches("^-*$"));
            }
        }
    }
}
