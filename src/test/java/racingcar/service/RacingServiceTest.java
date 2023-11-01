package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingServiceTest {
    @Test
    void stringToListShouldConvertCommaSeparatedStringToList() {
        RacingService racingService = new RacingService();

        String testString = "용준,용준1,용준2";
        List<String> expectedList = Arrays.asList("용준", "용준1", "용준2");
        List<String> result = racingService.stringToList(testString);

        assertEquals(expectedList, result);
    }
}