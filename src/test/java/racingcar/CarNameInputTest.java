package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static racingcar.TestUtil.setInput;
import static racingcar.model.car.CarName.NAME_DUPLICATED;
import static racingcar.model.car.CarName.NAME_LENGTH_LIMIT_EXCEEDED;
import static racingcar.util.Validator.EMPTY;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.view.InputView;

/**
 * docs/README.md <br/><br/> 요구사항 2, 5 <br/><br/> 2-1. 자동차 이름 입력 <br/> 5-2. 이름 입력 예외 발생 <br/>
 */
class CarNameInputTest {

    InputView inputView = new InputView();

    @AfterEach
    void closeInput() {
        Console.close();
    }

    @Test
    void 정상적인_이름_입력() {
        // given
        setInput("자동차1,자동차2,자동차3");

        List<Car> expected = List.of(Car.from("자동차1"), Car.from("자동차2"), Car.from("자동차3"));

        // when
        String[] carNames = inputView.askCarNames();
        List<Car> carList = Arrays.stream(carNames).map(Car::from).toList();
        Cars cars = Cars.from(carList);

        // then
        assertThat(cars.stream().toList()).isEqualTo(expected);
    }

    @Test
    void Car_이름이_5글자를_넘는_경우_예외_발생() {
        // given
        String carName = "메르세데스벤츠";

        // when & then
        assertThatThrownBy(() -> Car.from(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_LIMIT_EXCEEDED);
    }

    @Test
    void Car_입력이_없는_경우_예외_발생() {
        // given
        String carNames = "\n";
        setInput(carNames);

        // when & then
        assertThatThrownBy(() -> inputView.askCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY);
    }

    @Test
    void Cars_중복된_이름을_입력한_경우_예외_발생() {
        // given
        setInput("자동차1,자동차2,자동차3,자동차1,자동차2");

        // when
        String[] carNames = inputView.askCarNames();
        List<Car> carList = Arrays.stream(carNames).map(Car::from).toList();

        // then
        assertThatThrownBy(() -> Cars.from(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_DUPLICATED);
    }
}
