package racingcar.converter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringToAttemptCountConverterTest {

    private StringToAttemptCountConverter converter = new StringToAttemptCountConverter();

    @Test
    void execute() {
        String validValue = "5";
        int result = converter.execute(validValue);
        assertThat(result).isEqualTo(5);
    }
}