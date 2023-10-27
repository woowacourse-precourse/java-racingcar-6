package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
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
    public void init(){

        Car car1 = new Car(new Name("a"));
        Car car2 = new Car(new Name("b"));
        Car car3 = new Car(new Name("c"));

        carList = new ArrayList<>(List.of(car1,car2,car3));
    }

    @Test
    @DisplayName("a자동차, b자동차, c자동차 순으로 정렬된 배열이 반환된다.")
    void findWinnerControllerTest() throws Exception{

        //given
        carList.get(0).addAdvances(OK_NUMBER);
        carList.get(0).addAdvances(OK_NUMBER);
        carList.get(1).addAdvances(OK_NUMBER);
        carList.get(2).addAdvances(NO_NUMBER);

        //when
        findWinnerController = new FindWinnerController(carList);
        List<String> winners = findWinnerController.getWinners();

        //then
        assertThat("a").isEqualTo(winners.get(0));
        assertThat("b").isEqualTo(winners.get(1));
        assertThat("c").isEqualTo(winners.get(2));
    }
}
