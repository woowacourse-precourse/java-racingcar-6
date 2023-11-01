package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

    private CarList cars;
    private Car pobiCar;
    private Car woniCar;

    @BeforeEach
    public void setUp() {
        cars = new CarList("pobi,woni,jun");

        pobiCar = cars.getCars().get(0);
        woniCar = cars.getCars().get(1);

        cars.moveCarWhenNumberFourOrAbove(pobiCar, 4);
        cars.moveCarWhenNumberFourOrAbove(pobiCar, 5);
        cars.moveCarWhenNumberFourOrAbove(pobiCar, 6);

        cars.moveCarWhenNumberFourOrAbove(woniCar, 4);
        cars.moveCarWhenNumberFourOrAbove(woniCar, 5);
    }

    @Test
    @DisplayName("car 한대 움직이는 조건 만족하는지 test")
    public void moveCarWhenNumberFourOrAboveTest() {

        Car junCar = cars.getCars().get(2);

        assertThat(junCar.getPosition()).isEqualTo(0);

        cars.moveCarWhenNumberFourOrAbove(junCar, 0);
        assertThat(junCar.getPosition()).isEqualTo(0);

        cars.moveCarWhenNumberFourOrAbove(junCar, 3);
        assertThat(junCar.getPosition()).isEqualTo(0);

        cars.moveCarWhenNumberFourOrAbove(junCar, 4);
        assertThat(junCar.getPosition()).isEqualTo(1);

        cars.moveCarWhenNumberFourOrAbove(junCar, 9);
        assertThat(junCar.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("제일 멀리 있는 자동차 position 확인")
    public void findMaxPosition() throws Exception {

        int maxPosition = cars.findMaxPosition();
        assertThat(maxPosition).isEqualTo(3);
        System.out.println("woniCar.getPosition() = " + woniCar.getPosition());

        moveCarOnePosition(woniCar);
        maxPosition = cars.findMaxPosition();
        assertThat(maxPosition).isEqualTo(3);

        moveCarOnePosition(woniCar);
        maxPosition = cars.findMaxPosition();
        assertThat(maxPosition).isEqualTo(4);
    }

    @Test
    @DisplayName("우승자 찾기")
    public void findWinnersTest() {

        List<String> singleWinner = cars.findWinners(3);
        assertThat(singleWinner).containsExactly("pobi");
        assertThat(singleWinner).hasSize(1);

        moveCarOnePosition(woniCar);
        List<String> multipleWinners = cars.findWinners(3);
        assertThat(multipleWinners).containsExactly("pobi", "woni");
        assertThat(multipleWinners).hasSize(2);

    }

    private void moveCarOnePosition(Car carName) {
        cars.moveCarWhenNumberFourOrAbove(carName, 4);
    }
}
