package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NCarsTest {
    String givenNames = "pobi,woni";
    List<String> names = Arrays.stream(givenNames.split(",")).toList();
    NCars nCars;

    @BeforeEach
    void setUp() {
        nCars = NCars.applyNames(names);
    }

    @Test
    @DisplayName("자동차들에 이름들을 부여할 수 있다.")
    public void carNameApplyTest() {
        String givenNames = "pobi,woni";
        List<String> names = Arrays.stream(givenNames.split(",")).toList();
        nCars = NCars.applyNames(names);
        List<String> targetNames = Arrays.stream(givenNames.split(",")).toList();
        assertThat(nCars.getNamesForTest()).isEqualTo(targetNames);
    }

    @Test
    @DisplayName("차량들을 한번 이동시킨다.")
    public void moveCarsByOneTimeNumberTest() {
        List<Integer> carsPosition = nCars.moveCars();
        Integer numberOfCars = names.size();
        assertThat(carsPosition.size()).isEqualTo(numberOfCars);
    }

    @Test
    @DisplayName("차량들을 입력한만큼 이동시킨다.")
    public void moveCarsByGivenNumberTest() {
        Integer round = 5;
        List<List<Integer>> carsPosition = nCars.moveCarsRepeatedByRound(round);
        assertThat(carsPosition.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("차량들 개별 이동 후 출력")
    public void showCarsPositionAndNameAfterEachRoundTest() {
        List<Car> carList = new ArrayList<>();

        String nameOne = "cho";
        Car carOne = Car.applyName(nameOne);
        carOne.changePosition(CarMovementStatus.MOVING_FORWARD );
        carOne.changePosition(CarMovementStatus.MOVING_FORWARD );

        String nameTwo = "sung";
        Car carTwo = Car.applyName(nameTwo);
        carTwo.changePosition(CarMovementStatus.MOVING_FORWARD );
        carTwo.changePosition(CarMovementStatus.MOVING_FORWARD );

        carList.add(carOne);
        carList.add(carTwo);
        nCars = new NCars(carList);

        List<String> message = new ArrayList<>(Arrays.asList("cho : --", "sung : --"));
        assertThat(nCars.getSingleRoundResult()).isEqualTo(message);
    }

    @Test
    @DisplayName("우승자 이름 출력")
    public void showWinnerNameAfterGameTest() {
        List<Car> carList = new ArrayList<>();

        String nameOne = "cho";
        Car carOne = Car.applyName(nameOne);
        carOne.changePosition(CarMovementStatus.STOP);
        carOne.changePosition(CarMovementStatus.MOVING_FORWARD );

        String nameTwo = "sung";
        Car carTwo = Car.applyName(nameTwo);
        carTwo.changePosition(CarMovementStatus.MOVING_FORWARD );
        carTwo.changePosition(CarMovementStatus.MOVING_FORWARD );

        String nameThree = "Loo";
        Car carThree = Car.applyName(nameThree);
        carThree.changePosition(CarMovementStatus.MOVING_FORWARD );
        carThree.changePosition(CarMovementStatus.MOVING_FORWARD );

        carList.add(carOne);
        carList.add(carTwo);
        carList.add(carThree);

        nCars = new NCars(carList);

        List<String> message = new ArrayList<>(Arrays.asList("sung", "Loo"));
        assertThat(nCars.getWinnerName()).isEqualTo(message);
    }
}
