package study;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Utils;

public class UtilsTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        ArrayList<String> result = Utils.splitCarName(input);

        Assertions.assertThat(result).contains("2", "1");
        Assertions.assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        ArrayList<String> result = Utils.splitCarName(input);

        Assertions.assertThat(result).contains("1");
    }
}
