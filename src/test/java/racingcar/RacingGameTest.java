package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.contains;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarList;

class RacingGameTest {

    private RacingGame racingGame = new RacingGame();

    @Test
    void 쉼표를_기준으로_자동차의_이름을_입력받기(){
        List<Car> cars = racingGame.generateCar("povi,woni,minu");
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 전진하는_자동차_출력테스트(){
        List<Car> cars = racingGame.generateCar("povi,woni");
        List<Integer> carsPosition = Arrays.asList(2, 0);

        assertThat(racingGame.printNameAndPosition(cars,carsPosition)).contains("povi : --");
    }

}