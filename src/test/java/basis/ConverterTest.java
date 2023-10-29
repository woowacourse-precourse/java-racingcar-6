package basis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConverterTest {
    private Converter converter;

    @BeforeEach
    void init() {
        converter = new Converter();
    }

    @Test
    void 문자열을_쉼표로_구분해서_해시맵에_넣기() {
        List<String> expected = List.of("pobi", "crong");
        Map<String, String> actualMap = converter.splitAndAddToMap("pobi,crong");
        List<String> actual = new ArrayList<>();
        for (Entry<String, String> entry : actualMap.entrySet()) {
            String s = entry.getKey() + entry.getValue();
            actual.add(s);
        }
        Assertions.assertEquals(expected, actual);
        Assertions.assertThrows(IllegalArgumentException.class, () -> converter.splitAndAddToMap("pobi, ,crong"));
    }

    @Test
    void 문자열을_정수로_반환() {
        Assertions.assertEquals(7, converter.wordToInt("7"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> converter.wordToInt("안녕"));
    }
}