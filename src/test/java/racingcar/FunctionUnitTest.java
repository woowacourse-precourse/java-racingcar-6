package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winner;
import racingcar.util.Validator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class FunctionUnitTest {

    Cars cars = new Cars();
    private final String RAW_CAR_NAME = "pobi,woni,jun";
    private final int TRY_COUNT = 5;

    @Test
    void 자동차_이름_저장() {
        List<Car> carList = cars.setPlayer(RAW_CAR_NAME);
        carList.forEach(car -> System.out.println(car.getCarName()));

        Assertions.assertEquals(3, carList.size());
    }

    @Test
    void 자동차_전진() {
        List<Car> carList = cars.setPlayer(RAW_CAR_NAME);
        carList = cars.raceCars(carList);

        carList.forEach(car -> System.out.println(car.getCarName() + " " + car.getMove()));
    }

    @Test
    void 경주_실행결과_출력() {
        List<Car> carList = cars.setPlayer(RAW_CAR_NAME);
        GameController gameController = new GameController();

        OutputView.executeResult(carList);
    }

    @Test
    void 우승자_선정() {
        Winner winner = new Winner();

        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("woni", 4);
        Car car3 = new Car("jun", 1);

        List<Car> testCarList = List.of(car1, car2, car3);

        String soloWinner = winner.determineWinner(testCarList).get(0);

        assertThat(soloWinner).isEqualTo("woni");
    }

    @Test
    void 공동_우승자_선정() {
        Winner winner = new Winner();

        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("woni", 3);
        Car car3 = new Car("jun", 1);

        List<Car> testCarList = List.of(car1, car2, car3);

        List<String> jointWinner = winner.determineWinner(testCarList);

        OutputView.printWinner(jointWinner);
    }

    @Test
    void 사용자_자동차_이름_입력_검증() {
        String name = "pobi, jun";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.checkName(name))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_아닌수_입력_검증() {
        String rawTryCount = "bb";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.checkTryCount(rawTryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_1미만_숫자_입력_검증() {
        String rawTryCount = "0";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.checkTryCount(rawTryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
