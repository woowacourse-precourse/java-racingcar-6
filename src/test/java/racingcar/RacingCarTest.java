package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.RaceResult;

import java.util.Arrays;
import java.util.List;

public class RacingCarTest {

    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("abc");  // 이름 변경: "porsche" -> "porsc"
        assertThat(car.getName()).isEqualTo("abc");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("abc");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 레이스_우승자_판별_테스트() {
        Car car1 = new Car("abc");
        Car car2 = new Car("def");
        Car car3 = new Car("ghi");

        car1.move();
        car1.move();
        car2.move();


        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<Car> winners = RaceResult.getWinners(cars);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("abc");
    }

    @Test
    void 레이스_진행_테스트() {
        Car car1 = new Car("abcde");
        Car car2 = new Car("fghij");

        List<Car> cars = Arrays.asList(car1, car2);
        Race race = new Race(cars);

        race.raceOnce();

        assertThat(cars.get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(cars.get(1).getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 입력된_자동차_목록의_개수_확인_테스트() {
        Car car1 = new Car("abc");
        Car car2 = new Car("def");

        List<Car> cars = Arrays.asList(car1, car2);
        Race race = new Race(cars);

        assertThat(race.getCars().size()).isEqualTo(2);
    }
}
