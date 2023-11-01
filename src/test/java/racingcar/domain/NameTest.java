package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void testValidCarName() {
        String carName = "sam";
        Name name = new Name(carName);
        assertThat(carName).isEqualTo(name.toString());
    }

    @Test
    public void testInvalidCarName() {
        String invalidCarName = "tooLongName";
        assertThatThrownBy(() -> new Name(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
