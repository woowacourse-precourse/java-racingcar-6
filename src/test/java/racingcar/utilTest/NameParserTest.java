package racingcar.utilTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.util.NameParser;

public class NameParserTest {
    private NameParser nameParser;

    @BeforeEach
    void setUp() {
        nameParser = new NameParser();
    }

    @Test
    void testParseNameWithCommaSeparatedString() {
        String nameString = "John,Doe,Alice";

        List<String> nameList = nameParser.parseName(nameString);

        assertThat(nameList).containsExactly("John", "Doe", "Alice");
    }

    @Test
    void testParseNameWithException() {
        String nameString = "John Doe Alice";

        assertThrows(IllegalArgumentException.class, () -> {
            nameParser.parseName(nameString);
        });
    }
}