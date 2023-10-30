package racingcar.domain;

import java.util.List;

public class Car {

    private int position = 0;
    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int comparePosition(int position) {
        if (this.position > position) {
            return this.position;
        }
        return position;
    }

    public boolean isFurthestDistance(int furtherDistance) {
        return this.position == furtherDistance;
    }

    public void registerOnWinnerList(List<String> winnerList) {
        carName.writeOnWinnerList(winnerList);
    }

    public Winner recognizeAsWinner() {
        return carName.registerAsWinner();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(carName.makeNameForPrintResult());
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        sb.append("\n");
        return sb.toString();
    }
}
