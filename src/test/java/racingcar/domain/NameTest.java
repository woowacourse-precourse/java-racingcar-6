package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @Test
    void create(){
        Name name = new Name("pobi");

        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", ""})
    void createCarWithInvalidNames(String input) {
        assertThatThrownBy(() -> new Name(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
