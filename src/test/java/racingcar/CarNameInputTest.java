package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static racingcar.TestUtil.setInput;
import static racingcar.model.CarName.NAME_DUPLICATED;
import static racingcar.model.CarName.NAME_EMPTY;
import static racingcar.model.CarName.NAME_LENGTH_LIMIT_EXCEEDED;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;


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
        assertThat(cars.getCars()).isEqualTo(expected);
    }

    @Test
    void Car_이름이_5글자를_넘는_경우_예외_발생() {
        // given
        String carName = "메르세데스벤츠";

        // when & then
        assertThatThrownBy(() -> Car.from(carName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_LIMIT_EXCEEDED);
    }

    @Test
    void Car_입력이_없는_경우_예외_발생() {
        // given
        String carName = "";

        // when & then
        assertThatThrownBy(() -> Car.from(carName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_EMPTY);
    }

    @Test
    void Cars_중복된_이름을_입력한_경우_예외_발생() {
        // given
        setInput("자동차1,자동차2,자동차3,자동차1,자동차2");

        // when
        String[] carNames = inputView.askCarNames();
        List<Car> carList = Arrays.stream(carNames).map(Car::from).toList();

        // then
        assertThatThrownBy(() -> Cars.from(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_DUPLICATED);
    }
}
