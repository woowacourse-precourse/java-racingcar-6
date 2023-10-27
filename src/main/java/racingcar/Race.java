package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Race {
    int trial;
    int winnerRun =0;
    List<String> winner = new ArrayList<>();
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
            getWinnerRun(car.getRunCount());
            setWinner(car.getRunCount(), car.getCarName());
        }
    }

    public void getWinnerRun(int runCount){
        if(runCount > winnerRun) winnerRun = runCount;
    }

    public void setWinner(int carRunCount, String carName){
        winner.clear();
        if(carRunCount == winnerRun){
            winner.add(carName);
        }
    }
}
