package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.NumberConstant;
import racingcar.model.Cars;

class CarsServiceTest {

    private final String[] carArray = {"벤츠", "아우디", "BMW", "페라리"};

    private CarsService carsService;
    private Cars cars;

    @BeforeEach
    void beforeEach() {
        cars = new Cars(carArray);
        carsService = new CarsService(cars);
    }

    @Test
    @DisplayName("자동차들의 이름 위치 확인 테스트")
    void getCarNamePositionMapTest() {
        LinkedHashMap<String, Integer> expectedResultMap = new LinkedHashMap<>();
        for (String carName : carArray) {
            expectedResultMap.put(carName, 0);
        }
        assertThat(carsService.getCarNamePositionMap()).isEqualTo(expectedResultMap);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "-1,0"})
    @DisplayName("랜덤값에 따른 자동차 위치 증가 테스트")
    void moveCarOrNotTest(int i, int expected) {
        //carService.moveCarorNot의 두번째 인자값이 NumberConstant.Target_Number 보다 크면 첫번째 인자값에 위치한 자동차의 위치를 증가시켜야함
        carsService.moveCarOrNot(0, NumberConstant.TARGET_NUMBER + i);
        assertThat(cars.getCar(0).getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("가장 멀리있는 자동차 위치 확인 테스트")
    void getMaxPoistionTest(int positionAddCount) {
        for (int i = 0; i < positionAddCount; i++) {
            carsService.moveCarOrNot(0, NumberConstant.TARGET_NUMBER);
        }
        assertThat(carsService.getMaxPosition()).isEqualTo(positionAddCount);
    }

    @Test
    @DisplayName("가장 멀리있는 자동차 이름 확인 테스트")
    void getCarNamesAtPositionTest() {
        carsService.moveCarOrNot(0, NumberConstant.TARGET_NUMBER);
        carsService.moveCarOrNot(1, NumberConstant.TARGET_NUMBER);
        List<String> resultCarlist = new ArrayList<>(Arrays.asList("벤츠", "아우디"));
        int maxPosition = carsService.getMaxPosition();
        assertThat(carsService.getCarNamesAtPosition(maxPosition)).isEqualTo(resultCarlist);
    }
}