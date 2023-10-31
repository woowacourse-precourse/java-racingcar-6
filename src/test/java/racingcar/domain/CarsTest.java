package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars();
    }

    @Test
    void 자동차이름_확인() {

        ArrayList<String> carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add("jung");
        carNameList.add("min");
        cars.setCarNameList(carNameList);

        assertEquals(carNameList, cars.getCarNameList());
    }

    @Test
    void 자동차전진상황_확인() {

        ArrayList<List<String>> carProgress = new ArrayList<>();
        carProgress.add(List.of("--"));
        carProgress.add(List.of("---"));
        cars.setCarProgress(carProgress);

        assertEquals(carProgress, cars.getCarProgress());
    }
}