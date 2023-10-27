package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void saveCars() {
        List<Car> list = new ArrayList<>();
        Cars cars = new Cars(list);
        assertThatThrownBy(() -> cars.saveCars("asdf,asdfasdf"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}