package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.repository.Car;
import racingcar.repository.RacingMemoryRepository;
import racingcar.repository.RacingRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingMemoryRepositoryTest extends NsTest {

    @Test
    void 싱글톤으로_생성된다(){
        RacingRepository racingRepository1 = RacingMemoryRepository.getInstance();
        RacingRepository racingRepository2 = RacingMemoryRepository.getInstance();

        assertThat(racingRepository1).isEqualTo(racingRepository2);
    }


    @Test
    void 다수의_자동차를_조회할수있다() {
        // given
        RacingRepository racingRepository = new RacingMemoryRepository();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        // when
        car1.move(99);
        car2.move(98);
        racingRepository.create(car1);
        racingRepository.create(car2);

        // then
        List<Car> cars = racingRepository.findAll();

        Car pobiCar = cars.get(0);
        Car woniCar = cars.get(1);

        assertThat(pobiCar.getName()).isEqualTo("pobi");
        assertThat(pobiCar.getPosition()).isEqualTo(99);

        assertThat(woniCar.getName()).isEqualTo("woni");
        assertThat(woniCar.getPosition()).isEqualTo(98);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
