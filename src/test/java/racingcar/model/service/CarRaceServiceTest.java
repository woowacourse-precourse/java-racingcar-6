package racingcar.model.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarRaceServiceTest {

    private static final CarRaceService cs = new CarRaceService();

    @Test
    void addCars() {
        cs.addCars("pobi,woni");
        assertThat(cs.getCarsName().stream().map(() -> to
    }

    @Test
    void moveCars() {
    }

    @Test
    void getCarsName() {
    }

    @Test
    void getCarsLocation() {
    }

    @Test
    void getWinnersName() {
    }
}