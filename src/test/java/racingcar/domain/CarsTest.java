package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 중복_체크(){
        //given
        String input = "유정,유정,유정님";

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Cars(input);
        });
    }

    @Test
    void 공동_우승(){
        //given
        String name1 = "유정";
        String name2 = "권유정";

        Cars cars = new Cars(name1 + "," + name2);
        // when
        List<String> winners = cars.getWinners();
        // then
        assertThat(winners).containsExactly(name1, name2);
    }

    @Test
    void 한명_우승(){
        //given
        String name1 = "유정";
        String name2 = "권유정";

        Cars cars = new Cars(name1 + "," + name2);
        cars.getCars().get(0).move(5);

        // when
        List<String> winners = cars.getWinners();
        // then
        assertThat(winners).containsExactly(name1);
    }
}