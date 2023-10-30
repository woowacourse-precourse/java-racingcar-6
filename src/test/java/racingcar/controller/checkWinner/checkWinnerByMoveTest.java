package racingcar.controller.checkWinner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class checkWinnerByMoveTest {

    CheckWinner checkWinner = new checkWinnerByMove();

    @Test
    void getWinner() {
        Car c1 = new Car("name");
        Car c2 = new Car("name1");
        c1.move();

        List<Car> array = new ArrayList<>();
        array.add(c1);
        array.add(c2);

        assertThat(checkWinner.getWinner(array).length).isEqualTo(1);
    }

    @Test
    void getPublicWinner(){
        Car c1 = new Car("name");
        Car c2 = new Car("name1");
        c1.move();
        c2.move();

        List<Car> array = new ArrayList<>();
        array.add(c1);
        array.add(c2);

        assertThat(checkWinner.getWinner(array).length).isEqualTo(2);
    }
}