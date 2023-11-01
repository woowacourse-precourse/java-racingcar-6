package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    @ParameterizedTest
    @CsvSource({"9,3,1", "4,2,1", "1,2,0", "2,3,0", "4,4,2", "0,9,1"})
    public void 전진_또는_스탑_테스트(int move1, int move2, int expected) {
        //given
        Cars car = new Cars("JiHun", 0);

        //when
        car.move(move1);
        car.move(move2);
        int actual = car.getDistance();

        //then
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}