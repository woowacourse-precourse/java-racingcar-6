package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestUtil.setInput;
import static racingcar.util.NameSplitter.split;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
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
    void 중복된_이름_입력() {
        // given
        String input = "자동차1,자동차2,자동차3,자동차1,자동차2";
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
}
