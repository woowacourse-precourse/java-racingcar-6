package racingcar.domain.car;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constant.*;

class CarsTest {

    private static final String CAR_NAME = "test";

    @Test
    @DisplayName("단독_우승_일때_결과_출력_확인")
    void getWinnersString_SoloWinner_Output() {
        //given
        Cars cars = getCarsWinnerIsSolo();
        String expected = MESSAGE_WINNER + IS + CAR_NAME;

        //when
        String actual = cars.getWinnersString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("공동_우승_일때_결과_출력_확인")
    void getWinnersString_JointWinner_Output() {
        //given
        Cars cars = getCarsJointWinner();
        String expected = MESSAGE_WINNER + IS + CAR_NAME + OUTPUT_DELIM + CAR_NAME;

        //when
        String actual = cars.getWinnersString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("cars_toString()_확인")
    void toString_Cars_Output() {
        //given
        Cars cars = getCarsWinnerIsSolo();
        String expected = CAR_NAME + IS + LINE + "\n" +
                CAR_NAME + IS + "\n";

        //when
        String actual = cars.toString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    Cars getCarsWinnerIsSolo() {
        Car winnerCar = new Car(CAR_NAME);
        winnerCar.forward();

        Car loserCar = new Car(CAR_NAME);

        return new Cars(Lists.list(winnerCar, loserCar));
    }

    Cars getCarsJointWinner() {
        return new Cars(Lists.list(new Car(CAR_NAME), new Car(CAR_NAME)));
    }
}