package racingcar.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun:0,3,1:woni", "pobi,jun:5,5:pobi,jun"}, delimiter = ':')
    void findWinner(String names, String forwards, String result) {

        //given
        List<Car> carList = Stream.of(names.split(",")).map(Car::new).toList();
        List<Integer> nForward = Stream.of(forwards.split(",")).map(Integer::parseInt).toList();

        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < nForward.get(i); j++) {
                carList.get(i).move(4);
            }
        }

        Cars cars = new Cars(carList);
        List<String> winner = cars.findWinner();

        //then
        winner.forEach(name -> Assertions.assertThat(result).contains(name));


    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun:0,3,1:3", "pobi,jun:5,5:5", "pobi,woni,jun:0,0,0:0"}, delimiter = ':')
    void findWinnersPosition(String names, String forwards, int result) {

        //given
        List<Car> carList = Stream.of(names.split(",")).map(Car::new).toList();
        List<Integer> nForward = Stream.of(forwards.split(",")).map(Integer::parseInt).toList();

        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < nForward.get(i); j++) {
                carList.get(i).move(4);
            }
        }

        //when
        Cars cars = new Cars(carList);
        int winnersPosition = cars.findWinnersPosition();

        //then
        Assertions.assertThat(winnersPosition).isEqualTo(result);


    }
}