package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.Error;

class CarsTest {

    private final String[] carArray = {"벤츠", "아우디", "BMW", "페라리"};

    private Cars cars;

    @BeforeEach
    void beforeEach() {
        cars = new Cars(carArray);
    }

    @Test
    @DisplayName("중복된 자동차의 이름 확인 테스트")
    void 중복된_자동차_이름_확인() {
        // given
        String[] stringArray = {"A", "A", "B"};

        // when & then
        assertThatThrownBy(() -> new Cars(stringArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.DUPLICATE_CAR_NAME_ERROR.getMessage());
    }

    @Test
    @DisplayName("자동차들의 이름 위치 확인 테스트")
    void getCarNamePositionMapTest() {
        //given
        LinkedHashMap<String, Integer> expectedResultMap = new LinkedHashMap<>();
        for (String carName : carArray) {
            expectedResultMap.put(carName, 0);
        }

        //when
        LinkedHashMap<String, Integer> resultMap = cars.getCarNamePositionMap();

        //then
        assertThat(resultMap).isEqualTo(expectedResultMap);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("가장 멀리있는 자동차 위치 확인 테스트")
    void getMaxPoistionTest(int positionAddCount) {
        //given
        for (int i = 0; i < positionAddCount; i++) {
            cars.moveCar(0);
        }

        //when
        int maxPosition = cars.getMaxPosition();

        //then
        assertThat(maxPosition).isEqualTo(positionAddCount);
    }

    @Test
    @DisplayName("특정 위치에 있는 자동차들의 이름 확인 테스트")
    void getCarNamesAtPositionTest() {
        //given
        cars.moveCar(0);
        cars.moveCar(1);
        List<String> expectedCarListAtPositionZero = new ArrayList<>(Arrays.asList("BMW", "페라리"));
        List<String> expectedCarListAtPositionOne = new ArrayList<>(Arrays.asList("벤츠", "아우디"));

        //when
        List<String> carListAtPositionZero = cars.getCarNamesAtPosition(0);
        List<String> carListAtPositionOne = cars.getCarNamesAtPosition(1);

        //then
        assertThat(carListAtPositionZero).isEqualTo(expectedCarListAtPositionZero);
        assertThat(carListAtPositionOne).isEqualTo(expectedCarListAtPositionOne);
    }
}