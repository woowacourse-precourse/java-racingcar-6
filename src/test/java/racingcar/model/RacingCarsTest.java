package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingCarsTest {

    private String givenNames = "pobi,woni";
    private List<String> names;
    private Cars nCars;

    @BeforeEach
    void setUp() {
        names = Arrays.stream(givenNames.split(",")).collect(Collectors.toList());
        nCars = new RacingCars();
        nCars.applyNames(names);
    }

    @Test
    @DisplayName("자동차들에 이름들을 부여할 수 있다.")
    void carNameApplyTest() {
        Cars testCars = new RacingCars();
        testCars.applyNames(names);
        assertThat(testCars.getNamesForTest()).isEqualTo(names);
    }

    @Test
    @DisplayName("차량들을 한번 이동시킨다.")
    void moveCarsByOneTimeNumberTest() {
        List<Integer> carsPosition = nCars.moveCars();
        assertThat(carsPosition.size()).isEqualTo(names.size());
    }

    @Test
    @DisplayName("차량들을 입력한만큼 이동시킨다.")
    void moveCarsByGivenNumberTest() {
        int round = 5;
        List<List<Integer>> carsPosition = nCars.moveCarsRepeatedByRound(round);
        assertThat(carsPosition.size()).isEqualTo(round);
    }

    @Test
    @DisplayName("차량들 개별 이동 후 출력")
    void showCarsPositionAndNameAfterEachRoundTest() {
        List<Car> carList = initializeCarListWithPositions("cho", "sung");
        nCars = new RacingCars(carList);
        List<String> expectedMessages = Arrays.asList("cho : --", "sung : --");
        assertThat(nCars.getSingleRoundResult()).isEqualTo(expectedMessages);
    }

    @Test
    @DisplayName("우승자 이름 출력")
    void showWinnerNameAfterGameTest() {
        List<Car> carList = initializeCarListWithPositions("cho", "sung", "Hy");
        carList.get(1).changePosition(CarMovementStatus.MOVING_FORWARD);
        carList.get(2).changePosition(CarMovementStatus.MOVING_FORWARD);

        nCars = new RacingCars(carList);
        List<String> expectedWinners = Arrays.asList("sung", "Hy");
        assertThat(nCars.getWinnerName()).isEqualTo(expectedWinners);
    }

    private List<Car> initializeCarListWithPositions(String... names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            Car car = Car.applyName(name);
            car.changePosition(CarMovementStatus.MOVING_FORWARD);
            car.changePosition(CarMovementStatus.MOVING_FORWARD);
            carList.add(car);
        }
        return carList;
    }
}