package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

class RacingLogicTest {

    @Test
    void 숫자가_0에서_9사이_랜덤숫자인지() {
        int randomNumber = RacingLogic.makeRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 레이싱카가_전진할때() {
        RacingCar racingCar = new RacingCar("car");
        RacingLogic.isPlusDistance(4, racingCar);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @Test
    void 레이싱카가_움직이지_않을때() {
        RacingCar racingCar = new RacingCar("car");
        RacingLogic.isPlusDistance(0, racingCar);
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }

    @Test
    void 레이싱카_최대_거리_여러명일때() {
        RacingCars racingCars = new RacingCars(List.of("car1", "car2"));
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        for (RacingCar car : racingCarList) {
            car.setForwardDistance(5);
        }
        int maxDistance = RacingLogic.getMaxDistance(racingCars);
        assertThat(maxDistance).isEqualTo(5);

    }

    @Test
    void 레이싱카_최대_거리_한명일때() {
        RacingCars racingCars = new RacingCars(List.of("car1", "car2"));
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        racingCarList.get(0).setForwardDistance(3);
        racingCarList.get(1).setForwardDistance(5);
        int maxDistance = RacingLogic.getMaxDistance(racingCars);
        assertThat(maxDistance).isEqualTo(5);
    }

}