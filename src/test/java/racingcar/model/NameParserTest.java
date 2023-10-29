package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NameParserTest {

    @Test
    void 쉼표로_자동차_이름_나누기() {
        // Given
        String input = "pobi,woni,jun";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni", "jun");

        // When
        NameParser nameParser = new NameParser();
        List<String> resultCarNames = nameParser.parseName(input);

        // Then
        assertThat(resultCarNames).isNotNull();
        assertThat(resultCarNames).hasSize(3);
        assertThat(resultCarNames).containsExactlyElementsOf(expectedCarNames);
    }
}
