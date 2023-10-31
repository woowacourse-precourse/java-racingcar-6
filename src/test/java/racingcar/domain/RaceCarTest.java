package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceCarTest {
    private RaceCar raceCar;

    @BeforeEach
    void setUp() {
        raceCar = new RaceCar(Arrays.asList("Jeon", "Jeong", "Won"));
    }

    @Test
    void 전진() {
        raceCar.forward(Arrays.asList(1, 2, 4));
        assertThat(raceCar.moveDistance).isEqualTo(Arrays.asList("", "", "-"));
    }
}