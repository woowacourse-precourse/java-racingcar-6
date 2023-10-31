package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
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
        System.out.println("raceCar.names = " + raceCar.names);
        raceCar.forward(Arrays.asList(1, 2, 4));
        assertThat(raceCar.moveDistance).isEqualTo(Arrays.asList("", "", "-"));
    }

    @Test
    void 단독_우승() {
        raceCar.moveDistance = Arrays.asList("-", "--", "---");
        assertThat(raceCar.winner()).isEqualTo("Won");
    }

    @Test
    void 공동_우승() {
        raceCar.moveDistance = Arrays.asList("-", "---", "---");
        assertThat(raceCar.winner()).isEqualTo("Jeong, Won");
    }
}