package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

public class ResultTest {

    private Result result;
    private ArrayList<Car> carArrayList;
    private String winner;

    @Test
    void 결과_내놓아라() {

        carArrayList = new ArrayList<>();
        carArrayList.add(new Car("pobi"));
        carArrayList.add(new Car("MJ"));
        carArrayList.add(new Car("tjwls"));

        for (Car car : carArrayList) {
            car.setCount();
            car.setDistance("-");
        }
        carArrayList.get(1).setCount();
        carArrayList.get(2).setCount();

        result = new Result(carArrayList);
        winner = result.finalWinner();

        assertThat(winner).isEqualTo("MJ, tjwls");
    }

}