package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @DisplayName("자동차 리스트를 반환하면 불변 리스트로 반환해야 한다.")
    @Test
    void 자동차_불변_리스트_반환_테스트() {
        //given
        Cars cars = new Cars("jun,seo,park");

        //when
        List<Car> unmodifiableList = cars.getCars();

        //then
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.add(new Car("test")));
        assertThat(unmodifiableList.size()).isEqualTo(3);
    }

    @DisplayName("인덱스를 전달하면 그에 맞는 자동차를 반환해야 한다.")
    @Test
    void 자동차_인덱스로_반환_테스트() {
        //given
        Cars cars = new Cars("jun,seo,park");

        //when
        Car car = cars.findCarByIndex(2);

        //then
        assertThat(car.getName()).isEqualTo("park");
    }

    @DisplayName("자동차 리스트의 크기를 반환해야 한다.")
    @Test
    void 자동차_리스트_크기_반환_테스트() {
        //given
        Cars cars = new Cars("jun,seo,park,pobi,woni");

        //when
        int carsSize = cars.size();

        //then
        assertThat(carsSize).isEqualTo(5);
    }

    @DisplayName("중복되는 자동차 이름이 존재하면 예외가 발생해야 한다.")
    @Test
    void 중복되는_자동차_이름이_존재시_예외_발생_테스트() {
        //given
        String names = "jun,seo,park,jun";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new Cars(names));
    }
}
