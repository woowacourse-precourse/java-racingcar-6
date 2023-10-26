package racingcar.racecar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.CarName;
import racingcar.RaceCar;
import racingcar.RaceCars;

class RaceCarsTest {

    void moveForwards(RaceCar raceCar, int times) {
        for (int i = 0; i < times; i++) {
            raceCar.moveForward();
        }
    }

    @Test
    @DisplayName("RaceCars 최대값 테스트")
    void maximumListTest() {

        //given
        List<RaceCar> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new RaceCar(new CarName(String.valueOf(i))));
        }

        moveForwards(list.get(3), 10);
        moveForwards(list.get(4), 5);
        moveForwards(list.get(6), 1);
        moveForwards(list.get(7), 10);

        RaceCars raceCars = new RaceCars(list);
        List<RaceCar> maximumList = raceCars.getMaximumList();

        System.out.println("maximumList = " + maximumList);
    }

    @ParameterizedTest
    @DisplayName("String 기반 생성자 테스트")
    @ValueSource(strings = {"pobi,woni,jun"})
    void newConstructorTest(String names) {
        RaceCars raceCars = new RaceCars(names);
        System.out.println("raceCars = " + raceCars);
    }
}