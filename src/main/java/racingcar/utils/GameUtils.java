package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.views.SystemMessage;
import racingcar.model.Car;
import racingcar.constant.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class GameUtils {
    SystemMessage systemMessage = new SystemMessage();

    public String[] setCarList() {
        return systemMessage.getCarList().split(",");
    }

    public int setTrialNumber() {
        return isTrialValid(systemMessage.getTrialNumber());
    }

    public List<Car> convertCarList(String[] carList) {
        List<Car> cars = new ArrayList<>();
        for (String s : carList) {
            if (!isValid(s)) {
                throw new IllegalArgumentException(Constants.INPUT_ERROR);
            }
            cars.add(new Car(s, 0));
        }
        return cars;
    }

    public void processGame(List<Car> cars, int trial) {
        System.out.println();
        System.out.println(Constants.RESULT_INFO);
        for (int index = 0; index < trial; index++) {
            this.countSuccess(cars);
            System.out.println();
        }
        StringBuilder winner = new StringBuilder();
        int max = countMax(cars);
        for (Car car : cars) {
            if (car.getCount() == max) {
                this.appendString(winner, car);
            }
        }
        System.out.println("최종 우승자 : " + winner);
    }

    private void appendString(StringBuilder winner, Car car) {
        if (!winner.isEmpty()) {
            winner.append(", ");
            winner.append(car.getName());
        } else {
            winner.append(car.getName());
        }
    }

    private int countMax(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getCount() > max) {
                max = car.getCount();
            }
        }
        return max;
    }

    private void countSuccess(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.addCount();
            }
            this.printResult(car);
        }
    }

    private void printResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getCount()));
    }

    private boolean isValid(String car) {
        return car.length() <= 5;
    }

    private int isTrialValid(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.TRIAL_ERROR);
        }
    }
}
