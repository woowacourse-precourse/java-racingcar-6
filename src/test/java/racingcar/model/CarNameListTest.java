package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameListTest {
    CarNameList carNameList;
    List<String> carList;

    @BeforeEach
    void reset() {
        carList = new ArrayList<>();
        carList.add("blur");
    }

    @Test
    @DisplayName("CarNameList 테스트")
    void testCarNameList() {
        carNameList = CarNameList.createCar(carList);

        assertThat(carNameList.countCar()).isEqualTo(carList.size());
    }

    @Test
    @DisplayName("CarNameList toString() 테스트")
    void testCarNameListToString() {
        carNameList = CarNameList.createCar(carList);

        assertThat(carNameList.toString(0)).isEqualTo("blur");
    }
}