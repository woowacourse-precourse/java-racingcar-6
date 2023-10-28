package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;

class CarNameInputTest {

    Race race = new Race();
    InputView inputView = new InputView();

    @Test
    void 정상적인_이름_입력() {
        // given
        String actual = "자동차1,자동차2,자동차3";
        setInput(actual);

        Set<Car> expected = Set.of(
                new Car("자동차1"),
                new Car("자동차2"),
                new Car("자동차3")
        );
        // when
        String[] carNames = inputView.askCarName().split(",");
        for (String carName : carNames) {
            race.add(new Car(carName));
        }
        // then
        assertThat(race.getCars()).isEqualTo(expected);
    }

    @Test
    void 중복된_이름_입력() {
        // given
        String actual = "자동차1,자동차2,자동차1,자동차2";
        setInput(actual);

        Set<Car> expected = Set.of(
                new Car("자동차1"),
                new Car("자동차2")
        );
        // when
        String[] carNames = inputView.askCarName().split(",");
        for (String carName : carNames) {
            race.add(new Car(carName));
        }
        // then
        assertThat(race.getCars()).isEqualTo(expected);
    }

    void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
