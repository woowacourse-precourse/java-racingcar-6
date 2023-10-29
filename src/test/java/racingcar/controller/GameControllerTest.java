package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameControllerTest {

    GameController controller = new GameController();
    CarList carList = CarList.getInstance();

    @BeforeEach
    void before() {
        carList.getCars().clear();
    }

    @DisplayName("쉼표로 구분된 자동차 이름을 받아 배열로 정리 하는 기능 테스트")
    @ValueSource(strings = "terry,tobi,kdy,ydk")
    @ParameterizedTest
    void nameToListTest(String value) {
        //given
        controller.carsToList(value);

        //when
        List<Car> cars = carList.getCars();
        String carName1 = cars.get(0).getCarName();
        int carLevel = cars.get(0).getLevel();
        String carName2 = cars.get(2).getCarName();

        //then
        assertThat(cars.size()).isEqualTo(4);
        assertThat(carName1).isEqualTo("terry");
        assertThat(carName2).isEqualTo("kdy");
        assertThat(carLevel).isEqualTo(0);
    }

    @DisplayName("우승자를 찾기위한 Level의 최대값 찾기 기능 테스트")
    @Test
    void maxOfCarListTest() {
        //given
        controller.carsToList("terry,tobi,kdy,ydk");
        List<Car> cars = carList.getCars();
        cars.get(0).setLevelAndLog(cars.get(0));
        cars.get(0).setLevelAndLog(cars.get(0));
        cars.get(2).setLevelAndLog(cars.get(2));

        //when
        int maxNumber = controller.maxNum(cars);

        //then
        assertThat(maxNumber).isEqualTo(2);
    }
}