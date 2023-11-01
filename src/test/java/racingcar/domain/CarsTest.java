package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars("sam,dobi,peter");
    }

    @Test
    void testCarListCreation() {
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void testRace() {
        int[] numbers = {4, 3, 5};
        cars.race(numbers);

        assertThat(cars.getPositions().trim()).isEqualTo("sam : -\ndobi : \npeter : -");
    }

    @Test
    void testGetWinners() {
        int[] numbers = {4, 3, 5};
        cars.race(numbers);

        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactly("sam", "peter");
    }

    @Test
    void testGetMaxPosition() {
        int[] numbers = {4, 3, 5};
        cars.race(numbers);

        int maxPosition = cars.getMaxPosition();
        assertThat(maxPosition).isEqualTo(1);
    }

}
