package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private final Car car;
    private final List<String> winnerCarNames = new ArrayList<>();
    private final int mostMovedAmount;
    private final int numberOfCars;
    private int carIndex = 0;

    public OutputView(Car car) {
        this.car = car;
        numberOfCars = car.numberOf();
        mostMovedAmount = car.mostMovedAmount();
    }

    public String result() {
        setWinnerCarNames();
        return "\n최종 우승자 : " + String.join(", ", winnerCarNames);
    }

    private void setWinnerCarNames() {
        for (carIndex = 0; carIndex < numberOfCars; carIndex++) {
            addToListIfWinner();
        }
    }

    private void addToListIfWinner() {
        if (car.movedLately(carIndex) == mostMovedAmount) {
            winnerCarNames.add(car.name(carIndex));
        }
    }
}
