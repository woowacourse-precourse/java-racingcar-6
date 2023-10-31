package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class GameServiceTest {

    @Test
    void createTryCountTestSuccess() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 테스트용 입력 설정

        assertThat(Integer.parseInt(input)).isEqualTo(5);
    }

    @Test
    void createTryCountTestFail() {
        String input = "sdfd";
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 테스트용 입력 설정

        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Integer.parseInt(input)
        );
    }

    @Test
    void shouldIncreaseStepCountTest() {
        int randomNumber = 5;
        boolean result = randomNumber >= 4;

        assertThat(result).isEqualTo(true);
    }

    @Test
    void printFinalWinnerTest() {
        int maxStepCount = 2;
        String winner = "";

        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("woni"));

        carList.get(0).increaseStepCount();
        carList.get(0).increaseStepCount();
        carList.get(1).increaseStepCount();

        for (var car : carList) {
            int stepCount = car.getStepCount();
            if (maxStepCount == stepCount) {
                winner = car.getName();
            }
        }

        assertThat(winner).isEqualTo("pobi");
    }

}