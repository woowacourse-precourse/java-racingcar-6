package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("경주하는 자동차 생성 테스트")
    void 경주_자동차_생성_테스트() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Hong"));
        cars.add(new Car("Chan"));
        cars.add(new Car("Ui"));
        RacingCars racingCars = new RacingCars(cars);

        assertThat(racingCars.getRacingCars()).isEqualTo(cars);
    }

    @Test
    @DisplayName("단독 최종 우승자 판단 테스트")
    void 단독_최종_우승자_판단_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("jun"));

        RacingCars racingCars = new RacingCars(cars);
        Car car1 = racingCars.getRacingCars().get(0);
        Car car2 = racingCars.getRacingCars().get(1);

        car1.goForward();
        car1.goForward();
        car2.goForward();

        List<String> winners = racingCars.winnersJudge();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).contains("pobi");
    }

    @Test
    @DisplayName("공동 최종 우승자 판단 테스트")
    void 공동_최종_우승자_판단_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ZZang"));
        cars.add(new Car("12345"));
        cars.add(new Car("qwer"));

        RacingCars racingCars = new RacingCars(cars);
        Car car1 = racingCars.getRacingCars().get(0);
        Car car2 = racingCars.getRacingCars().get(1);
        Car car3 = racingCars.getRacingCars().get(2);

        car1.goForward();
        car1.goForward();
        car2.goForward();
        car2.goForward();
        car3.goForward();

        List<String> winners = racingCars.winnersJudge();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains("ZZang");
        assertThat(winners).contains("12345");
    }
}
