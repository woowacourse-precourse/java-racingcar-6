package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;


public class CarsTest {
    Car pobi = new Car("pobi");
    Car woni = new Car("woni");
    Car jun = new Car("jun");

    @Test
    void 공동우승자를_찾을_수_있는지_테스트() {
        //given
        pobi.move(4);
        woni.move(5);

        Cars cars = new Cars(List.of(pobi, woni, jun));
        //when
        List<String> winner = cars.findWinners();
        //then
        assertThat(winner).isEqualTo(List.of("pobi", "woni"));
    }

    @Test
    void 단독우승자를_찾을_수_있는지_테스트() {
        //given
        pobi.move(4);
        woni.move(5);
        woni.move(5);
        woni.move(6);
        jun.move(4);
        jun.move(2);

        Cars cars = new Cars(List.of(pobi, woni, jun));
        //when
        List<String> winner = cars.findWinners();
        //then
        assertThat(winner).isEqualTo(List.of("woni"));
    }

    @Test
    void 등록된_자동차가_없을_때_예외() {
        Cars cars = new Cars(List.of());
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> cars.findWinners());
        assertThat(e.getMessage()).isEqualTo("차량 리스트가 비었습니다.");
    }

}
