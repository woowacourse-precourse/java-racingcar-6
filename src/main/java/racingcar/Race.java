package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int round;
    private List<Car> cars;

    public Race(int round, List<Car> cars) {
        this.round = round;
        this.cars = cars;
    }

    public int getRound() {
        return round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void proceedRound() {
        for (Car car : cars) {
            car.proceed();
        }
    }

    public void start() {
        OutputConsole.print(OutputConsole.STATUS_MESSAGE);
        for (int i = 0; i < round; i++) {
            proceedRound();
            OutputConsole.printStatus(getCurrentStatus());
        }
    }

    public List<Status> getCurrentStatus() {
        List<Status> currentStatus = new ArrayList<>();
        for (Car car : cars) {
            currentStatus.add(new Status(car.getName(), car.getDistance()));
        }
        return currentStatus;
    }

    public int getMaxDistance() {
        int max = 0;
        for (Car car : cars) {
            if (car.getDistance() > max) {
                max = car.getDistance();
            }
        }
        return max;
    }

    public List<Car> getSameDistanceCars(int distance) {
        List<Car> sameDistanceCars = new ArrayList<>();
        for (Car car : cars) {
            if (distance == car.getDistance()) {
                sameDistanceCars.add(car);
            }
        }
        return sameDistanceCars;
    }

    public List<Car> getWinners() {
        int max = getMaxDistance();
        return getSameDistanceCars(max);
    }

}
