package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Race {
    int trial;

    RunningMessage message = new RunningMessage();
    CarSetting carSetting = new CarSetting();

    public void start() {
        message.printStartMessage();
        carSetting.setCarName();
    }

    public void running() {
        message.printResultMessage();
        for (int try_count = 0; try_count < trial; try_count++) {
            inCars();
            System.out.println();
        }
    }

    public void setTrial() {
        message.printHowManyGame();
        trial = Integer.parseInt(Console.readLine());
    }

    public void inCars() {
        Car[] cars = carSetting.getCar();
        for (Car car : cars) {
            message.printCarName(car.getCarName());
            message.printRunCount(car.getRunCount());
        }
    }
}
