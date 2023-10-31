package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SplitterTest {

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        Splitter splitter = new Splitter();
        String input = "sonata,avante,genesis";
        List<String> expected = Arrays.asList("sonata", "avante", "genesis");

        List<String> result = splitter.stringToList(input);

        assertEquals(expected, result);
    }
}