package racingcar.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    static int MOVE_FORWARD = 4;

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun:0,3,1:woni", "pobi,jun:5,5:pobi,jun"}, delimiter = ':')
    void findWinner(String names, String forwards, String winnerLine) {

        //given
        List<Car> carList = Stream.of(names.split(",")).map(Car::new).toList();
        List<Integer> nForward = Stream.of(forwards.split(",")).map(Integer::parseInt).toList();

        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < nForward.get(i); j++) {
                carList.get(i).move(MOVE_FORWARD);
            }
        }

        Cars cars = new Cars(carList);
        List<String> winner = cars.findWinner();

        //then
        winner.forEach(name -> Assertions.assertThat(winnerLine).contains(name));


    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun:0,3,1:3", "pobi,jun:5,5:5", "pobi,woni,jun:0,0,0:0"}, delimiter = ':')
    void findWinnersPosition(String names, String forwards, int length) {

        //given
        List<Car> carList = Stream.of(names.split(",")).map(Car::new).toList();
        List<Integer> nForward = Stream.of(forwards.split(",")).map(Integer::parseInt).toList();

        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < nForward.get(i); j++) {
                carList.get(i).move(MOVE_FORWARD);
            }
        }

        //when
        Cars cars = new Cars(carList);
        int winnersPosition = cars.findWinnersPosition();

        //then
        Assertions.assertThat(winnersPosition).isEqualTo(length);


    }
}