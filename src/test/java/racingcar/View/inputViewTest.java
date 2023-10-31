package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.StringToList.stringToList;

import org.junit.jupiter.api.Test;
import racingcar.Application;

public class inputViewTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";

        String[] result = stringToList(input);
        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

}
