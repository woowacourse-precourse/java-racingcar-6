package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NameSplitTest {

    @Test
    void 자동차_이름_가져오기() {
        // Given
        List<String> inputList = Arrays.asList("pobi : -", "woni : ---", "crong : --");
        String delimiter = " :";

        // When
        List<String> result = NameSplit.splitCarList(inputList, delimiter);

        // Then
        List<String> expected = Arrays.asList("pobi", "woni", "crong");
        assertThat(result).isEqualTo(expected);
    }
}
