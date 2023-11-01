package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RaceTest {

    @Test
    void 자동차_이름이_정상적으로_입력되지_않은_경우() {
        String nameIsNull = null;
        String nameIsEmpty = "";
        String nameIsBlank = " ";
        String nameIsLong = "looooong";

        assertThatThrownBy(() -> new Race(nameIsNull, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsEmpty, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsBlank, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race(nameIsLong, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차별로_움직인_횟수중_가장큰값_찾는_경우() {
        Car ford = new Car("ford");
        ford.move(5); //전진
        Car bmw = new Car("bmw");
        bmw.move(3); //멈춤

        List<Car> carList = new ArrayList<>();
        carList.add(ford);
        carList.add(bmw);

        int max = 0;
        for (Car car : carList) {
            max = Math.max(max, car.getCount());
        }

        assertThat(ford.getCount()).isEqualTo(1);
        assertThat(bmw.getCount()).isEqualTo(0);

        assertThat(max).isEqualTo(ford.getCount());
    }

    @Test
    void 우승자가_한명일경우_출력하기() {
        List<String> winners = new ArrayList<>();
        winners.add("haeun");

        String join = String.join(", ", winners);
        assertThat(join).isEqualTo("haeun");
    }

    @Test
    void 우승자가_여러명일경우_쉼표를_기준으로_출력하기() {
        List<String> winners = new ArrayList<>();
        winners.add("haeun");
        winners.add("hacoco");

        String join = String.join(", ", winners);
        assertThat(join).isEqualTo("haeun, hacoco");
    }
}
