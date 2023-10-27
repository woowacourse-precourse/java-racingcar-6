package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void 이름_파싱() {
        //given
        String input = "test1,test2,test3";
        List<String> expectedNames = List.of("test1", "test2", "test3");

        //when
        List<String> actualNames = Utils.parseNames(input);

        //then
        assertThat(actualNames.size()).isEqualTo(actualNames.size());
        assertIterableEquals(expectedNames, actualNames);
    }

}