package racingcar.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRepositoryTest {
    private CarRepository carRepository;
    private List<Car> carList;
    private Car aCar;
    private Car bCar;
    private Car cCar;

    @BeforeEach
    void init() {
        aCar = new Car("kang", 0);
        bCar = new Car("yong", 0);
        cCar = new Car("soo", 0);
        carList = new ArrayList<>(List.of(aCar, bCar, cCar));
        carRepository = new CarRepository(carList);
    }

    @Test
    void 자동차_생성_테스트() {
        String[] carNames = new String[]{"kang", "yong", "so"};

        carRepository.setCarList(carNames);

        assertThat(carRepository.getCarList()).contains(aCar, bCar, cCar);
    }

    @Test
    void 우승자_선정_테스트() {
        aCar.move(true);
        bCar.move(true);

        assertThat(carRepository.findWinners()).contains(aCar.getName());
    }
}
