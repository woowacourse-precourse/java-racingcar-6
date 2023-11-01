package racingcar.model.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarRaceServiceTest {

    private static final CarRaceService cs = new CarRaceService();

    static {
        cs.addCars("pobi");
    }
    @Test
    void addCars() {
        cs.addCars("woni");
        assertThat(cs.getCarsName()
                .get(1))
                .isEqualTo("woni");
    }

    @Test
    void getCarsName() {
        assertThat(cs.getCarsName()
                .get(0))
                .isEqualTo("pobi");
    }

    @Test
    void getCarsLocation() {
        assertThat(cs.getCarsLocation().get(0))
                .isZero();
    }

    @Test
    void getWinnersName() {
        assertThat(cs.getWinnersName()
                .get(0))
                .isEqualTo("pobi");
    }
}