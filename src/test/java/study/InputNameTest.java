package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.StringName;

public class InputNameTest {

    List<String> splitNameTest(String testString) {
        List<String> result = StringName.splitName(testString);
        return result;
    }

    @Test
    void splitName_확인() {
        String ts = "1,2,3,4,5, 6 , ";
        List<String> expected = new ArrayList<>(
                Arrays.asList("1", "2", "3", "4", "5", " 6 ", " ")
        );
        assertThat(splitNameTest(ts)).isEqualTo(expected);

        String ts2 = "1,";
        List<String> expected2 = new ArrayList<>(
                Arrays.asList("1")
        );
        assertThat(splitNameTest(ts2)).isEqualTo(expected2);
    }

    @Test
    void splitName_에러확인() {
        String ts2 = "asdf, a123456";
        assertThatThrownBy(() -> splitNameTest(ts2))
                .isInstanceOf(IllegalArgumentException.class);

        String ts3 = "";
        assertThatThrownBy(() -> splitNameTest(ts3))
                .isInstanceOf(IllegalArgumentException.class);

        String ts4 = ",1";
        assertThatThrownBy(() -> splitNameTest(ts4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
