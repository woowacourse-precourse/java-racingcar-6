package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class OutputTest {
    private Output output;
    private List<Car> cars;

    @BeforeEach
    void init() {
        output = new Output();
        cars = new ArrayList<>();
        cars.add(new Car("pobi", 2));
        cars.add(new Car("yung", 1));
    }

    @Test
    void 차_전진_상태() {
        assertThat(output.carSituation(cars.get(0))).contains("pobi : --");
    }

    @Test
    void 우승자_출력() {
        assertThat(output.winner(cars)).contains("pobi");
    }
}