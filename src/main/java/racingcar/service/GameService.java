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
        while(checkCount != progressCount) {
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

    public List<String> createWinnerCarNameList() {
        List<String> winnerCarNameList = new ArrayList<>();
        int max = -1;
        for (Car car : carList) {
            if (car.getAdvanceCount() > max) {
                max = car.getAdvanceCount();
                winnerCarNameList.clear();
                winnerCarNameList.add(car.getName());
            } else if (car.getAdvanceCount() == max) {
                winnerCarNameList.add(", " + car.getName());
            }
        }

        return winnerCarNameList;
    }
}
