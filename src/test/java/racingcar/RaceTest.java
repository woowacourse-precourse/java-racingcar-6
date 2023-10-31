package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class RaceTest {
    private Cars cars;
    private String input = "자동차1,자동차2,자동차3,자동차4";
    @BeforeEach
    void beforeEach() {
        cars = new Cars();
        cars.generateCars(input);
    }


}
