package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TypeConverterTest {

    private TypeConverter typeConverter = new TypeConverter();
    @Test
    @DisplayName("string을 int로 정확히 변환하는지 테스트")
    void test_String_To_Int(){
        int expectedResult = 1;
        assertEquals(expectedResult,typeConverter.stringToInt("1"));
    }


}