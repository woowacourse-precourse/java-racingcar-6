package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarListGenerator;

import java.util.List;

class CameraTest {

    List<Car> carList;
    Cars cars;
    Camera camera = new Camera();

    @Test
    void 레이싱_시작전_상황() {
        String carNames = "pobi,woni,jun";
        carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);

        String excepted =
                """
                        pobi :\s
                        woni :\s
                        jun :\s""";
        Assertions.assertThat(camera.captureRaceState(cars)).isEqualTo(excepted);
    }

    @Test
    void 맨앞_자동차만_이동한_후_상황() {
        String carNames = "pobi,woni,jun";
        carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);

        cars.cars().get(0).forward(1);

        String excepted =
                """
                        pobi : -
                        woni :\s
                        jun :\s""";
        Assertions.assertThat(camera.captureRaceState(cars)).isEqualTo(excepted);
    }

    @Test
    void 맨앞_맨뒤_자동차만_5번_이동한_후_상황() {
        String carNames = "pobi,woni,jun";
        carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);

        for (int round = 0; round < 5; round++) {
            cars.cars().get(0).forward(1);
            cars.cars().get(cars.cars().size() - 1).forward(1);
        }

        String excepted =
                """
                        pobi : -----
                        woni :\s
                        jun : -----""";
        Assertions.assertThat(camera.captureRaceState(cars)).isEqualTo(excepted);
    }
}
