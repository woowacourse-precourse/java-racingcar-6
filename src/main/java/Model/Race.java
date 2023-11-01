package Model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int maxPosition;
    private List<String> winner;

    public Race(List<String> names) {
        cars = new ArrayList<>();
        winner = new ArrayList<>();
        this.maxPosition = 0;
        addCarsList(names);
    }

    public void addCarsList(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public List<String> getWinner() {
        return winner;
    }

    public void playRound() {
        for (Car car : cars) {
            car.moveRole();
        }
    }

    public void maxPosition() {
        for (Car car : cars) {
            maxPosition = comparePosition(maxPosition, car.getPosition());
        }
    }

    public int comparePosition(int position1, int position2) {
        return Math.max(position1, position2);
    }

    public void whoWinner() {
        for (Car car : cars) {
            boolean win = winner(car.getPosition());
            addWinner(win, car.getName());
        }
    }

    public boolean winner(int position) {
        return maxPosition == position;
    }

    public void addWinner(boolean win, String name) {
        if (win) {
            winner.add(name);
        }
    }
}
