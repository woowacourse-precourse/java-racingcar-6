package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @DisplayName("자동차들 생성")
    @ParameterizedTest
    @ValueSource(strings = {"test1,test2", "test1,test2,test3"})
    void create(String carNames) {
        //when
        Cars cars = new Cars(carNames);

        //then
        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차들 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"test1,test1", "test1,test2,test2", "test1,test2,test1"})
    void createFail(String carNames) {
        assertThatThrownBy(() -> new Cars(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("단독 우승자")
    @Test
    void singleWinner() {
        // given
        String name1 = "test1";
        String name2 = "test2";

        Cars cars = new Cars(name1);

        Car winnerCar = new Car(name2);
        while (winnerCar.getPosition() == 0) {
            winnerCar.move();
        }

        cars.getCarList().add(winnerCar);
        // when
        cars.handleWinnerResult();

        // then
        assertThat(cars.getWinnerList().toString()).doesNotContain(name1);
    }

    @DisplayName("공동 우승자")
    @Test
    void multipleWinner() {
        // given
        String name1 = "test1";
        String name2 = "test2";
        String name3 = "test3";

        Cars cars = new Cars(name1);

        Car winnerCar1 = new Car(name2);
        while (winnerCar1.getPosition() == 0) {
            winnerCar1.move();
        }

        cars.getCarList().add(winnerCar1);

        Car winnerCar2 = new Car(name3);
        while (winnerCar2.getPosition() == 0) {
            winnerCar2.move();
        }

        cars.getCarList().add(winnerCar2);
        // when
        cars.handleWinnerResult();

        // then
        assertThat(cars.getWinnerList().toString()).contains(name2, name3);
    }
}
