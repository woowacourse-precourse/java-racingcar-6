package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsNameConverterTest {

    @Test
    public void 전체차이름String을_List로_변환() {
        String carsName = "Car1,Car2,Car3";

        List<String> result = CarsNameConverter.convertStringToList(carsName);

        List<String> expected = List.of("Car1", "Car2", "Car3");
        assertEquals(expected, result);
    }
}