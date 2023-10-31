package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultStringifierTest {
    private Cars testCars;

    @BeforeEach
    void setUp() {
        String testCarName1 = "pobi";
        String testCarName2 = "woni";
        Car testCar1 = new Car(testCarName1);
        Car testCar2 = new Car(testCarName2);
        testCars = new Cars(new ArrayList<>(List.of(testCar1, testCar2)));
    }

    @Test
    void 자동차_이동_과정_문자열_변환_테스트() {
        String result = ResultStringifier.generateProgressString(testCars.getCars());

        assertThat(result).isEqualTo("pobi : \nwoni : \n");
    }

    @Test
    void 우승자_문자열_변환_테스트() {
        List<String> winnerNames = testCars.findWinners().stream().map(Car::getName).toList();
        String result = ResultStringifier.generateWinnersString(winnerNames);

        assertThat(result).isEqualTo("pobi,woni");
    }
}