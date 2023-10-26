package car;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Cars;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 우승자_목록_반환() {
        String[] carNames = {"a","b","c","d"};
        int[] distanceArr = {2,4,1,0};

        Cars cars = new Cars();
        cars.fill(carNames,distanceArr);
        String winner = cars.getWinners();

        assertThat(winner).isEqualTo("b");
    }
}
