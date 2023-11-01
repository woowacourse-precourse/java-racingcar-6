package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @Test
    void getMaxMovingCnt_리스트에서_movingCnt가_가장_큰_수_반환() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("apple", 9));
        cars.add(new Car("banana", 10));
        cars.add(new Car("orange", 10));
        //when
        int maxMovingCnt = outputView.getMaxMovingCnt(cars);
        //then
        assertThat(maxMovingCnt).isEqualTo(10);
    }

    @Test
    void getWinner_우승자가_여러명_일때_모두_반환() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("apple", 9));
        cars.add(new Car("banana", 10));
        cars.add(new Car("orange", 10));
        assertThat(outputView.getWinner(cars)).isEqualTo("banana,orange");
    }
}