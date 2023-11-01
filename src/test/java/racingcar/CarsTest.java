package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void toList_메서드가_Cars_객체를_List_객체로_변환() {
        Cars cars = new Cars("woowa,pre,cour,se");
        assertThat(cars.toList()).isInstanceOf(List.class);
    }

    @Test
    void toList_메서드가_올바른_리스트를_반환() {
        Cars cars = new Cars("woowa,pre,cour,se");
        List<Car> carList = cars.toList();
        assertThat(carList).hasSize(4);
        assertThat(carList).extracting(Car::getName)
                .containsExactly("woowa", "pre", "cour", "se");
    }

    @Test
    void toList_메서드가_올바르게_구분자_처리() {
        Cars cars = new Cars("woo..,p*#,cou(r,se)");
        List<Car> carList = cars.toList();
        assertThat(carList).hasSize(4);
        assertThat(carList).extracting(Car::getName)
                .containsExactly("woo..", "p*#", "cou(r", "se)");
    }
}