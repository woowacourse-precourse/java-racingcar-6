package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarListServiceTest {

    @Test
    void getWinnerName_전체_자동차_리스트_받아서_단독_우승자_정상_반환() {
        // given
        List<Car> carList = Arrays.asList(
                new Car("car1", 1),
                new Car("car2", 7),
                new Car("car3", 4)
        );
        //when
        CarListService carListService = new CarListService();

        //then
        List<String> expected = Arrays.asList("car2");
        assertThat(carListService.getWinnerName(carList)).isEqualTo(expected);
    }

    @Test
    void getWinnerName_전체_자동차_리스트_받아서_공동_우승자_정상_반환() {
        // given
        List<Car> carList = Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 8),
                new Car("car3", 8)
        );
        //when
        CarListService carListService = new CarListService();

        //then
        List<String> expected = Arrays.asList("car2", "car3");
        assertThat(carListService.getWinnerName(carList)).isEqualTo(expected);
    }
}