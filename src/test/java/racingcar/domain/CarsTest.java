package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("")
    void 최대값_구하기() {
        List<Car> carList = Arrays.asList(
                new Car("tree", 2),
                new Car("pobi", 2),
                new Car("crong", 3)
        );
        Winners expectedWinners = new Winners(carList);
    }


    @Test
    @DisplayName("우승자 1명 테스트")
    void 우승자_1명() {
        //given
        List<Car> carList = Arrays.asList(
                new Car("tree", 2),
                new Car("pobi", 2),
                new Car("crong", 3)
        );
        Cars cars = new Cars(carList);
        //when
        Winners expectedWinners = new Winners(Arrays.asList(new Car("crong", 3)));
        //then
        assertThat(cars.getWinners()).isEqualTo(expectedWinners);
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void 우승자_2명() {
        //given
        Car tree = new Car("tree", 2);
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 3);
        List<Car> carList = Arrays.asList(tree, pobi, crong);
        Cars cars = new Cars(carList);
        //when
        Winners expectedWinners = new Winners(Arrays.asList(pobi, crong));
        //then
        assertThat(cars.getWinners()).isEqualTo(expectedWinners);
    }
}
