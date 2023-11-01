package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {
    private static final int MOVING_NUM = 4;
    private static final int STOP = 3;
    private Game game = new Game();

    @Test
    void getWinners_메서드_사용시_우승_자동차_반환() {
        List<Car> carList = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        carList.forEach(Car::increaseMovingCount);
        carList.get(0).increaseMovingCount();

        List<Car> result = game.getWinners(carList);

        assertThat(result)
                .containsExactly(carList.get(0));
    }

    @Test
    void canMoveForward_메서드_사용시_전진가능_한_경우인지_판단() {
        boolean result = game.canMoveForward(MOVING_NUM);

        assertThat(result).isTrue();
    }

    @Test
    void canMoveForward_메서드_사용시_전진불가능_한_경우인지_판단() {
        boolean result = game.canMoveForward(STOP);

        assertThat(result).isFalse();
    }

    @Test
    void getMaxMovingNumber_메서드_사용시_가장_큰_전진수_반환() {
        List<Car> carList = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        carList.get(0).increaseMovingCount();
        int result = game.getMaxMovingNumber(carList);

        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void createCarsFromNames_메서드_사용시_이름이_매핑된_자동차_리스트_반환() {
        List<String> names = Arrays.asList("woo", "wa", "tech");
        List<Car> result = game.createCarsFromNames(names);

        assertThat(result)
                .hasSize(names.size())
                .extracting(Car::getName)
                .containsExactlyElementsOf(names);
    }
}