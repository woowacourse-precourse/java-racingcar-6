package racingcar.domain;

import java.util.List;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
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
        winnerList.add(this.name);
    }


    @Override
    public String toString() {
        String distance = "";
        for (int i = 0; i < position; i++) {
            distance += "-";
        }
        return name + " : " + distance;
    }
}
