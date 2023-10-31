package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    Cars cars;

    @BeforeEach
    public void setUpCars() {
        cars = new Cars();
    }

    @ParameterizedTest
    @CsvSource(value = {
        "'seori,snow,joy'",
        "'seori, snow, joy'",
        "'seori ,snow ,joy '",
        "'seori, sn ow, jo y'"
    })
    void 이름들을_올바르게_입력하는_경우(String input) {
        cars.settingNames(input);
        assertEquals(cars.getCarList().size(), 3);
        assertEquals(cars.getCarList().get(0).getName(), "seori");
        assertEquals(cars.getCarList().get(1).getName(), "snow");
        assertEquals(cars.getCarList().get(2).getName(), "joy");
    }


    @ParameterizedTest
    @CsvSource(value = {
        "'seori,seori,snow,joy', 동일한 이름으로 경주 게임을 진행할 수 없습니다.",
        "'snow,sn ow,j oy,joy',동일한 이름으로 경주 게임을 진행할 수 없습니다.",
        "meow,'이름을 쉼표(,)로 구분해야 합니다. 또한, 최소 2대 이상의 자동차가 필요합니다.'"
    })
    void 이름들을_잘못_입력하는_경우(String input, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> cars.settingNames(input));
        assertEquals(e.getMessage(), exceptionMessage);
    }
}