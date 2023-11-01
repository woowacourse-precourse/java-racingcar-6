package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("이동한 결과를 문자열로 반환")
    void getMoveResultTest() {
        //given
        List<CarName> carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        CarNames carNames = new CarNames(carNameList);
        Cars cars = new Cars(carNames);

        cars.moveAllCar();

        //when
        String result = cars.getMoveResult();

        //then
        assertThat(result).contains("test1 : ", "test2 : ", "test3 : ");
    }

    @Test
    void findWinnerTest() {
        //given
        List<CarName> carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        CarNames carNames = new CarNames(carNameList);
        Cars cars = new Cars(carNames);

        //when
        String winnerList = "test1, test2, test3";
        Winners winners = cars.findWinner();

        //then
        assertThat(winners.makeWinnerList()).isEqualTo(winnerList);
    }
}
