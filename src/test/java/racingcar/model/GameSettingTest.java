package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameSettingTest {

    @Test
    void getCarsTest() {
        Cars cars = new Cars("isaac,han");
        assertThat(cars.getCars().get(0).getName()).isEqualTo("isaac");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("han");
    }

    @Test
    void getAttemptsTest() {
        int input = 5;
        Attempts attempts = new Attempts(input);
        assertThat(attempts.getNumber()).isEqualTo(input);
    }
}