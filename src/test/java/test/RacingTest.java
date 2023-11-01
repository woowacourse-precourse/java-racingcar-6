package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validation.InputValidation;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;

public class RacingTest {

    @Test
    void 경주_자동차이름_반점_기준으로_구분() {
        String input = "pobi,woni,jun";
        String[] lst = generateRacersFromNames(input);

        Assertions.assertThat(lst).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Test
    public void 이름_5글자_초과_검증() {
        InputValidation inputValidation = new InputValidation();
        String invalidName = "jeonsg";

        Assertions.assertThatThrownBy(() -> inputValidation.isNameValid(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    public void 입력한_횟수_숫자로_변환_불가능_할_때_검증() {
        String input = "abc";
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> inputView.readTryGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 숫자를 입력하세요.");
    }

    @Test
    public void 포지션이_가장_앞선_자동차가_우승() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.goToPosition(); // Car1 1칸 전진
        car2.goToPosition(); // Car2 1칸 전진

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);

        List<String> winners = cars.findWinners();

        Assertions.assertThat(winners).containsExactly("Car1", "Car2");
    }

    private String[] generateRacersFromNames(String input) {
        return input.split(",");
    }

}
