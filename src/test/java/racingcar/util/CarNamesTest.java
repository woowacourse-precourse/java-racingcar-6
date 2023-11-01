package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNamesTest {

    @Test
    void hasNotNUllEmpty() {
        assertThatThrownBy(() -> new CarNames(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new CarNames(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void extractCarNames() {
        CarNames carNames = new CarNames("Car1, Car2, Car3 ");
        List<String> extractedNames = carNames.extractCarNames();

        assertThat(extractedNames).containsExactly("Car1", "Car2", "Car3");
    }
}