package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    void testValidCarName() {
        String carName = "sam";
        CarName name = new CarName(carName);
        assertThat(carName).isEqualTo(name.toString());
    }

    @Test
    public void testInvalidCarName() {
        String invalidCarName = "tooLongName";
        assertThatThrownBy(() -> new CarName(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
