package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    public void Racing(List<Car> cars, int GameNum) {

        for (int i = 0; i < GameNum; i++) {
            RacingEachCars(cars);
        }

    }

    private void RacingEachCars(List<Car> cars) {
        Output output = new Output();

        for (Car car : cars) {
            WinCar(car);
            output.CarResult(car);
        }
        System.out.println();

    }


    private void WinCar(Car car) {
        int randnum = Randoms.pickNumberInRange(0, 9);

        if (randnum >= 4) {
            car.cnt++;
        }

    }

}
