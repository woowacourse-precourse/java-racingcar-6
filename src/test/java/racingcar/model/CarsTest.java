package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class CarsTest {

    @Test
    @DisplayName("Cars_객체_생성")
    void createCars() {
        String[] input = {"test", "test2", "test3"};

        Cars testCars = new Cars(input);

        assertThat(testCars.getCars())
                .hasSize(input.length);
    }
}
