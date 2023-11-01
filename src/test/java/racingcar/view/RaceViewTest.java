package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.helper.OutputTest;
import racingcar.model.Car;

class RaceViewTest extends OutputTest {
    private List<Car> cars;

    @Test
    void 선발된_우승자_쉼표로_연결하여_출력() {
        // given
        cars = Arrays.asList(new Car("name1"), new Car("name2"), new Car("name3"));

        // when
        RaceView.displayWinner(cars);

        // then
        assertThat(output()).isEqualTo("최종 우승자 : name1,name2,name3");
    }

    @Test
    void 선발된_우승자가_한명() {
        // given
        cars = Arrays.asList(new Car("one"));

        // when
        RaceView.displayWinner(cars);

        // then
        assertThat(output()).isEqualTo("최종 우승자 : one");
    }
}