package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import car.Car;
import game.DefaultRandomGenerator;
import game.Game;
import game.GameReferee;
import game.TestRandomGenerator;
import org.junit.jupiter.api.Test;
import util.GamePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameTest extends NsTest{

    private static final int MAX_NUMBER = 9;

    @Test
    void 레이싱카_모두_이동() {
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameReferee gameReferee = new GameReferee(new TestRandomGenerator(MAX_NUMBER));

        int repeat = 3;

        for (int i = 0; i < repeat; i++) {
            gameReferee.allMove(carList);

        }

        assertThat(car1.getPosition()).isEqualTo(repeat);
        assertThat(car2.getPosition()).isEqualTo(repeat);
        assertThat(car3.getPosition()).isEqualTo(repeat);

    }

    @Test
    void 우승자_1명() {
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.move();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameReferee gameReferee = new GameReferee(new DefaultRandomGenerator());
        gameReferee.determineWinner(carList);

        assertThat(output()).contains("최종 우승자 : Car1");
    }

    @Test
    void 우승자_2명_이상() {
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameReferee gameReferee = new GameReferee(new DefaultRandomGenerator());
        gameReferee.determineWinner(carList);

        assertThat(output()).contains("최종 우승자 : Car1, Car2, Car3");
    }


    @Override
    protected void runMain() {

    }
}
