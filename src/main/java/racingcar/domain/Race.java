package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    private List<Car> carList = new ArrayList<>();
    private int attemptCount;

    public Race(String carNames, int attemptCount) {
        validate(carNames);
        addToCarList(carNames);
        this.attemptCount = attemptCount;
    }

    public void racing() {
        for (int i = 0; i < attemptCount; i++) {
            round();
            System.out.println();
        }
    }

    public List<String> getWinners() {
        int maxCount = findMaxCount();
        return getWinnerNames(maxCount);
    }

    private static void validate(String carNames) {
        if (carNames == null || carNames.isEmpty() || carNames.isBlank()) {
            throw new IllegalArgumentException();
        }
        String[] carNameArr = getSplit(carNames);
        for (String carName : carNameArr) {
            if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static String[] getSplit(String carNames) {
        return carNames.split(",");
    }

    private void addToCarList(String carNames) {
        String[] carNameArr = getSplit(carNames);
        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }
    }

    private void round() {
        for (Car car : carList) {
            int random = Randoms.pickNumberInRange(0, 9);
            car.move(random);
        }
        printRaceResultByRound();
    }

    private void printRaceResultByRound() {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private int findMaxCount() {
        int maxCount = 0;
        for (Car car : carList) {
            maxCount = Math.max(maxCount, car.getCount());
        }
        return maxCount;
    }

    private List<String> getWinnerNames(int maxCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getCount() == maxCount) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
