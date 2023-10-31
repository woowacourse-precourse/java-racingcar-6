package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.FindWinnerController;
import racingcar.model.Car;
import racingcar.model.Name;

public class FindWinnerControllerTest {

    private final static int OK_NUMBER = 4;
    private final static int NO_NUMBER = 1;
    private FindWinnerController findWinnerController;
    private List<Car> carList;

    @BeforeEach
    public void init() {

        Car car1 = new Car(new Name("a"));
        Car car2 = new Car(new Name("b"));
        Car car3 = new Car(new Name("c"));

        carList = new ArrayList<>(List.of(car1, car2, car3));
    }

    private void moveTwoStep(Car car) {
        for (int i = 0; i < 2; i++) {
            car.addPosition(OK_NUMBER);
        }
    }

    @Test
    @DisplayName("2번 이동한 a자동차가 우승자로 반환된다.")
    void findWinnerControllerTest() throws Exception {
        //given
        moveTwoStep(carList.get(0));
        carList.get(1).addPosition(OK_NUMBER);
        carList.get(2).addPosition(NO_NUMBER);

        //when
        findWinnerController = new FindWinnerController(carList);
        List<String> winners = findWinnerController.getWinners();

        //then
        assertThat("a").isEqualTo(winners.get(0));
    }


    @Test
    @DisplayName("2번 이동한 a,b자동차가 우승자로 반환된다.")
    void findWinnerControllerTest2() throws Exception {

        //given
        moveTwoStep(carList.get(0));
        moveTwoStep(carList.get(1));
        carList.get(2).addPosition(NO_NUMBER);

        //when
        findWinnerController = new FindWinnerController(carList);
        List<String> winners = findWinnerController.getWinners();

        //then
        assertThat("a").isEqualTo(winners.get(0));
        assertThat("b").isEqualTo(winners.get(1));
    }

    @Test
    @DisplayName("2번 이동한 a,b,c자동차가 우승자로 반환된다.")
    void findWinnerControllerTest3() throws Exception {

        //given
        moveTwoStep(carList.get(0));
        moveTwoStep(carList.get(1));
        moveTwoStep(carList.get(2));
        carList.get(2).addPosition(NO_NUMBER);

        //when
        findWinnerController = new FindWinnerController(carList);
        List<String> winners = findWinnerController.getWinners();

        //then
        assertThat("a").isEqualTo(winners.get(0));
        assertThat("b").isEqualTo(winners.get(1));
        assertThat("c").isEqualTo(winners.get(2));
    }
}
