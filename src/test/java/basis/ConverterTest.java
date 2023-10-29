package basis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
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
        Map<String, String> actualMap = converter.putHashMap("pobi,crong");
        List<String> actual = new ArrayList<>();
        for (Entry<String, String> entry : actualMap.entrySet()) {
            String s = entry.getKey() + entry.getValue();
            actual.add(s);
        }
        Assertions.assertEquals(expected, actual);
    }
}