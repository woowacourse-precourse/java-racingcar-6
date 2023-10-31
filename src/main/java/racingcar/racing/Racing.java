package racingcar.racing;

import inAndOut.Output;
import racingcar.car.Car;
import racingcar.car.CarList;
import utils.RandomUtils;

import java.util.List;

public class Racing {
    private List<Car> carList;
    private Output output;
    public Racing(CarList carList) {
        this.carList = carList.getCarList();
        this.output = new Output();
    }

    public void raceStart(int count) {
        for (int i = 0; i < count; i++) {
            for (Car car : carList) {
                // stop and go 판단
                if (decideToGo()) {
                    car.move();
                }
                output.printResult(car);
            }
            System.out.println("");
        }
    }

    private boolean decideToGo() {
        int randNum = RandomUtils.nextInt(0, 9);
        if (randNum >= 4) {
            return true;
        }
        return false;
    }
}
