package racingcar.service;

import racingcar.domain.Car;

import java.util.*;

public class GameService {
    private int progressCount;
    private final List<Car> carList = new ArrayList<>();

    public void addCarNameList(List<String> carNameList) {
        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }

    public void setProgressCount(int progressCount) {
        this.progressCount = progressCount;
    }

    public StringBuilder createProgressResult() {
        StringBuilder racingResult = new StringBuilder();
        int checkCount = 0;
        while(isNotProgressCount(checkCount)) {
            checkCount++;
            carList.forEach(
                    car -> racingResult
                            .append(car.getName())
                            .append(" : ")
                            .append(car.getAdvanceCountMark())
                            .append("\n")
            );
            racingResult.append("\n");
        }

        return racingResult;
    }

    private boolean isNotProgressCount(int checkCount) {
        return checkCount != progressCount;
    }

    public List<String> createWinnerCarNameList() {
        List<String> winnerCarNameList = new ArrayList<>();
        int max = -1;
        for (Car car : carList) {
            if (isGreaterThanMaxValue(max, car.getAdvanceCount())) {
                max = car.getAdvanceCount();
                winnerCarNameList.clear();
                winnerCarNameList.add(car.getName());
            } else if (equalsMaxValue(max, car.getAdvanceCount())) {
                winnerCarNameList.add(", " + car.getName());
            }
        }

        return winnerCarNameList;
    }

    private boolean isGreaterThanMaxValue(int max, int advanceCount) {
        return advanceCount > max;
    }

    private boolean equalsMaxValue(int max, int advanceCount) {
        return advanceCount == max;
    }
}
