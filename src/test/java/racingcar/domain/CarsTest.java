package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void race호출시_Car들의_Position이_1만큼_증가(int index) {
        //given
        List<Car> carList = Arrays.asList(
                new Car(new CarName("pobi"), new Position(0))
                , new Car(new CarName("woni"), new Position(0))
                , new Car(new CarName("jun"), new Position(0)));
        Cars cars = new Cars(carList);
        //when
        cars.race(() -> true);
        //then
        assertThat(cars.getCars().get(index).getPosition()).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @CsvSource({"0,pobi","1,jun"})
    void 경주완료후_우승자는_pobi와_jun(int index, String carName) {
        //given
        List<Car> carList = Arrays.asList(
                new Car(new CarName("pobi"), new Position(4))
                , new Car(new CarName("woni"), new Position(2))
                , new Car(new CarName("jun"), new Position(4)));
        Cars cars = new Cars(carList);
        //when
        List<String> winners = cars.findWinners();
        //then
        assertThat(winners.get(index)).isEqualTo(carName);
    }
}
