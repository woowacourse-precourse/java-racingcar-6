package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.TestCommon;

class CarsTest extends TestCommon {
    private Cars cars;

    private List<Car> makeCars(String makeCarsName) {
        return cars.registerCar(makeCarsName).getCars();
    }

    private List<Integer> changeStringToIntegerArray(String stringValue) {
        List<Integer> integers = new ArrayList<>();

        for (String value : stringValue.split(",")) {
            integers.add(Integer.parseInt(value));
        }

        return integers;
    }

    private void moveCar(Integer moveCount, Car moveCar) {
        for (int j = 0; j < moveCount; j++) {
            moveCar.move();
        }
    }

    @BeforeEach
    void testInit() {
        cars = new Cars();
    }

    @ParameterizedTest
    @CsvSource(value = {"2:pobi,woni", "3:pobi,woni,jun"}, delimiter = ':')
    void 차이름을_넘겼을_경우_차객체_리스트가_생성_되는지_확인한다(Integer makedCarsCount, String makeCarsName) {
        List<Car> makedCars = makeCars(makeCarsName);

        assertThat(makedCars.size()).isEqualTo(makedCarsCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni:3,5:woni", "pobi,woni,jun:6,3,6:pobi,jun"}, delimiter = ':')
    void 생성한_차중에_제일_많이_이동한_차를_정확히_구해내는지_테스트_한다(String makeCarsName, String moveCountsString, String winnersName) {
        List<Car> expectedWinners = new Cars().registerCar(winnersName).getCars();
        List<Integer> moveCounts = changeStringToIntegerArray(moveCountsString);
        List<Car> makedCars = makeCars(makeCarsName);
        for (int i = 0; i < makedCars.size(); i++) {
            moveCar(moveCounts.get(i), makedCars.get(i));
        }

        List<Car> actualWinners = cars.getMaxMoveCars();

        for (int i = 0; i < expectedWinners.size(); i++) {
            String expectedCarName = expectedWinners.get(i).getName();
            String actualCarName = actualWinners.get(i).getName();
            assertThat(expectedCarName).isEqualTo(actualCarName);
        }
    }
}