package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceControllerTest {

    RaceController raceController = new RaceController();

    @Test
    @DisplayName("자동차 이름에 따라 객체 초기화")
    void initializeCars() {
        String inputCars = "pobi,woni,jun";
        ArrayList<Car> cars = new ArrayList<>();
        raceController.initializeCars(cars, inputCars);

        assertThat(cars).size().isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("랜덤 수가 4 이상일 경우 자동차 하나 전진")
    void moveCarIfRandomNumberIsFourOrHigher() {
        Car car = new Car("pobi");
        int randomNum = raceController.moveCarIfRandomNumberIsFourOrHigher(car);

        if(randomNum >= 4) {
            assertThat(car.getProgress()).isEqualTo("-");
        }
        else{
            assertThat(car.getProgress()).isEqualTo("");
        }
    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinner() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        raceController.modifyCar(cars.get(0));

        String winner = raceController.findWinner(cars, 1);
        assertThat(winner).isEqualTo("pobi");
    }
}