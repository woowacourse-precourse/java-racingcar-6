package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private final Car car;
    private final List<String> winnerCarNames = new ArrayList<>();
    private final int mostMovedAmount;
    private final int numberOfCars;

    public OutputView(Car car) {
        this.car = car;
        numberOfCars = car.numberOf();
        mostMovedAmount = car.mostMovedAmount();
    }

    public void printResult() {
        setWinnerCarNames();
        System.out.print("\n최종 우승자 : " + String.join(", ", winnerCarNames));
    }

    private void setWinnerCarNames() {
        int carIndex = 0;
        while (carIndex < numberOfCars) {
            addToListIfWinner(carIndex);
            carIndex++;
        }
    }

    private void addToListIfWinner(int carIndex) {
        if (car.movedLately(carIndex) == mostMovedAmount) {
            winnerCarNames.add(car.name(carIndex));
        }
    }
}
