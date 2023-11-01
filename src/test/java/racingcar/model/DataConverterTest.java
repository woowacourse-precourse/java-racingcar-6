package racingcar.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataConverterTest {

    @Test
    public void testChangeInputStringToList() {

        DataConverter dataConverter = new DataConverter();
        String input = "1,2,3";


        List<String> testList = dataConverter.changeInputStringToList(input);
        List<String> expectedList = List.of("1", "2", "3");


        assertEquals(expectedList.contains("1"), testList.contains("1"));
    }

    @Test
    public void testChangeInputStringToInteger() {

        DataConverter dataConverter = new DataConverter();
        String input = "10";


        int result = dataConverter.changeInputStringToInteger(input);
        int expectedResult = 10;


        assertEquals(expectedResult, result);
    }
}