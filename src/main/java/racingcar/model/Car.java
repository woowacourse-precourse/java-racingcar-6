package racingcar.model;

import racingcar.CarDTO;

public class Car {
    public CarDTO car;

    public Car(CarDTO car) {
        this.car = car;
    }

    public void Forward() {
        int curProgress = car.getForwardProgress();
        curProgress++;
        car.setForwardProgress(curProgress);
    }

    public String getName() {
        return car.getName();
    }

    public int getForwardProgress() {
        return car.getForwardProgress();
    }

    public String makeProgressBar() {
        String result = "";
        int progress = car.getForwardProgress();
        for (int i = 0; i < progress; i++) {
            result += '-';
        }
        return result;
    }
}
