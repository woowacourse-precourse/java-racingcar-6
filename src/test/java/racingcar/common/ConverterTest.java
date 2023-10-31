package racingcar.common;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConverterTest {

    @DisplayName("String 타입의 자동차 이름을 List<String> 타입으로 변경")
    @ParameterizedTest(name = "carNames=\"{0}\"")
    @ValueSource(strings = {"pobi,jun", " pobi , jun"})
    void stringToList(String carNames) {
        StringToListConverter converter = new StringToListConverter();
        List<String> carNameList = converter.convert(carNames);
        assertAll(
                () -> assertEquals(2, carNameList.size()),
                () -> assertEquals(true, carNameList.contains("pobi")),
                () -> assertEquals(true, carNameList.contains("jun"))
        );
    }
}
