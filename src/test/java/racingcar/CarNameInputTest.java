package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.TestUtil.setInput;
import static racingcar.message.ExceptionMessage.DUPLICATE_NAME;
import static racingcar.message.ExceptionMessage.LENGTH_LIMIT_EXCEEDED;
import static racingcar.util.NameSplitter.split;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

class CarNameInputTest {

    InputView inputView = new InputView();

    @Test
    void 정상적인_이름_입력() {
        // given
        String input = "자동차1,자동차2,자동차3";
        setInput(input);

        List<Car> expected = List.of(
                Car.from("자동차1"),
                Car.from("자동차2"),
                Car.from("자동차3")
        );
        // when
        String[] carNames = split(inputView.askCarNames());
        List<Car> carList = Arrays.stream(carNames).map(Car::from).toList();

        // then
        assertThat(carList).isEqualTo(expected);
    }

    @Test
    void 이름이_5글자를_넘는_경우_예외_발생() {
        // given
        String input = "메르세데스벤츠";
        setInput(input);

        // when
        String carName = inputView.askCarNames();

        // then
        assertThatThrownBy(() -> Car.from(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_LIMIT_EXCEEDED.getMessage());
    }

    @Test
    void 중복된_이름을_입력한_경우_예외_발생() {
        // given
        String input = "자동차1,자동차2,자동차3,자동차1,자동차2";
        setInput(input);

        // when
        String[] carNames = split(inputView.askCarNames());
        List<Car> carList = Arrays.stream(carNames).map(Car::from).toList();

        // then
        assertThatThrownBy(() -> Cars.from(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NAME.getMessage());
    }
}
